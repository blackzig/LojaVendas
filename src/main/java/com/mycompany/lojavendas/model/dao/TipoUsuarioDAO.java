/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.model.dao;

import com.mycompany.lojavendas.conf.Conexao;
import com.mycompany.lojavendas.model.TipoUsuario;
import com.mycompany.lojavendas.model.Usuario;
import com.mycompany.lojavendas.tools.TratamentoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michel
 */
public class TipoUsuarioDAO {

    Connection con = null;

    public TipoUsuarioDAO() {
        con = Conexao.conectar();
    }

    public List<TipoUsuario> listaDeUsuarios(String busca) {
        List<TipoUsuario> lista = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM `usuario` u "
                    + "INNER JOIN tipo_usuario tu "
                    + "ON u.id = tu.id_usuario "
                    + "WHERE u.login like ? "
                    + "OR tu.nome like ? "
                    + "ORDER BY u.login";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, '%' + busca + '%');
            ps.setString(2, '%' + busca + '%');
            rs = ps.executeQuery();

            while (rs.next()) {
                String idUsuario = rs.getString("id");
                String login = rs.getString("login");
                boolean status = rs.getBoolean("status");
                String idTipoUsuario = rs.getString(5);
                String tipoUsuario = rs.getString("nome");

                Usuario u = new Usuario();
                u.setId(idUsuario);
                u.setLogin(login);
                u.setStatus(status);

                TipoUsuario tu = new TipoUsuario();
                tu.setId(idTipoUsuario);
                tu.setNome(tipoUsuario);
                tu.setUsuario(u);

                lista.add(tu);
            }

        } catch (SQLException e) {
            System.out.println("ERRO listaDeUsuarios " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexaoEResultSet(con, rs);
        }
        return lista;
    }

    public List<String> listaTipoUsuario() {
        List<String> lista = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "SELECT DISTINCT(nome) FROM tipo_usuario "
                    + "order by nome";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                lista.add(nome);
            }

        } catch (SQLException e) {
            System.out.println("ERRO listaTipoUsuario " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexaoEResultSet(con, rs);
        }
        return lista;
    }

    public String salvar(TipoUsuario tipoUsuario) {
        String msg = null;
        try {
            String sql = "INSERT INTO tipo_usuario "
                    + "(id, nome, id_usuario) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tipoUsuario.getId());
            ps.setString(2, tipoUsuario.getNome());
            ps.setString(3, tipoUsuario.getUsuario().getId());
            ps.execute();
            return msg = "OK";
        } catch (SQLException e) {
            System.out.println("ERRO salvar tu " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexao(con);
        }
        return msg;
    }

}
