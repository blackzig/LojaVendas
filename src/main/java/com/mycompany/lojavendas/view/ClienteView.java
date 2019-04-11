/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.view;

import com.mycompany.lojavendas.conf.Estatico;
import com.mycompany.lojavendas.controller.ClienteController;
import com.mycompany.lojavendas.model.Cliente;
import com.mycompany.lojavendas.tools.CameraFoto;
import com.mycompany.lojavendas.tools.JanelaMensagem;
import com.mycompany.lojavendas.tools.TableCellRendererColor;
import com.mycompany.lojavendas.tools.TableCellSelectedColor;
import com.mycompany.lojavendas.tools.TrabalhandoComDatas;
import com.mycompany.lojavendas.tools.TrabalhandoComImagens;
import com.mycompany.lojavendas.tools.UseRowsKeyBoard;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import relatorio.Dynamic;
import relatorio.Relatorio;

/**
 *
 * @author Michel
 */
public class ClienteView extends javax.swing.JInternalFrame {
//https://toedter.com/jcalendar/

    JMenuItem menuCliente;

    int editando = 0;

    String idCliente;

    List<Cliente> lista = null;
    List<String> listaSTR = new ArrayList<>();
    List<String> listaSTRAux = new ArrayList<>();

    public ClienteView(JMenuItem menuCliente) {
        initComponents();
        this.menuCliente = menuCliente;

        imagemPadraoCliente();
        JTable.getTableHeader().setReorderingAllowed(false);
        JTable.setAutoCreateRowSorter(true);
        JTable.setDefaultRenderer(Object.class, new TableCellSelectedColor());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFCpf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTFNascimento = new javax.swing.JFormattedTextField();
        JLFoto = new javax.swing.JLabel();
        JBSalvar = new javax.swing.JButton();
        JBBusca = new javax.swing.JButton();
        JTFPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        JBNovo = new javax.swing.JButton();
        JBCamera = new javax.swing.JButton();
        JDCNascimento = new com.toedter.calendar.JDateChooser();
        JBRemover = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cliente");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CPF");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nome");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nascimento");

        try {
            JTFNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####    ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JTFNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTFNascimentoFocusLost(evt);
            }
        });

        JLFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/semImagem.png"))); // NOI18N
        JLFoto.setToolTipText("Clique aqui para mudar a imagem");
        JLFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLFotoMouseClicked(evt);
            }
        });

        JBSalvar.setText("Salvar");
        JBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarActionPerformed(evt);
            }
        });

        JBBusca.setText("Buscar");
        JBBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscaActionPerformed(evt);
            }
        });

        JTFPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTFPesquisaKeyPressed(evt);
            }
        });

        JTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Nascimento", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        JTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);

        JBNovo.setText("Novo");
        JBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNovoActionPerformed(evt);
            }
        });

        JBCamera.setText("Camera");
        JBCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCameraActionPerformed(evt);
            }
        });

        JBRemover.setText("Remover");
        JBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRemoverActionPerformed(evt);
            }
        });

        jButton1.setText("Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Relatório 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Relatório 3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBSalvar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JBNovo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JBCamera))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(JTFNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(JTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JDCNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTFNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBRemover))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBBusca)
                            .addComponent(JBRemover))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTFNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JDCNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JBSalvar)
                                    .addComponent(JBNovo)
                                    .addComponent(JBCamera)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        menuCliente.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void JLFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLFotoMouseClicked
        try {
            JFileChooser dialogo = TrabalhandoComImagens.arquivoDeImagem();
            int resposta = dialogo.showOpenDialog(this);
            if (resposta == JFileChooser.APPROVE_OPTION) {
                File arquivo = dialogo.getSelectedFile();
                String cpf = JTFCpf.getText();
                if (!cpf.equalsIgnoreCase("")) {
                    TrabalhandoComImagens.moverArquivo(arquivo, cpf);
                }
                JLFoto.setIcon(TrabalhandoComImagens
                        .retornaIconeRedimensionado(arquivo));
            }
        } catch (HeadlessException e) {
            System.out.println("JLFotoMouseClicked " + e.getMessage());
        }
    }//GEN-LAST:event_JLFotoMouseClicked

    private void JBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalvarActionPerformed
        String nome = JTFNome.getText();
        String cpf = JTFCpf.getText();
        String nascimento = JTFNascimento.getText();

        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        //expressões regulares java
        //https://stackoverflow.com/questions/26577685/java-check-if-a-string-contains-intint/26577787#26577787
