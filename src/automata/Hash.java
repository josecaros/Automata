/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;

/**
 *
 * @author jcaros
 */
public class Hash {
   public ArrayList<Nodo>[] tabla;
   int pri=11;
   
   public Hash(){
      tabla = new ArrayList[pri];
      /*for(int i=0;i<pri;i++)
         tabla[i]= new ArrayList<>();*/
   }
   
   public void insertar(char a,Nodo dato){
      int key=funcionT1((int) a);
      if(tabla[key]==null){
         tabla[key] = new ArrayList<>();
         tabla[key].add(dato);
      }
      else
         tabla[key].add(dato);
   }
   
   public boolean contiene(char a){
      int key=funcionT1((int) a);
      if(tabla[key]!=null)
         return true;
      else
         return false;
   }
   
   public ArrayList get(char a){
      int key=funcionT1((int) a);
      return tabla[key];
   }
   
   
   public int funcionT1(int dato) {
		int a=7, b=3;
		return ((a*dato+b)%pri)%tabla.length;
	}
   
}
