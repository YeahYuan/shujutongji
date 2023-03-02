package danmu.mango;

import lombok.Data;

import java.util.ArrayList;

@Data
public class JieMuConfig {
    public static ArrayList<JieMuBO> list;

    static {
        list = new ArrayList<JieMuBO>();
//        list.add(new JieMuBO("时光2-11食堂", 30, "https://bullet-ws.hitv.com/bullet/tx/2023/02/26/002755/18331919/{time}.json", "18331919"));
//        list.add(new JieMuBO("时光2-11", 109, "https://bullet-ws.hitv.com/bullet/tx/2023/02/26/000409/18343443/{time}.json", "18343443"));
//        list.add(new JieMuBO("时光2-11加更", 32, "https://bullet-ws.hitv.com/bullet/tx/2023/02/26/000000/18346275/{time}.json", "18346275"));
//        list.add(new JieMuBO("时光2-12食堂", 33, "https://bullet-ali.hitv.com/bullet/tx/2023/02/26/000000/18377380/{time}.json", "18377380"));
//        list.add(new JieMuBO("时光2-12", 99, "https://bullet-ws.hitv.com/bullet/tx/2023/02/26/012028/18388625/{time}.json", "18388625"));

        list.add(new JieMuBO("蘑菇屋1", 70, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/062034/15887959/{time}.json", "15887959"));
        list.add(new JieMuBO("蘑菇屋2", 88, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/064137/15897869/{time}.json", "15897869"));
        list.add(new JieMuBO("蘑菇屋3", 71, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/103831/15975358/{time}.json", "15975358"));
        list.add(new JieMuBO("快发1先导", 24, "https://bullet-ali.hitv.com/bullet/tx/2023/02/21/011629/16859880/{time}.json", "16859880"));
        list.add(new JieMuBO("快发1-1", 87, "https://bullet-ali.hitv.com/bullet/tx/2023/02/21/120152/16859884/{time}.json", "16859884"));
        list.add(new JieMuBO("快发1-1加更", 29, "https://bullet-ws.hitv.com/bullet/tx/2023/02/21/044449/16872505/{time}.json", "16872505"));
        list.add(new JieMuBO("快发1-2", 89, "https://bullet-ws.hitv.com/bullet/tx/2023/02/21/050104/16923259/{time}.json", "16923259"));
        list.add(new JieMuBO("快发1-2加更", 19, "https://bullet-ws.hitv.com/bullet/tx/2023/02/21/135122/16923277/{time}.json", "16923277"));
        list.add(new JieMuBO("快发1-3", 89, "https://bullet-ali.hitv.com/bullet/tx/2023/02/21/134314/16984742/{time}.json", "16984742"));
        list.add(new JieMuBO("快发1-4", 89, "https://bullet-ali.hitv.com/bullet/tx/2023/02/21/140556/17064228/{time}.json", "17064228"));
        list.add(new JieMuBO("快发1-4加更", 29, "https://bullet-ws.hitv.com/bullet/tx/2023/02/21/062520/17064239/{time}.json", "17064239"));
        list.add(new JieMuBO("快发1-5", 89, "https://bullet-ali.hitv.com/bullet/tx/2023/02/21/033819/17145366/{time}.json", "17145366"));
        list.add(new JieMuBO("快发1-5加更", 20, "https://bullet-ws.hitv.com/bullet/tx/2023/02/21/043608/17148029/{time}.json", "17148029"));
        list.add(new JieMuBO("快发1-6", 89, "https://bullet-ali.hitv.com/bullet/tx/2023/02/21/125508/17249026/{time}.json", "17249026"));
        list.add(new JieMuBO("快发1-7", 89, "https://bullet-ws.hitv.com/bullet/tx/2023/02/21/140208/17324055/{time}.json", "17324055"));
        list.add(new JieMuBO("快发1-7纯享", 45, "https://bullet-ali.hitv.com/bullet/tx/2023/02/21/000001/17352676/{time}.json", "17352676"));
        list.add(new JieMuBO("快发2-先导", 43, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/063905/17922988/{time}.json", "17922988"));
        list.add(new JieMuBO("快发2-1", 94, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/063838/17956080/{time}.json", "17956080"));
        list.add(new JieMuBO("快发2-1加更", 40, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/011728/17961897/{time}.json", "17961897"));
        list.add(new JieMuBO("快发2-2", 92, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/121918/17989440/{time}.json", "17989440"));
        list.add(new JieMuBO("快发2-2加更", 30, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/000000/17991715/{time}.json", "17991715"));
        list.add(new JieMuBO("快发2-3", 99, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/104645/18015032/{time}.json", "18015032"));
        list.add(new JieMuBO("快发2-3加更", 44, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/064351/18019115/{time}.json", "18019115"));
        list.add(new JieMuBO("快发2-4", 98, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/110832/18045440/{time}.json", "18045440"));
        list.add(new JieMuBO("快发2-4加更", 41, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/062811/18050622/{time}.json", "18050622"));
        list.add(new JieMuBO("快发2-5", 88, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/104523/18099952/{time}.json", "18099952"));
        list.add(new JieMuBO("快发2-5加更", 35, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/104249/18104758/{time}.json", "18104758"));
        list.add(new JieMuBO("快发2-6", 97, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/113854/18146278/{time}.json", "18146278"));
        list.add(new JieMuBO("快发2-6加更", 36, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/064228/18160060/{time}.json", "18160060"));
        list.add(new JieMuBO("快发2-7", 94, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/040815/18196277/{time}.json", "18196277"));
        list.add(new JieMuBO("快发2-7加更", 48, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/011728/18197801/{time}.json", "18197801"));
        list.add(new JieMuBO("快发2-8", 96, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/104413/18232863/{time}.json", "18232863"));
        list.add(new JieMuBO("快发2-8加更", 36, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/062811/18235486/{time}.json", "18235486"));
        list.add(new JieMuBO("快发2-9", 95, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/121516/18291783/{time}.json", "18291783"));
        list.add(new JieMuBO("快发2-9加更", 47, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/051625/18295452/{time}.json", "18295452"));
        list.add(new JieMuBO("快发2-10", 97, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/123415/18333936/{time}.json", "18333936"));
        list.add(new JieMuBO("快发2-10加更", 31, "https://bullet-ali.hitv.com/bullet/tx/2023/02/25/064323/18338450/{time}.json", "18338450"));
        list.add(new JieMuBO("快发2-11", 96, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/123415/18379093/{time}.json", "18379093"));
        list.add(new JieMuBO("快发2-11加更", 33, "https://bullet-ws.hitv.com/bullet/tx/2023/02/25/122757/18384179/{time}.json", "18384179"));

    }
}
