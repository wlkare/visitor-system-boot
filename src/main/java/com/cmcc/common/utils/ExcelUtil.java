package com.cmcc.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 
 * ClassName: ExcelUtil
 * 
 * @Description excel导出导出工具类
 * @author liuhaihe
 * @date 2019年3月27日
 */
public class ExcelUtil {
	private static Logger log =  LoggerFactory.getLogger(ExcelUtil.class);

	/**
	 * 
	 * @Description 导入excel，传入文件与实体，返回解释与的实体集合
	 * @return Map<String,List<Object>> 解释成功与失败的实体集合
	 * @author liuhaihe
	 * @date 2019年3月27日
	 */
	
	 public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []titles,String [][]values, HSSFWorkbook wb){

	        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
	        if(wb == null){
	            wb = new HSSFWorkbook();
	        }

	        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
	        HSSFSheet sheet = wb.createSheet(sheetName);

	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
	        HSSFRow row = sheet.createRow(0);

	        // 第四步，创建单元格，并设置值表头 设置表头居中
	        HSSFCellStyle style = wb.createCellStyle();
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

	        //声明列对象
	        HSSFCell cell = null;

	        //创建标题
	        for(int i=0;i<titles.length;i++){
	            cell = row.createCell(i);
	            cell.setCellValue(titles[i]);
	            cell.setCellStyle(style);
	        }

	        //创建内容
	        int t = values.length;
	        for(int i=0;i<t;i++){
	        	int f = values[i].length;
	            row = sheet.createRow(i + 1);
	            if(f > 0){
	            	for(int j=0;j<f;j++){
	            		//将内容按顺序赋给对应的列对象
	            		row.createCell(j).setCellValue(values[i][j]);
	            	}
	            }
	        }
	        return wb;
	    }
	 
	//发送响应流方法
	    public static void setResponseHeader(HttpServletResponse response, String fileName) {
	        try {
	            fileName = new String(fileName.getBytes(),"ISO8859-1");
	            response.setContentType("application/octet-stream;charset=ISO8859-1");
	            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
	            response.addHeader("Pargam", "no-cache");
	            response.addHeader("Cache-Control", "no-cache");
	        } catch (UnsupportedEncodingException e) {
            	log.error("文件名转码异常");
            }
	    }
}
