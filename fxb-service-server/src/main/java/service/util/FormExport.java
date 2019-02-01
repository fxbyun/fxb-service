package service.util;

import domain.entity.UsrWithDraw;
import domain.type.AuditStatus;
import domain.type.WithdrawStatus;
import domain.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 导出xml的例子
 */
public class FormExport {
    private static final List<Integer> columnWidth = new ArrayList<Integer>();
    private static final List<String> titles = new ArrayList<String>();

    static {
        titles.add("提款ID");
        titles.add("用户帐号");
        titles.add("用户ID");
        titles.add("提款金额");
        titles.add("手续费");
        titles.add("创建时间");
        titles.add("提款状态");
        titles.add("客户端");
        titles.add("审核状态");
        titles.add("审核人");
        titles.add("审核时间");
        titles.add("提款时间");

        columnWidth.add(12);
        columnWidth.add(12);
        columnWidth.add(12);
        columnWidth.add(12);
        columnWidth.add(12);
        columnWidth.add(20);
        columnWidth.add(12);
        columnWidth.add(12);
        columnWidth.add(12);
        columnWidth.add(12);
        columnWidth.add(20);
        columnWidth.add(20);
    }

    /**导出xml的例子
     * @param withDrawList
     * @param response
     * @throws IOException
     */
    private void exportData(List<UsrWithDraw> withDrawList, HttpServletResponse response) throws IOException {
        String fileName = "提款记录";
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
        OutputStream ouputStream = response.getOutputStream();
        //设置sheetSize的大小
        int sheetSize = 100;
        //需要多少sheetSize
        int totalPage = (withDrawList.size() /sheetSize ) +1 ;

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = null ;
        for (int i = 0; i < totalPage; i++) {
            if(workbook.getSheetIndex("sheet"+i) == -1){
                sheet = workbook.createSheet("sheet"+i);
            }
            //设置每列的宽度
            ExcelUtil.setColumnWidth(sheet, columnWidth );
            //字体样式设置
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
            Font font = workbook.createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short)12);
            font.setBold(true);
            font.setColor(HSSFColor.BLACK.index);
            style.setFont(font);
            //设置每个sheet的表头header
            HSSFRow header = sheet.createRow(0);
            ExcelUtil.setTitle(header, titles, style);

            for (int j = 1; j < sheetSize; j++) {
                int index = j+i*sheetSize -1 ;
                if(index >= withDrawList.size()){
                    break;
                }
                UsrWithDraw draw = withDrawList.get(index);

                HSSFRow item = sheet.createRow(j);
                item.createCell(0).setCellValue(draw.getId());
                item.createCell(1).setCellValue(draw.getAccount());
                item.createCell(2).setCellValue(draw.getUserId());
                item.createCell(3).setCellValue(draw.getAmount().doubleValue());
                item.createCell(4).setCellValue(draw.getUserFee().doubleValue());
                item.createCell(5).setCellValue(draw.getCreateTime().getTime());
                item.createCell(6).setCellValue(WithdrawStatus.valueOf(draw.getWithdrawStatus()).getDescription());
                item.createCell(7).setCellValue(draw.getSellClient());
                item.createCell(8).setCellValue(AuditStatus.valueOf(draw.getAuditStatus()).getDescription());
                item.createCell(9).setCellValue(draw.getAuditUser());
                item.createCell(10).setCellValue(draw.getAuditTime());
                item.createCell(11).setCellValue(draw.getWithdrawTime());
            }
        }

        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
        workbook.close();
    }
}
