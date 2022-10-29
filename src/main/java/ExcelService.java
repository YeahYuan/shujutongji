import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExcelService {

    public static int allRow = 1;
    public static int xingRow = 1;
    public static int duoRenRow = 1;
    public static XSSFSheet allSheet;
    public static XSSFSheet xingSheet;
    public static XSSFSheet duoRenSheet;
    public static CellStyle xingStyle;
    public static CellStyle otherStyle;

    public static final String path = "C:\\Users\\lll\\IdeaProjects\\shujutongji\\src\\main\\resources\\数据统计{}.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
        test();
//        gaiLou();
    }

    public static void gaiLou() {
        // https://m.weibo.cn/2461615292/4822088227226417
        String id = "4822088227226417";
        String urlParam = "https://m.weibo.cn/comments/hotflow?id=" + id + "&mid=" + id + "&max_id_type=0";
        String resStr = HttpTools.get(urlParam);
        JSONObject strJson = JSONObject.parseObject(resStr);
        String maxId = strJson.getJSONObject("data").getString("max_id");
        System.out.println(maxId);
        while (!"0".equals(maxId)) {
            urlParam = "https://m.weibo.cn/comments/hotflow?id=" + id + "&mid=" + id + "&max_id=" + maxId +"&max_id_type=0";
            resStr = HttpTools.get(urlParam);
            strJson = JSONObject.parseObject(resStr);
            maxId = strJson.getJSONObject("data").getString("max_id");
            System.out.println(maxId);
        }
    }

    public static void test() throws IOException, InvalidFormatException {
        File file = ResourceUtils.getFile("classpath:数据统计模版1.xlsx");
        XSSFWorkbook book = new XSSFWorkbook(file);
        xingStyle = book.createCellStyle();
        xingStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        xingStyle.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        otherStyle = book.createCellStyle();
        otherStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        otherStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());

        allSheet = book.getSheetAt(1);
        xingSheet = book.getSheetAt(2);
        duoRenSheet = book.getSheetAt(3);
        XSSFSheet sheet1 = book.getSheetAt(0);
        for (int i = 1; i <= sheet1.getLastRowNum() ; i++) {
            XSSFRow row = sheet1.getRow(i);
            int seq = (int) row.getCell(0).getNumericCellValue();
            String date = row.getCell(1).getStringCellValue();
            String title = row.getCell(2).getStringCellValue();
            String person = row.getCell(3).getStringCellValue();
            String url = row.getCell(4).getStringCellValue();
            String id = row.getCell(5).getStringCellValue();
            Huo huo = new Huo(seq, date, title, person, url, id);
            printOne(huo);

            System.out.println(huo);
//            try {
//                Thread.sleep(1000 * 10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        FileOutputStream outputStream = new FileOutputStream(StringUtils.replace(path, "{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))));
        book.write(outputStream);
        outputStream.close();
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
            boolean isXing = "单人".equals(huo.person) || ((text.contains("醒") && !text.contains("远") && !text.contains("生")) || text.contains("安娜") || text.contains("艾伦") || text.contains("猫猫"));
            XSSFRow allSheetRow = allSheet.createRow(allRow);
            allSheetRow.createCell(0).setCellValue(allRow++);
            allSheetRow.createCell(1).setCellValue(huo.date);
            allSheetRow.createCell(2).setCellValue(huo.date + huo.title);
            allSheetRow.createCell(3).setCellValue(huo.person);
            allSheetRow.createCell(4).setCellValue(rank);
            allSheetRow.createCell(5).setCellValue(name);
            XSSFCell cell6 = allSheetRow.createCell(6);
            cell6.setCellValue(Integer.parseInt(like));
            cell6.setCellStyle(isXing ? xingStyle : otherStyle);
            XSSFCell cell7 = allSheetRow.createCell(7);
            cell7.setCellValue(text);
            cell7.setCellStyle(isXing ? xingStyle : otherStyle);
            allSheetRow.setRowStyle(isXing ? xingStyle : otherStyle);

//            if (isXing) {
//                XSSFRow xingSheetRow = xingSheet.createRow(xingRow++);
//                xingSheetRow.createCell(0).setCellValue(huo.date);
//                xingSheetRow.createCell(1).setCellValue(huo.title);
//                xingSheetRow.createCell(2).setCellValue(rank);
//                xingSheetRow.createCell(3).setCellValue(name);
//                xingSheetRow.createCell(4).setCellValue(like);
//                xingSheetRow.createCell(5).setCellValue(text);
//            }
//            if (huo.person > 1) {
//                XSSFRow duoRenSheetRow = duoRenSheet.createRow(duoRenRow++);
//                duoRenSheetRow.setRowStyle(isXing ? xingStyle : otherStyle);
//                duoRenSheetRow.createCell(0).setCellValue(huo.date);
//                duoRenSheetRow.createCell(1).setCellValue(huo.title);
//                duoRenSheetRow.createCell(2).setCellValue(rank);
//                duoRenSheetRow.createCell(3).setCellValue(name);
//                duoRenSheetRow.createCell(4).setCellValue(like);
//                duoRenSheetRow.createCell(5).setCellValue(text);
//            }
        }
    }

    public void exportExcel2007() throws IOException {
        //创建工作簿 类似于创建Excel文件
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建 sheetname页名
        XSSFSheet sheet = workbook.createSheet("员工信息");
        sheet.setColumnWidth(3,20*256);//给第3列设置为20个字的宽度
        sheet.setColumnWidth(4,20*256);//给第4列设置为20个字的宽度
        //创建一行,下标从0开始
        XSSFRow row = sheet.createRow(0);
        //创建这行中的列,下标从0开始 （表头）
        XSSFCell cell = row.createCell(0);
        // 给cell 0下表赋值
        cell.setCellValue("姓名");
        //创建这行中的列,并给该列直接赋值
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("生日");
        row.createCell(4).setCellValue("手机号");
        // 设置表里内容
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("保密");
        row.createCell(2).setCellValue("男");
        row.createCell(3).setCellValue("保密");
        row.createCell(4).setCellValue("12121212121");

        row = sheet.createRow(2);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("18");
        row.createCell(2).setCellValue("女");
        row.createCell(3).setCellValue("2000-01-01");
        row.createCell(4).setCellValue("12121212122");
        //设定 路径
        File file = new File("D:\\zph\\temp\\员工信息2007.xlsx");
        FileOutputStream stream = new FileOutputStream(file);
        // 需要抛异常
        workbook.write(stream);
        //关流
        stream.close();
    }
}
