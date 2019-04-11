/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import com.mycompany.lojavendas.tools.TrabalhandoComDatas;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 *
 *
 */
//https://dynamicreports.readthedocs.io/en/latest/index.html
//https://github.com/dynamicreports/dynamicreports
public class Dynamic {

    public Dynamic() {
        build();
    }

    private void build() {
        try {
            StyleBuilder titulo = stl.style().bold().underline()
                    .setFontSize(16)
                    .setBottomPadding(10)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder boldStyle = stl.style().bold().setPadding(1);
            StyleBuilder boldCenteredStyle = stl.style(boldStyle)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
                    .setBorder(stl.pen1Point())
                    .setBackgroundColor(Color.LIGHT_GRAY)
                    .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE);

            StyleBuilder meDeBordas = stl.style()
                    .setBorder(stl.pen1Point())
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);

            TextColumnBuilder<Long> idColumn = col.column(
                    "ID", "id", type.longType()).setWidth(10)
                    .setStyle(meDeBordas);
            TextColumnBuilder<String> produtoColumn = col.column(
                    "Produto", "produto", type.stringType())
                    .setStyle(meDeBordas);
            TextColumnBuilder<String> dataCompraColumn = col.column(
                    "Data Compra", "data_compra", type.stringType())
                    .setWidth(20)
                    .setStyle(meDeBordas);
            TextColumnBuilder<String> precoColumn = col.column(
                    "Preço", "preco", type.stringType()).setWidth(15)
                    .setStyle(meDeBordas);
            TextColumnBuilder<Double> precoColumnD = col.column(
                    "Preço", "precoD", type.doubleType()).setWidth(15)
                    .setStyle(meDeBordas);

            JasperReportBuilder report = report();
            String home_path = System.getProperty("user.home");
            String caminho = home_path + "\\relatorioCompra.pdf";
            report
                    .setColumnTitleStyle(columnTitleStyle)
                    .highlightDetailEvenRows()
                    .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .title(cmp.text("Relatório de Compra").setStyle(titulo))
                    .columns(
                            idColumn, produtoColumn, dataCompraColumn,
                            precoColumn, precoColumnD
                    )
                    .subtotalsAtSummary(sbt.sum(precoColumnD)
                            .setStyle(meDeBordas))
                    .setDataSource(createDataSource())
                    .toPdf(new FileOutputStream(caminho));
        } catch (FileNotFoundException | DRException ex) {
            Logger.getLogger(Dynamic.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("id", "produto",
                "data_compra", "preco", "precoD");
        DynamicDAO ddao = new DynamicDAO();
        List<Produto> lista = ddao.todos();
        lista.forEach((a) -> {
            String dataCompra = TrabalhandoComDatas
                    .fixDateFromBD(a.getDataCompra());
            dataSource.add(a.getId(), a.getProduto(), dataCompra,
                    NumberFormat.getCurrencyInstance().format(a.getPreco()),
                    a.getPreco());
        });
        return dataSource;
    }

    public static void main(String[] args) {
        new Dynamic();
    }
}
