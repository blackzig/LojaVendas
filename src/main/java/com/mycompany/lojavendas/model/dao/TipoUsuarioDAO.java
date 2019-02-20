/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.model.dao;

import com.mycompany.lojavendas.conf.Conexao;
import com.mycompany.lojavendas.model.TipoUsuario;
import com.mycompany.lojavendas.tools.TratamentoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michel
 */
public class TipoUsuarioDAO {
    
    Connection con = null;
    
    public TipoUsuarioDAO() {
        con = Conexao.conectar();
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

//    private void fecharConexao() {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println("ERRO ao fechar conexão "
//                        + e.getMessage());
//            }
//        }
//    }
//
//    private void fecharConexaoEResultSet(ResultSet rs) {
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(TipoUsuarioDAO.class.getName())
//                        .log(Level.SEVERE, null, ex);
//            }
//        }
//        fecharConexao();
//    }
}
