/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolo.usuario;

import java.util.ArrayList;
import java.util.Scanner;
import Libre.Roles;
// import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 *
 * @author Rolo
 */
public class TPUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
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
//        Usuarios.add(0,usr);  //  "d1","d2","d3","d4","d5",tipoUsr,1);
//        Ape=Usuarios.get(0).Apellido;
        
        Scanner datos = new Scanner(System.in);
        campo=0;
        
        sigo = "SI";

        while (sigo == "SI"){

            usr = new ClaseUsuario();
        
        System.out.println("Ingreso Datos del Usuario " + (campo));
        System.out.println("Ingrese Nombre del Usuario: ");
        do {
         Nom=datos.next();
         Nom=usr.validarNombreApellido(Nom);
        } while(Nom.isEmpty() );

        System.out.println("Ingrese Apellido del Usuario: ");
        do {
         Ape=datos.next();
         Ape=usr.validarNombreApellido(Ape);
        } while(Ape.isEmpty() );

        System.out.println("Ingrese Mail del Usuario: ");
        do {
         mail=datos.next();
         mail=usr.validarMail(mail);
        } while(mail.isEmpty() );
        
        do {
          resul=true;   
          System.out.println("Ingrese Fecha Nacimiento del Usuario (DD/MM/YYYY): ");
          do {
           FeNac=datos.next();
           FeNac=usr.validarFecha(FeNac);
          } while(FeNac.isBlank());
          
//  Calculo edad y Valido si fecha Nac es mayor a la fecha actual        
          edad=usr.CalculoEdad(FeNac);
          if(edad<0){
             System.out.println("Fecha Nacimiento Incorrecta. Intente nuevamente.");
             resul=false;
          }
          else if(edad<18){
             System.out.println("Debe ser Mayor de edad. Intente nuevamente.");
             resul=false;
          }
          else if(edad>100){
             System.out.println("Debe ser una edad menor. Intente nuevamente.");
             resul=false;
          }
              
        } while(!resul);
//  Agrego
        do {
          resul=true;  
//  Hasta aca          
         try{
           System.out.println("Ingrese Rol del Usuario (Usr [Default] ; Admin) : ");

           tipoUs="USR";   
           tipoUs=datos.next().toUpperCase();
           tipoUsr= Roles.valueOf(tipoUs);    //   Evalua el dato ingresado
//           variosdatos=tipoUsr.toString();
         } catch(IllegalArgumentException e){
           System.out.println(" Debe Ingresar Usr o Admin . ");
           resul=false;  
//           tipoUs="USR";   
//           tipoUsr= Roles.valueOf(tipoUs);  //   Evalua el dato ingresado
         }
/**
           variosdatos="ADMIN";
           if(Roles.valueOf(tipoUs.trim()) == Roles.valueOf(variosdatos.trim())){
             tipoUsr=Roles.ADMIN;
           }
*/
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
        System.out.println(" .............................. " );
        
        do{
         resul=true;   
         System.out.println("Desea Ingresar un Nuevo Usuario? (1=SI [Default] ; 2=NO) : ");
         try {
         tipoUs="1";   
         tipoUs=datos.next();
         
         tipoUs = tipoUs.trim();
         if(Integer.parseInt(tipoUs) == 2){
            sigo = "NO";
         } else{
             campo++;
         }
//  InputMismatchException         
         } catch(NumberFormatException e) {
           System.out.println(" Debe Ingresar un valor numerico 1 o 2  ");
           resul=false;  
         }    
         
        } while(!resul);
        
        }  // Fin del While de Carga de Alumnos .....    
//    ............  Muestro Usuarios Cargados  .......
        System.out.println(" Usuarios Ingresados .. " + Usuarios.size() );
        Iterator<ClaseUsuario> nombreIterator;
        nombreIterator = Usuarios.iterator();
        while(nombreIterator.hasNext()){
	   usr = nombreIterator.next();
	   System.out.println(usr.Nombre + " / " + usr.Apellido + " / " + usr.Mail + " / " + usr.FNac + " / " + usr.Edad + " / " + usr.Rol + " / " + usr.FCreac );
        }
    }   //  Fin main
}    //  Fin class
