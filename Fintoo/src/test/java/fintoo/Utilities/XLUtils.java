package fintoo.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		
		String data;
	try {cell = row.getCell(colnum);	 
		data= cell.toString();}
	catch(Exception e) {
		return null;
	}
	/*	try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}*/
		wb.close();
		fi.close();
	//	return data;
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static boolean setDataForCell(String sheetPath,String sheetName, String colName, int rowNum, String data) {
		try {
			fi = new FileInputStream(sheetPath);
			wb = new XSSFWorkbook(fi);

			if (rowNum <= 0)
				return false;

			int index = wb.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			ws = wb.getSheetAt(index);

			row = ws.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;
             ws.getDefaultRowHeight();
             ws.getDefaultColumnWidth();
			//ws.autoSizeColumn(colNum);
			row = ws.getRow(rowNum );
			if (row == null)
				row = ws.createRow(rowNum);
		

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			// cell style
			// CellStyle cs = workbook.createCellStyle();
			 
			CellStyle cs = wb.createCellStyle();
			if((colName.equals("UnmatchedWords"))) {
				
				cs.setFillForegroundColor(IndexedColors.RED.index);
				 cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				 cell.setCellStyle(cs);
			}
			cell.setCellValue(data);
			cs.setWrapText(true);
			 cell.setCellStyle(cs);

			fo = new FileOutputStream(sheetPath);

			wb.write(fo);

			fo.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
