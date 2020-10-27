/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolo.usuario;
import Libre.Roles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Rolo
 */
public class ClaseUsuario {
  String Nombre, Apellido, Mail, FNac, FCreac;
  Roles Rol;
  int Edad;

    public ClaseUsuario(){
        
    }
            
    public ClaseUsuario(String Nombre, String Apellido, String Mail, String FNac, String FCreac, Roles Rol, int Edad) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Mail = Mail;
        this.FNac = FNac;
        this.FCreac = FCreac;
        this.Rol = Rol;
        this.Edad = Edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getMail() {
        return Mail;
    }

    public String getFNac() {
        return FNac;
    }

    public String getFCreac() {
        return FCreac;
    }

    public Roles getRol() {
        return Rol;
    }

    public int getEdad() {
        return Edad;
    }

    public void setNombre(String Nombre) {
           this.Nombre = Nombre.trim().toUpperCase();
    }

    public void setApellido(String Apellido) {
           this.Apellido = Apellido.trim().toUpperCase();
    }

    public void setMail(String Mail) {
           this.Mail = Mail.trim();
    }

    public void setFNac(String FNac) {
        this.FNac = FNac;
    }

    public void setFCreac(String FCreac) {
        this.FCreac = FCreac;
    }

    public void setRol(Roles Rol) {
        this.Rol = Rol;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }



    

    public String validarNombreApellido(String NomApe) {
        String resu="";
        NomApe=NomApe.trim().toUpperCase();
        
        if(NomApe.length()> 0 ){
           resu=NomApe; 
        } else {
            System.out.println("Debe Ingresar un valor Valido ");
        }
        return resu;
    }
    
    public String validarMail(String correo) {
        String resu="";
        correo = correo.trim();
        
        if( (correo.length()> 6) && (correo.contains("@"))){
           resu=correo; 
        } else {
            System.out.println("Debe Ingresar un valor Valido ");
        }
        
        return resu;
    }

    public String validarFecha(String fecha) {
        boolean resu=true;

        try{
        fecha = fecha.trim();
        SimpleDateFormat FecFormato = new SimpleDateFormat("dd/MM/yyyy");
        FecFormato.setLenient(false);
        
        FecFormato.parse(fecha);
        }
        catch (ParseException e){
         System.out.println("Debe ingresar una Fecha Valida: " + e);    
         fecha = "";
        }
        return fecha;
    }

    public boolean ValidoNumero(String dato, String tipo){
        boolean resu=false;
        int numero;
        
        try{
        numero =Integer.parseInt(dato);
        switch (tipo)
        {
           case "D" -> {
               if(numero >0 && numero < 31){
                 resu = true;  
               }       }
           case "M" -> {
               if(numero > 0 && numero < 13){
                 resu = true;  
               }
                }
           case "A" -> {
               if(numero > 1910 && numero < 2020 ){
                 resu = true;  
               }

           }
    } 
//        dato = dato.trim();
        }
        catch(NumberFormatException e){
         System.out.println("Debe ingresar un Numero Valido: " + e);    
        }
        return resu;
        
    }
    
    public int CalculoEdad(String FechaNac) {
        int edad = 0;
        String mifecactu;        
        LocalDate FecActu = LocalDate.now();
        DateTimeFormatter formaFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        mifecactu = FecActu.format(formaFecha);
        String[] Arrfecactu = mifecactu.split("/");
        String[] Arrfecnac =  FechaNac.split("/");
        edad = Integer.parseInt(Arrfecactu[2]) - Integer.parseInt(Arrfecnac[2]);
        if(Integer.parseInt(Arrfecactu[1]) < Integer.parseInt(Arrfecactu[1])){
            edad = edad -1;
        } else if(Integer.parseInt(Arrfecactu[1]) == Integer.parseInt(Arrfecnac[1])){
            if(Integer.parseInt(Arrfecactu[0]) < Integer.parseInt(Arrfecnac[0])){
            edad = edad -1;
        }
        }
//            System.out.println("EL Dia es : " + Arrfecactu[0]);
     return edad;    
    }
    
    public void MostrarDato(){
        //  Salida
        
    }
    
}
