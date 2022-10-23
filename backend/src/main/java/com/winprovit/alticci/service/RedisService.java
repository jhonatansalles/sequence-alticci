package com.winprovit.alticci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void set(Long key, Object value) {
		redisTemplate.opsForValue().set(String.valueOf(key), value, 1, TimeUnit.DAYS);
	}
	
	public Long get(Long key) {
		return ((Integer) redisTemplate.opsForValue().get(String.valueOf(key))).longValue();
	}

	public Boolean hasKey(Long key) {
		return redisTemplate.hasKey(String.valueOf(key));
	}
}