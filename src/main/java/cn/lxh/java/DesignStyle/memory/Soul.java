package cn.lxh.java.DesignStyle.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by starlin
 * on 2016/09/13 14:47.
 */
public class Soul {
    private Memory memory;

    private Map<Person, Memory> memoryMap = new HashMap<Person, Memory>();

    //抽离或者说搜集一个人的记忆
    public void pullAwayMemory(Person person){
        memoryMap.put(person, person.getMemory());
    }

    //强行将一个人的记忆固定在某一刻
    public void forceFixMemory(Person person){
        if (memoryMap.containsKey(person)) {
            person.setMemory(memoryMap.get(person));
        }
    }
}
