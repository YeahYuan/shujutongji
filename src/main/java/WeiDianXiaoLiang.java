import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeiDianXiaoLiang {

    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        String urlParam = "https://thor.weidian.com/detail/getItemSkuInfo/1.0?param=%7B%22itemId%22%3A%225824125384%22%7D&wdtoken=24fd0bc9&_=1668703085412";

        while (true) {
            String resStr = HttpTools.get(urlParam);
            JSONObject strJson = JSONObject.parseObject(resStr);
            JSONArray jsonArray = strJson.getJSONObject("result").getJSONArray("skuInfos");
            System.out.print(LocalDateTime.now().format(df) + "\t");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                printOne(jsonObject);
            }
            System.out.println();
            Thread.sleep(1000);
        }
    }

    private static void printOne(JSONObject jsonObject) {
        System.out.print(jsonObject.getJSONObject("skuInfo").getString("stock") + "\t");
    }


}
