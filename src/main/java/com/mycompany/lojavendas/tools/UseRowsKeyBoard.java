/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author zigui
 */
public class UseRowsKeyBoard {
    
    public static int useRows(JTable table, KeyEvent evt, List list) {
        //String id = null;
        int line = table.getSelectedRow();
        int code = evt.getKeyCode();

        switch (code) {
            case KeyEvent.VK_DOWN:
                if (line < list.size() - 1) {
                    line += 1;
                   // id = (String) table.getValueAt(line, 0);
                }
                break;
            case KeyEvent.VK_UP:
                if (line > 0) {
                    line -= 1;
                   // id = (String) table.getValueAt(line, 0);
                }
                break;
            case KeyEvent.VK_ENTER:
                line += 1;
                if (line < list.size()) {
                  //  id = (String) table.getValueAt(line, 0);
                } else {
                    line = 0;
                  // id = (String) table.getValueAt(0, 0);
                }
                break;
            default:
                break;
        }
        return line;
    }

    public static void justNumbers(KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)
                || vchar == KeyEvent.VK_BACK_SPACE
                || vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }
}