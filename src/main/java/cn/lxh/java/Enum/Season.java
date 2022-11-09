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
    //ö�����е����Ա������������
    SPRING("spring","����"){
        @Override
        public void show() {
            System.out.println("����");
        }
    },
    SUMMER("summer","����") {
        @Override
        public void show() {
            System.out.println("����");
        }
    },
    AUTUMN("autumn","����") {
        @Override
        public void show() {
            System.out.println("����");
        }
    },
    WINTER("winter","����") {
        @Override
        public void show() {
            System.out.println("����");
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
        //ֱ����ö��������.����
        Season spring = Season.SPRING;
        System.out.println(spring);
        spring.show();
        //ö�����еķ���1.values(),������һ������
        Season[] seasons = Season.values();
        for(Season season:seasons){
            System.out.println(season);
        }
        //ö�����еķ���2.valuesOf()�д����string�ַ���������ö�����е�����
        System.out.println(Season.valueOf("SPRING"));
    }
}
