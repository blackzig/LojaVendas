/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.model.dao;

import com.mycompany.lojavendas.conf.Conexao;
import com.mycompany.lojavendas.model.Cliente;
import com.mycompany.lojavendas.tools.TrabalhandoComDatas;
import com.mycompany.lojavendas.tools.TratamentoConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michel
 */
public class ClienteDAO {

    Connection con = null;

    public ClienteDAO() {
        con = Conexao.conectar();
    }

    public List<Cliente> listaDeClientes(String busca) {
        List<Cliente> lista = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM `cliente` "
                    + "WHERE nome LIKE ? LIMIT 30";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, '%' + busca + '%');
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date nascimento = rs.getDate("nascimento");

                Cliente u = new Cliente();
                u.setId(id);
                u.setNome(nome);
                u.setCpf(cpf);
                u.setNascimento(nascimento);

                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("ERRO listaDeClientes " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexaoEResultSet(con, rs);
        }
        return lista;
    }

    public String atualizar(Cliente cliente) {
        String msg = null;
        try {
            String sql = "UPDATE cliente "
                    + "SET nome=?, cpf=?, nascimento=? "
                    + "Where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, TrabalhandoComDatas.dateUtilToDateSql(
                    cliente.getNascimento()));
            ps.setString(4, cliente.getId());
            ps.execute();
            return msg = "OK";
        } catch (SQLException e) {
            System.out.println("ERRO atualizar cliente " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexao(con);
        }
        return msg;
    }

    public String salvar(Cliente c) {
        String msg = null;
        try {
            String sql = "INSERT INTO cliente "
                    + "(id, nome, cpf, nascimento) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getId());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getCpf());
            if (c.getNascimento() == null) {
                ps.setDate(4, null);
            } else {
                ps.setDate(4, TrabalhandoComDatas.dateUtilToDateSql(
                        c.getNascimento()));
            }
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
