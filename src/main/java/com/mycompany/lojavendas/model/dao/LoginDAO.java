/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.model.dao;

import com.mycompany.lojavendas.conf.Conexao;
import com.mycompany.lojavendas.model.StatusLogin;
import com.mycompany.lojavendas.model.TipoUsuario;
import com.mycompany.lojavendas.model.Usuario;
import com.mycompany.lojavendas.tools.TratamentoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michel
 */
public class LoginDAO {

    Connection con = null;

    public LoginDAO() {
        con = Conexao.conectar();
    }

    public TipoUsuario login(Usuario u) {
        TipoUsuario tipo = new TipoUsuario();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM `usuario` u "
                    + "INNER JOIN tipo_usuario tu ON "
                    + "u.id = tu.id_usuario "
                    + "WHERE u.login = ? AND u.senha = sha2(?,256)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            rs = ps.executeQuery();

            while (rs.next()) {
                String idUsuario = rs.getString("id");
                String login = rs.getString("login");
                boolean status = rs.getBoolean("status");
                String idTipoUsuario = rs.getString(5);
                String tipoUsuario = rs.getString("nome");

                Usuario user = new Usuario();
                user.setId(idUsuario);
                user.setLogin(login);
                user.setStatus(status);

                tipo.setId(idTipoUsuario);
                tipo.setNome(tipoUsuario);
                tipo.setUsuario(u);
            }
        } catch (SQLException e) {
            System.out.println("ERRO login " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexaoEResultSet(con, rs);
        }
        return tipo;
    }

}
