package cn.lxh.java.Fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * fastJson
 * @author Jfeng
 * @date 2017/10/10
 */
@SuppressWarnings("all")
@Slf4j
public class JsonResultUtil {

    private static final SerializeConfig config;
    private static final SerializeConfig configForParty;
    private static final SerializeConfig config1;
    private static final SerializeFilter[] filters;
    private static final SerializeFilter[] filters2;
    private static final SerializerFeature[] features;
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String dateFormat_party = "yyyy-MM-dd HH:mm:ss.S";
    private static final PascalNameFilter pascalNameFilter = new PascalNameFilter();

    static {
        config = new SerializeConfig();
        config.put(java.util.Date.class, new SimpleDateFormatSerializer(dateFormat));
        config.put(Integer.class,new ToStringSerializer());
        config.put(int.class,new ToStringSerializer());
        config.put(Long.class,new ToStringSerializer());
        config.put(long.class,new ToStringSerializer());
        config.put(Double.class,new ToStringSerializer());
        config.put(double.class,new ToStringSerializer());
        config.put(java.math.BigDecimal.class,new ToStringSerializer());
        config.put(Boolean.class,new ToStringSerializer());
        config.put(boolean.class,new ToStringSerializer());
        config.put(BigInteger.class,new ToStringSerializer());
        config.put(Byte.class,new ToStringSerializer());
        config.put(Float.class,new ToStringSerializer());
        config.put(Short.class,new ToStringSerializer());


        configForParty = new SerializeConfig();
        //增加字段类型转换
        configForParty.put(java.util.Date.class, new SimpleDateFormatSerializer(dateFormat_party));
        configForParty.put(Integer.class,new ToStringSerializer());
        configForParty.put(int.class,new ToStringSerializer());
        configForParty.put(Long.class,new ToStringSerializer());
        configForParty.put(long.class,new ToStringSerializer());
        configForParty.put(Double.class,new ToStringSerializer());
        configForParty.put(double.class,new ToStringSerializer());
        configForParty.put(java.math.BigDecimal.class,new ToStringSerializer());
        configForParty.put(Boolean.class,new ToStringSerializer());
        configForParty.put(boolean.class,new ToStringSerializer());
        configForParty.put(BigInteger.class,new ToStringSerializer());
        configForParty.put(Byte.class,new ToStringSerializer());
        configForParty.put(Float.class,new ToStringSerializer());


        config1 = new SerializeConfig();

        List<SerializerFeature> featureList = new ArrayList<>();
        featureList.add(SerializerFeature.WriteMapNullValue); // 输出空置字段
        featureList.add(SerializerFeature.WriteNullListAsEmpty); // list字段如果为null，输出为[]
        featureList.add(SerializerFeature.WriteNullNumberAsZero); // 数值字段如果为null，输出为0
        featureList.add(SerializerFeature.WriteNullBooleanAsFalse); // Boolean字段如果为null，输出为false
        featureList.add(SerializerFeature.WriteNullStringAsEmpty); // 字符类型字段如果为null，输出为""

        featureList.add(SerializerFeature.WriteDateUseDateFormat); // 全局修改日期格式。JSON.DEFFAULT_DATE_FORMAT = “yyyy-MM-dd”
        featureList.add(SerializerFeature.DisableCircularReferenceDetect); // 关闭FastJson的引用检测
        features = featureList.toArray(new SerializerFeature[featureList.size()]);

        List<SerializeFilter> filterList = new ArrayList<>();
        ValueFilter valueFilter = new ValueFilter() {
            @Override
            public Object process(Object object, String name, Object value) {
                if(value instanceof List){
                    return value;
                }
                if (value == null){
                    return "";
                }
                return value;
            }
        };
        filterList.add(valueFilter);
        filterList.add(pascalNameFilter);
        filters = filterList.toArray(new SerializeFilter[filterList.size()]);
        List<SerializeFilter> filterList2 = new ArrayList<>();
        filterList2.add(valueFilter);
        filters2=filterList2.toArray(new SerializeFilter[filterList2.size()]);
    }

