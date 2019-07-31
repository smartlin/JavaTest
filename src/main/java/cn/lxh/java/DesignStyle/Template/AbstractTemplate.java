package cn.lxh.java.DesignStyle.Template;

/**
 * ģ�巽���е����� 3 ������������ apply() �ǳ��󷽷����������ʵ��������ʵģ�巽�����м������󷽷���ȫ�����ɵģ�
 * ����Ҳ���Խ���������������Ϊ���󷽷�����������ʵ�֡�
 * Ҳ����˵��ģ�巽��ֻ�������һ��Ӧ��Ҫ��ʲô���ڶ���Ӧ����ʲô��������Ӧ����ʲô��������ô������������ʵ�֡�
 */
public abstract class AbstractTemplate {
    // �����ģ�巽��
    public void templateMethod(){
        init();
        apply(); // ������ص�
        end(); // ������Ϊ���ӷ���
    }
    protected void init() {
        System.out.println("init ������Ѿ�ʵ�֣�����Ҳ����ѡ��д");
    }
      // ��������ʵ��
    protected abstract void apply();

    protected void end() {
    }
}