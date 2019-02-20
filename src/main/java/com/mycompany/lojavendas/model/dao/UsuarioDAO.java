/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.model.dao;

import com.mycompany.lojavendas.conf.Conexao;
import com.mycompany.lojavendas.model.Usuario;
import com.mycompany.lojavendas.tools.TratamentoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Michel
 */
public class UsuarioDAO {

    Connection con = null;

    public UsuarioDAO() {
        con = Conexao.conectar();
    }

    public String salvar(Usuario usuario) {
        String msg = null;
        try {
            String sql = "INSERT INTO usuario "
                    + "(id, login, senha, status) "
                    + "VALUES (?, ?, sha2(?, 256), ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getId());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setBoolean(4, true);
            ps.execute();
            return msg = "OK";
        } catch (SQLException e) {
            System.out.println("ERRO salvar usuário " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexao(con);
        }
        return msg;
    }

}
