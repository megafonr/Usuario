/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolo.usuario;
import java.util.ArrayList;
import Libre.Roles;
import java.time.LocalDate;
//import java.util.InputMismatchException;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 *
 * @author Rolo
 */
public class TPUsuarioGrafico {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        byte campo;
        String Nom;
        String Ape;
        String mail;
        String FeNac;
        String FeCrea;
        Roles tipoUsr = Roles.USR ;
        String tipoUs, variosdatos, sigo; 
        int edad, indi;
        boolean resul;
        LocalDate Fechalocal = LocalDate.now();        

        ArrayList<ClaseUsuario> Usuarios = new ArrayList<ClaseUsuario>();
        ClaseUsuario usr;

        campo=0;
        
        sigo = "SI";

        while (sigo == "SI"){

            usr = new ClaseUsuario();
        
          JOptionPane.showMessageDialog(null, "Ingreso Datos del Usuario " + (1+campo)); 
          do {
            Nom=JOptionPane.showInputDialog("Ingrese Nombre del Usuario");
            Nom=usr.validarNombreApellido(Nom);
          } while(Nom.isEmpty() );

          do {
            Ape=JOptionPane.showInputDialog("Ingrese Apellido del Usuario");
            Ape=usr.validarNombreApellido(Ape);
          } while(Ape.isEmpty() );

          do {
            mail=JOptionPane.showInputDialog("Ingrese Mail del Usuario");
            mail=usr.validarMail(mail);
          } while(mail.isEmpty() );

          do {
            resul=true;   
            do {
              FeNac=JOptionPane.showInputDialog("Ingrese Fecha Nacimiento del Usuario (DD/MM/YYYY):");
              FeNac=usr.validarFecha(FeNac);
            } while(FeNac.isBlank());
//          Calculo edad y Valido si fecha Nac es mayor a la fecha actual        
            edad=usr.CalculoEdad(FeNac);
            if(edad<0){
              JOptionPane.showMessageDialog(null, "Fecha Nacimiento Incorrecta. Intente nuevamente.");     
              resul=false;
            } else if(edad<18){
              JOptionPane.showMessageDialog(null, "Debe ser Mayor de edad. Intente nuevamente.");     
              resul=false;
            } else if(edad>100){
              JOptionPane.showMessageDialog(null, "Debe ser una edad menor. Intente nuevamente.");     
             resul=false;
            }
            
          } while(!resul);

        do{
          resul=true;  
          try{
            tipoUs="USR";   
            tipoUs=JOptionPane.showInputDialog(null, "Ingrese Rol del Usuario (Usr [Default] ; Admin) : ");     
            tipoUsr= Roles.valueOf(tipoUs.toUpperCase());    //   Evalua el dato ingresado
          } catch(IllegalArgumentException e){
             JOptionPane.showMessageDialog(null, "Debe Ingresar Usr o Admin .");     
            resul=false;  
          }
       } while(!resul);

        usr.setNombre(Nom);
        usr.setApellido(Ape);
        usr.setMail(mail);
        usr.setFNac(FeNac);
        usr.setEdad(edad);
        FeCrea = String.valueOf(Fechalocal);        
        usr.setFCreac(FeCrea);
        usr.setRol(tipoUsr);  

//   Cargo el usuario en el ArrayList
        Usuarios.add(usr);
        
//        Usuarios.add(campo,usr);
        System.out.println(" Usuario " + campo + " Ingresado .......... " );
        
        do{
          resul=true;   
//          System.out.println("Desea Ingresar un Nuevo Usuario? (1=SI [Default] ; 2=NO) : ");
          int ax;
          ax = JOptionPane.showConfirmDialog(null, "Desea Ingresar un Nuevo Usuario?","Carga de Usuarios", JOptionPane.YES_NO_OPTION );
          if(ax == JOptionPane.YES_OPTION){
             JOptionPane.showMessageDialog(null, "Has seleccionado SI.");
             campo++;
          } else if(ax == JOptionPane.NO_OPTION){
             sigo = "NO";
             JOptionPane.showMessageDialog(null, "Has seleccionado NO.");
          }

        } while(!resul);
        
        }  // Fin del While de Carga de Alumnos .....    
        
//    ............  Muestro Usuarios Cargados  .......
//        System.out.println(" Usuarios Ingresados .. " + Usuarios.size() );
         variosdatos = "Usuarios Ingresados: " + "\n";
        Iterator<ClaseUsuario> nombreIterator;
        nombreIterator = Usuarios.iterator();
        while(nombreIterator.hasNext()){
	   usr = nombreIterator.next();
           variosdatos=variosdatos + usr.Nombre + " / " + usr.Apellido + " / " + usr.Mail + " / " + usr.FNac + " / " + usr.Edad + " / " + usr.Rol + " / " + usr.FCreac + "\n";
        }
         JOptionPane.showMessageDialog(null, variosdatos);

        
    }   //  Fin Main ......
}   //  Fin Clase   ......

        /* Contruimos el cuandro de diálogo*/
        // nombre=JOptionPane.showInputDialog("Introduce tu nombre");
        /* Mostramos el nombre por consola*/
        // JOptionPane.showMessageDialog(null, "Has seleccionado: " + nombre);     
/**     ***********
int ax = JOptionPane.showConfirmDialog(null, "Estas en java?");
        if(ax == JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog(null, "Has seleccionado SI.");
        else if(ax == JOptionPane.NO_OPTION)
            JOptionPane.showMessageDialog(null, "Has seleccionado NO.");
        else if(ax == JOptionPane.CANCEL_OPTION)
            JOptionPane.showMessageDialog(null, "Has seleccionado Cancel.");
******/