//        if (nascimento.matches(".*\\d+.*")) {
//            c.setNascimento(
//                    TrabalhandoComDatas.formatBRToDateEUA(nascimento));
//        }

        try {
            String nascimento1 = ((JTextField) JDCNascimento
                    .getDateEditor().getUiComponent()).getText();
            c.setNascimento(
                    TrabalhandoComDatas.formatBRToDateEUA(nascimento1));
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }

        if (editando == 0) {
            ClienteController.salvarCliente(c);
        } else {
            c.setId(idCliente);
            ClienteController.atualizarCliente(c);
            editando = 0;
        }

        imagemCliente(cpf);

        JBBuscaActionPerformed(null);
    }//GEN-LAST:event_JBSalvarActionPerformed

    private void JTFNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTFNascimentoFocusLost
        String nascimento = JTFNascimento.getText();
        if (!nascimento.equals("  /  /    ")) {
            boolean itsOk = TrabalhandoComDatas.validarData(nascimento);
            if (itsOk == false) {
                JTFNascimento.setText("");
            }
        }
    }//GEN-LAST:event_JTFNascimentoFocusLost

    private void JBBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscaActionPerformed
        String busca = JTFPesquisa.getText();
        ClienteController tuc = new ClienteController();
        lista = tuc.listaDeClientes(busca);
        carregarTabelaCliente();
    }//GEN-LAST:event_JBBuscaActionPerformed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        editando = 1;
        int linha = JTable.getSelectedRow();
        String idCliente = (String) JTable.getValueAt(linha, 0);
        String status = (String) JTable.getValueAt(linha, 4);

        if (evt.getClickCount() >= 2) {
            if (status == null) {
                lista.get(linha).setStatus("REMOVA");
                listaSTRAux.add(idCliente);
                listaSTR.add(idCliente);
            } else {
                lista.get(linha).setStatus(null);
                listaSTRAux.forEach((a) -> {
                    if (idCliente.equalsIgnoreCase(a)) {
                        listaSTR.remove(a);
                    }
                });
            }
            carregarTabelaCliente();
        }
        trocaDeClienteComTeclado(linha);
    }//GEN-LAST:event_JTableMouseClicked

    private void JBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNovoActionPerformed
        JTFNome.setText("");
        JTFCpf.setText("");
        JTFNascimento.setText("");
        editando = 0;
    }//GEN-LAST:event_JBNovoActionPerformed

    private void JTFPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JBBuscaActionPerformed(null);
        }
    }//GEN-LAST:event_JTFPesquisaKeyPressed

    private void JBCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCameraActionPerformed
        try {
            new CameraFoto();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBCameraActionPerformed

    private void JTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTableKeyPressed
        int linha = UseRowsKeyBoard.useRows(JTable, evt, lista);
        trocaDeClienteComTeclado(linha);
    }//GEN-LAST:event_JTableKeyPressed

    private void JBRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRemoverActionPerformed
        listaSTR.forEach((a) -> {
            System.out.println("id " + a);
        });
        listaSTRAux.clear();
        listaSTR.clear();
    }//GEN-LAST:event_JBRemoverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Relatorio r = new Relatorio();
        r.relatorioCompras();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Relatorio r = new Relatorio();
        String dataInicial = TrabalhandoComDatas
                .formatoBRTOEUA(JTFNascimento.getText());
        String nascimento1 = ((JTextField) JDCNascimento
                .getDateEditor().getUiComponent()).getText();
        String dataFinal = TrabalhandoComDatas
                .formatoBRTOEUA(nascimento1);
        r.relatorioCompras2(dataInicial, dataFinal);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Dynamic();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void trocaDeClienteComTeclado(int linha) {
        idCliente = (String) JTable.getValueAt(linha, 0);
        String nome = (String) JTable.getValueAt(linha, 1);
        String cpf = (String) JTable.getValueAt(linha, 2);
        String nascimento = (String) JTable.getValueAt(linha, 3);

        JTFNome.setText(nome);
        JTFCpf.setText(cpf);
        // JTFNascimento.setText(nascimento);
        ((JTextField) JDCNascimento
                .getDateEditor().getUiComponent()).setText(nascimento);
        Estatico.setCpfCamera(cpf);

        imagemCliente(cpf);
    }

    private void imagemCliente(String cpf) {
        if (!cpf.equalsIgnoreCase("")) {
            boolean imagemExiste = TrabalhandoComImagens
                    .imagemDoCliente(cpf);
            if (imagemExiste) {
                TrabalhandoComImagens tci = new TrabalhandoComImagens();
                Icon icon = tci.imagem(cpf);
                JLFoto.setIcon(icon);
            } else {
                imagemPadraoCliente();
            }
        } else {
            imagemPadraoCliente();
        }
    }

    private void imagemPadraoCliente() {
        TrabalhandoComImagens tci = new TrabalhandoComImagens();
        JLFoto.setIcon(tci.imagemPadrao());
    }

    private void carregarTabelaCliente() {
        DefaultTableModel modelo = (DefaultTableModel) JTable.getModel();
        modelo.setRowCount(0);
        JTable.getColumnModel().getColumn(0).setMinWidth(0);
        JTable.getColumnModel().getColumn(0).setMaxWidth(0);
        JTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        //JTable.getColumnModel().getColumn(4).setMinWidth(0);
        // JTable.getColumnModel().getColumn(4).setMaxWidth(0);

        if (lista.isEmpty()) {
            JanelaMensagem.nadaNaLista();
        } else {
            lista.forEach((c) -> {
                String nascimento = "";
                if (c.getNascimento() != null) {
                    nascimento = TrabalhandoComDatas
                            .fixDateFromBD(c.getNascimento());
                }
                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getCpf(),
                    nascimento, c.getStatus()});
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBusca;
    private javax.swing.JButton JBCamera;
    private javax.swing.JButton JBNovo;
    private javax.swing.JButton JBRemover;
    private javax.swing.JButton JBSalvar;
    private com.toedter.calendar.JDateChooser JDCNascimento;
    private javax.swing.JLabel JLFoto;
    private javax.swing.JTextField JTFCpf;
    private javax.swing.JFormattedTextField JTFNascimento;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFPesquisa;
    private javax.swing.JTable JTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
