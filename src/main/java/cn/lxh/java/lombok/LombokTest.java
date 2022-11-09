package cn.lxh.java.lombok;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by starlin
 * on 2022/7/8 15:19.
 * �����������޲κ��вι���ķ�ʽ
 * 1��Lombokͬʱʹ?@Data��@Builder��ʱ�����Ҫ?��?�ι��죬��Ҫ�ڴ���???����?ע��@Tolerate��
 * ��Lombok��?�����ʱ�򣬶�ָ���Ĺ��캯������֪
 *
 * 2��ֱ��ʹ���޲ι�����+�вι������ķ�ʽ��
 * @RequiredArgsConstructor �������в�
 * @NoArgsConstructor �������޲ι�����
 */
@Data
@RequiredArgsConstructor
//@NoArgsConstructor
public class LombokTest {
    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

}
