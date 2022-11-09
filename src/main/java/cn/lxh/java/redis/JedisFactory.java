//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lxh.java.redis;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicReference;

class JedisFactory implements PooledObjectFactory<Jedis> {
    private final AtomicReference<HostAndPort> hostAndPort;
    private final int timeout;
    private final String password;
    private final int database;
    private final String clientName;

    public JedisFactory(String host, int port, int timeout, String password, int database) {
        this(host, port, timeout, password, database, (String)null);
    }

    public JedisFactory(String host, int port, int timeout, String password, int database, String clientName) {
        this.hostAndPort = new AtomicReference();
        this.hostAndPort.set(new HostAndPort(host, port));
        this.timeout = timeout;
        this.password = password;
        this.database = database;
        this.clientName = clientName;
    }

    public void setHostAndPort(HostAndPort hostAndPort) {
        this.hostAndPort.set(hostAndPort);
    }

    public void activateObject(PooledObject<Jedis> pooledJedis) throws Exception {
        BinaryJedis jedis = (BinaryJedis)pooledJedis.getObject();
        if (jedis.getDB().longValue() != (long)this.database) {
            jedis.select(this.database);
        }

    }

    public void destroyObject(PooledObject<Jedis> pooledJedis) throws Exception {
        BinaryJedis jedis = (BinaryJedis)pooledJedis.getObject();
        if (jedis.isConnected()) {
            try {
                try {
                    jedis.quit();
                } catch (Exception var4) {
                    ;
                }

                jedis.disconnect();
            } catch (Exception var5) {
                ;
            }
        }

    }

    public PooledObject<Jedis> makeObject() throws Exception {
        HostAndPort hostAndPort = (HostAndPort)this.hostAndPort.get();
        Jedis jedis = new Jedis(hostAndPort.getHost(), hostAndPort.getPort(), this.timeout);
        jedis.connect();
        if (null != this.password) {
            jedis.auth(this.password);
        }

        if (this.database != 0) {
            jedis.select(this.database);
        }

        if (this.clientName != null) {
            jedis.clientSetname(this.clientName);
        }

        return new DefaultPooledObject(jedis);
    }

    public void passivateObject(PooledObject<Jedis> pooledJedis) throws Exception {
    }

    public boolean validateObject(PooledObject<Jedis> pooledJedis) {
        BinaryJedis jedis = (BinaryJedis)pooledJedis.getObject();

        try {
            HostAndPort hostAndPort = (HostAndPort)this.hostAndPort.get();
            String connectionHost = jedis.getClient().getHost();
            int connectionPort = jedis.getClient().getPort();
            return hostAndPort.getHost().equals(connectionHost) && hostAndPort.getPort() == connectionPort && jedis.isConnected() && jedis.ping().equals("PONG");
        } catch (Exception var6) {
            return false;
        }
    }
}
