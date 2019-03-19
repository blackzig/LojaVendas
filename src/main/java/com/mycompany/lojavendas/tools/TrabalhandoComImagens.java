/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author zigui
 */
public class TrabalhandoComImagens {

    public static final String FOTOS = "C:\\Users\\Michel\\Documents\\NetBeansProjects\\LojaVendas\\fotosClientes/";

    public static JFileChooser arquivoDeImagem() {
        JFileChooser dialogo = new JFileChooser();
        String files[] = {"jpg", "png"};
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Arquivos de Foto", files
        );
        dialogo.setFileFilter(filtro);
        return dialogo;
    }

    public Icon imagemIDIcon(String id) {
        Icon icon = null;
        File f = new File(FOTOS + id + ".jpg");
        if (f.exists() && !f.isDirectory()) {
            icon = new ImageIcon(FOTOS + id + ".jpg");
        } else {
            icon = imagemPadrao();
        }
        return icon;
    }

    public static boolean imagemDoAlunoMatricula(int matricula) {
        boolean icon = false;
        File f = new File(FOTOS + matricula + ".jpg");
        if (f.exists() && !f.isDirectory()) {
            icon = true;
        }
        return icon;
    }

    public static Icon retornaIconeRedimensionado(File newName) {
        BufferedImage bi = ResizeImage.returnImageResize(
                newName.getAbsolutePath(), 250, 210);
        ImageIcon icon = new ImageIcon(bi);
        return icon;
    }

    public static String moverArquivo(File arquivo) {
        String uuid = null;
        try {
            UUID idOne = UUID.randomUUID();
            uuid = idOne.toString();
            File dest = new File(FOTOS + uuid + ".jpg");
            Files.copy(arquivo.toPath(), dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(TrabalhandoComImagens.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return uuid;
    }

    public Icon imagemPadrao() {
        Icon icon = null;
        try {
            URL url = getClass().getResource("/imagem/semImagem.png");
            File newName = new File(new URI(url.toString()));
            icon = TrabalhandoComImagens.retornaIconeRedimensionado(newName);
        } catch (URISyntaxException ex) {
            Logger.getLogger(TrabalhandoComImagens.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return icon;
    }

    public Icon imagem(int id) {
        File newName = new File(FOTOS + id + ".jpg");
        Icon icon = TrabalhandoComImagens.retornaIconeRedimensionado(newName);
        return icon;
    }

    public Icon imagem(String uuid) {
        File newName = new File(FOTOS + uuid + ".jpg");
        Icon icon = TrabalhandoComImagens.retornaIconeRedimensionado(newName);
        return icon;
    }

    public Icon existeImagemUUID(String uuid) {
        Icon icon = null;
        File f = new File(FOTOS + uuid + ".jpg");
        if (f.exists() && !f.isDirectory()) {
            icon = new ImageIcon(FOTOS + uuid + ".jpg");
        } else {
            icon = imagemPadrao();
        }
        return icon;
    }
}
