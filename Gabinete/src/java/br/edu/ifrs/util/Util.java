/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Rodrigo
 */
public class Util 
{
    public static Calendar formataStringToCalendar(String data) throws Exception 
    { 
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/mm/yyyy");
        Calendar c = Calendar.getInstance();
        if (data == null || data.equals(""))
            return null;
        try 
        {
            c.setTime(formatoData.parse(data));
        } catch (ParseException e) {            
            throw e;
        }
        return c;
    }    
    
    public static String formataCalendarToString(Calendar data) throws Exception 
    { 
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar c = new GregorianCalendar();
        String retorno="";
        if (data == null || data.equals(""))
            return null;
        retorno = formatoData.format(c.getTime());
        return retorno;
    }    
    
}
