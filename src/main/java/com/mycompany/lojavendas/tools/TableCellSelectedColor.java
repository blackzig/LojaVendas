/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import com.mycompany.lojavendas.view.Start;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author elaprendiz - jleod7 <http://www.youtube.com/user/jleod7>
 */
public class TableCellSelectedColor extends DefaultTableCellRenderer {

    private JLabel componente;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        componente = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        componente.setHorizontalAlignment(CENTER);

        if (value != null) {
            switch (value.toString()) {
                case "michel":
                    setBackground(Color.green);
                    componente.setForeground(Color.black);
                    break;
                case "medeiros":
                    setBackground(Color.white);
                    componente.setForeground(Color.black);
                    break;
                default:
                    zebrar(row, isSelected);
            }
        } else {
            zebrar(row, isSelected);
        }

        try {
            if (table.getValueAt(row, 4).equals("REMOVA")) {
                componente.setBackground(Color.red);
            }
        } catch (Exception e) {

        }

        return componente;
    }

    private void zebrar(int row, boolean isSelected) {
        componente.setForeground(Color.white);
        if (row % 2 == 0) {
            componente.setBackground(Color.BLACK);
        } else {
            componente.setBackground(Color.blue);
        }
        if (isSelected) {
            componente.setBackground(Color.orange);
        }
    }

}
