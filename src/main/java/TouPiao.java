import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;

public class TouPiao {
    public static void main(String[] args) throws InterruptedException {
        String urlParam = "https://vote.ajmide.com/get_votelist.php";
        while (true) {
            String resStr = HttpTools.post(urlParam);
            JSONObject strJson = JSONObject.parseObject(resStr);
            JSONArray jsonArray = strJson.getJSONObject("data").getJSONArray("vote-item");
            System.out.print(LocalDateTime.now().format(Consts.DF) + "\t");
            printOne(jsonArray, "刘雨昕");
            printOne(jsonArray, "伯远");
            printOne(jsonArray, "苏醒");
            printOne(jsonArray, "张远");
            printOne(jsonArray, "王源");
            System.out.println("");

//            Thread.sleep(1000);
            Thread.sleep(1000 * 60 * 60);
        }
    }

    private static void printOne(JSONArray jsonArray, String name) {
        for (int i = 0; i < 10; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.getString("title").contains(name)) {
                System.out.print(jsonObject.getString("voteCount") + "\t");
            }
        }
    }


}
