package com.xiaowei.sys.platform.core.facade.service.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
 * Created by pc-hh on 2015/11/2.
 */
public class SSOJedisDBShardInfo extends JedisShardInfo {

    private int database;

    public SSOJedisDBShardInfo(String host, int database) {
        super(host, 6379);
        this.database = database;
    }

    public SSOJedisDBShardInfo(String host, String name, int database) {
        super(host, 6379, name);
        this.database = database;
    }

    public SSOJedisDBShardInfo(String host, int port, int database) {
        super(host, port, 2000);
        this.database = database;
    }

    public SSOJedisDBShardInfo(String host, int port, String name, int database) {
        super(host, port, 2000, name);
        this.database = database;
    }

    public SSOJedisDBShardInfo(String host, int port, int timeout, int database) {
        super(host, port, timeout, "1");
        this.database = database;
    }

    public SSOJedisDBShardInfo(String host, int port, int timeout, String name, int database) {
        super(host, port, timeout, name);
        this.database = database;
    }

    @Override
    public Jedis createResource() {
        try {
            Jedis jedis = new Jedis(this);
            if (database != 0 && "PONG".equals(jedis.ping())) {
                jedis.select(database);
            }
            return jedis;
        } catch (Exception e) {
            System.out.println((new StringBuilder("连接异常=>")).append(getHost()).append(":").append(getPort()).append(":").append(getDatabase()).toString());
            return null;
        }


    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }
}
