package exportUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;



public class ExcelUtils {

	/**
	 * 导出数据列表保存至 excel2003
	 * @param <T>
	 * @param fileName
	 * @param list
	 */
	public static <T> void generateclsjExcelFor2003(String fileName, List<T> list,
			HttpServletResponse response){
		HSSFWorkbook workbook2003 = new HSSFWorkbook();
		HSSFSheet sheet = workbook2003.createSheet("客诉分析");
		int baseLong = 6;
		int addLong = 0;
		int qtyLong = 0;
		//对列设置宽度为80像素
	    sheet.setColumnWidth(0, 80 * 80);   
	    sheet.setColumnWidth(1, 120 * 100);   
	    sheet.setColumnWidth(2, 120 * 100);  
  	    sheet.setColumnWidth(3, 120 * 100);   
  	    sheet.setColumnWidth(4, 120 * 100);   
  	    sheet.setColumnWidth(5, 120 * 100);   
	   
	    //---------------------------------------------------
	

	    //生成第一行标题行
	    //XSSFRow fristHeadRow = sheet.createRow(0);
	        
	    //生成第二行表头行
	    HSSFRow secondHeadRow = sheet.createRow(0);
			
	    /*################################表头部分设置START################################*/
	    // 创建样式
	    HSSFFont headerfont = workbook2003.createFont();
	    HSSFCellStyle headerStyle = workbook2003.createCellStyle();
	    // 字体加粗
	    headerfont.setBoldweight(Font.BOLDWEIGHT_BOLD);   

	    // 设置长文本自动换行
	    headerStyle.setWrapText(true);
	    headerStyle.setFont(headerfont);
			
	    //水平方向对齐
	    headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    // 垂直方向的对齐方式
	    headerStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
			
	    //设置边框
	    headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			
	    //设置背景颜色
	    headerStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
	    /*################################表头部分设置END################################*/  
			
	    /*################################普通单元格部分设置START################################*/
	    // 创建样式
	    HSSFFont commonfont = workbook2003.createFont();
	    HSSFCellStyle commonStyle = workbook2003.createCellStyle();
	    commonStyle.setWrapText(true);
	    commonStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中    
	    commonStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中 
	    commonStyle.setFont(commonfont);
	    //水平方向对齐
	    commonStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    //设置边框
	    commonStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    commonStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    commonStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    commonStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    /*################################普通单元格部分设置END################################*/
	    qtyLong = baseLong+addLong;
	    for(int i = 0 ; i < qtyLong ; i++){
	    	//第二行生成单元格
	    	HSSFCell cell = secondHeadRow.createCell(i);
	    	//应用表头样式
	    	cell.setCellStyle(headerStyle);
	    	switch (i) {
	    	case 0:
				cell.setCellValue("序号");
				break;
	    	case 1:
				cell.setCellValue("客诉时间");
				break;
			case 2:
				cell.setCellValue("周期");
				break;
			case 3:
				cell.setCellValue("渠道来源");
				break;
			case 4:
				cell.setCellValue("客诉类型");
				break;
			case 5:
				cell.setCellValue("客诉子类型");
				break;
			default:
				break;
			}
	    }
	    if(list != null && list.size() > 0) {
	    	//从工作表第二行开始为数据内容部分
	    	for(int j = 0 ; j < list.size() ; j++){
	    		T t = list.get(j);
	    		//生成行
	    		HSSFRow row = sheet.createRow(j+1);
				
	    		//序号
	    		HSSFCell brandName = row.createCell(0);
	    		brandName.setCellValue(j+1);
	    		brandName.setCellStyle(commonStyle);
				
				//客诉时间
				HSSFCell complaintTime = row.createCell(1);
				complaintTime.setCellValue(((Object) t).toString());
				complaintTime.setCellStyle(commonStyle);
				
				//查询周期
				HSSFCell complaintDimension = row.createCell(2);
				complaintDimension.setCellValue(((Object) t).toString());
				complaintDimension.setCellStyle(commonStyle);
				
				
				//渠道来源
				HSSFCell channelSource = row.createCell(3);
				channelSource.setCellValue(((Object) t).toString());
				channelSource.setCellStyle(commonStyle);
				
				//客诉类型
				HSSFCell Type = row.createCell(4);
				Type.setCellValue(((Object) t).toString());
				Type.setCellStyle(commonStyle);
				
				
				//客诉子类型
				HSSFCell subType = row.createCell(5);
				subType.setCellValue(((Object) t).toString());
				subType.setCellStyle(commonStyle);
	    	}
			
			
			//以浏览器下载的形式导出Excel文件
	    	downFile(fileName,workbook2003, null,response);
	    }else{
	    	downFile(fileName,workbook2003, null,response);
	    }
	}
	
	
	
	/**
	 * 浏览器下载的形式导出Excel文件(方法抽取)
	 * @param fileName
	 * @param workbook2003
	 * @param workbook2007
	 */
	private static void generateExcelByDownload(String fileName, HSSFWorkbook workbook2003, XSSFWorkbook workbook2007,HttpServletResponse response) {
		//以下载的形式导出EXCEL2003或2007
		//HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("application/force-download");
		//根据不同浏览器输出
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
		try {
			if (isMSIE) {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
		OutputStream os = null;
		
		try {
			os = response.getOutputStream();
			if(null != workbook2003){
				//输出excel2003文件流
				workbook2003.write(os);
			}else{
				workbook2007.write(os);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	  public static void downFile(String fileName, HSSFWorkbook workbook2003, XSSFWorkbook workbook2007,HttpServletResponse response){
			ServletOutputStream output = null;
			HttpServletRequest request = ServletActionContext.getRequest();
			try {
			 response = ServletActionContext.getResponse();
			// 设置下载文件类型
			response.setContentType("application/octet-stream;charset=ISO-8859-1");
			// 设置下载文件头
			 String agent = request.getHeader("USER-AGENT");    
	         if (null != agent && -1 != agent.indexOf("MSIE") || null != agent    
	                 && -1 != agent.indexOf("Trident")) {// ie    
	        	 fileName = java.net.URLEncoder.encode(fileName, "UTF8"); 
	        	 response.setHeader("Content-Disposition",
	     				"filename=\"" + fileName+"\"");
	         } else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等    
	        	 fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");    
	        	 response.setHeader("Content-Disposition",
	     				"attachment; filename=\"" + fileName+"\"");
	         } 
	         output = response.getOutputStream();
				if(null != workbook2003){
					//输出excel2003文件流
					workbook2003.write(output);
				}else{
					workbook2007.write(output);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (output != null) {
						output.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}
