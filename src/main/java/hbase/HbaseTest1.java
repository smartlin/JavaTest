package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by starlin
 * on 2017/10/23 10:52.
 */
public class HbaseTest1 {

    public static Logger logger = LoggerFactory.getLogger(HbaseTest1.class);


    //Creat����
    public static void createTable(Connection connection, TableName tableName, String... columnFamilies) throws IOException {
        Admin admin = null;
        try {
            admin = connection.getAdmin();
            if(admin.tableExists(tableName)){
                logger.warn("table:{} exists!", tableName.getName());
            }else{
                HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
                for(String columnFamily : columnFamilies) {
                    tableDescriptor.addFamily(new HColumnDescriptor(columnFamily));
                }
                admin.createTable(tableDescriptor);
                logger.info("create table:{} success!", tableName.getName());
            }
        } finally {
            if(admin!=null) {
                admin.close();
            }
        }
    }

    //put����
    /**�����������ʹ�� Table.put(List<Put> list)**/
    public static void put(Connection connection, TableName tableName, String rowKey, String columnFamily, String column, String data) throws IOException {
        Table table = null;
        try {
            table = connection.getTable(tableName);
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(data));
            table.put(put);
            //table.put(List<Put> put);
        } finally {
            if(table!=null) {
                table.close();
            }
        }
    }

    //get����������row key��ȡ���еĸ�������
    public static void get(Connection connection, TableName tableName, String rowKey) throws IOException {
        Table table = null;
        try {
            table = connection.getTable(tableName);
            Get get = new Get(Bytes.toBytes(rowKey));
            Result result = table.get(get);
            NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> navigableMap = result.getMap();
            for(Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> entry : navigableMap.entrySet()){

                logger.info("columnFamily:{}", Bytes.toString(entry.getKey()));
                NavigableMap<byte[], NavigableMap<Long, byte[]>> map =entry.getValue();
                for(Map.Entry<byte[], NavigableMap<Long, byte[]>> en:map.entrySet()){
                    System.out.print(Bytes.toString(en.getKey())+"##");
                    NavigableMap<Long, byte[]> nm = en.getValue();
                    for(Map.Entry<Long, byte[]> me : nm.entrySet()){
                        logger.info("column key:{}, value:{}", me.getKey(), me.getValue());
                    }
                }
            }
        } finally {
            if(table!=null) {
                table.close();
            }
        }
    }

    //scan����
    public static void scan(Connection connection, TableName tableName) throws IOException {
        Table table = null;
        try {
            table = connection.getTable(tableName);
            ResultScanner rs = null;
            try {
                //Scan scan = new Scan(Bytes.toBytes("u120000"), Bytes.toBytes("u200000"));
                rs = table.getScanner(new Scan());
                for(Result r:rs){
                    NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> navigableMap = r.getMap();
                    for(Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> entry : navigableMap.entrySet()){
                        logger.info("row:{} key:{}", Bytes.toString(r.getRow()), Bytes.toString(entry.getKey()));
                        NavigableMap<byte[], NavigableMap<Long, byte[]>> map =entry.getValue();
                        for(Map.Entry<byte[], NavigableMap<Long, byte[]>> en:map.entrySet()){
                            System.out.print(Bytes.toString(en.getKey())+"##");
                            NavigableMap<Long, byte[]> ma = en.getValue();
                            for(Map.Entry<Long, byte[]>e: ma.entrySet()){
                                System.out.print(e.getKey()+"###");
                                System.out.println(Bytes.toString(e.getValue()));
                            }
                        }
                    }
                }
            } finally {
                if(rs!=null) {
                    rs.close();
                }
            }
        } finally {
            if(table!=null) {
                table.close();
            }
        }
    }

    //delete����
    //ɾ�����е�����
    public static void deleteTable(Connection connection, TableName tableName) throws IOException {
        Admin admin = null;
        try {
            admin = connection.getAdmin();
            if (admin.tableExists(tableName)) {
                //������disable, ��delete
                admin.disableTable(tableName);
                admin.deleteTable(tableName);
                logger.info(tableName + "�� ��ɾ��");
            }
        } finally {
            if(admin!=null) {
                admin.close();
            }
        }
    }

    public static void testCrud() {
        System.setProperty("hadoop.home.dir", "D:\\tools\\hadoop-common-2.2.0-bin");
        Connection connection = null;
        try {
            connection = HBaseConnectionUtils.getConnection();
            TableName tableName = TableName.valueOf("PartyLog");

            //����HBase��
            //createTable(connection, tableName, "cf1", "cf2");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = simpleDateFormat.format(new Date());
            String date1 = simpleDateFormat1.format(new Date());
            System.out.println(date);
            //put
            for(int i=3440000;i<4000000;i++){
                String md5hash = MD5Hash.getMD5AsHex(Bytes.toBytes(String.valueOf(i))).substring(0, 7);
                //System.out.println(md5hash);
                put(connection, tableName, md5hash + String.valueOf(i) + date, "PartyLogCf", "partyId", ""+i);
                put(connection, tableName, md5hash + String.valueOf(i) + date, "PartyLogCf", "type", "type"+i);
                put(connection, tableName, md5hash + String.valueOf(i) + date, "PartyLogCf", "attributeName", "attributeName"+i);
                put(connection, tableName, md5hash + String.valueOf(i) + date, "PartyLogCf", "attributeValue", "attributeValue"+i);
                put(connection, tableName, md5hash + String.valueOf(i) + date, "PartyLogCf", "inputDate", "20180103");
            }

            //
            ////get
            //get(connection, tableName, rowKey);

            //scan��
          //  scan(connection, tableName);

            //delete
          //  deleteTable(connection, tableName);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //����д��
    public static void batchPut() throws IOException {
        //��ȡ���Ų���
        Configuration config = HBaseConfiguration.create();
        //��������
        Connection connection = ConnectionFactory.createConnection(config);
        try {
            //���ӱ� ��ȡ�����
            Table t = connection.getTable(TableName.valueOf("testtable"));
            BufferedMutator table = connection.getBufferedMutator(TableName.valueOf("testtable"));
            try {
                Put p = new Put(Bytes.toBytes("myrow-1"));
                //p.add(); ����ط���add �Ǹ����ڵķ���Ȼ���Ҳ���֪��Cell���÷���ʲô
                p.add(Bytes.toBytes("colfam1"), Bytes.toBytes("name1"), Bytes.toBytes("zhangsan1"));
                //table.put(p);
                List<Mutation> mutations = new ArrayList<Mutation>();
                mutations.add(p);
                table.mutate(mutations);
                //�����flush �ں���get�����ǿ�������
                table.flush();
                // Close your table and cluster connection.
                Get get=new Get(Bytes.toBytes("myrow-1"));
                Result result=t.get(get);
                for(Cell cell:result.rawCells()){
                    System.out.print("�н�: "+new String(CellUtil.cloneRow(cell)));
                    System.out.print("\t�д�: "+new String(CellUtil.cloneFamily(cell)));
                    System.out.print("\t��: "+new String(CellUtil.cloneQualifier(cell)));
                    System.out.print("\tֵ: "+new String(CellUtil.cloneValue(cell)));
                    System.out.println("\tʱ���: "+cell.getTimestamp());
                }
                System.out.print(">>>>end");
            } finally {
                if (table != null) {
                    table.close();
                }
            }
        } finally {
            connection.close();
        }
    }


    public static void main(String[] args) throws IOException {
        testCrud();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        //String date = simpleDateFormat.format(new Date());
        //System.out.println(date);

    }

}
