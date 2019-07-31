package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;

/**
 * Created by starlin
 * on 2017/10/24 13:35.
 */
public class HbaseTest2 {

    public static Configuration configuration;
    static{
        configuration = HBaseConfiguration.create();
        //configuration.set("hbase.master","ip1:60000");
        configuration.set("hbase.zookeeper.quorum", "192.168.235.131,192.168.235.132") ;
        configuration.set("hbase.zookeeper.property.clientPort","2181");
    }

    public static void creaTable(String tablename) throws Exception{
        HBaseAdmin admin = new HBaseAdmin(configuration);
        if(admin.tableExists(tablename)){
            admin.disableTable(tablename);
            admin.deleteTable(tablename);
            System.out.println("开始创建表！");
        }
        System.out.println("新的表正在创建中！！！");
        HTableDescriptor tableDescriptor = new HTableDescriptor(tablename);
        tableDescriptor.addFamily(new HColumnDescriptor("cf1"));
        admin.createTable(tableDescriptor);

        Put put = new Put("123".getBytes());
        put.add("cf1".getBytes(), "colum1".getBytes(), "value1".getBytes()) ;
        put.add("cf1".getBytes(), "colum2".getBytes(), "value2".getBytes()) ;
        put.add("cf1".getBytes(), "colum3".getBytes(), "value3".getBytes()) ;

        Put put2 = new Put("234".getBytes()) ;
        put2.add("cf1".getBytes(), "colum1".getBytes(), "value1".getBytes()) ;
        put2.add("cf1".getBytes(), "colum2".getBytes(), "value2".getBytes()) ;
        put2.add("cf1".getBytes(), "colum3".getBytes(), "value3".getBytes()) ;

        HTable table = new HTable(configuration, tablename);
        table.put(put);
        table.put(put2);
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("hadoop.home.dir", "D:\\tools\\hadoop-common-2.2.0-bin");
        creaTable("test1");
    }
}
