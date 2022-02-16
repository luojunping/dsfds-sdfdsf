package com.ljp.test.redis;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class RedissonClusterTest {

    public static void main(String[] args) {
//        Config config = new Config();
//        ClusterServersConfig clusterServersConfig = config.useClusterServers();
//        clusterServersConfig.addNodeAddress("redis://luojunping:7001", "redis://luojunping:7002", "redis://luojunping:7003", "redis://luojunping:7004", "redis://luojunping:7005", "redis://luojunping:7006");
//        clusterServersConfig.setUsername("admin");
//        clusterServersConfig.setPassword("admin");
//        RedissonClient redissonClient = Redisson.create(config);
//        RLock rLock = redissonClient.getLock("luojunping");
////        rLock.lockAsync();
//        rLock.lock();
    }

    @Test
    public void testScan() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("redisson-test.yml");
        InputStream inputStream = classPathResource.getInputStream();
        Config config = Config.fromYAML(inputStream);
        RedissonClient redissonClient = Redisson.create(config);
        RKeys rKeys = redissonClient.getKeys();
        Iterable<String> keysByPattern = rKeys.getKeysByPattern("hello-*", 1);
        keysByPattern.forEach(System.err::println);
        System.err.println("-----------------------------");
        rKeys.getKeys(1).forEach(System.err::println);
//        System.out.println("-----------------------------");
//        System.out.println("rKeys.deleteByPattern(\"hello*\") = " + rKeys.deleteByPattern("hello*"));
//        keysByPattern = rKeys.getKeysByPattern("hello*", 100);
//        System.out.println("rKeys.delete(\"hello\") = " + rKeys.delete("hello"));
//        keysByPattern.forEach(System.err::println);
//        System.out.println("-----------------------------");
//        Iterable<String> keys = rKeys.getKeys();
//        keys.forEach(System.err::println);
//        RAtomicLong rAtomicLong = redissonClient.getAtomicLong("hello-1");
//        System.out.println("rAtomicLong.get() = " + rAtomicLong.get());
//        RBucket<String> rBucket = redissonClient.getBucket("hello");
//        rBucket = redissonClient.getBucket("hello", StringCodec.INSTANCE);
//        System.out.println("rBucket.get() = " + rBucket.get());
        redissonClient.shutdown();
    }

}
