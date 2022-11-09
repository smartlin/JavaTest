package cn.lxh.java.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by starlin
 * on 2017/07/06 11:12.
 */
public class IsNumberOrString {
    public static void main(String[] args) {
        String str = "123";
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher((CharSequence) str);
        boolean result = matcher.matches();
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
