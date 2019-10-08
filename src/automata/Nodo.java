/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;
import java.util.*;

/**
 *
 * @author jcaros
 */
public class Nodo {

   public String nombre;
   public Nodo next;
   boolean fin=false;
   public HashMap<Character ,Nodo> trancisiones;
   public Hash transiciones1;
   
   public Nodo(String in) {
      nombre=in;
      trancisiones = new HashMap<>();
      next=null;
      transiciones1= new Hash();
   }
}
