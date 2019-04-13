/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import com.mycompany.lojavendas.model.Cliente;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcel {

    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;

    String home_path = System.getProperty("user.home");

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    private void write(List<Cliente> lista) throws IOException, WriteException {
        File file = new File(inputFile);

        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("pt", "BR"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Relatório de Cliente", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet);
        createContent(excelSheet, lista);

        workbook.write();
        workbook.close();
    }

    private void createLabel(WritableSheet sheet)
            throws WriteException {
        // Lets create a times font
        WritableFont times12pt = new WritableFont(WritableFont.TIMES, 12);
        // Define the cell format
        times = new WritableCellFormat(times12pt);
        // Lets automatically wrap the cells
        times.setWrap(true);

        // create create a bold font with unterlines
        WritableFont times16ptBoldUnderline = new WritableFont(
                WritableFont.TIMES, 16, WritableFont.BOLD, false
        //  UnderlineStyle.SINGLE
        );
        timesBoldUnderline = new WritableCellFormat(times16ptBoldUnderline);
        // Lets automatically wrap the cells
        timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        // Write a few headers
        addCaption(sheet, 0, 0, "Nome");
        addCaption(sheet, 1, 0, "CPF");
        addCaption(sheet, 2, 0, "Nascimento");
    }

    private void createContent(WritableSheet sheet, List<Cliente> lista) throws WriteException,
            RowsExceededException {
        Integer i = 1;
        for (Cliente l : lista) {
            addLabel(sheet, 0, i, l.getNome());
            addLabel(sheet, 1, i, l.getCpf());
            addLabel(sheet, 2, i, TrabalhandoComDatas
                    .fixDateFromBD(l.getNascimento()));
            i++;
        }
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }

    private void addNumber(WritableSheet sheet, int column, int row,
            Integer integer) throws WriteException, RowsExceededException {
        Number number;
        number = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
    }

    public void gerarExcel(List<Cliente> lista) throws IOException, WriteException {
        WriteExcel test = new WriteExcel();
        test.setOutputFile(home_path + "/RelatorioCliente.xls");
        test.write(lista);
        JOptionPane.showMessageDialog(null, "Salvo em " + home_path
                + "/RelatorioCliente.xls", "Atenção", 1);
    }
}
