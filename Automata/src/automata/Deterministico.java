/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author jcaros
 */
public class Deterministico implements Automata{
   
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
      a.trancisiones.put(elem, b);
   }
   
   @Override
   public void agregarTransicion(String a, char elem, String b){
      searchNodo(a).trancisiones.put(elem, searchNodo(b));
   }

   @Override
   public boolean evaluarEntrada(String entrada) {
      Nodo current=inicio;
      char[] cadena=entrada.toCharArray();
      int i;
      Nodo aux=inicio;
      for(i=0;i<cadena.length;i++){
         aux=transicion(current, cadena[i]);
         if(aux!=null){
            current=aux;
         }
         else
            return false;
      }
      if(aux.fin)
         return true;
      return false;
   }

   @Override
   public void agregarAlfabeto(char[] alf) {
      alfabeto=alf;
   }
   
   public Nodo transicion(Nodo node,char a){
      boolean salida=node.trancisiones.containsKey(a);
      if(salida)
         return node.trancisiones.get(a);
      return null;
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
