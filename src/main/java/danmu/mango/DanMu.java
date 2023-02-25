package danmu.mango;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import tool.HttpTools;

public class DanMu {

    private static int count = 0;
    private final static String URL_PATTEN = "https://galaxy.bz.mgtv.com/cdn/opbarrage?version=3.0.0&vid=18388625&abroad=0&pid=0&os=&uuid=&deviceid=ddb32bee-4496-4c3a-a7d3-cfc0dd2b0c8b&cid=501604&ticket=EB6BD32241343136A9630464371610BF&mac=&platform=0&time={time}&device=0&allowedRC=1&appVersion=3.0.0&reqtype=form-post&callback=jsonp_1677245792819_76078&allowedRC=1";
//    https://galaxy.bz.mgtv.com/rdbarrage?&callback=jQuery18205482948195711259_1676870946296
    // &_support=10000000&version=1.0.0&vid=18333936&abroad=0&os=&uuid=&deviceid=&cid=506987&ticket=&time=240062
    // &mac=&platform=0&_=1676871086288

    public static void main(String[] args) {
        oneVideo(URL_PATTEN);

//        String resStr = HttpTools.get("https://pcweb.api.mgtv.com/list/master?_support=10000000&filterpre=true&vid=15897869&cid=436137&pn=1&ps=60&allowedRC=1&_support=10000000");
//        String resStr = HttpTools.get("https://pcweb.api.mgtv.com/list/master?_support=10000000&filterpre=true&vid=15897869&cid=436137&pn=1&ps=60&allowedRC=1&_support=10000000");
//        JSONObject strJson = JSONObject.parseObject(resStr);
//        for (Object o : strJson.getJSONObject("data").getJSONArray("list")) {
//            JSONObject obj = (JSONObject) o;
//            System.out.println(obj.get("t3") + "\t" +obj.get("video_id") + "\t" +obj.get("url"));
//        }


//        String urlPatten = "https://bullet-ali.hitv.com/bullet/tx/2023/02/20/221812/18333936/{time}.json";
//        String uuid = "e0f54263fbac4155bdb9375515973c8b";
//        findDanMuByUser(urlPatten, 90, uuid, false);
    }

    public static void findDanMuByUser(String urlPatten, int duration, String uuid, boolean printAll) {
        for (int i = 0; i <= duration; i++) {
            String url = urlPatten.replace("{time}", i+"");
            String resStr = HttpTools.get(url);
            JSONObject strJson = JSONObject.parseObject(resStr);
            int total = strJson.getJSONObject("data").getIntValue("total");
            System.out.println("第{" + i + "}分钟获取到{" + total + "}条弹幕");
            for (Object o : strJson.getJSONObject("data").getJSONArray("items")) {
                JSONObject obj = (JSONObject) o;
                if (uuid.equals(obj.getString("uuid")) || printAll) {
                    printOne(obj);
                }
            }
        }
    }

    public static void printOne(JSONObject obj) {
        System.out.println(count++ + "\t" +obj.getString("uuid") + "\t" + obj.getString("content"));
    }

    public static void oneVideo(String urlPatten) {
        long next = 0;
        while (true) {
            String url = urlPatten.replace("{time}", next + "");
            String resStr = HttpTools.get(url);
            resStr = resStr.substring(26, resStr.length() - 2);
            JSONObject strJson = JSONObject.parseObject(resStr);
            int total = strJson.getJSONObject("data").getIntValue("total");
//            System.out.println("第{" + (next/60000) + "}分钟获取到{" + total + "}条弹幕");
            next = strJson.getJSONObject("data").getIntValue("next");
            JSONArray itemsArray = strJson.getJSONObject("data").getJSONArray("items");
            if (null == itemsArray) {
                return;
            }
            for (Object o : itemsArray) {
                JSONObject obj = (JSONObject) o;
                printOne(obj);
            }
        }
    }
}
