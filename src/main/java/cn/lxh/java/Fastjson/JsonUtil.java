package cn.lxh.java.Fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by starlin
 * on 2019/2/21 16:07.
 */
@Slf4j
public class JsonUtil {
    public static<T> T convertFromJson(String json, TypeReference<T> type) {
        try {
            return JSON.parseObject(json,type, Feature.IgnoreNotMatch);
        } catch (Exception e) {
            log.error("[序列化失败]{}{}", json,e);
        }
        return null;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge("20");
        person.setEname("ceshi");
        PartyResult partyResult = new PartyResult();
        partyResult.setCode("1");
        partyResult.setCount("");
        partyResult.setData("");
        partyResult.setMsg("merchantId不能为空");
        partyResult.setResult("error");
        System.out.println(partyResult.toCamelString());
        System.out.println(JsonUtil.convertFromJson(partyResult.toCamelString(), new TypeReference() {
        }));
    }
}
