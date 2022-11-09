package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HbaseTest {
    private HBaseAdmin admin = null;
    // �������ö���HBaseConfiguration  
    private HBaseConfiguration cfg = null;
  
    public HbaseTest() throws Exception {  
        Configuration HBASE_CONFIG = new Configuration();
  
        HBASE_CONFIG.set("hbase.zookeeper.quorum", "192.168.235.128");
  
        HBASE_CONFIG.set("hbase.zookeeper.property.clientPort", "2181");  
  
        cfg = new HBaseConfiguration(HBASE_CONFIG);  
  
        admin = new HBaseAdmin(cfg);  
    }  
  
    // ����һ�ű�ָ������������  
    public void createTable(String tableName, String columnFarily)  
            throws Exception {  
  
        if (admin.tableExists(tableName)) {  
            System.out.println(tableName + "���ڣ�");  
            System.exit(0);  
        } else {  
            HTableDescriptor tableDesc = new HTableDescriptor(tableName);
            tableDesc.addFamily(new HColumnDescriptor(columnFarily));
            admin.createTable(tableDesc);  
            System.out.println("������ɹ���");  
        }  
    }  
  
    // Hbase��ȡ���еı���Ϣ  
    public List getAllTables() {
        List<String> tables = null;  
        if (admin != null) {  
            try {  
                HTableDescriptor[] allTable = admin.listTables();  
                if (allTable.length > 0)  
                    tables = new ArrayList<String>();
                for (HTableDescriptor hTableDescriptor : allTable) {  
                    tables.add(hTableDescriptor.getNameAsString());  
                    System.out.println(hTableDescriptor.getNameAsString());  
                }  
            } catch (IOException e) {
                e.printStackTrace();  
            }  
        }  
        return tables;  
    }  
  
    // Hbase����ĳ���������һ����¼  
    public boolean addOneRecord(String table, String key, String family,  
            String col, byte[] dataIn) {  
        HTablePool tp = new HTablePool(cfg, 1000);
        HTable tb = (HTable) tp.getTable(table);
        Put put = new Put(key.getBytes());
        put.add(family.getBytes(), col.getBytes(), dataIn);  
        try {  
            tb.put(put);  
            System.out.println("����������" + key + "�ɹ�������");  
            return true;  
        } catch (IOException e) {  
            System.out.println("����������" + key + "ʧ�ܣ�����");  
            return false;  
        }  
    }  
  
    // Hbase���м�¼��Ϣ�Ĳ�ѯ  
    public void getValueFromKey(String table, String key) {  
        HTablePool tp = new HTablePool(cfg, 1000);  
        HTable tb = (HTable) tp.getTable(table);  
        Get get = new Get(key.getBytes());  
        try {  
            Result rs = tb.get(get);  
            if (rs.raw().length == 0) {  
                System.out.println("�����ڹؼ���Ϊ" + key + "���У�!");  
  
            } else {  
                for (KeyValue kv : rs.raw()) {
                    System.out.println(new String(kv.getKey()) + " "  
                            + new String(kv.getValue()));  
                }  
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    // ��ʾ�������ݣ�ͨ��HTable Scan���ȡ���б����Ϣ  
    public void getAllData(String tableName) throws Exception {  
        HTable table = new HTable(cfg, tableName);  
        Scan scan = new Scan();  
        ResultScanner rs = table.getScanner(scan);
        for (Result r : rs) {  
            for (KeyValue kv : r.raw()) {  
                System.out.println(new String(kv.getKey())  
                        + new String(kv.getValue()));  
            }  
        }  
    }  
  
    // Hbase���м�¼��Ϣ��ɾ��  
    public boolean deleteRecord(String table, String key) {  
        HTablePool tp = new HTablePool(cfg, 1000);  
        HTable tb = (HTable) tp.getTable(table);  
        Delete de = new Delete(key.getBytes());  
        try {  
            tb.delete(de);  
            return true;  
        } catch (IOException e) {  
            System.out.println("ɾ����¼" + key + "�쳣������");  
            return false;  
        }  
    }  
  
    // Hbase�б��ɾ��  
    public boolean deleteTable(String table) {  
        try {  
            if (admin.tableExists(table)) {  
                admin.disableTable(table);  
                admin.deleteTable(table);  
                System.out.println("ɾ����" + table + "!!!");  
            }  
            return true;  
        } catch (IOException e) {  
            System.out.println("ɾ����" + table + "�쳣!!!");  
            return false;  
        }  
    }


    // ���Ժ���  
    public static void main(String[] args) {  
        try {  
            HbaseTest hbase = new HbaseTest();  
             //hbase.createTable("test", "id");
             hbase.getAllTables();
  
            // hbase.addOneRecord("student","id1","fam1","name","Jack".getBytes());  
            // hbase.addOneRecord("student","id1","fam1","address","HZ".getBytes());  
            // hbase.getValueFromKey("student","id1");  
            // hbase.getAllData("student");  
  
            //hbase.deleteRecord("student", "id1");  
              
            //hbase.deleteTable("student");
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  