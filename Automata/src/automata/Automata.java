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
public interface Automata {
   
   public void agregarEstado(Nodo a, boolean estado);
   public void agregarTransicion(Nodo a,char elem,Nodo b);
   public void agregarTransicion(String a, char elem, String b);
   public boolean evaluarEntrada(String entrada);
   public void agregarAlfabeto(char [] alf);
   
   
}
