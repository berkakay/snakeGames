package snake_game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;

public class Kutu extends JLabel {
    /*
        Berk Akay
        06.04.2019
    */
    public int width = 20;
    public int mYon = YON.SAG;
    Kutu(){
        setBounds(100,100,width, width);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 =(Graphics2D)g;
        Rectangle2D rect = new Rectangle2D.Double(1,1,getWidth()-2,getHeight()-2);
        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(2));
        g2.draw(rect);
    } 
    public void SolaGit(){
        int posX = getX();
        int posY = getY();
        posX -= width;
        setBounds(posX, posY, width, width);
    }
    public void SagaGit(){
        int posX = getX();
        int posY = getY();
        posX += width;
        setBounds(posX, posY, width, width);   
    }
    public void YukariCik(){
        int posX = getX();
        int posY = getY();
        posY -= width;
        setBounds(posX, posY, width, width);               
    }
    public void AsagiIn(){
        int posX = getX();
        int posY = getY();
        posY += width;
        setBounds(posX,posY,width,width);             
    }
    public Kutu KutuOlustur(){
        Kutu kutuOlustur = new Kutu();
        int x = getX();
        int y = getY();
        kutuOlustur.setBounds(x, y, width,width);
        kutuOlustur.mYon = -mYon;
        kutuOlustur.Hareket();
        kutuOlustur.mYon = mYon;
        return kutuOlustur;
    }
    public void Hareket(){
        if(mYon == YON.SOL){
            SolaGit();
        }
        else if(mYon == YON.SAG){
            SagaGit();
        }
        else if(mYon == YON.ASAGI){
            AsagiIn();
        }
        else{
            YukariCik();
        }
    }
}
