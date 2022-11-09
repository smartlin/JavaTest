package cn.lxh.java.SimpleJavaClass;

/**
 * Created by starlin
 * on 2015/09/21 9:06.
 */
class Province{
    private int pid;
    private String pname;
    private City citys[];

    public Province(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public City[] getCitys() {
        return citys;
    }

    public void setCitys(City[] citys) {
        this.citys = citys;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
class City{
    private int cid;
    private String cname;
    private String czipcode;
    private Province pro;

    public City(int cid, String cname, String czipcode) {
        this.cid = cid;
        this.cname = cname;
        this.czipcode = czipcode;
    }

    public Province getPro() {
        return pro;
    }

    public void setPro(Province pro) {
        this.pro = pro;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", czipcode='" + czipcode + '\'' +
                '}';
    }
}
public class PrvoinceSimpleJavaClass {
    public static void main(String[] args) {
        //设置数据
        Province p = new Province(1,"湖北省");
        City c = new City(1001,"洪湖市","433200");
        City b = new City(1002,"武汉市","433000");
        City d = new City(1003,"荆州市","433212");
        City e = new City(1004,"黄石市","433211");
        //取出数据
        c.setPro(p);//一个城市属于一个省
        b.setPro(p);//一个城市属于一个省
        d.setPro(p);//一个城市属于一个省
        e.setPro(p);//一个城市属于一个省
        p.setCitys(new City[]{c, b, d, e});//一个省有多个城市
        for(int i = 0 ; i<p.getCitys().length;i++){
            System.out.println(p.getCitys()[i].toString());//取出一个省中所有的城市信息
        }
        System.out.println("=======================================");
        System.out.println(c.getPro().toString());
    }
}
