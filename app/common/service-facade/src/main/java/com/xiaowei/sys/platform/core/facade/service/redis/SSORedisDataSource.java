package com.xiaowei.sys.platform.core.facade.service.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by pc-hh on 2015/8/27.
 */
public interface SSORedisDataSource {
    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis, boolean broken);
}
