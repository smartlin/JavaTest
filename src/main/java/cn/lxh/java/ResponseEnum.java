package cn.lxh.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title	 
 * @author      mzkun
 * @date        2015��12��7������1:40:55
 * @Description �ӿڵ���Ӧ�������ö����
 */
public enum ResponseEnum {
    SUCCESS("200", "�ɹ�"),
    USERNAME_NULL("1110001", "�û���Ϊ��"),
    PASSWARD_NULL("1110002", "����Ϊ��"),
    BATCHNO_NULL("1110003", "���κ�Ϊ��"),
    COUNTTYPE_NULL("1110004", "ͳ������Ϊ��"),
    GASNO_NULL("1110005", "���Ϊ��"),
    PROTOCOLCODE_NULL("1110006", "Э���Ϊ��"),
    DIRECTIVES_NULL("1110007", "ָ��Ϊ��"),
    USERNAME_UNRIGHT("1120001", "�û������Ϸ�"),
    CUSTOMERCODE_UNRIGHT("1120002", "�ͻ����벻�Ϸ�"),
    BATCHNO_UNRIGHT("1120003", "���κŲ��Ϸ�"),
    COUNTTYPE_UNRIGHT("1120004", "ͳ�����Ͳ��Ϸ�"),
    GASNO_UNRIGHT("1120005", "��Ų��Ϸ�"),
    UNLOGIN("1130001", "�û�û�и�ϵͳ��¼Ȩ��"),
    LOGIN_OUTTIME("1130002", "�û������˵�¼ʱ��"),
    ACCOUNT_ERROR("1130003", "�˺Ų����ڻ��˺����벻ƥ��"),
    FUNCTION_NOT_OVER("1130004", "�ܹ���δ����"),
    FUNCTION_OVER("1120006", "������ܹ��ܣ�����ɾ��"),
    METER_MOVED("1120007", "����ѳ���������ɾ��"),
    DATABASE_OPER_EXCEPTION("1180001", "���ݿ�����쳣");

    
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
