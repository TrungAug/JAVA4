/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.LibaryHelper;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;

/**
 *
 * @author ASUS
 */
public class ExcelExporter {

    public static ExcelExporter getNewExcelExporter() {
        return new ExcelExporter();
    }

    public void exportToExcel(Map<String, Object> data) {
        JFileChooser jfileChooser = new JFileChooser();
        jfileChooser.showSaveDialog(null);
        File saveFile = jfileChooser.getSelectedFile();
        if (saveFile != null) {
            saveFile = new File(saveFile.toString() + ".xlsx");
        }

        try ( Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");

            // Create headers
            Row headerRow = sheet.createRow(0);
            int colNum = 0;
            for (String key : data.keySet()) {
                headerRow.createCell(colNum++).setCellValue(key);
            }

            // Fill in data
            Row dataRow = sheet.createRow(1);
            colNum = 0;
            for (Object value : data.values()) {
                Cell cell = dataRow.createCell(colNum++);
                if (value instanceof String) {
                    cell.setCellValue((String) value);
                } else if (value instanceof Integer) {
                    cell.setCellValue((Integer) value);
                } else if (value instanceof Double) {
                    cell.setCellValue((Double) value);
                } // Handle other data types as needed
            }

            // Write the workbook to the file
            try ( FileOutputStream fileOut = new FileOutputStream(saveFile)) {
                workbook.write(fileOut);
            }

           DialogHelper.alert(null,"Xuất file Thành công!");
        } catch (IOException e) {
            DialogHelper.alert(null,"Lỗi xuất file!");
            //e.printStackTrace();
        }

    }
}
