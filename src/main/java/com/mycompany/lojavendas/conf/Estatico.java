/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.conf;

/**
 *
 * @author Michel
 */
public class Estatico {

    private static String tipoUsuario;
    private static String login;
    //private static List<String> tipoUsuario;

    public static String getTipoUsuario() {
        return tipoUsuario;
    }

    public static void setTipoUsuario(String tipoUsuario) {
        Estatico.tipoUsuario = tipoUsuario;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Estatico.login = login;
    }

}
