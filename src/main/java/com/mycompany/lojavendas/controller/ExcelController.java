/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.controller;

import com.mycompany.lojavendas.model.Cliente;
import com.mycompany.lojavendas.tools.WriteExcel;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.write.WriteException;

/**
 *
 * @author Michel
 */
public class ExcelController {

    public static void gerarExcelCliente(List<Cliente> lista) {
        try {
            WriteExcel w = new WriteExcel();
            w.gerarExcel(lista);
        } catch (IOException | WriteException ex) {
            Logger.getLogger(ExcelController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

}
