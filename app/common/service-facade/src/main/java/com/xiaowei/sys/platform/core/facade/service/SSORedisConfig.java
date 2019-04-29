package com.xiaowei.sys.platform.core.facade.service;

import com.xiaowei.sys.platform.core.facade.service.redis.SSORedisClientTemplate;
import com.xiaowei.sys.platform.core.facade.service.redis.SSORedisDataSource;
import com.xiaowei.sys.platform.core.facade.service.redis.SSORedisDataSourceImpl;
import com.xiaowei.sys.platform.core.facade.service.util.SSORedisUtil;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class SSORedisConfig {

    @Value("${sso.redis.host}")
    private String host;
    @Value("${sso.redis.port}")
    private Integer port;
    @Value("${sso.redis.password}")
    private String password;
    @Value("${sso.redis.server.connectionTimeout}")
    private Integer connectionTimeout;
    @Value("${sso.redis.server.soTimeout}")
    private Integer soTimeout;
    @Value("${sso.redis.server.weight}")
    private int weight;
    @Value("${sso.redis.server.blockWhenExhausted}")
    private boolean blockWhenExhausted;
    @Value("${sso.redis.server.maxWaitMillis}")
    private long maxWaitMillis;
    @Value("${sso.redis.server.minIdle}")
    private int minIdle;
    @Value("${sso.redis.server.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${sso.redis.server.numTestsPerEvictionRun}")
    private int numTestsPerEvictionRun;
    @Value("${sso.redis.server.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${sso.redis.server.maxIdle}")
    private int maxIdle;
    @Value("${sso.redis.server.maxTotal}")
    private int maxTotal;

    protected GenericObjectPoolConfig getGenericObjectPoolConfig() {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        genericObjectPoolConfig.setMaxWaitMillis(maxWaitMillis);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMaxTotal(maxTotal);
        genericObjectPoolConfig.setTestWhileIdle(testWhileIdle);
        genericObjectPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        genericObjectPoolConfig.setTestOnBorrow(testOnBorrow);
        return genericObjectPoolConfig;
    }

    protected JedisShardInfo getShard1Read() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port, connectionTimeout, soTimeout, weight);
        jedisShardInfo.setPassword(password);
        return jedisShardInfo;
    }

    protected JedisShardInfo getShard1Write() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port, connectionTimeout, soTimeout, weight);
        jedisShardInfo.setPassword(password);
        return jedisShardInfo;
    }

    protected ShardedJedisPool getJedisReadShardPool() {
        List<JedisShardInfo> shardInfos = new ArrayList<>();
        shardInfos.add(getShard1Read());
        return new ShardedJedisPool(getGenericObjectPoolConfig(), shardInfos);
    }

    protected ShardedJedisPool getJedisWriteShardPool() {
        List<JedisShardInfo> shardInfos = new ArrayList<>();
        shardInfos.add(getShard1Write());
        return new ShardedJedisPool(getGenericObjectPoolConfig(), shardInfos);
    }

    @Bean(name = "ssoRedisDataSource")
    public SSORedisDataSource getRedisDataSource() {
        SSORedisDataSourceImpl redisDataSource = new SSORedisDataSourceImpl();
        redisDataSource.setShardedJedisPool(getJedisReadShardPool());
        return redisDataSource;
    }

    @Bean(name = "ssoRedisClientTemplate")
    public SSORedisClientTemplate getRedisClientTemplate() {
        SSORedisClientTemplate redisClientTemplate = new SSORedisClientTemplate();
        redisClientTemplate.setRedisDataSource(getRedisDataSource());
        return redisClientTemplate;
    }

    @Bean(name = "ssoRedisUtil")
    public SSORedisUtil getRedisUtil(){
        SSORedisUtil redisUtil = new SSORedisUtil();
        redisUtil.setRedisClientTemplate(getRedisClientTemplate());
        return  redisUtil;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(Integer soTimeout) {
        this.soTimeout = soTimeout;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public int getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }
}

