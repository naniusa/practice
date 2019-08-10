package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {
	public String path;//path of the excel file
	public FileInputStream fis=null;//reads the file
	public FileOutputStream fileout=null;//write the files
	private XSSFWorkbook workbook =null;//access the xl documents
	private  XSSFSheet Sheet=null;//access the sheet in the xl doc
	private XSSFRow row=null;//access the row in the xl doc
	private XSSFCell cell=null;//access the cell in xl doc
	
	public XlsReader(String path)  {//purpose of this function is to see where the excel sheet is.
		this.path=path;
			try {
				fis=new FileInputStream(path);//read the file from the path 
				workbook=new XSSFWorkbook(fis);//accessing the workbook excel
			  Sheet = workbook.getSheetAt(0);//accessing the sheet
				fis.close();//after every thing close the workbook
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}	
		public  String getCellData(String sheetName,String colName,int rowNum) {
			try {
			if(rowNum<=0)
				return"";
			
			int index = workbook.getSheetIndex(sheetName);
			int col_NUM=-1;
			if(index==-1)
				return "";
			Sheet=workbook.getSheetAt(index);
			row=Sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()));
			col_NUM=i;
			
			
			}
			
			if (col_NUM==-1) 
				return "";
			Sheet = workbook.getSheetAt(index);
				row =Sheet.getRow(rowNum-1);
				if (row==null)
					return"";
				cell=row.getCell(col_NUM);
				if (cell==null)
					return"";
				return cell.getStringCellValue();
					
				}
				
				catch(Exception e) {
			e.printStackTrace();
			return"row"+rowNum+"or column"+colName+"does not exist in xls";
			
				}
			}
		public String getCellData(String sheetName, String colName, String string) {
			// TODO Auto-generated method stub
			return null;
		}
		}


