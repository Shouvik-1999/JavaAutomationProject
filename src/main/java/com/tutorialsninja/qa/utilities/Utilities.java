package com.tutorialsninja.qa.utilities;

import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utilities {
	public static final int IMPLICIT_WAIT_TIME=10;
	public static String generateEmailWithTimeStamp() {
		Date date=new Date();
		return "krshouvik"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
	public static String generateRandomPath() {
		Date date=new Date();
		String Sc= date.toString().replace(" ", "-").replace(":", "-");
		return Sc;
	}
	
	public static Object[][] getData() {
		Object[][]data=null;
		try {
			FileInputStream fis=new FileInputStream(".\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\Login.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Login");
			int row=sh.getLastRowNum();
			int col =sh.getRow(0).getLastCellNum();
			data=new Object[row][col];
			for(int i=0;i<row;i++) {

				for(int j=0;j<col;j++) {
					CellType cellType=sh.getRow(i+1).getCell(j).getCellType();

					switch(cellType) {
					case STRING:
						data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
						break;

					case NUMERIC:
						data[i][j]=sh.getRow(i+1).getCell(j).getNumericCellValue();
						break;

					case BOOLEAN:
						data[i][j]=sh.getRow(i+1).getCell(j).getBooleanCellValue();
						break;
					default:
						break;
					}
				}
			}

		}catch(Exception E) {
			System.out.println(E);
		}
		return data;
	}
}
