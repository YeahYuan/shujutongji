import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("统计开始时间：" + LocalDateTime.now().toString());
        System.out.println("微博\t排名\tid\t点赞\t评论");
        List<Huo> huoList =new ArrayList<>();
//        huoList.add(new Huo("预告915","4814091015952704"));
//        huoList.add(new Huo("预告916","4814374499521510"));
//        huoList.add(new Huo("邀请函","4815480865687938"));
//        huoList.add(new Huo("候选人","4815744410061826"));
        huoList.add(new Huo("苏醒技能","4815804807780477"));
//        huoList.add(new Huo("花絮","4815872755501699"));
//        huoList.add(new Huo("建校仪式","4815895416799332"));
//        huoList.add(new Huo("黑历史","4816136997177536"));
//        huoList.add(new Huo("00后","4816167199311101"));
//        huoList.add(new Huo("爱你","4816197402760702"));
//        huoList.add(new Huo("上才艺","4816212493601372"));
//        huoList.add(new Huo("题板","4816257792349332"));
//        huoList.add(new Huo("爷叔","4816469185272105"));
//        huoList.add(new Huo("代言人","4816476744451872"));
//        huoList.add(new Huo("扑倒涵哥","4816484293673202"));
        huoList.add(new Huo("苏醒绝美","4816499393169662"));
//        huoList.add(new Huo("同学情","4816522038216939"));
//        huoList.add(new Huo("建校","4816526694419200"));
//        huoList.add(new Huo("兴趣爱好","4816552236681529"));
//        huoList.add(new Huo("开业","4816559795340045"));
//        huoList.add(new Huo("兴趣爱好2","4816574889853438"));
//        huoList.add(new Huo("战报","4816923465879627"));
        for (Huo huo : huoList) {
            printOne(huo);
        }
        System.out.println("统计结束时间：" + LocalDateTime.now().toString());

    }
    public static void printOne(Huo huo) {

        String urlParam = "https://m.weibo.cn/comments/hotflow?id=" + huo.id + "&mid=" + huo.id + "&max_id_type=0";
        String resStr = HttpTools.get(urlParam);
        JSONObject strJson = JSONObject.parseObject(resStr);
        JSONArray jsonArray = strJson.getJSONObject("data").getJSONArray("data");
        int rank = 0;
        for (Object o : jsonArray) {
            rank++;
            JSONObject obj = (JSONObject) o;
            String name = obj.getJSONObject("user").getString("screen_name");
            String like = obj.getString("like_count");
            String text = obj.getString("text");
            System.out.println(huo.title + "\t" + rank + "\t" + name + "\t" + like + "\t" + text);
        }
    }



}

