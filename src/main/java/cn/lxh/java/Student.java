package cn.lxh.java;

/**
 * Created by starlin
 * on 2016/11/23 10:04.
 */
public class Student {
    //private String name;
    //private String address;
    //private String dateOfBirth;
    private String id;
    private String des;
    private String groupNum;


    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", des='" + des + '\'' +
                ", groupNum='" + groupNum + '\'' +
                '}';
    }
}
