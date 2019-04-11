/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import com.mycompany.lojavendas.conf.Conexao;
import com.mycompany.lojavendas.tools.TratamentoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DynamicDAO {

    Connection con = null;

    public DynamicDAO() {
        con = Conexao.conectarTest();
    }

    public List<Produto> todos() {
        List<Produto> lista = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM `produto` ORDER BY `data_compra` ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = correrTabela(rs);
        } catch (SQLException e) {
            System.out.println("ERRO todos " + e.getMessage());
        }
        return lista;
    }

    private List<Produto> correrTabela(ResultSet rs) {
        List<Produto> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                long id = rs.getLong("id");
                String produto = rs.getString("produto");
                double preco = rs.getDouble("preco");
                Date dataCompra = rs.getDate("data_compra");

                Produto a = new Produto();
                a.setId(id);
                a.setProduto(produto);
                a.setPreco(preco);
                a.setDataCompra(dataCompra);
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro correrTabela " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexaoEResultSet(con, rs);
        }
        return lista;
    }//correr_tabela

}