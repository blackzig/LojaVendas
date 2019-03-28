/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.mycompany.lojavendas.conf.Estatico;
import java.sql.SQLException;
import javax.swing.JLabel;

public class CameraFoto extends JFrame {

    private final Executor executor = Executors.newSingleThreadExecutor();

    //private Dimension size = WebcamResolution.QQVGA.getSize();
    //private Dimension size = WebcamResolution.QVGA.getSize();
    private final Dimension size = WebcamResolution.VGA.getSize();

    private final List<Webcam> webcams = Webcam.getWebcams();
    private final List<WebcamPanel> panels = new ArrayList<>();

    private final JButton btSnapMe = new JButton(new SnapMeAction());
    private final JButton btStart = new JButton(new StartAction());
    private final JButton btStop = new JButton(new StopAction());
    private final JLabel men = new JLabel("\nNão feche a janela com a câmera "
            + "ligada.\n");
    private final JLabel men1 = new JLabel("\nSalve os dados para a foto ser "
            + "atualizada.\n");

    public CameraFoto() throws SQLException {
        super("Câmera Loja");
        webcams.stream().map((webcam) -> {
            webcam.setViewSize(size);
            return webcam;
        }).map((webcam) -> new WebcamPanel(webcam, size, false))
                .map((panel) -> {
                    panel.setFPSDisplayed(true);
                    return panel;
                }).map((panel) -> {
            panel.setFillArea(true);
            return panel;
        }).forEach((panel) -> {
            panels.add(panel);
        });

        // start application with disable snapshot button - we enable it when
        // webcam is started
        btSnapMe.setEnabled(false);
        btStop.setEnabled(false);

        setLayout(new FlowLayout());

        panels.stream().forEach((panel) -> {
            add(panel);
        });

        add(btSnapMe);
        add(btStart);
        add(btStop);
        add(men);
        add(men1);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class SnapMeAction extends AbstractAction {

        public SnapMeAction() {
            super("Snapshot");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Webcam webcam = webcams.get(0);
                String caminhoFoto = TrabalhandoComImagens.FOTOS
                        + Estatico.getCpfCamera() + ".jpg";
                File file = new File(caminhoFoto);
                ImageIO.write(webcam.getImage(), "jpg", file);
            } catch (IOException ex) {
                System.out.println("Erro " + ex.getMessage());
            }
        }
    }

    private class StartAction extends AbstractAction implements Runnable {

        public StartAction() {
            super("Start");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            btStart.setEnabled(false);
            btSnapMe.setEnabled(true);
            executor.execute(this);
        }

        @Override
        public void run() {
            btStop.setEnabled(true);
            panels.stream().forEach((panel) -> {
                panel.start();
            });
        }
    }

    private class StopAction extends AbstractAction {

        public StopAction() {
            super("Stop");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            btStart.setEnabled(true);
            btSnapMe.setEnabled(false);
            btStop.setEnabled(false);

            panels.stream().forEach((panel) -> {
                panel.stop();
            });
        }
    }
}
