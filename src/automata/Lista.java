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
public class Lista {

   public class Node {

      public Nodo dato;
      public Node next;
      public Node prev;

      Node(Nodo date) {
         dato = date;
         next = null;
         prev = null;
      }

   }
   
   public Node head;
   public Node actual;
   public int tam;
   
   public Lista(){
      head=null;
      actual=null;
      tam=0;
   }
   
   public void insertar(Nodo date){
      if(head==null){
         head = new Node(date);
         actual=head;
         tam++;
      }
      else{
         Node aux= new Node(date);
         actual.next=aux;
         aux.prev=actual;
         actual=aux;
         tam++;
      }
   }
   
   public Node buscar(Nodo dato){
      Node aux=head;
      while(aux!=null && aux.dato!=dato){
         aux=aux.next;
      }
      return aux;
   }
}
