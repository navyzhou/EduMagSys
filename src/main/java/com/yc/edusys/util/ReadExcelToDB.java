package com.yc.edusys.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 从指定的Excel中读取数据到List集合中
 * @author navy
 */
public class ReadExcelToDB {
	/**
	 * 将Excel中的数据按顺序读取到一个集合中
	 * @param fl
	 * @return
	 */
	@SuppressWarnings("resource")
	public List<List<String>> importExcel(File fl) {
		List<List<String>> dataList = new ArrayList<List<String>>();
		try {
			Workbook workbook = null; // excel对象
			String fileName = fl.getName().toLowerCase(); // 获取文件名

			if (fileName.endsWith("xls")){
				workbook = new HSSFWorkbook(new FileInputStream(fl));
			} else if (fileName.endsWith("xlsx")){
				workbook = new XSSFWorkbook(new FileInputStream(fl));
			} else {
				throw new  RuntimeException("您选择的文件不是一个Excel文件...");
			}

			Sheet sheet = workbook.getSheet("Sheet1"); // 获取excel中的第一个表格
			int rows = sheet.getLastRowNum();// 获取最后一行，即得到表格中的数据行数
			if (rows==0){
				throw new  RuntimeException("表格中没有数据...");
			}

			Row row = null; // 行对象
			Iterator<Cell> cols = null;  // 列对象
			List<String> list =null; // 用来存放一行数据
			String pwd = MD5Encryption.createPassword("123321"); 
			for (int i = 1; i <= rows; i++){ // 循环获取每一行的数据
				row = sheet.getRow(i);
				if (row != null){
					cols = row.cellIterator();
					list = new ArrayList<String>();
					while (cols.hasNext()){ // 循环获取每一列的数据存到list中
						list.add(getCellString(cols.next()));
					}
					list.add(pwd);
					dataList.add(list); // 将这一行数据存到dataList中
				}
			}

		} catch (FileNotFoundException e) {
			LogUtil.log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			LogUtil.log.error(e);
			e.printStackTrace();
		} 
		return dataList;
	}

	//把EXCEL Cell原有数据转换成String类型
	@SuppressWarnings("deprecation")
	private String getCellString(Cell cell) {
		if(cell == null) 
			return "";
		String cellSring = "";

		switch (cell.getCellType()) {  
		case HSSFCell.CELL_TYPE_STRING: // 字符串  
			cellSring = cell.getStringCellValue();
			break;  
		case HSSFCell.CELL_TYPE_NUMERIC: // 数字  
			cellSring=String.valueOf(cell.getNumericCellValue());
			break; 
		case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean 
			cellSring=String.valueOf(cell.getBooleanCellValue());
			break;  
		case HSSFCell.CELL_TYPE_FORMULA: // 公式  
			cellSring=String.valueOf(cell.getCellFormula());
			break;  
		case HSSFCell.CELL_TYPE_BLANK: // 空值  
			cellSring=""; 
			break;  
		case HSSFCell.CELL_TYPE_ERROR: // 故障  
			cellSring=""; 
			break;  
		default:  
			cellSring="";  
			break; 
		}        
		return cellSring;
	}
}
