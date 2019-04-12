/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojavendas.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zigui
 */
public class TrabalhandoComDatas {

    public static boolean validarData(String data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(data);
            return true;
        } catch (ParseException ex) {
            JanelaMensagem.dataInvalida();
            return false;
        }
    }

    public static int calculateAge(String dataBR) {
        String dataEUA = formatoBRTOEUA(dataBR);
        LocalDate birthDate = LocalDate.parse(dataEUA);

        if (birthDate != null) {
            LocalDate localDate = LocalDate.now();
            return Period.between(birthDate, localDate).getYears();
        } else {
            return 0;
        }
    }

    public static int calculateMonths(String dataBR) {
        String dataEUA = formatoBRTOEUA(dataBR);
        LocalDate date = LocalDate.parse(dataEUA);

        if (date != null) {
            LocalDate localDate = LocalDate.now();
            return Period.between(date, localDate).getMonths();
        } else {
            return 0;
        }
    }

    public static String moreThreeMonth(Date dataBR) {
        String dataEUA = fixDateToEUA(dataBR);
        LocalDate date = LocalDate.parse(dataEUA).plusMonths(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedString = date.format(formatter);
        return formattedString;
    }

    public static Date formatBRToDateEUA(String data) {
        String dataEUA = formatoBRTOEUA(data);
        Date dateEUA = StringToDateEUA(dataEUA);
        return dateEUA;
    }

    public static String formatoBRTOEUA(String data) {
        String consertar_data1 = data.substring(0, 2);
        String consertar_data2 = data.substring(3, 5).concat("-");
        String consertar_data3 = data.substring(6, 10).concat("-");

        String data_corrigida = consertar_data3.concat(consertar_data2)
                .concat(consertar_data1);
        return data_corrigida;
    }

    public static Date StringToDateEUA(String dateEUA) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Date data = null;
        try {
            data = sdf.parse(dateEUA);
        } catch (ParseException ex) {
            Logger.getLogger(TrabalhandoComDatas.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public static Date StringToDateEUAToDateBR(String dateEUA) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Date data = null;
        try {
            data = sdf.parse(dateEUA);
        } catch (ParseException ex) {
            Logger.getLogger(TrabalhandoComDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public static java.sql.Date dateSqlDateTodayEUA() {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance()
                .getTime().getTime());
        return date;
    }

    public static java.sql.Date dateUtilToDateSql(Date data) {
        java.sql.Date date = new java.sql.Date(data.getTime());
        return date;
    }

    public static String localTimeToString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = LocalTime.now().format(dtf);
        return time;
    }

    public static String fixDateFromBD(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String reportDate = df.format(date);
        return reportDate;
    }

    public static String fixDateToEUA(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(date);
        return reportDate;
    }

    public static String dataHoje() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MM-yyyy");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }

}
