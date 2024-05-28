package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import PageObjects.IBAobj;

public class ReadExcelFile   {



	public static Boolean ReadTabledata(String FileDownloadPath) {




		//String ExcelFile=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"data"+File.separator+"Downloads";

		String newpath=FileDownloadPath+File.separator+"INGREDIENT BASED ANALYSIS Report.xlsx";
		Boolean val=false;
		try {
			FileInputStream file =new FileInputStream(newpath);

			try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
				XSSFSheet Sheet=workbook.getSheetAt(0);

				int rows=Sheet.getLastRowNum();
				int column=Sheet.getRow(1).getLastCellNum();

				System.out.println(rows);
				System.out.println(column);

				for(int r=1;r<=rows;r++) {
					List<String> getdata=new ArrayList<String>();
					XSSFRow row=Sheet.getRow(r);


					for(int c=0;c<column;c++) {

						String cellvalueStr="";
						String cellValueNumeric="";

						XSSFCell cell=row.getCell(c);
						if (cell!=null) { 

							if(cell.getCellType()==CellType.STRING) {

								cellvalueStr=cell.getStringCellValue();
								getdata.add(cellvalueStr);
								//System.out.println(cellvalueStr);

							}
							else if(cell.getCellType()==CellType.NUMERIC) {

								cellValueNumeric=String.valueOf((int)cell.getNumericCellValue());
								getdata.add(cellValueNumeric);

								//System.out.println(cellValueNumeric);
							}


						}


					}


					val=getdata.containsAll(IBAobj.getIBATabledata(r));


				}
				return val;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;




	}




}
