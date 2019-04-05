/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;

/**
 *
 * @author HB
 */
public class Yem extends JLabel {
     /*
        Berk Akay
        06.04.2019
    */
    public int width = 20; 
    Yem(){
        setPosition(60,60);
     }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D elp = new Ellipse2D.Double(0,0,width-2,width-2);
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));
        g2.draw(elp);
        g2.setColor(Color.CYAN) ;
    }
    public void setPosition(int posX, int posY){
        setBounds(posX,posY,width,width);
    }
}
