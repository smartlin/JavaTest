package cn.lxh.java;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by starlin
 * on 2016/11/23 10:03.
 */
public class GsonTest {
    public static void main(String[] args) {
        String json = "[{\"name\":\"Duke\",\"address\":\"Menlo Park\",\"dateOfBirth\":\"Feb 1, 2000 12:00:00 AM\"}]";
        //String json = "[{\"id\":\"2117\",\"des\":\"Days.not.use.gas.to.valve.off\",\"groupNum\":\"3\"},{\"id\":\"2201\",\"des\":\"Balance.shortage.class.1.alarm\",\"groupNum\":\"5\"},{\"id\":\"2202\",\"des\":\"Balance.shortage.class.2.alarm\",\"groupNum\":\"5\"},{\"id\":\"2203\",\"des\":\"Low.battery\",\"groupNum\":\"5\"},{\"id\":\"2204\",\"des\":\"Signal.mutation\",\"groupNum\":\"5\"},{\"id\":\"2205\",\"des\":\"Battery.mutation\",\"groupNum\":\"5\"},{\"id\":\"2206\",\"des\":\"Use.gas.abnormal.Smaller.than.monthly.average\",\"groupNum\":\"5\"},{\"id\":\"2207\",\"des\":\"Reading.abnormal.Smaller\",\"groupNum\":\"5\"},{\"id\":\"2208\",\"des\":\"Time.within.the.meter.abnormal\",\"groupNum\":\"5\"},{\"id\":\"2101\",\"des\":\"Run.out.Balance.shortage\",\"groupNum\":\"1\"},{\"id\":\"2102\",\"des\":\"Low.voltage.Low.battery\",\"groupNum\":\"1\"},{\"id\":\"2103\",\"des\":\"Power.down\",\"groupNum\":\"1\"},{\"id\":\"2104\",\"des\":\"Overflow\",\"groupNum\":\"1\"},{\"id\":\"2105\",\"des\":\"EMI\",\"groupNum\":\"1\"},{\"id\":\"2107\",\"des\":\"Bilateral.magnetic.interference\",\"groupNum\":\"1\"},{\"id\":\"2106\",\"des\":\"Unilateral.interference\",\"groupNum\":\"1\"},{\"id\":\"2111\",\"des\":\"Meters.be.mandatory.valve.off\",\"groupNum\":\"2\"},{\"id\":\"2108\",\"des\":\"Valve.off\",\"groupNum\":\"1\"},{\"id\":\"2118\",\"des\":\"GPRS.restricted.start\",\"groupNum\":\"3\"},{\"id\":\"2119\",\"des\":\"Exist.new.user.information.in.the.meter\",\"groupNum\":\"3\"},{\"id\":\"2112\",\"des\":\"Dismantle.meter.test\",\"groupNum\":\"2\"},{\"id\":\"2120\",\"des\":\"Valve.is.not.available\",\"groupNum\":\"3\"},{\"id\":\"2114\",\"des\":\"GPRS.be.mandatory.closed.by.server\",\"groupNum\":\"2\"},{\"id\":\"2121\",\"des\":\"External.alarm.trigger\",\"groupNum\":\"3\"},{\"id\":\"2115\",\"des\":\"Unit.price.is.0\",\"groupNum\":\"2\"},{\"id\":\"2122\",\"des\":\"External.crystal.stop\",\"groupNum\":\"3\"},{\"id\":\"2116\",\"des\":\"Days.not.upload.GPRS.data.success.to.valve.off\",\"groupNum\":\"2\"},{\"id\":\"2113\",\"des\":\"Monthly.upload.data.function.open\",\"groupNum\":\"2\"},{\"id\":\"2110\",\"des\":\"Out-of-Factory.marking\",\"groupNum\":\"2\"},{\"id\":\"2109\",\"des\":\"Direct.reading.abnormal\",\"groupNum\":\"2\"},{\"id\":\"2501\",\"des\":\"备电掉电（有备电时）\",\"groupNum\":\"6\"},{\"id\":\"2502\",\"des\":\"主电压低/电量不足\",\"groupNum\":\"6\"},{\"id\":\"2503\",\"des\":\"主电掉电\",\"groupNum\":\"6\"},{\"id\":\"2504\",\"des\":\"过流\",\"groupNum\":\"6\"},{\"id\":\"2505\",\"des\":\"预留\",\"groupNum\":\"6\"},{\"id\":\"2506\",\"des\":\"单边干扰\",\"groupNum\":\"6\"},{\"id\":\"2507\",\"des\":\"双边磁干扰\",\"groupNum\":\"6\"},{\"id\":\"2508\",\"des\":\"阀门关\",\"groupNum\":\"6\"},{\"id\":\"2509\",\"des\":\"预留\",\"groupNum\":\"7\"},{\"id\":\"2510\",\"des\":\"出厂标识\",\"groupNum\":\"7\"},{\"id\":\"2511\",\"des\":\"表具被强制命令关阀\",\"groupNum\":\"7\"},{\"id\":\"2512\",\"des\":\"阀门直通\",\"groupNum\":\"7\"},{\"id\":\"2513\",\"des\":\"预留\",\"groupNum\":\"7\"},{\"id\":\"2514\",\"des\":\"预留\",\"groupNum\":\"7\"},{\"id\":\"2515\",\"des\":\"预留\",\"groupNum\":\"7\"},{\"id\":\"2516\",\"des\":\"预留\",\"groupNum\":\"7\"}]";
        Gson gson = new Gson();

//使用Type类，取得相应类型对象的class属性。
        Type listType=new TypeToken<ArrayList<Student>>(){}.getType();//TypeToken内的泛型就是Json数据中的类型
        ArrayList<Student> list = gson.fromJson(json, listType);//使用该class属性，获取的对象均是list类型的

        System.out.println("student.getName()  = " + list.get(0).getDes());//从list中取得内容即可
        System.out.println("student.getAddress() = " + list.get(0).getId());
        System.out.println("student.getDateOfBirth() = "
                + list.get(0).getGroupNum());
    }
}
