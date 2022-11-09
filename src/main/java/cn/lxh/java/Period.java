package cn.lxh.java;

import java.util.Date;

/**
 * Created by starlin
 * on 2016/10/25 9:37.
 */
public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if(start.compareTo(end) > 0){
            throw new IllegalArgumentException(start + "after" + end);
        }
        this.start = start;
        this.end = end;
    }
    public Date start(){
        return start;
    }
    public Date end(){
        return end;
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        end.setYear(78);
    }
}
