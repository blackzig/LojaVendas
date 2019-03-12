/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.controller;

import com.mycompany.lojavendas.model.TipoUsuario;
import com.mycompany.lojavendas.model.Usuario;
import com.mycompany.lojavendas.model.dao.TipoUsuarioDAO;
import com.mycompany.lojavendas.tools.GerarUUID;
import com.mycompany.lojavendas.tools.JanelaMensagem;
import java.util.List;

/**
 *
 * @author Michel
 */
public class TipoUsuarioController {

    public TipoUsuario usuarioPossuiEsseTipoUsuario(Usuario usuario,
            String tipoUsuario) {
        TipoUsuarioDAO tdao = new TipoUsuarioDAO();
        TipoUsuario tipo = tdao.usuarioTemEsseTipoUsuario(usuario,
                tipoUsuario);
        return tipo;
    }

    public int remover(String id) {
        int itsOK = JanelaMensagem.mensagemDeRemocao();
        if (itsOK == 0) {
            TipoUsuarioDAO tudao = new TipoUsuarioDAO();
            tudao.remover(id);
        }
        return itsOK;
    }

    public TipoUsuario idTipoUsuario(TipoUsuario tu) {
        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        TipoUsuario tipo = tudao.idTipoUsuario(tu);
        return tipo;
    }

    public List<TipoUsuario> listaDeUsuarios(String busca) {
        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        List<TipoUsuario> lista = tudao.listaDeUsuarios(busca);
        return lista;
    }

    public List<String> listaTipoUsuario() {
        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        List<String> lista = tudao.listaTipoUsuario();
        return lista;
    }

    public String salvarTipoUsuario(String idUsuario, String tipoUsuario) {
        Usuario u = new Usuario();
        u.setId(idUsuario);

        TipoUsuario tu = new TipoUsuario();
        tu.setId(GerarUUID.gerarUUID());
        tu.setNome(tipoUsuario);
        tu.setUsuario(u);

        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        String msg = tudao.salvar(tu);

        return msg;
    }

}
