import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import java.util.Hashtable;

/**
 * Created by starlin
 * on 2016/04/22 9:27.
 */
public class test {
    public static void main(String[] args) {
        /*String s = "123,134,156,";
        String[] msg = s.split(",");
        for(int i=0;i<msg.length;i++){
            System.out.println(msg[i]);
        }*/
        //String msg = "{\"message\":\"交易码不存在\",\"dftyp\":\"46\",\"begru\":\"0571\",\"serge\":\"?\",\"anlage\":\"\",\"errorCode\":\"Error\",\"concetrarid\":\"?\",\"duser\":\"3A\",\"mopre\":\"?\",\"sergeO\":\"?\",\"editfile\":\"\",\"amicode\":\"0571\"}";
        //System.out.println(jsontoXml(msg));
        String sql = "";
        StringBuffer sqlQuery = new StringBuffer();
        sqlQuery.append(" select * from ( select t_1.* , rownum rownumber from ( ");
        sqlQuery.append( sql );
        sqlQuery.append("  )t_1 )t_temp where t_temp.rownumber > :startIndex and t_temp.rownumber <= :lastIndex ");
        System.out.println(sqlQuery);
        Hashtable hashtable = new Hashtable();
    }

    public static String jsontoXml(String json) {
        try {
            XMLSerializer serializer = new XMLSerializer();
            JSON jsonObject = JSONSerializer.toJSON(json);
            return serializer.write(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
