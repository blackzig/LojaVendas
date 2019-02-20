/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Michel
 */
public class Conexao {

    static Connection con = null;

    public static Connection conectar() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sistema_java",
                    "root",
                    ""
            );
        } catch (SQLException e) {
            System.out.println("ERROR Conexao " + e.getMessage());
        }
        return con;
    }

}
