package hbase;


import hbase.util.PropertiesUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;


public class HBaseConnectionUtils {

    public static Connection getConnection() throws IOException {
        Connection connection = ConnectionFactory.createConnection(getConfiguration());
        return connection;
    }

    private static Configuration getConfiguration() throws IOException {

        Properties props = PropertiesUtils.load("hbase/hbase.properties");
        System.out.println(props.getProperty("hbase.zookeeper.quorum"));
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", props.getProperty("hbase.zookeeper.quorum"));
        config.set("hbase.zookeeper.property.clientPort", props.getProperty("hbase.zookeeper.property.clientPort"));
        //config.set("hbase.zookeeper.quorum","192.168.235.128");
        //config.set("hbase.zookeeper.property.clientPort", "2181");
        return config;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("----->"+HBaseConnectionUtils.getConnection());
    }
}
