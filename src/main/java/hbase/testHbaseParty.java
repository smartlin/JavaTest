package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class testHbaseParty {

        private static Configuration conf = null;
        static {
                conf = HBaseConfiguration.create();
                conf.set("hbase.zookeeper.quorum", "192.168.235.128");
                //conf.set("hbase.zookeeper.quorum", "192.168.235.131,192.168.235.132");
                //大数据测试集群
                //conf.set("hbase.zookeeper.quorum","10.33.88.33,10.33.88.35,10.33.88.36");
                conf.set("hbase.zookeeper.property.clientPort", "2181");
        }



        private static void createTable() throws MasterNotRunningException,
                        ZooKeeperConnectionException, IOException {

                HBaseAdmin admin = new HBaseAdmin(conf);// 新建一个数据库管理员//新api
                if (admin.tableExists(TableName.valueOf("LogTable"))) {
                        System.out.println("table is not exist!");
                        System.exit(0);
                } else {

                        HTableDescriptor desc = new HTableDescriptor(
                                        TableName.valueOf("PartyLog"));
                        desc.addFamily(new HColumnDescriptor("partyLogId"));
                        desc.addFamily(new HColumnDescriptor("partyId"));
                        desc.addFamily(new HColumnDescriptor("type"));
                        desc.addFamily(new HColumnDescriptor("attributeName"));
                        desc.addFamily(new HColumnDescriptor("attributeValue"));
                        desc.addFamily(new HColumnDescriptor("inputDate"));
                        desc.addFamily(new HColumnDescriptor("stampDate"));

                        admin.createTable(desc);
                        admin.close();
                        System.out.println("create table Success!");
                }
        }

        /*
         * 为表添加数据（适合知道有多少列族的固定表）
         * 
         * @rowKey rowKey
         * 
         * @tableName 表名
         * 
         * @column1 第一个列族列表
         * 
         * @value1 第一个列的值的列表
         *
         */
        private static void addData(String rowKey, String tableName,String[] column1, String[] value1,String[] column2,String[] value2,String[] column3,String[] value3,String[] column4,String value4,
                                    String[] column5,String[] value5,String[] column6,String[] value6) throws IOException {
                Put put = new Put(Bytes.toBytes(rowKey));// 设置rowkey
                HTable table = new HTable(conf, Bytes.toBytes(tableName));// HTabel负责跟记录相关的操作如增删改查等//
                                                                                                                                        // 获取表
                HColumnDescriptor[] columnFamilies = table.getTableDescriptor() // 获取所有的列族
                                .getColumnFamilies();

                for (int i = 0; i < columnFamilies.length; i++) {
                        String familyName = columnFamilies[i].getNameAsString(); // 获取列族名
                        if (familyName.equals("article")) { // article列族put数据
                                for (int j = 0; j < column1.length; j++) {
                                        put.add(Bytes.toBytes(familyName),
                                                        Bytes.toBytes(column1[j]), Bytes.toBytes(value1[j]));
                                }
                        }

                }
                table.put(put);
                System.out.println("add data Success!");
        }

        public static void main(String[] args) throws IOException {
                String[] cols = new String[1];
                String[] colsValue = new String[1];
                cols[0] = "title";
                colsValue[0] = "AboutYunArticle";

                // 创建表
                createTable();
                for(int i=0;i<10000;i++){
                  // 添加值
               //   addData("starlin"+i, "PartyLog", cols, colsValue);
                }

        }
}
