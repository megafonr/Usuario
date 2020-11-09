/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libre;

/**
 *
 * @author Rolo
 */
/**   Dejo Original
public enum Roles {
    Administrador,
    Usuario
}
*/ 

public enum Roles {
    USR("1"),
    ADMIN("2");
    
    private String itemlista;
    
    private Roles(String itemlista){
        this.itemlista=itemlista;
        
    }
      @Override
    public String toString(){
           return itemlista.trim() ;
/**
           if (itemlista=="2"){
           return "2" ;
         }
         else{
             return "1" ;
         }
*/
    }   
}
