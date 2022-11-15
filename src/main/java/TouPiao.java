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

            System.out.println(
                    LocalDateTime.now() + "\t" +
                    jsonArray.getJSONObject(0).getString("title") + "\t" + jsonArray.getJSONObject(0).getString("voteCount") + "\t" +
                    jsonArray.getJSONObject(1).getString("title") + "\t" + jsonArray.getJSONObject(1).getString("voteCount") + "\t" +
                    jsonArray.getJSONObject(2).getString("title") + "\t" + jsonArray.getJSONObject(2).getString("voteCount") + "\t" +
                    jsonArray.getJSONObject(3).getString("title") + "\t" + jsonArray.getJSONObject(3).getString("voteCount") + "\t" +
                    jsonArray.getJSONObject(4).getString("title") + "\t" + jsonArray.getJSONObject(4).getString("voteCount")
            );

//            Thread.sleep(1000);
            Thread.sleep(1000 * 60 * 10);
        }
    }


}
