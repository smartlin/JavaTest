package cn.lxh.java.DesignStyle.memory;

import java.util.List;

/**
 * Created by starlin
 * on 2016/09/13 14:14.
 * 记忆类（备忘录）
 */
public class Memory {

    private List<String> storyList;

    public List<String> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<String> storyList) {
        this.storyList = storyList;
    }
}
