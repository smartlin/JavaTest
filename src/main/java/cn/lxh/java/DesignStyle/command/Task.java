package cn.lxh.java.DesignStyle.command;

/**
 * Created by starlin
 * on 2016/09/10 13:21.
 * 添加命令接口和具体的命令，不过这里似乎叫任务（Task）更合适
 */
public interface Task {
    public void handle();
}
