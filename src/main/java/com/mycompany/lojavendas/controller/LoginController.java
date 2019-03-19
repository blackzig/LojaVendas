/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.controller;

import com.mycompany.lojavendas.model.TipoUsuario;
import com.mycompany.lojavendas.model.Usuario;
import com.mycompany.lojavendas.model.dao.LoginDAO;
import com.mycompany.lojavendas.tools.JanelaMensagem;

/**
 *
 * @author Michel
 */
public class LoginController {

    public static TipoUsuario login(Usuario u) {
        TipoUsuario tipo = null;
        if (u.getLogin().equalsIgnoreCase("")
                || u.getSenha().equalsIgnoreCase("")) {
            JanelaMensagem.loginVazio();
        } else {
            LoginDAO ldao = new LoginDAO();
            tipo = ldao.login(u);
            if (tipo.getId() == null) {
                JanelaMensagem.loginErro();
            }
        }
        return tipo;
    }

}
