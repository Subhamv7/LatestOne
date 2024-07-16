package com.comcast.ecommerce.PracticeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataInExcel {

	@Test
	public void sampleTest() throws FileNotFoundException {

		FileInputStream fis = new FileInputStream("./Test-Data/ShopperstackData.xlsx");
		try {
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet("writeData").createRow(1).createCell(0).setCellValue("iphone12");
			wb.getSheet("writeData").createRow(2).createCell(0).setCellValue("iphone13");

			FileOutputStream fos = new FileOutputStream("./Test-Data/ShopperstackData.xlsx");
			wb.write(fos);
			wb.close();

		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
