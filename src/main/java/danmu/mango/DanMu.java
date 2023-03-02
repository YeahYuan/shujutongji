package danmu.mango;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import tool.HttpTools;

@Slf4j
public class DanMu {

    private static int count = 0;
    //时光12正片
//    private final static String URL_PATTEN = "https://galaxy.bz.mgtv.com/cdn/opbarrage?version=3.0.0&vid=18388625&abroad=0&pid=0&os=&uuid=&deviceid=ddb32bee-4496-4c3a-a7d3-cfc0dd2b0c8b&cid=501604&ticket=EB6BD32241343136A9630464371610BF&mac=&platform=0&time={time}&device=0&allowedRC=1&appVersion=3.0.0&reqtype=form-post&callback=jsonp_1677245792819_76078&allowedRC=1";
    //时光12加更
//    private final static String URL_PATTEN = "https://galaxy.bz.mgtv.com/cdn/opbarrage?version=3.0.0&vid=18390680&abroad=0&pid=0&os=&uuid=&deviceid=583f6cd5-2675-4b70-b641-6ad481e53737&cid=501604&ticket=&mac=&platform=0&time={time}&device=0&allowedRC=1&appVersion=3.0.0&reqtype=form-post&callback=jsonp_1677303093983_35808&allowedRC=1";
//演唱会
//        private final static String URL_PATTEN = "https://galaxy.bz.mgtv.com/cdn/opbarrage?version=3.0.0&vid=18420351&abroad=0&pid=0&os=&uuid=&deviceid=583f6cd5-2675-4b70-b641-6ad481e53737&cid=506987&ticket=0100E9037FE43D6BA8C6D6062E5FA3F0&mac=&platform=0&time={time}&device=0&allowedRC=1&appVersion=3.0.0&reqtype=form-post&callback=jsonp_1677767145888_72875&allowedRC=1";
    //完整演唱会
    private final static String URL_PATTEN = "https://galaxy.bz.mgtv.com/cdn/opbarrage?version=3.0.0&vid=18420798&abroad=0&pid=0&os=&uuid=&deviceid=583f6cd5-2675-4b70-b641-6ad481e53737&cid=506987&ticket=0100E9037FE43D6BA8C6D6062E5FA3F0&mac=&platform=0&time={time}&device=0&allowedRC=1&appVersion=3.0.0&reqtype=form-post&callback=jsonp_1677768697540_84966&allowedRC=1";
    //    https://galaxy.bz.mgtv.com/rdbarrage?&callback=jQuery18205482948195711259_1676870946296
    // &_support=10000000&version=1.0.0&vid=18333936&abroad=0&os=&uuid=&deviceid=&cid=506987&ticket=&time=240062
    // &mac=&platform=0&_=1676871086288

    public static void main(String[] args) {
//        for (JieMuBO jieMu : JieMuConfig.list) {
//            printDanMu(jieMu);
//        }
        oneVideo(URL_PATTEN);

//        String resStr = HttpTools.get("https://pcweb.api.mgtv.com/list/master?_support=10000000&filterpre=true&vid=&cid=457910&pn=1&ps=60&allowedRC=1&_support=10000000");
////        String resStr = HttpTools.get("https://pcweb.api.mgtv.com/list/master?_support=10000000&filterpre=true&vid=&cid=436137&pn=1&ps=60&allowedRC=1&_support=10000000");
////        String resStr = HttpTools.get("https://pcweb.api.mgtv.com/list/master?_support=10000000&filterpre=true&vid=&cid=506987&pn=1&ps=60&allowedRC=1&_support=10000000");
//        JSONObject strJson = JSONObject.parseObject(resStr);
//        for (Object o : strJson.getJSONObject("data").getJSONArray("list")) {
//            JSONObject obj = (JSONObject) o;
//            System.out.println(obj.get("t1") + "\t" +obj.get("video_id") + "\t" +obj.get("url") + "\t" +obj.get("time"));
//        }


//        String urlPatten = "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/144431/18388625/{time}.json";
//        printDanMu(urlPatten, 50, 52);
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

    public static void printDanMu(JieMuBO jieMu) {
        for (int i = 0; i <= jieMu.getDuration(); i++) {
            String url = jieMu.getDanMuUrlPatten().replace("{time}", i+"");
            String resStr = HttpTools.get(url);
            JSONObject strJson = JSONObject.parseObject(resStr);
            int total = strJson.getJSONObject("data").getIntValue("total");
            for (Object o : strJson.getJSONObject("data").getJSONArray("items")) {
                JSONObject obj = (JSONObject) o;
                printOne(obj, jieMu);
            }
        }
    }

    public static void printDanMu(String urlPatten, int start, int end) {
        int i = start;
        for (; i <= end; i++) {
            String url = urlPatten.replace("{time}", i+"");
            String resStr = HttpTools.get(url);
            JSONObject strJson = JSONObject.parseObject(resStr);
            int total = strJson.getJSONObject("data").getIntValue("total");
//            System.out.println("第{" + i + "}分钟获取到{" + total + "}条弹幕");
            for (Object o : strJson.getJSONObject("data").getJSONArray("items")) {
                JSONObject obj = (JSONObject) o;
                printOne(obj);
            }
        }
    }

    public static void printOne(JSONObject obj, JieMuBO jieMu) {
        log.info(count++ + "\t"
                + obj.getString("ids") + "\t"
                + obj.getString("time") + "\t"
                + obj.getString("uuid") + "\t"
                + obj.getString("content").replaceAll("[\t\n\r]", "") + "\t"
                + jieMu.getTitle());
    }
    public static void printOne(JSONObject obj) {
        log.info(count++ + "\t"
                + obj.getString("ids") + "\t"
                + obj.getString("time") + "\t"
                + obj.getString("uuid") + "\t"
                + obj.getString("content").replaceAll("[\t\n\r]", ""));
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
