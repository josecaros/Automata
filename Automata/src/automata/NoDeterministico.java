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
public class NoDeterministico implements Automata{
   
   public char[] alfabeto;
   public Nodo inicio;
      
   @Override
   public void agregarEstado(Nodo a, boolean estado) {
      Nodo aux=inicio;
      a.fin=estado;
      if(aux==null){
         inicio=a;
      }
      else{
         while(aux.next!=null)
            aux=aux.next;
         aux.next=a;
      }
   }

   @Override
   public void agregarTransicion(Nodo a, char elem, Nodo b) {
      a.transiciones1.insertar(elem, b);
   }

   @Override
   public void agregarTransicion(String a, char elem, String b) {
      searchNodo(a).transiciones1.insertar(elem, searchNodo(b));
   }

   @Override
   public boolean evaluarEntrada(String entrada) {
      char[] entry = entrada.toCharArray();
      ArrayList<Nodo> aux= inicio.transiciones1.get(entry[0]);
      for(int i=1;i<entry.length;i++){
         if(aux!=null){
            aux=transicion(entry[i], aux);
         }
         else
            return false;
      }
      if(aux.isEmpty())
         return false;
      else{
         for(int i=0;i<aux.size();i++)
            if(aux.get(i).fin)
               return true;
         return false;
      }
   }
   
   public ArrayList<Nodo> transicion(char a, ArrayList<Nodo> entra){
      ArrayList<Nodo> salida = new ArrayList<>();
      for(int i=0;i<entra.size();i++){
         ArrayList<Nodo> temp = entra.get(i).transiciones1.get(a);
         if(temp!=null){
            for(int p=0;p<temp.size();p++)
               salida.add(temp.get(p));
         }
      }
      return salida;
   }

   @Override
   public void agregarAlfabeto(char[] alf) {
      alfabeto=alf;
   }
   
   public Nodo searchNodo(String dato) {
      Nodo aux=inicio;
      while(aux!=null){
         if(aux.nombre.equals(dato)){
            return aux;
         }
         aux=aux.next;
      }
      return null;
   }
}
