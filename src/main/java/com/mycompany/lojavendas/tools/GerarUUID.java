/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import java.util.UUID;

/**
 *
 * @author Michel
 */
public class GerarUUID {

    public static String gerarUUID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id;
    }

}
