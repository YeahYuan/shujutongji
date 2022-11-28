import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeiDianXiaoLiang_Niao {
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss");
    private static final int A_STOCK = 999;
    private static final int B_STOCK = 999;
    private static final int C_STOCK = 6399;
    private static int total = 0;
    public static void main(String[] args) throws InterruptedException {
        String urlParam = "https://thor.weidian.com/detail/getItemSkuInfo/1.0?param=%7B%22itemId%22%3A%225824196578%22%7D&wdtoken=36b629f3&_=1668915120146";
        while (true) {
            String resStr = HttpTools.get(urlParam);
            JSONObject strJson = JSONObject.parseObject(resStr);
            JSONArray jsonArray = strJson.getJSONObject("result").getJSONArray("skuInfos");
            System.out.print(LocalDateTime.now().format(df) + "\t");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                printOne(jsonObject);
            }
            System.out.println(total);
            total = 0;
            Thread.sleep(1000 * 60 * 60);
        }
    }
    private static void printOne(JSONObject jsonObject) {
        JSONObject skuInfo = jsonObject.getJSONObject("skuInfo");
        int stock = Integer.parseInt(skuInfo.getString("stock"));
        int sold;
        if (skuInfo.getString("title").contains("A版小卡套装")) {
            sold = A_STOCK - stock;
            total = total + sold;
        } else if (skuInfo.getString("title").contains("B版小卡套装")) {
            sold = B_STOCK - stock;
            total = total + sold;
        } else if (skuInfo.getString("title").contains("C")) {
            sold = C_STOCK - stock;
            total = total + (2 * sold);
        } else {
            return;
        }
        System.out.print(sold + "\t");
    }
}
