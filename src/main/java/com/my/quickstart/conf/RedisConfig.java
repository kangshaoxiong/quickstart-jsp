package com.my.quickstart.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.my.quickstart.base.BaseLogger;

/**
 * Redis 缓存配置
 * 
 * @author Alan
 *
 */
@Configuration
@EnableCaching
public class RedisConfig extends BaseLogger {

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RedisTemplate redisTemplate() {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean(name="cacheManager")
	public RedisCacheManager redisCacheManager() {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
		return cacheManager;
	}

}
