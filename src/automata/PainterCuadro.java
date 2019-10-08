/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author jcaros
 */
public class PainterCuadro extends JPanel implements MouseListener, MouseMotionListener {

   private Vector<PainterNodo> vector;
   private Vector<PainterArista> aristas;
   private Point p1, p2;
   private PainterNodo nodoMover;
   private int iNodo;

   private JPanel panel1 = new JPanel();
   private JTextField jTextField1 = new javax.swing.JTextField();
   private JButton jButton1 = new javax.swing.JButton();
   private JLabel jLabel1 = new javax.swing.JLabel();
   private String cadena;
   private Automata automata;
   private boolean datI = true;
   private String ini;

   public PainterCuadro() {
      this.aristas = new Vector<>();
      this.vector = new Vector<>();
      automata = new NoDeterministico();
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      jLabel1.setText("Cadena a Validar");
      jButton1.setText("Validar");
      jTextField1.setColumns(20);

      panel1.setLayout(new GridLayout(2, 3, 10, 10));
      this.add(panel1);
      panel1.add(jLabel1);
      panel1.add(jTextField1);
      panel1.add(jButton1);
      jTextField1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField1ActionPerformed(evt);
         }
      });

      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

   }

   private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

   }

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
      cadena = jTextField1.getText();
      System.out.println(cadena);
      JOptionPane.showMessageDialog(this, automata.evaluarEntrada(cadena));

   }

   //@Override
   public void paint(Graphics g) {
      super.paint(g);
      for (PainterNodo nodos : vector) {
         nodos.pintar(g);
      }
      for (PainterArista arista : aristas) {
         arista.pintar(g);
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON1) {
         boolean selec = true;
         for (PainterNodo nodo : vector) {
            if (new Rectangle(nodo.getX() - PainterNodo.diametro / 2, nodo.getY() - PainterNodo.diametro / 2, PainterNodo.diametro, PainterNodo.diametro).contains(e.getPoint())) {
               int resp = JOptionPane.showConfirmDialog(null, "¿Desea establecer este nodo como Final?");
               if (JOptionPane.OK_OPTION == resp) {
                  System.out.println(nodo.getNombre());
                  automata.searchNodo(nodo.getNombre()).fin = true;
                  nodo.setNombre(nodo.getNombre() + "END");
                  automata.recorrer();
               }
               selec = false;
               repaint();
               break;
            }
         }
         if (selec) {
            String nombre = JOptionPane.showInputDialog("Nombre nodo:");
            this.vector.add(new PainterNodo(e.getX(), e.getY(), nombre));
            repaint();
            automata.agregarEstado(new Nodo(nombre), false);
         }
      }

      if (e.getButton() == MouseEvent.BUTTON3) {
         for (PainterNodo nodo : vector) {
            if (new Rectangle(nodo.getX() - PainterNodo.diametro / 2, nodo.getY() - PainterNodo.diametro / 2, PainterNodo.diametro, PainterNodo.diametro).contains(e.getPoint())) {
               if (p1 == null) {
                  
                  p1 = new Point(nodo.getX(), nodo.getY());
                  ini = nodo.getNombre();
                  //System.out.println("++++"+ini+"-----");

               } else {
                  p2 = new Point(nodo.getX(), nodo.getY());
                  String nombre2 = JOptionPane.showInputDialog("Nombre Arista:");
                  char[] car = nombre2.toCharArray();
                  automata.agregarTransicion(ini, car[0], nodo.getNombre());
                  this.aristas.add(new PainterArista(p1.x, p1.y, p2.x, p2.y, nombre2));
                  repaint();
                  p1 = null;
                  p2 = null;

               }
            }

         }
      }

   }

   @Override
   public void mousePressed(MouseEvent e) {
      int iN = 0;
      for (PainterNodo nodo : vector) {
         if (new Rectangle(nodo.getX() - PainterNodo.diametro / 2, nodo.getY() - PainterNodo.diametro / 2, PainterNodo.diametro, PainterNodo.diametro).contains(e.getPoint())) {
            nodoMover = nodo;
            iNodo = iN;
            break;
         }
         iN++;
      }
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      nodoMover = null;
      iNodo = -1;
   }

   @Override
   public void mouseEntered(MouseEvent e) {

   }

   @Override
   public void mouseExited(MouseEvent e) {

   }

   @Override
   public void mouseDragged(MouseEvent e) {
      if (nodoMover != null) {
         this.vector.set(iNodo, new PainterNodo(e.getX(), e.getY(), nodoMover.getNombre()));
         int iE = 0;
         for (PainterArista arista : aristas) {
            if (new Rectangle(arista.getX1() - PainterNodo.diametro / 2, arista.getY1() - PainterNodo.diametro / 2, PainterNodo.diametro, PainterNodo.diametro).contains(e.getPoint())) {
               this.aristas.set(iE, new PainterArista(e.getX(), e.getY(), arista.getX2(), arista.getY2(), arista.getNombre()));
            }
            if (new Rectangle(arista.getX2() - PainterNodo.diametro / 2, arista.getY2() - PainterNodo.diametro / 2, PainterNodo.diametro, PainterNodo.diametro).contains(e.getPoint())) {
               this.aristas.set(iE, new PainterArista(arista.getX1(), arista.getY1(), e.getX(), e.getY(), arista.getNombre()));
            }
            iE++;
         }
         repaint();
      }
   }

   @Override
   public void mouseMoved(MouseEvent e) {

   }

}
