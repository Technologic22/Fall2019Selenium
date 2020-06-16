package com.automation.tests.day25_excel_io;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception{
        //we need to get a file as an object - generic file
        File file=new File("VytrackTestUsers.xlsx");

        //--Object that represents excel file
        Workbook workbook=WorkbookFactory.create(file);

        //-- choose your sheet on which U want to work
        Sheet workSheet=workbook.getSheet("QA2-all");

        //--get your specific row
        Row firstRow=workSheet.getRow(0);

        //--get your cell number
        Cell firstCell=firstRow.getCell(0);

        //--extract string value
        String value=firstCell.getStringCellValue();
        System.out.println(value);

    }
}
