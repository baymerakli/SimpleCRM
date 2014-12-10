package com.ozg.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPOC {
    public static void main(String[] args) {
	// Blank workbook
	XSSFWorkbook workbook = new XSSFWorkbook();

	// Create a blank sheet
	XSSFSheet sheet = workbook.createSheet("Customer Data");

	// This data needs to be written (Object[])
	Map<String, Object[]> data = new TreeMap<String, Object[]>();
	data.put("1", new Object[] { "NAME", "EMAIL", "NOTE" });
	data.put("2", new Object[] { "Amit", "amit@gmail.com", "Shukla" });
	data.put("3", new Object[] { "Lokesh", "lokesh@gmail.com", "Gupta" });
	data.put("4", new Object[] { "John", "jhon@gmail.com", "Adwards" });
	data.put("5", new Object[] { "Brian", "brian@gmail.com", "Schultz" });

	// Iterate over data and write to sheet
	Set<String> keyset = data.keySet();
	int rownum = 0;
	for (String key : keyset) {
	    Row row = sheet.createRow(rownum++);
	    Object[] objArr = data.get(key);
	    int cellnum = 0;
	    for (Object obj : objArr) {
		Cell cell = row.createCell(cellnum++);
		if (obj instanceof String)
		    cell.setCellValue((String) obj);
		else if (obj instanceof Integer)
		    cell.setCellValue((Integer) obj);
	    }
	}
	try {
	    // Write the workbook in file system
	    FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
	    workbook.write(out);
	    out.close();
	    System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
