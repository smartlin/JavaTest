package cn.lxh.java.SimpleJavaClass;

/**
 * Created by starlin
 * on 2015/09/20 20:15.
 */
class Emp{
    private int empno;
    private String ename;
    private String job;
    private Double sal;
    private Double comm;
    private Dept dept;
    private Emp mgr;

    public Emp getMgr() {
        return mgr;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Emp(int empno, String ename, String job, Double sal, Double comm) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                '}';
    }
}
class Dept{
    private int deptno;
    private String deptname;
    private String loc;
    private Emp emp[];

    public Emp[] getEmp() {
        return emp;
    }

    public void setEmp(Emp[] emp) {
        this.emp = emp;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept(int deptno, String deptname, String loc) {
        this.deptno = deptno;
        this.deptname = deptname;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
public class EmpSimpleJavaDemo {
    public static void main(String[] args) {
        Dept dept = new Dept(9999,"技术部","China");
        Emp ea = new Emp(1762,"starlin","职员",2000.0,0.00);
        Emp eb = new Emp(1482,"yhg","经理",2000.0,0.00);
        Emp ec = new Emp(1111,"yb","总经理",2000.0,0.00);
        //设置雇员与领导的关系
        ea.setMgr(eb);
        eb.setMgr(ec);
        //设置雇员和部门关系
        ea.setDept(dept);//一个雇员对应一个部门
        eb.setDept(dept);
        ec.setDept(dept);
        dept.setEmp(new Emp[]{ea, eb, ec});
        //取出数据
        System.out.println(ea.toString());//取得雇员信息
        System.out.println(ea.getMgr().toString());//取得雇员领导信息
        System.out.println(ea.getDept().toString());//取得雇员的部门信息
        System.out.println("===========================================");
        for(int i = 0;i<dept.getEmp().length;i++){
            System.out.println(dept.getEmp()[i].toString());//部门下的所有雇员信息
            if(dept.getEmp()[i].getMgr()!= null) {
                System.out.println("\t" + dept.getEmp()[i].getMgr().toString());//每个雇员的领导信息
            }
        }

    }
}
