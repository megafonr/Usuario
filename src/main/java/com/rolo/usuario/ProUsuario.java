/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolo.usuario;

import java.util.Calendar;

/**
 *
 * @author Rolo
 */
public class ProUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     // TODO code application logic here
      String strTest = "99";   
      Calendar otrafecha = Calendar.getInstance();
      int ao = otrafecha.get(Calendar.YEAR);
      int me = otrafecha.get(Calendar.MONTH) + 1;
      int di = otrafecha.get(Calendar.DAY_OF_MONTH);
      try {
      int iTest = Integer.valueOf(strTest);   
      System.out.println("Cadena real:" + strTest);   
      System.out.println("Convertido a Int:" + iTest);   
      System.out.println("---- Año: " + ao);   
      System.out.println("-------- Mes: " + me);   
      System.out.println("------------ Dia: " + di);   
      }
      catch(NumberFormatException e){
      System.out.println("Convertido a Int:" + e);             
      }
    }
}
