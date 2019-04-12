/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import static com.mycompany.lojavendas.tools.Compactador.compactarParaZip;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michel
 */
public class BackupBD {

    public static final String CAMINHO = "C:\\Users\\Michel\\Documents\\"
            + "NetBeansProjects\\LojaVendas\\";

    public static void executarBackupBat() {
        try {
            String line;
            Process p = Runtime.getRuntime().exec(CAMINHO + "backup.bat");
            try (BufferedReader input = new BufferedReader(
                    new InputStreamReader(p.getInputStream()))) {
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            }
            ziparArquivo();
        } catch (IOException ex) {
            Logger.getLogger(BackupBD.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public static void ziparArquivo() {
        try {
            String local = CAMINHO + "BackupBD\\"
                    + TrabalhandoComDatas.dataHoje() + ".sql";
            String camzip = CAMINHO + "BackupBD\\"
                    + TrabalhandoComDatas.dataHoje().concat(".zip");

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("erro ziparArquivo " + ex.getMessage());
            }

            compactarParaZip(camzip, local);

            File f = new File(local);
            f.delete();
        } catch (IOException ex) {
            Logger.getLogger(BackupBD.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

}
