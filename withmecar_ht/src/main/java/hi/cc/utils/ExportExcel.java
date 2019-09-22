package hi.cc.utils;

import hi.car.pojo.MemberProfile;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

//  导出Excel
public class ExportExcel {
    public static boolean exportMember(List<MemberProfile> list ,String fileName){
        boolean bool = false;
        // 创建HHSWorkBook对象（Excel文档对象）
        HSSFWorkbook  hssfWorkBook=new HSSFWorkbook();
        //  创建Excel表
        HSSFSheet sheet = hssfWorkBook.createSheet();
        //在当前表建行，第一行也就是rowNum为0的行一般为表头行
        HSSFRow titleRow = sheet.createRow(0);
        //编辑表头
        //给当前行titleRow创建单元格，并使用setCellValue方法赋值
        titleRow.createCell(0).setCellValue("id");
        titleRow.createCell(1).setCellValue("nickname");
        titleRow.createCell(2).setCellValue("name");
        titleRow.createCell(3).setCellValue("gender");
        titleRow.createCell(4).setCellValue("level");
        titleRow.createCell(5).setCellValue("avatar_url");
        titleRow.createCell(6).setCellValue("mobile_code");
        titleRow.createCell(7).setCellValue("mobil");
        titleRow.createCell(8).setCellValue("email");
        titleRow.createCell(9).setCellValue("description");
        titleRow.createCell(10).setCellValue("country");
        titleRow.createCell(11).setCellValue("provice");
        titleRow.createCell(12).setCellValue("city");
        titleRow.createCell(13).setCellValue("district");
        titleRow.createCell(14).setCellValue("address");
        titleRow.createCell(15).setCellValue("register_time");
        titleRow.createCell(16).setCellValue("point");
        for (MemberProfile m :list ) {
//          获取当前最大行
            int maxRow = sheet.getLastRowNum();
            // 新建一行操作
            HSSFRow datarow = sheet.createRow(maxRow + 1);
            datarow.createCell(0).setCellValue(m.getId());
            datarow.createCell(1).setCellValue(m.getNickname()==null?"":m.getNickname());
            datarow.createCell(2).setCellValue(m.getName()==null?"":m.getName());
            datarow.createCell(3).setCellValue(m.getGender());
            datarow.createCell(4).setCellValue(m.getLevel());
            datarow.createCell(5).setCellValue(m.getAvatar_url()==null?"":m.getAvatar_url());
            datarow.createCell(6).setCellValue(m.getMobile_code()==null?"":m.getMobile_code());
            datarow.createCell(7).setCellValue(m.getMobile()==null?"":m.getMobile());
            datarow.createCell(8).setCellValue(m.getEmail()==null?"":m.getEmail());
            datarow.createCell(9).setCellValue(m.getDescription()==null?"":m.getDescription());
            datarow.createCell(10).setCellValue(m.getCountry());
            datarow.createCell(11).setCellValue(m.getProvince());
            datarow.createCell(12).setCellValue(m.getCity());
            datarow.createCell(13).setCellValue(m.getDistrict());
            datarow.createCell(14).setCellValue(m.getAddress()==null?"":m.getAddress());
            datarow.createCell(15).setCellValue(m.getRegister_time()==null?"":m.getRegister_time());
            datarow.createCell(16).setCellValue(m.getPoint());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("D:\\"+fileName);
            hssfWorkBook.write(outputStream);
            hssfWorkBook.close();
            bool = true;
            return bool;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return bool;
    }
}
