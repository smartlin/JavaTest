package cn.lxh.java;

/**
 * 判断系统是32位还是64位
 * Created by starlin
 * on 2016/12/22 15:42.
 */
public class SystemBit {


    public static void main(String[] args) {
        boolean is64bit = false;
        if (System.getProperty("os.name").contains("Windows")) {
            is64bit = (System.getenv("ProgramFiles(x86)") != null);
        } else {
            is64bit = (System.getProperty("os.arch").indexOf("64") != -1);
        }
        System.out.println(is64bit);

        System.out.println(System.getenv("SYSTEMDRIVE"));

    }
}
