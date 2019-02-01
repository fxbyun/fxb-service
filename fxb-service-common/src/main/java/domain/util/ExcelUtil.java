package domain.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;

import java.util.List;
public class ExcelUtil {
    //设置每列的宽度
    public static void setColumnWidth(HSSFSheet sheet, List<Integer> columnWidth){
        for (int i = 0; i < columnWidth.size(); i++) {
            sheet.setColumnWidth(i, columnWidth.get(i)*256);
        }
    }

    //设置第一行的title
    public static void setTitle(HSSFRow title, List<String> titles , CellStyle style){
        for (int i = 0; i < titles.size(); i++) {
            title.createCell(i).setCellValue(titles.get(i));
            title.getCell(i).setCellStyle(style);
        }
    }
}
