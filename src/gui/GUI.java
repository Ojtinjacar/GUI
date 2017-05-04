/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiante
 */
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI extends JFrame {

    public GUI() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setTitle("HolaMundo");
        frame.setSize(1000, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class NewPanel extends JPanel implements ActionListener, MouseListener {

    private Timer timer;
    private int x;
    private int y;
    private int secuencia;

    public NewPanel() {
        this.addMouseListener(this);
        timer = new Timer(25, this);
        timer.start();
        this.x = 20;
    }

    public Rectangle ObtenerPunto() {
        return new Rectangle(x + 150, 350, 350, 210);
    }

    public void CheckCollisions() {
        Rectangle Carro = this.ObtenerPunto();
        Rectangle muro = new Rectangle(720, 420, 150, 110);
        if (Carro.intersects(muro)) {
            System.out.println("colision");
           timer.stop();

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = cargarimagen("fondo.png");
       Image fondo1 = cargarimagen("cats.gif");
        g.drawImage(fondo, 0, 0, null);
      //  g.drawImage(fondo1, 0, 0, null);
        g.drawImage(fondo1, x, y,x + 132,y+80,(this.secuencia*132),+0,(this.secuencia*132)+132,80,this);

        //rectangulo
        Polygon polygon = new Polygon();
        g.fillOval(x + 200, 500, 60, 60);
        g.fillOval(x + 400, 500, 60, 60);
        g.setColor(Color.red);
        g.fillRect(x + 150, 420, 350, 80);

        polygon.addPoint(x + 170, 420);
        polygon.addPoint(x + 200, 350);
        polygon.addPoint(x + 450, 350);
        polygon.addPoint(x + 470, 420);

        //rectangulo
        g.setColor(Color.red);
        g.fillPolygon(polygon);
        g.drawRect(x + 150, 350, 350, 210);
        g.fillRect(720, 420, 150, 110);
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
        x += 100; 
        if (this.secuencia==5) {
            this.secuencia =0;
        }else
            this.secuencia++;
        
        //CheckCollisions();
        repaint();
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if (ObtenerPunto().contains(mp)) {

            timer.stop();

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Image cargarimagen(String imagen) {
        ImageIcon aaaaa = new ImageIcon(imagen);
        Image image = aaaaa.getImage();
        return image;
    }
}
