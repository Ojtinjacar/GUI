/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionListener;


/**
 *
 * @author Estudiante
 */
import java.awt.event.ActionEvent;
public class GUI extends JFrame {

    public GUI() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setTitle("HolaMundo");
        frame.setSize(1000, 1500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class NewPanel extends JPanel implements ActionListener{
private Timer timer;
private int x;

    public NewPanel() {
          timer = new Timer(25, this);
            timer.start();
            this.x=20;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Click");
        
        //rectangulo

       
        Polygon polygon = new Polygon();
        g.fillOval(x+600, 700, 60, 60);
        g.fillOval(x+800, 700, 60, 60);
        g.setColor(Color.red);
        g.fillRect(x+550, 620, 350, 80);

        polygon.addPoint(x+570, 620);
        polygon.addPoint(x+600, 550);
        polygon.addPoint(x+850, 550);
        polygon.addPoint(x+870, 620);
        //rectangulo
        g.drawRect(x+550, 550, 350, 210);
          g.setColor(Color.red);
        g.fillPolygon(polygon);
        /*
        g.setColor(Color.blue);
        g.drawRect(570, 550, 350, 210);
        Polygon polygon1 = new Polygon();
        g.drawOval(620, 700, 60, 60);
        g.drawOval(820, 700, 60, 60);
        //rectangulo
        g.drawRect(570, 620, 350, 80);

        polygon1.addPoint(590, 620);
        polygon1.addPoint(620, 550);
        polygon1.addPoint(870, 550);
        polygon1.addPoint(890, 620);

        g.drawPolygon(polygon1);
*/
       /* g.setColor(Color.MAGENTA);
        Polygon polygon2 = new Polygon();
        g.drawOval(640, 700, 60, 60);
        g.drawOval(840, 700, 60, 60);
        g.drawRect(590, 620, 350, 80);

        polygon2.addPoint(610, 620);
        polygon2.addPoint(640, 550);
        polygon2.addPoint(890, 550);
        polygon2.addPoint(910, 620);

        g.drawPolygon(polygon2);
        g.drawRect(590, 550, 350, 210);
       */

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x+=1;
       repaint();
    }
    
}
