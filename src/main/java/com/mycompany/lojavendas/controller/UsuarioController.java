/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.controller;

import com.mycompany.lojavendas.model.Usuario;
import com.mycompany.lojavendas.model.dao.UsuarioDAO;
import com.mycompany.lojavendas.tools.GerarUUID;
import com.mycompany.lojavendas.tools.JanelaMensagem;

/**
 *
 * @author Michel
 */
public class UsuarioController {

    public String salvar(Usuario usuario, String tipoUsuario) {
        String id = GerarUUID.gerarUUID();
        usuario.setId(id);
        UsuarioDAO udao = new UsuarioDAO();
        String msg = udao.salvar(usuario);

        if (msg.equalsIgnoreCase("OK")) {
            TipoUsuarioController tuc = new TipoUsuarioController();
            String msgTU = tuc.salvarTipoUsuario(id, tipoUsuario);
            JanelaMensagem.verificarMensagem(msgTU);
        } else {
            JanelaMensagem.mensagemFalha();
        }
        return msg;
    }

}
