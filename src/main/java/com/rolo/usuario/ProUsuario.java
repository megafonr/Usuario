/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolo.usuario;

import java.util.Calendar;
import javax.swing.JOptionPane;

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
        /* Declaramos una variable String*/
        String nombre;
        /* Contruimos el cuandro de diálogo*/
        nombre=JOptionPane.showInputDialog("Introduce tu nombre");
        /* Mostramos el nombre por consola*/
        System.out.println(nombre);     

      int ao = otrafecha.get(Calendar.YEAR);
      int me = otrafecha.get(Calendar.MONTH) + 1;
      int di = otrafecha.get(Calendar.DAY_OF_MONTH);
      int ho = otrafecha.get(Calendar.HOUR_OF_DAY );
      int mi = otrafecha.get(Calendar.MINUTE );
      int se = otrafecha.get(Calendar.SECOND );
      try {
      int iTest = Integer.valueOf(strTest);   
      System.out.println("Cadena real:" + strTest);   
      System.out.println("Convertido a Int:" + iTest);   
      System.out.println("---- Año: " + ao);   
      System.out.println("-------- Mes: " + me);   
      System.out.println("------------ Dia: " + di);   
      System.out.println("---------- Hora: " + ho);   
      System.out.println("--------- Minuto: " + mi);   
      System.out.println("---------- Segundo: " + se);   
      }
      catch(NumberFormatException e){
      System.out.println("Convertido a Int:" + e);             
      }
    }
}
