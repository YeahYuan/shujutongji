import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class WeiboCommentsTools {

    public static void main(String[] args) {
        getAllComments("4822088227226417");
    }

    public static void getAllComments(String id) {
        String urlPattern = "https://m.weibo.cn/api/comments/show?id=" + id +"&page=";
        int page = 0;
        int rank = 0;
        while (true) {
            String resStr = HttpTools.get(urlPattern + ++page);
            JSONObject strJson = JSONObject.parseObject(resStr);
            JSONArray jsonArray = strJson.getJSONObject("data").getJSONArray("data");
            for (Object o : jsonArray) {
                rank++;
                JSONObject obj = (JSONObject) o;
                String name = obj.getJSONObject("user").getString("screen_name");
                String like = obj.getString("like_counts");
                String text = obj.getString("text");
                System.out.println(rank + "\t" + name + "\t" + like + "\t" + text);
            }
        }
    }

    @Data
    public static class Comment {
        private String userName;
        private String text;
        private String likeCount;
    }
}
