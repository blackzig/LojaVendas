/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.controller;

import com.mycompany.lojavendas.model.Cliente;
import com.mycompany.lojavendas.model.dao.ClienteDAO;
import com.mycompany.lojavendas.tools.GerarUUID;
import com.mycompany.lojavendas.tools.JanelaMensagem;
import java.util.List;

/**
 *
 * @author Michel
 */
public class ClienteController {

    public List<Cliente> listaDeClientes(String busca) {
        ClienteDAO tudao = new ClienteDAO();
        List<Cliente> lista = tudao.listaDeClientes(busca);
        return lista;
    }

    public static void atualizarCliente(Cliente c) {
        if (c.getNome().equals("")) {
            JanelaMensagem.digiteONome();
        } else {
            ClienteDAO cdao = new ClienteDAO();
            cdao.atualizar(c);
            JanelaMensagem.mensagemOK();
        }
    }

    public static void salvarCliente(Cliente c) {
        if (c.getNome().equals("")) {
            JanelaMensagem.digiteONome();
        } else {
            String id = GerarUUID.gerarUUID();
            c.setId(id);
            ClienteDAO cdao = new ClienteDAO();
            cdao.salvar(c);
            JanelaMensagem.mensagemOK();
        }
    }

}
