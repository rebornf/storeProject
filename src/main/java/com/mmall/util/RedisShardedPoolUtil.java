package com.mmall.util;

import com.mmall.common.RedisShardedPool;
import com.mmall.common.RedisShardedPool;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedis;

/**
 * Created with IntelliJ IDEA By lxy on 2018/10/29
 * 分布式redis的业务代码，暂时没有调用
 */
@Slf4j
public class RedisShardedPoolUtil {

	public static String set(String key,String value){
		ShardedJedis jedis = null;
		String result = null;

		try {
			jedis = RedisShardedPool.getJedis();
			result = jedis.set(key,value);
		}catch (Exception e){
			log.error("set key{} value:{} error",key,value,e);
			RedisShardedPool.returnBrokenResource(jedis);
			return result;
		}
		RedisShardedPool.returnResource(jedis);
		return result;
	}

	public static String getSet(String key, String value){
		ShardedJedis jedis = null;
		String result = null;

		try {
			jedis = RedisShardedPool.getJedis();
			result = jedis.getSet(key,value);
		}catch (Exception e){
			log.error("getSet key{} value:{} error",key,value,e);
			RedisShardedPool.returnBrokenResource(jedis);
			return result;
		}
		RedisShardedPool.returnResource(jedis);
		return result;
	}

	//ex单位为s
	public static String setEx(String key,String value,int exTime){
		ShardedJedis jedis = null;
		String result = null;

		try {
			jedis = RedisShardedPool.getJedis();
			result = jedis.setex(key,exTime,value);
		}catch (Exception e){
			log.error("setEx key{} value:{} error",key,value,e);
			RedisShardedPool.returnBrokenResource(jedis);
			return result;
		}
		RedisShardedPool.returnResource(jedis);
		return result;
	}

	//重新设置key的有效期多久
	public static Long expire(String key,int exTime){
		ShardedJedis jedis = null;
		Long result = null;

		try {
			if (key != null){
				jedis = RedisShardedPool.getJedis();
				result = jedis.expire(key,exTime);
			}else {
				return null;
			}
		}catch (Exception e){
			log.error("setExpire key{} value:{} error",key,e);
			RedisShardedPool.returnBrokenResource(jedis);
			return result;
		}
		RedisShardedPool.returnResource(jedis);
		return result;
	}

	public static String get(String key){
		ShardedJedis jedis = null;
		String result = null;
		try {
			if (key != null){
				jedis = RedisShardedPool.getJedis();
				result = jedis.get(key);
			}else {
				return result;
			}
		}catch (Exception e){
			log.error("get key{} error",key,e);
			RedisShardedPool.returnBrokenResource(jedis);
			return result;
		}
		RedisShardedPool.returnResource(jedis);
		return result;
	}

	public static Long del(String key){
		ShardedJedis jedis = null;
		Long result = null;
		try {
			if (key != null){
				jedis = RedisShardedPool.getJedis();
				result = jedis.del(key);
			}else {
				return result;
			}
		}catch (Exception e){
			log.error("del key{} error",key,e);
			RedisShardedPool.returnBrokenResource(jedis);
			return result;
		}
		RedisShardedPool.returnResource(jedis);
		return result;
	}

	//设置key的时候，只有当set的key不存在的时候才会成功
	public static Long setnx(String key,String value){
		ShardedJedis jedis = null;
		Long result = null;

		try {
			jedis = RedisShardedPool.getJedis();
			result = jedis.setnx(key,value);
		}catch (Exception e){
			log.error("setnx key{} value:{} error",key,value,e);
			RedisShardedPool.returnBrokenResource(jedis);
			return result;
		}
		RedisShardedPool.returnResource(jedis);
		return result;
	}



}
