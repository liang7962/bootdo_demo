package com.bootdo.common.utils.excle;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;

import java.util.List;

/**
 * Created by hello on 2018/12/18.
 */
public class ExcelUtil {

//    public static void exportExcel(HttpServletResponse response, ExcelData data) {
//        log.info("导出解析开始，fileName:{}",data.getFileName());
//        try {
//            //实例化HSSFWorkbook
//            try (HSSFWorkbook workbook = new HSSFWorkbook()) {
//                //创建一个Excel表单，参数为sheet的名字
//                HSSFSheet sheet = workbook.createSheet("sheet");
//                //设置表头
//                setTitle(workbook, sheet, data.getHead());
//                //设置单元格并赋值
//                setData(sheet, data.getData());
//                //设置浏览器下载
//                setBrowser(response, workbook, data.getFileName());
//            }
//            log.info("导出解析成功!");
//        } catch (Exception e) {
//            log.info("导出解析失败!");
//            e.printStackTrace();
//        }
//    }


    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static XSSFWorkbook getXSSFWorkbook(String sheetName, List<String> title, List<Object[]> values, XSSFWorkbook wb) {

        if (title == null || values == null) {
            return null;
        }

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new XSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        XSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();
        //style.setWrapText(true);// 设置自动换行
        style.setFillForegroundColor((HSSFColor.GREY_25_PERCENT.index)); // 设置前景色
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式
        /*style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);*/
       /* HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
        headerFont.setFontName("黑体"); // 设置字体类型
        headerFont.setFontHeightInPoints((short) 10); // 设置字体大小
        style.setFont(headerFont); // 为标题样式设置字体样式*/

        //声明列对象
        XSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(title.get(i));
            cell.setCellStyle(style); // 设置样式
        }

        //创建内容
        Object v = null;
        for (int i = 0; i < values.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values.get(i).length; j++) {
                //将内容按顺序赋给对应的列对象
                v = values.get(i)[j];
                if (null != v) {
                    row.createCell(j).setCellValue(v.toString());
                }
            }
        }
        return wb;
    }

}
