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

    public static void nadaNaLista() {
        JOptionPane.showMessageDialog(null, "Nenhum dado encontrado.",
                "Aviso", 1);
    }

    public static void preecherTodosOsCampos() {
        JOptionPane.showMessageDialog(null, "Todos os campos devem "
                + "ser preenchidos.",
                "Aviso", 1);
    }

    public static void verificarMensagem(String msg) {
        if (msg.equalsIgnoreCase("OK")) {
            JOptionPane.showMessageDialog(null,
                    "Dados cadastrados com sucesso.",
                    "Aviso", 1);
        } else {
            mensagemFalha();
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

    public static int mensagemDeRemocao() {
        Object[] options = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null,
                "Tem certeza que deseja remover esse registro",
                "Atenção!!!", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return opcao;
    }

    public static void loginVazio() {
        JOptionPane.showMessageDialog(null,
                "Preencha o campo usuário e senha.",
                "Aviso", 1);
    }

    public static void loginErro() {
        JOptionPane.showMessageDialog(null,
                "Usuário ou senha estão errados.",
                "Aviso", 1);
    }

    public static void naoRemoverTipoUsuario() {
        JOptionPane.showMessageDialog(null,
                "Não há a possibilidade de remover o tipo de usuário.\n "
                + "Você pode inativar o usuário ou atualizar o "
                + "tipo de usuário.",
                "Aviso", 1);
    }

    public static void novoUsuario() {
        JOptionPane.showMessageDialog(null,
                "Pronto para inserir um novo usuário.",
                "Aviso", 1);
    }

    public static void dataInvalida() {
        JOptionPane.showMessageDialog(null,
                "Digite uma data válida.",
                "Aviso", 1);
    }

    public static void digiteONome() {
        JOptionPane.showMessageDialog(null,
                "Digite o nome.",
                "Aviso", 1);
    }
}
