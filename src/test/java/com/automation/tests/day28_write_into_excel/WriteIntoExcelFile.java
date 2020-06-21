package com.automation.tests.day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream=new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook= WorkbookFactory.create(inputStream);  //--!! U can also specify password!
        Sheet sheet=workbook.getSheet("QA3-short");
        Row row=sheet.getRow(1); ///--2nd row
        Cell cell=row.getCell(5);

        System.out.println("Before "+cell.getStringCellValue());
        cell.setCellValue("FAILED"); //-- I am changing from 'n/a' to a 'Passed'
        System.out.println("After "+cell.getStringCellValue());

        Row firstRow=sheet.getRow(0);  //-- Get first cell
        Cell newCell=firstRow.createCell(6); //-- create new cell
        newCell.setCellValue("Date of Execution"); //--give the name to this cell

        //--!! write date & Time to the second row of last Column!!!
        Row secondRow=sheet.getRow(1);
        Cell newCell2=secondRow.createCell(6); //--Create a cell
        newCell2.setCellValue(LocalDate.now().toString());  //-- I will set current date and time into cell

        //--I create If I wanna write sth into excel file
        //-- dont forget to close excel file if U opened it
        FileOutputStream outputStream=new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();

        /**
         * Close the underlying input resource (File or Stream)
         * from which the workbook was read
         *
         * <p>Once this has been called, no further operations,
         * updates or reads should be performed on the Workbook
         *
         */
    }

}
