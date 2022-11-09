package cn.lxh.java.Enum;

/**
 * Created by starlin
 * on 2015/12/17 15:31.
 *
 */
interface Info{
    public void show();
}
public enum  Season implements Info{
    //枚举类中的属性必须放在最上面
    SPRING("spring","春天"){
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
    SUMMER("summer","夏天") {
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    AUTUMN("autumn","秋天") {
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    WINTER("winter","冬天") {
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };

    private String seasonName;
    private String seasonDesc;
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonDesc='" + seasonDesc + '\'' +
                ", seasonName='" + seasonName + '\'' +
                '}';
    }
//    public static Map<String, String> codeMap = new HashMap<String, String>();
//    static {
//        for (Season enums : values()) {
//            codeMap.put(enums.getSeasonName(), enums.getSeasonDesc());
//        }
//    }
    public static void main(String[] args) {
        //直接用枚举类类名.属性
        Season spring = Season.SPRING;
        System.out.println(spring);
        spring.show();
        //枚举类中的方法1.values(),返回是一个数组
        Season[] seasons = Season.values();
        for(Season season:seasons){
            System.out.println(season);
        }
        //枚举类中的方法2.valuesOf()中传入的string字符串必须是枚举类中的属性
        System.out.println(Season.valueOf("SPRING"));
    }
}