    public static String toJSONString(Object o) {
        return JSON.toJSONString(o, config,filters2,features);
    }
    //陈敏专用
    public static String toJSONString2(Object o) {
        return JSON.toJSONString(o, configForParty, filters2, features);
    }

    public static String toJSONString(Object o, SerializerFeature... feature) {
        return JSON.toJSONString(o, config, feature);
    }

    public static String toJSONString1(Object o) {
        return JSON.toJSONString(o, config1,features);
    }
    /**
     * key 全小写的方法
     * @param o
     * @param feature
     * @return
     */
    public static String toLowString(Object o) {
        return JSON.toJSONString(o, configForParty, filters, features);
    }

    /**
     * 不输出空字段
     * @param o
     * @return
     */
    public static String toJSONStringWithPrettyFormat(Object o) {
        return JSON.toJSONString(o, SerializerFeature.PrettyFormat);
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * map 转 Class 对象
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(Map<String, String> map, Class<T> clazz) {
        String json = toJSONString(map);
        return JSON.parseObject(json, clazz);
    }

    /**
     * 解析数组
     * @param json  [{ ... }, { ... }]
     */
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }


    public static String getCommonJson(String result, String msg, String count, Object data)
    {
        String dataJson = "\"\"";
        try {
            if (data != null)
                dataJson = toJSONString(data);
        }
        catch (Exception e) {
            result = "error";
            msg = "封装json产生异常";
        }
        String r = "{\"result\":\"" + result + "\",\"msg\":\"" + msg + "\",\"count\":\"" + count + "\",\"data\":" + dataJson + "}";
        return r;
    }
    public static String getCommonJson2(String result, String msg, String count, Object data)
    {
        String dataJson = "\"\"";
        try {
            if (data != null)
                dataJson = toJSONString2(data);
        }
        catch (Exception e) {
            result = "error";
            msg = "封装json产生异常";
        }
        String r = "{\"result\":\"" + result + "\",\"msg\":\"" + msg + "\",\"count\":\"" + count + "\",\"data\":" + dataJson + "}";
        return r;
    }

    /**
     * @func 老版本特殊返回 不推荐使用
     */
    public static String getPageListJson(List list, String count)
    {
        String cJson = toLowString(list);
        String r = "{\"Count\":" + count + ",\"Data\":" + cJson + "}";

        return r;
    }

    public static String getMsgJson(String msg) {
        String r = "{\"msg\":\"" + msg +  "\"}";
        return r;
    }
    public static String string2json(String s) {
        if (s == null)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if ((ch >= 0) && (ch <= '\037')) {
                        String ss = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            sb.append('0');
                        }
                        sb.append(ss.toUpperCase());
                    } else {
                        sb.append(ch);
                    }break;
            }
        }
        return sb.toString();
    }

    public static String getCommonJsonCapital(String result, String msg, String count, Object data){
        String dataJson = "\"\"";
        try {
            if (data != null)
                dataJson = toJSONString(data);
        }
        catch (Exception e) {
            result = "error";
            msg = "封装json产生异常";
        }
        String r = "{\"result\":\"" + result + "\",\"msg\":\"" + msg + "\",\"Count\":\"" + count + "\",\"Data\":" + dataJson + "}";
        return r;
    }

    /**
     * 将对象转成json格式
     */
    public static Map<String, Object>   convertJsonStrToMap(String jsonStr){
        Map<String, Object> map = JSON.parseObject(jsonStr,new TypeReference<Map<String, Object>>(){} );
        return map;
    }


    public static String getMsgIdJson(String msg, String id)
    {
        String cJson = string2json(msg);
        return "{\"msg\":\"" + cJson + "\",\"id\":\"" + id + "\"}";
    }


    public static<T> T convertFromJson(String json,TypeReference<T> type) {
        try {

            return JSON.parseObject(JSON.parse(json).toString(),type, Feature.IgnoreNotMatch);
        } catch (Exception e) {
            log.error("[partysdk序列化失败]{}{}", json,e);
        }
        return null;
    }

    public static void main(String[] args) {
        //JsonResultUtil.convertFromJson()
    }
}
