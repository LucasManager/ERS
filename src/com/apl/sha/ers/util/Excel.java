package com.apl.sha.ers.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class Excel {
	private HSSFWorkbook workbook;

	private String filename;

	public Excel() {
		workbook = new HSSFWorkbook();// 建立新HSSFWorkbook对象
	}

	public Excel(String filename) throws IOException {
		openExistsfile(filename);
	}

	public void openExistsfile(String filename) throws IOException {
		this.filename = filename;
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filename));
		workbook = new HSSFWorkbook(fs);
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void save() throws IOException {
		FileOutputStream fileout = new FileOutputStream(filename);
		workbook.write(fileout);// 把Workbook对象输出到文件workbook.xls中
		fileout.close();
	}

	public void saveAs(String newfilename) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(newfilename);
		workbook.write(fileOut);// 把Workbook对象输出到文件workbook.xls中
		fileOut.close();
	}

	public void copyRecordset(int sheetindex, Vector vec, int startrows,
			int startcolumns) {
		if(vec.size()<=0) {
			return;
		}
		HSSFSheet worksheet=this.getWorkbook().getSheetAt(sheetindex);
		startrows--;
		startcolumns--;
		Vector veccol = (Vector) vec.get(0);
		int colcount = veccol.size();
		int rowcount = vec.size();
		for (int i = 0; i < rowcount; i++) {
			Vector vectmp = new Vector();
			vectmp = (Vector) vec.get(i);
			HSSFRow row = worksheet.getRow(startrows + i);
			if(row==null) {
				row=worksheet.createRow(startrows + i);
			}
			for (int j = 0; j < colcount; j++) {
				HSSFCell cell = row.getCell(Short.parseShort(Integer
						.toString(startcolumns + j)));
				if(cell==null) {
					cell=row.createCell(Short.parseShort(Integer
							.toString(startcolumns + j)));
				}
				String data=(String)vectmp.get(j);
				if(BasicFunc.isNumeric(data)) {
					cell.setCellValue(Double.parseDouble(data));
				}else {
					cell.setCellValue(data);
				}
			}
		}
	}

	public void copyRecordset(String sheetname, Vector vec, int startrows,
			int startcolumns) {
		if(vec.size()<=0) {
			return;
		}
		int sheetindex=this.getWorkbook().getSheetIndex(sheetname);
		this.copyRecordset(sheetindex,vec,startrows,startcolumns);
	}

	public void copyRecordsetTranspose(int sheetindex, Vector vec, int startrows,
			int startcolumns) {
		if(vec.size()<=0) {
			return;
		}
		HSSFSheet worksheet=this.getWorkbook().getSheetAt(sheetindex);
		startrows--;
		startcolumns--;
		Vector vecrow = (Vector) vec.get(0);
		String data="";
		int rowcount = vecrow.size();
		int colcount = vec.size();
		for (int i = 0; i < colcount; i++) {
			Vector vectmp = new Vector();
			vectmp = (Vector) vec.get(i);
			for (int j = 0; j < rowcount; j++) {
				HSSFRow row = worksheet.getRow(startrows + j);
				if(row==null) {
					row=worksheet.createRow(startrows + j);
				}
				HSSFCell cell = row.getCell(Short.parseShort(Integer
						.toString(startcolumns + i)));
				if(cell==null) {
					cell=row.createCell(Short.parseShort(Integer
							.toString(startcolumns + i)));
				}
				data=(String)vectmp.get(j);
				if(BasicFunc.isNumeric(data)) {
					cell.setCellValue(Double.parseDouble(data));
				}else {
					cell.setCellValue(data);
				}
			}
		}
	}

	public void copyRecordsetTranspose(String sheetname, Vector vec, int startrows,
			int startcolumns) {
		if(vec.size()<=0) {
			return;
		}
		int sheetindex=this.getWorkbook().getSheetIndex(sheetname);
		this.copyRecordsetTranspose(sheetindex,vec,startrows,startcolumns);
	}
	
	public void setValue(int sheetindex,int rows, int columns, String value) {
		rows--;
		columns--;
		HSSFSheet worksheet=this.getWorkbook().getSheetAt(sheetindex);
		HSSFRow row = worksheet.getRow(rows);
		if(row==null) {
			row=worksheet.createRow(rows);
		}
		HSSFCell cell = row.getCell(Short.parseShort(Integer
				.toString(columns)));
		if(cell==null) {
			cell=row.createCell(Short.parseShort(Integer.toString(columns)));
		}
		cell.setCellValue(value);
	}
	
	public void setValue(String sheetname,int rows, int columns, String value) {
		int sheetindex=this.getWorkbook().getSheetIndex(sheetname);
		this.setValue(sheetindex,rows,columns,value);
	}
	
	
	public void setValue(int sheetindex,int rows, int columns, double value) {
		rows--;
		columns--;
		HSSFSheet worksheet=this.getWorkbook().getSheetAt(sheetindex);
		HSSFRow row = worksheet.getRow(rows);
		if(row==null) {
			row=worksheet.createRow(rows);
		}
		HSSFCell cell = row.getCell(Short.parseShort(Integer
				.toString(columns)));
		if(cell==null) {
			cell=row.createCell(Short.parseShort(Integer.toString(columns)));
		}
		cell.setCellValue(value);
	}

	public void setValue(String sheetname,int rows, int columns, double value) {
		int sheetindex=this.getWorkbook().getSheetIndex(sheetname);
		this.setValue(sheetindex,rows,columns,value);
	}
	
	public void write(OutputStream outstream) throws IOException {
		workbook.write(outstream);// 把Workbook对象输出到stream
	}
	
	public void removeSheets(String[] sheetnames) { //uncompleted 
		
	}
	
	public void removeSheet(String sheetname) { 
		int sheetindex =workbook.getSheetIndex(sheetname);
		workbook.removeSheetAt(sheetindex);
	}
	
	public void leaveSheets(String[] sheetnames) { //not recommended 
		String sheetname="";
		int count=workbook.getNumberOfSheets();
		for(int i=count-1;i>=0;i--) {
			sheetname=workbook.getSheetName(i);
			if(!BasicFunc.isInlist(sheetname,sheetnames)){
				workbook.removeSheetAt(i);
			}
		}
	}
	
	public void copySheets(String parent_name,String sheetname) { //uncompleted
		int sheetindex =workbook.getSheetIndex(parent_name);
		workbook.cloneSheet(sheetindex);
		workbook.setSheetName(workbook.getNumberOfSheets()-1,sheetname);
	}
	
	public void renameSheet(String oldname,String newname) { //uncompleted
		int sheetindex =workbook.getSheetIndex(oldname);
		workbook.setSheetName(sheetindex,newname);
	}
}
