/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import javax.swing.JFrame;

/**
 *
 * @author jcaros
 */
public class Painter {
   
   public static void main(String[] args){
      JFrame ventana = new JFrame("GrafoP1");
      ventana.add(new PainterCuadro());
      ventana.setSize(600,600);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setVisible(true);
   }
   
}
