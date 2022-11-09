package cn.lxh.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title	 
 * @author      mzkun
 * @date        2015年12月7日下午1:40:55
 * @Description 接口的响应码和描述枚举类
 */
public enum ResponseEnum {
    SUCCESS("200", "成功"),
    USERNAME_NULL("1110001", "用户名为空"),
    PASSWARD_NULL("1110002", "密码为空"),
    BATCHNO_NULL("1110003", "批次号为空"),
    COUNTTYPE_NULL("1110004", "统计类型为空"),
    GASNO_NULL("1110005", "表号为空"),
    PROTOCOLCODE_NULL("1110006", "协议号为空"),
    DIRECTIVES_NULL("1110007", "指令为空"),
    USERNAME_UNRIGHT("1120001", "用户名不合法"),
    CUSTOMERCODE_UNRIGHT("1120002", "客户代码不合法"),
    BATCHNO_UNRIGHT("1120003", "批次号不合法"),
    COUNTTYPE_UNRIGHT("1120004", "统计类型不合法"),
    GASNO_UNRIGHT("1120005", "表号不合法"),
    UNLOGIN("1130001", "用户没有该系统登录权限"),
    LOGIN_OUTTIME("1130002", "用户超过了登录时限"),
    ACCOUNT_ERROR("1130003", "账号不存在或账号密码不匹配"),
    FUNCTION_NOT_OVER("1130004", "跑功能未结束"),
    FUNCTION_OVER("1120006", "表具已跑功能，不能删除"),
    METER_MOVED("1120007", "表具已出厂，不能删除"),
    DATABASE_OPER_EXCEPTION("1180001", "数据库操作异常");

    
    private String code;
    private String value;

    ResponseEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
    
    public static Map<String, String> codeMap = new HashMap<String, String>();

    static {
        for (ResponseEnum enums : values()) {
            codeMap.put(enums.getCode(), enums.getValue());
        }
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(ResponseEnum.BATCHNO_UNRIGHT.getCode() + " :" + ResponseEnum.BATCHNO_UNRIGHT.getValue() );
    }
}
