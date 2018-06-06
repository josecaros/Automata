/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.HashMap;

/**
 *
 * @author jcaros
 */
public class Main {
   public static void main(String[]args){
      /*Automata automata1=new Deterministico();
      Automata automata2=new Deterministico();
      char[] alfabeto={'a','b'};
      // Automata que acaba siempre en b y tiene un numero par de a's
      // ejemplo: aaab, ab, aaaaab
      Nodo a=new Nodo("q1");
      Nodo b=new Nodo("q2");
      Nodo c=new Nodo("q3");
      
      automata1.agregarAlfabeto(alfabeto);
      automata1.agregarEstado(a, false);
      automata1.agregarEstado(b, false);
      automata1.agregarEstado(c, true);
      
      automata1.agregarTransicion(a, 'a', b);
      automata1.agregarTransicion(b, 'a',a);
      automata1.agregarTransicion(b, 'b', c);
      
      System.out.println("Pruebas del Automata 1");
      System.out.println(automata1.evaluarEntrada("aaaaaaaaaab"));  //false
      System.out.println(automata1.evaluarEntrada("aaaaaaaaaa"));   //false
      System.out.println(automata1.evaluarEntrada("aab"));          //false
      System.out.println(automata1.evaluarEntrada("aaab"));         //true
      System.out.println(automata1.evaluarEntrada("ab"));           //true
      System.out.println(automata1.evaluarEntrada("aaaaab"));       //true
      System.out.println(automata1.evaluarEntrada("a1adbc"));       //true
      //Automata que solo acepta un numero par de a's y b's, ademas estos deben ir en pares
      //ejemplo: aabb , aabbaabbaabbaabb
      
      automata2.agregarAlfabeto(alfabeto);
      automata2.agregarEstado(new Nodo("e1"), false);
      automata2.agregarEstado(new Nodo("e2"), false);
      automata2.agregarEstado(new Nodo("e3"), false);
      automata2.agregarEstado(new Nodo("e4"), true);
      automata2.agregarEstado(new Nodo("e5"), true);
      
      automata2.agregarTransicion("e1", 'a', "e2");
      automata2.agregarTransicion("e2", 'a', "e4");
      automata2.agregarTransicion("e4", 'b', "e3");
      automata2.agregarTransicion("e1", 'b', "e3");
      automata2.agregarTransicion("e3", 'b', "e5");
      automata2.agregarTransicion("e5", 'a', "e2");
      
      
      System.out.println("Pruebas del Automata 2");
      System.out.println(automata2.evaluarEntrada("ab"));            //false
      System.out.println(automata2.evaluarEntrada("aaaab"));         //false
      System.out.println(automata2.evaluarEntrada("aabbaaabb"));     //false
      System.out.println(automata2.evaluarEntrada("aabb"));          //true
      System.out.println(automata2.evaluarEntrada("aabbaabbaabb"));  //true
      System.out.println(automata2.evaluarEntrada("bbaabb"));        //true

      */
      Automata automata= new NoDeterministico();
      char [] alfabeto = {'0','1','2'};
      automata.agregarAlfabeto(alfabeto);
      
      Nodo a = new Nodo("q0");
      Nodo b = new Nodo("q1");
      Nodo c = new Nodo("q2");
      Nodo d = new Nodo("q3");
      
      automata.agregarEstado(a, false);
      automata.agregarEstado(b, false);
      automata.agregarEstado(c, false);
      automata.agregarEstado(d, true);
      
      automata.agregarTransicion(a, '1', a);
      automata.agregarTransicion(a, '0', b);
      automata.agregarTransicion(a, '2', c);
      automata.agregarTransicion(b, '0', b);
      automata.agregarTransicion(b, '2', c);
      automata.agregarTransicion(b, '1', a);
      automata.agregarTransicion(c, '0', d);
      automata.agregarTransicion(c, '1', d);
      automata.agregarTransicion(c, '2', d);
      automata.agregarTransicion(c, '0', b);
      automata.agregarTransicion(d, '1', d);
      automata.agregarTransicion(d, '0', d);
      automata.agregarTransicion(d, '2', c);
      
   
      
      System.out.println(automata.evaluarEntrada("02222"));
      
      
      
      
      
       
               
   }
      
   
}
