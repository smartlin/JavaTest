package cn.lxh.java.DesignStyle.command;

public class Problem implements Task{

    private Programmer programmer;
    
    public Problem(Programmer programmer) {
        super();
        this.programmer = programmer;
    }
    
    public void handle() {
        programmer.handleProblem();
    }

    public String toString() {
        return "Problem [programmer=" + programmer.getName() + "]";
    }
    
}