/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import javax.swing.JOptionPane;

/**
 *
 * @author Michel
 */
public class JanelaMensagem {

    public static void verificarMensagem(String msg) {
        if (msg.equalsIgnoreCase("OK")) {
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso.",
                    "Aviso", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco.",
                    "Aviso", 0);
        }
    }

    public static void mensagemOK() {
        JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso.",
                "Aviso", 1);
    }

    public static void mensagemFalha() {
        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco.",
                "Aviso", 0);
    }

}
