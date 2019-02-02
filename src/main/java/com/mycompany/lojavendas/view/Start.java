/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.view;

import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Michel
 */
public class Start {

    public static void main(String[] args) {
        try {
            //MetalLookAndFeel
            String name = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
            javax.swing.UIManager.setLookAndFeel(name);
            LoginView lv = new LoginView();
            lv.setVisible(true);
        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("ERROR " + e.getMessage());

        }
    }

}
