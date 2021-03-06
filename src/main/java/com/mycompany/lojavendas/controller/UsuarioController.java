/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.controller;

import com.mycompany.lojavendas.model.TipoUsuario;
import com.mycompany.lojavendas.model.Usuario;
import com.mycompany.lojavendas.model.dao.UsuarioDAO;
import com.mycompany.lojavendas.tools.GerarUUID;
import com.mycompany.lojavendas.tools.JanelaMensagem;

/**
 *
 * @author Michel
 */
public class UsuarioController {

    public String atualizar(Usuario usuario, String tipoUsuario) {
        UsuarioDAO udao = new UsuarioDAO();
        String msg = udao.atualizar(usuario);
        String msgFinal = verificarTipoUsuario(usuario, tipoUsuario, msg);
        return msgFinal;
    }

    private String verificarTipoUsuario(Usuario usuario,
            String tipoUsuario, String msg) {
        String mesagem = null;
        TipoUsuarioController tuc = new TipoUsuarioController();
        TipoUsuario tipo = tuc
                .usuarioPossuiEsseTipoUsuario(usuario, tipoUsuario);
        if (tipo.getId() == null) {
            //válido para quando o sistema permitir mais de um tipo de usuário
            //mesagem = gravarTipoUsuario(msg, usuario.getId(), tipoUsuario);
            mesagem = atualizarTipoUsuario(msg, usuario.getId(), tipoUsuario);
        }
        return mesagem;
    }

    public String salvar(Usuario usuario, String tipoUsuario) {
        String id = GerarUUID.gerarUUID();
        usuario.setId(id);
        UsuarioDAO udao = new UsuarioDAO();
        String msg = udao.salvar(usuario);
        String finalMsg = gravarTipoUsuario(msg, id, tipoUsuario);
        return finalMsg;
    }

    //válido para quando o sistema permitir mais de um tipo de usuário
    private String gravarTipoUsuario(String msg, String id,
            String tipoUsuario) {
        String msgTU = null;
        if (msg.equalsIgnoreCase("OK")) {
            TipoUsuarioController tuc = new TipoUsuarioController();
            msgTU = tuc.salvarTipoUsuario(id, tipoUsuario);
            JanelaMensagem.verificarMensagem(msgTU);
        } else {
            JanelaMensagem.mensagemFalha();
        }
        return msgTU;
    }

    private String atualizarTipoUsuario(String msg, String id,
            String tipoUsuario) {
        String msgTU = null;
        if (msg.equalsIgnoreCase("OK")) {
            TipoUsuarioController tuc = new TipoUsuarioController();
            msgTU = tuc.atualizarTipoUsuario(id, tipoUsuario);
            JanelaMensagem.verificarMensagem(msgTU);
        } else {
            JanelaMensagem.mensagemFalha();
        }
        return msgTU;
    }

}
