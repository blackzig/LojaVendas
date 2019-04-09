/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import com.mycompany.lojavendas.conf.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Michel
 */
public class Relatorio {

    Connection con = null;

    public Relatorio() {
        con = Conexao.conectarTest();
    }

    public void relatorioCompras2(String dataInicial, String dataFinal) {
        try {
            String sql = "SELECT * FROM `produto` "
                    + "where data_compra "
                    + "BETWEEN ? AND ? "
                    + "ORDER BY `data_compra` ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ResultSet rs = ps.executeQuery();
            JRResultSetDataSource jr = new JRResultSetDataSource(rs);
            JasperReport report = JasperCompileManager.compileReport(
                    System.getProperty("user.dir") + ""
                    + "\\src\\main\\java\\relatorio\\relatorio2.jrxml"
            );
            JasperPrint print = JasperFillManager.fillReport(
                    report, null, jr);
            JasperExportManager.exportReportToPdfFile(
                    print, System.getProperty("user.home")
                    + "/relatorioCompra2.pdf"
            );
            JOptionPane.showMessageDialog(
                    null, "Relatório gerado", "Relatório", 1);
        } catch (Exception e) {
        }
    }

    //C:\Users\Michel\Documents\NetBeansProjects\LojaVendas\src\main\java\relatorio\relatorio.jrxml
    public void relatorioCompras() {
        try {
            String sql = "SELECT * FROM `produto` "
                    + "where data_compra BETWEEN \"2016-02-05\" "
                    + "AND \"2017-02-05\" ORDER BY `data_compra` ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            JRResultSetDataSource jr = new JRResultSetDataSource(rs);

            System.out.println("user dir " + System.getProperty("user.dir"));

            JasperReport report = JasperCompileManager.compileReport(
                    System.getProperty("user.dir") + ""
                    + "\\src\\main\\java\\relatorio\\relatorio.jrxml"
            );

            System.out.println("user home " + System.getProperty("user.home"));

            JasperPrint print = JasperFillManager.fillReport(
                    report, null, jr);
            JasperExportManager.exportReportToPdfFile(
                    print, System.getProperty("user.home")
                    + "/relatorioCompra.pdf"
            );
            JOptionPane.showMessageDialog(
                    null, "Relatório gerado", "Relatório", 1);
        } catch (Exception e) {
        }
    }

}
