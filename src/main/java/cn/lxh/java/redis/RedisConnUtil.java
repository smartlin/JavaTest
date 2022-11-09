//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lxh.java.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RedisConnUtil {
  private static JedisPool pool = null;
  static Map<String, String> map = new HashMap();

  public RedisConnUtil() {
  }

  public static JedisPool getPool() {
    if (pool == null) {
      JedisPoolConfig config = new JedisPoolConfig();
      config.setMaxTotal(500);
      config.setMaxIdle(10);
      config.setMaxWaitMillis(60000L);
      config.setTestOnBorrow(true);
      //pool = new JedisPool(config, "10.201.1.1", 6379);
      pool = new JedisPool(config, "10.20.11.55", 6379);
    }

    return pool;
  }

  public static void returnResource(JedisPool pool, Jedis redis) {
    if (redis != null) {
      pool.returnResource(redis);
    }

  }

  public static String get(String key) {
    String value = null;
    JedisPool pool = null;
    Jedis jedis = null;

    try {
      pool = getPool();
      jedis = pool.getResource();
      value = jedis.get(key);
    } catch (Exception var8) {
      pool.returnBrokenResource(jedis);
      var8.printStackTrace();
    } finally {
      returnResource(pool, jedis);
    }

    return value;
  }

  public static String set(String key, String value) {
    JedisPool pool = null;
    Jedis jedis = null;

    try {
      pool = getPool();
      jedis = pool.getResource();
      value = jedis.set(key, value);
      String var6 = value;
      return var6;
    } catch (Exception var9) {
      pool.returnBrokenResource(jedis);
      var9.printStackTrace();
    } finally {
      returnResource(pool, jedis);
    }

    return null;
  }

  public static Long del(String key) {
    JedisPool pool = null;
    Jedis jedis = null;

    try {
      pool = getPool();
      jedis = pool.getResource();
      Long var5 = jedis.del(key);
      return var5;
    } catch (Exception var8) {
      pool.returnBrokenResource(jedis);
      var8.printStackTrace();
    } finally {
      returnResource(pool, jedis);
    }

    return null;
  }

  public static String hmget(String key, String... field) {
    String value = null;
    JedisPool pool = null;
    Jedis jedis = null;

    try {
      pool = getPool();
      jedis = pool.getResource();
      value = (String)jedis.hmget(key, field).get(0);
    } catch (Exception var9) {
      pool.returnBrokenResource(jedis);
      var9.printStackTrace();
    } finally {
      returnResource(pool, jedis);
    }

    return value;
  }

  public static String hmset(String key, String field, String value) {
    JedisPool pool = null;
    Jedis jedis = null;

    try {
      pool = getPool();
      jedis = pool.getResource();
      HashMap<String, String> map = new HashMap(1);
      map.put(field, value);
      value = jedis.hmset(key, map);
      String var7 = value;
      return var7;
    } catch (Exception var10) {
      pool.returnBrokenResource(jedis);
      var10.printStackTrace();
    } finally {
      returnResource(pool, jedis);
    }

    return null;
  }

  public static void main(String[] args) {
    File file = new File("d:"+File.separator+"×ª±í.txt");
    FileInputStream inputStream = null;
    BufferedReader bufferedReader = null;

    try {
      inputStream = new FileInputStream(file);
      bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String str = null;
      String dtu = null;
      int var6 = 0;

      while((str = bufferedReader.readLine()) != null) {
        ++var6;
        dtu = str.substring(2);
        System.out.println(dtu + "@" + str);
        hmset(dtu, "id", "1");
        hmset(dtu, "no", str);
      }
    } catch (Exception var15) {
      var15.printStackTrace();
    } finally {
      try {
        bufferedReader.close();
      } catch (IOException var14) {
        var14.printStackTrace();
      }

    }

  }
}
