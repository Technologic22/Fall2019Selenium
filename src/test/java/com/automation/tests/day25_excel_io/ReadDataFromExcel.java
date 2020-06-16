package com.automation.tests.day25_excel_io;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;

/**
 * NO WORRIES - about "?" on the excel file in IntelliJ
 */
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
        String secondCellValue=firstRow.getCell(1).getStringCellValue();
        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell=firstRow.getLastCellNum();
        System.out.println("###____________###");
        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+" | ");
        }
        System.out.println();
        System.out.println("----...............----");
        //-- how to get number of rows
        //--last row is 301-->>index is 300
        //--index of last row
        int numberOfRows=workSheet.getLastRowNum();
        int numberOfRows2=workSheet.getPhysicalNumberOfRows();

        System.out.println("\nIndex of last row : "+numberOfRows);
        System.out.println("\nNumber of rows 2 :"+numberOfRows2);

        //--HOW TO PRINT ALL SPREAD SHEET==--

        for (int row = 0; row <workSheet.getPhysicalNumberOfRows() ; row++) {
            for (int cell=0; cell<workSheet.getRow(row).getLastCellNum();cell++){
                String cellValue= workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue+" | ");
            }
            System.out.println();
        }
    }
}
