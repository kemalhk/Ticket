package com.example.Ticket.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {
    private final static int cache_clear_interval = 3;
    private int requestCount = 0;

    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunningMethod()throws InterruptedException{
        requestCount++;
        if (requestCount >= cache_clear_interval)
        {
            clearCache();
            requestCount=0;
        }
        Thread.sleep(5000L);
        return "method calisti";
    }

    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache(){
        System.out.println("cache temizlendi");
    }
}
