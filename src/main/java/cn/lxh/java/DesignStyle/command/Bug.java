package cn.lxh.java.DesignStyle.command;

public class Bug implements Task{

    private Programmer programmer;
    
    public Bug(Programmer programmer) {
        super();
        this.programmer = programmer;
    }
    
    public void handle() {
        programmer.handleBug();
    }

    public String toString() {
        return "Bug [programmer=" + programmer.getName() + "]";
    }
    
}