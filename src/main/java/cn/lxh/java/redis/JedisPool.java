//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lxh.java.redis;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.JedisURIHelper;
import redis.clients.util.Pool;

import java.net.URI;

public class JedisPool extends Pool<Jedis> {
  public JedisPool(GenericObjectPoolConfig poolConfig, String host) {
    this(poolConfig, host, 6379, 2000, (String)null, 0, (String)null);
  }

  public JedisPool(String host, int port) {
    this(new GenericObjectPoolConfig(), host, port, 2000, (String)null, 0, (String)null);
  }

  public JedisPool(String host) {
    URI uri = URI.create(host);
    if (uri.getScheme() != null && uri.getScheme().equals("redis")) {
      String h = uri.getHost();
      int port = uri.getPort();
      String password = JedisURIHelper.getPassword(uri);
      int database = 0;
      Integer dbIndex = JedisURIHelper.getDBIndex(uri);
      if (dbIndex != null) {
        database = dbIndex.intValue();
      }

      this.internalPool = new GenericObjectPool(new JedisFactory(h, port, 2000, password, database, (String)null), new GenericObjectPoolConfig());
    } else {
      this.internalPool = new GenericObjectPool(new JedisFactory(host, 6379, 2000, (String)null, 0, (String)null), new GenericObjectPoolConfig());
    }

  }

  public JedisPool(URI uri) {
    this(new GenericObjectPoolConfig(), (URI)uri, 2000);
  }

  public JedisPool(URI uri, int timeout) {
    this(new GenericObjectPoolConfig(), uri, timeout);
  }

  public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password) {
    this(poolConfig, host, port, timeout, password, 0, (String)null);
  }

  public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port) {
    this(poolConfig, host, port, 2000, (String)null, 0, (String)null);
  }

  public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout) {
    this(poolConfig, host, port, timeout, (String)null, 0, (String)null);
  }

  public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database) {
    this(poolConfig, host, port, timeout, password, database, (String)null);
  }

  public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database, String clientName) {
    super(poolConfig, new JedisFactory(host, port, timeout, password, database, clientName));
  }

  public JedisPool(GenericObjectPoolConfig poolConfig, URI uri) {
    this(poolConfig, (URI)uri, 2000);
  }

  public JedisPool(GenericObjectPoolConfig poolConfig, URI uri, int timeout) {
    super(poolConfig, new JedisFactory(uri.getHost(), uri.getPort(), timeout, JedisURIHelper.getPassword(uri), JedisURIHelper.getDBIndex(uri) != null ? JedisURIHelper.getDBIndex(uri).intValue() : 0, (String)null));
  }

  public Jedis getResource() {
    Jedis jedis = (Jedis)super.getResource();
    jedis.setDataSource(this);
    return jedis;
  }

  public void returnBrokenResource(Jedis resource) {
    if (resource != null) {
      this.returnBrokenResourceObject(resource);
    }

  }

  public void returnResource(Jedis resource) {
    if (resource != null) {
      try {
        resource.resetState();
        this.returnResourceObject(resource);
      } catch (Exception var3) {
        this.returnBrokenResource(resource);
        throw new JedisException("Could not return the resource to the pool", var3);
      }
    }

  }

  public int getNumActive() {
    return this.internalPool != null && !this.internalPool.isClosed() ? this.internalPool.getNumActive() : -1;
  }
}
