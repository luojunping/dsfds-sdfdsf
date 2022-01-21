package com.ljp.test.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;

public class RedissonClusterTest {

    public static void main(String[] args) {
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        clusterServersConfig.addNodeAddress("redis://luojunping:7001", "redis://luojunping:7002", "redis://luojunping:7003", "redis://luojunping:7004", "redis://luojunping:7005", "redis://luojunping:7006");
        clusterServersConfig.setUsername("admin");
        clusterServersConfig.setPassword("admin");
        RedissonClient redissonClient = Redisson.create(config);
        RLock rLock = redissonClient.getLock("luojunping");
//        rLock.lockAsync();
        rLock.lock();
    }


}
