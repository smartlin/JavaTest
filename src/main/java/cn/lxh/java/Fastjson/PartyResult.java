package cn.lxh.java.Fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Jfeng Date: 2017/3/7
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@SuppressWarnings("all")
public class PartyResult<T> implements Serializable {
    private static final long serialVersionUID = -2466637085792266744L;

    private String result;

    private String code;

    private String msg;

    private String count;

    private T data;

    public PartyResult(String result, String code, String msg, String count, T data) {
        this.result = result;
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String toCamelString() {
        return JsonResultUtil.toJSONString(this);
    }

    @JSONField(serialize = false)
    public void setSuccessResult(){
        this.setCode("200");
        this.setResult("success");
        this.setMsg("²Ù×÷³É¹¦");
    }

    @JSONField(serialize = false)
    public void setSuccessResult(String msg){
        this.setCode("200");
        this.setResult("success");
        this.setMsg(msg);
    }


    @JSONField(serialize = false)
    public void setErrorResult(String code, String msg){
        this.setCode(code);
        this.setResult("error");
        this.setMsg(msg);
    }

    public static <T> PartyResult buildErrorResult(String msg) {
        PartyResult<Map<String, Object>> partyResult = new PartyResult<>();
        partyResult.setData(new HashMap<String, Object>());
        partyResult.setResult("error");
        partyResult.setCode("500");
        partyResult.setMsg(msg);
        return partyResult;
    }
}
