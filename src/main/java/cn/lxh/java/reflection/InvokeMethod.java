package cn.lxh.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by starlin
 * on 2016/05/23 13:43.
 */
public class InvokeMethod {
    private String firstName;
    private String lastName;

    public InvokeMethod(){

    }

    public InvokeMethod(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return getInternalFullName("Sr.");
    }

    private String getInternalFullName(String suffix) {
        return firstName + " " + lastName + " " + suffix;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InvokeMethod invokeMethod = new InvokeMethod();
        Method method = invokeMethod.getClass().getDeclaredMethod("getInternalFullName",InvokeMethod.class);
        method.setAccessible(true);
        String fullName = (String) method.invoke(invokeMethod, "Jr.");
        System.out.println(fullName);
    }
}
