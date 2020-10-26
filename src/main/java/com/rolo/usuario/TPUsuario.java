/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolo.usuario;

import java.util.ArrayList;
import java.util.Scanner;
import Libre.Roles;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
        Roles tipoUsr;
        String tipoUs;
        int edad;
        String sigo; 
        boolean resul;
        LocalDate Fechalocal = LocalDate.now();        
        tipoUsr = Roles.Usuario;
        
        ArrayList<ClaseUsuario> Usuarios = new ArrayList<>();
        ClaseUsuario usr = new ClaseUsuario();
        Usuarios.add(0,usr);  //  "d1","d2","d3","d4","d5",tipoUsr,1);
        Ape=Usuarios.get(0).Apellido;
        
        Scanner datos = new Scanner(System.in);
        campo=0;
        
        sigo = "SI";

        while (sigo == "SI"){
        System.out.println("Ingreso Datos Usuario " + (campo+1));
        System.out.println("Ingrese Nombre Alumno: ");
        do {
         Nom=datos.next();
         Nom=usr.validarNombreApellido(Nom);
        } while(Nom.isEmpty() );

        System.out.println("Ingrese Apellido Alumno: ");
        do {
         Ape=datos.next();
         Ape=usr.validarNombreApellido(Ape);
        } while(Ape.isEmpty() );

        System.out.println("Ingrese Mail Alumno: ");
        do {
         mail=datos.next();
         mail=usr.validarMail(mail);
        } while(mail.isEmpty() );
        
        do {
          resul=true;   
          System.out.println("Ingrese Fecha Nacimiento Alumno (DD/MM/YYYY): ");
          do {
           FeNac=datos.next();
           FeNac=usr.validarFecha(FeNac);
          } while(FeNac.isBlank());
//        SimpleDateFormat FeFor = new SimpleDateFormat("dd/MM/yyyy");
//  No valido si fecha Nac es mayor a la fecha actual        
          edad=usr.CalculoEdad(FeNac);
          if(edad<0){
             System.out.println("Fecha Nacimiento Incorrecta. Intente nuevamente.");
             resul=false;
          }
        } while(!resul);

        System.out.println("Ingrese Rol Alumno (1=Usuario [Default] ; 2=Administrador) : ");
         tipoUs="1";   
         tipoUs=datos.next();
         tipoUs = tipoUs.trim();
         tipoUsr=Roles.Usuario;
         if(Integer.parseInt(tipoUs) == 2){
            tipoUsr=Roles.Administrador;
         }

        usr.setNombre(Nom);
        usr.setApellido(Ape);
        usr.setMail(mail);
        usr.setFNac(FeNac);
        usr.setEdad(edad);
        FeCrea = String.valueOf(Fechalocal);        
        usr.setFCreac(FeCrea);
        usr.setRol(tipoUsr);  

        Usuarios.add(campo,usr);
        System.out.println(" Alumno " + campo+1 + " Ingresado .......... " );
        System.out.println(" .............................. " );
        
         System.out.println("Desea Ingresar un Nuevo Alumno? (1=SI [Default] ; 2=NO) : ");
         tipoUs="1";   
         tipoUs=datos.next();
         tipoUs = tipoUs.trim();
         if(Integer.parseInt(tipoUs) == 2){
            sigo = "NO";
         } else{
             campo++;
         }
        }
// Fin del While de Carga de Alumnos .....    

    }
}
