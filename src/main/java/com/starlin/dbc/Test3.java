package com.starlin.dbc;

public class Test3 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入学员人数");
//        int ren = in.nextInt();
//        int i = 1;
//        int sum = 0;
//        while (i <= ren) {
//            System.out.println("请输入第" + i + "个学员的成绩");
//            int a = in.nextInt();
//            sum = sum + a;
//            i++;
//        }
//        int avg = sum / ren;
//        System.out.println("学员的平均分为" + avg);
//
//        String msg = "abcd-efg";
//        String msg1 = "\n" +"aaa"  ;
//        System.out.println(msg.substring(msg.length()-3));
//        System.out.println(msg + msg1);

        //{"Info":[{"spzfy":"0.00"},{"selectname_lb":"销售费用"},{"selectname_qj":"201601"},
        //{"xe":"0.00"},{"ysyfy":"0.00"},{"name":"王林"}]}
        /*Map<String, String> map = new HashMap<>();
        map.put("spzfy", "200");
        map.put("xe","300");
        map.put("name", "王林");
        JSONArray jsonArray = JSONArray.fromObject(map);
        System.out.println(JSONSerializer.toJSON(map));
        System.out.println(jsonArray);

        JSONObject OneDetail = null;
        OneDetail = new JSONObject();
        OneDetail.put("ksrq", "200");
        OneDetail.put("kssj", "300");
        OneDetail.put("jsrq", "400");
        JSONArray InfoStr = new JSONArray();
        InfoStr.add(OneDetail);
        JSONObject returnStr = new JSONObject();
        returnStr.put("Info", InfoStr);
        System.out.println("returnStr====" + returnStr.toString());*/


        String s = "201501";
        System.out.println(s.substring(0,4));
        System.out.println(Integer.parseInt(s) +1 + "15");
        System.out.println("20160216".compareTo("20160215"));
    }

}   
