/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.Graphics;

/**
 *
 * @author jcaros
 */
public class PainterNodo {
   public int x,y;
   private String nombre;
   public static final int diametro=55;
   
   public PainterNodo(int a, int b, String nom){
      x=a;
      y=b;
      nombre = nom;
   }
   
   public void pintar(Graphics graf){
      graf.drawOval(x-diametro/2, y-diametro/2, diametro, diametro);
      graf.drawString(nombre, x, y);
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }
   
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   
}
