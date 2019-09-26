/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public abstract class MyFormatter {
    
    public static String STR_DATE = "dd/MM/yyyy";
    public static String STR_TIME = "HH:mm:ss";
    
    public static String integerToString(Integer value, int quantZeros){
        Formatter formatterCodigo = new Formatter();
        String f;
        if (quantZeros == 0){
            f = "%d";
        }else{
            f = "%0"+String.valueOf(quantZeros)+"d";
        }
        formatterCodigo.format(f, value);
        return formatterCodigo.toString();
    }
    
    public static String dateToString(Date date){
        if (date != null){
            DateFormat dateFormat = new SimpleDateFormat(STR_DATE);
            return dateFormat.format(date);
        }else{
            return "";
        }
    }
    
    public static String dateTimeToStringInicial(Date date){
        if (date != null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int ano = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH);
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.set(ano, mes, dia, 00, 00, 00);
            DateFormat dateFormat = new SimpleDateFormat(STR_DATE + " " + STR_TIME);
            return dateFormat.format(calendar.getTime());
        }else{
            return "";
        }
    }
    
    public static String dateTimeToStringFinal(Date date){
        if (date != null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int ano = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH);
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.set(ano, mes, dia, 23, 59, 59);
            DateFormat dateFormat = new SimpleDateFormat(STR_DATE + " " + STR_TIME);
            return dateFormat.format(calendar.getTime());
        }else{
            return "";
        }
    }
    
    public static String dateToStringDia(Date date){
        if (date != null){
            DateFormat dateFormat = new SimpleDateFormat(STR_DATE);
            return dateFormat.format(date).substring(0, 2);
        }else{
            return "";
        }
    }
    
    public static String dateToStringMes(Date date){
        if (date != null){
            DateFormat dateFormat = new SimpleDateFormat(STR_DATE);
            return dateFormat.format(date).substring(3, 5);
        }else{
            return "";
        }
    }
    
    public static String dateToStringAno(Date date){
        if (date != null){
            DateFormat dateFormat = new SimpleDateFormat(STR_DATE);
            return dateFormat.format(date).substring(6, 10);
        }else{
            return "";
        }
    }
    
    public static String timeToString(Date date){
        if (date != null){
            DateFormat dateFormat = new SimpleDateFormat(STR_TIME);
            return dateFormat.format(date);
        }else{
            return "";
        }
    }
    
    public static String doubleMoneyToString(double value){
        Formatter formatter = new Formatter();
        formatter.format("%,.2f", value);
        return formatter.toString();
    }
    
    public static String somenteNumeros(double valor){
        Formatter formatterValor = new Formatter();
        formatterValor.format("%,.2f", valor);
        String valorString = formatterValor.toString();
        int quant = valorString.length();
        String vlr = "";
            int j=0;
            for (int i=0; i<quant;i++){
                String ch = valorString.substring(i, i+1);
                if ((!ch.equalsIgnoreCase(".")) && (!ch.equalsIgnoreCase(","))){
                    vlr = vlr + ch;
                }
            }
            if (valorString.substring(quant-2, quant-1).equalsIgnoreCase(".")){
                vlr = vlr + "0";
            }
            return vlr;
    }
    
    public static Date stringToDate(String dateStr){
        SimpleDateFormat formatter = new SimpleDateFormat(STR_DATE);
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException ex) {
            Logger.getLogger(MyFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
}
