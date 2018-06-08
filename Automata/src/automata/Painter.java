/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.GroupLayout.*;

/**
 *
 * @author jcaros
 */
public class Painter {
   public static JPanel jPanel1;
   
   public static void main(String[] args){
      
      JFrame ventana = new JFrame("GrafoP1");
      
      PainterCuadro panel=new PainterCuadro();
      ventana.add(panel);      
      ventana.setSize(500,500);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setResizable(true);
      ventana.setVisible(true);
   }   
}
