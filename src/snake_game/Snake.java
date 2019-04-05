package snake_game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Snake extends JLabel {
     /*
        Berk Akay
        06.04.2019
    */
    public ArrayList<Kutu> Liste = new ArrayList<Kutu>();
    public Kutu kutu = new Kutu();
    public Timer timer = null;
    public Yem yem=new Yem();
    public Random random = null;
    public void yemEkle(){
        int width = getWidth() - 100 - yem.width;
        int height = getHeight() - 100 - yem.width;
        int posX =  10 + Math.abs(random.nextInt()) % width ;
        int posY =  10 + Math.abs(random.nextInt()) & height ;
        posX = posX - posX % 20;
        posY = posY - posY % 20;
        for(int i=0;i<Liste.size();i++){
            if((posX == Liste.get(i).getX()) && (posY == Liste.get(i).getY()) ){
                yemEkle();
                return;
            }
        }
        yem.setPosition(posX, posY);    
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D rect = new Rectangle2D.Double(5, 5, getWidth()-10, getHeight()-10);
        g2.setColor(Color.red); // Renk
        g2.setStroke(new BasicStroke(10)); //Kalem Kalınlığı
        g2.draw(rect);
    }
    
    Snake(){
        addKeyListener(new KlavyeKontrol());
        random = new Random(System.currentTimeMillis());
        setFocusable(true); // Focus' u Yılana Alıyoruzki Bir tuşa basıldığında Yılan Label Dinleyebilsin. 
        //Focus o frame' e o label' e odaklan ve işlemler orada gerçekleşecek.
        timer = new Timer(100, new TimerKontrol());
        timer.start();
        add(kutu);
        Liste.add(kutu);
        for(int i=1;i<1;i++){
            KuyrukEkle();
        }
        add(yem);
        add(kutu);
       
    }   
    public void KuyrukEkle(){
        Kutu A = Liste.get(Liste.size()-1).KutuOlustur();
        Liste.add(A);
        add(A);
    }
    public void AllHareket(){
        for(int i=Liste.size()-1;i>0;i--){
            Kutu Onceki = Liste.get(i-1);
            Kutu Sonraki = Liste.get(i);
            Liste.get(i).Hareket();
            Sonraki.mYon = Onceki.mYon;
        }
        kutu.Hareket();
    }
    class KlavyeKontrol implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
           if(e.getKeyCode() == KeyEvent.VK_LEFT)
           {
               if(kutu.mYon != YON.SAG){
                 kutu.mYon = YON.SOL;   
               }
              
           }
               if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                  if(kutu.mYon != YON.SOL){
                      kutu.mYon = YON.SAG;
                  }
               }
                   if(e.getKeyCode() == KeyEvent.VK_UP){
                       if(kutu.mYon != YON.ASAGI){
                           kutu.mYon = YON.YUKARI;
                       }
                   }
                       if(e.getKeyCode() == KeyEvent.VK_DOWN){
                           if(kutu.mYon != YON.YUKARI){
                                kutu.mYon = YON.ASAGI;
                           }
                          
                       }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
    public boolean DurumKontrol(){
        int cerceve = 10;
        int width = getWidth();
        int height = getHeight();
        
        if(kutu.getX() <= 10 || kutu.getX()+kutu.width >= width - cerceve)
        {
           return true;  
        }
        if(kutu.getY() <= 10 || kutu.width+kutu.getY() >=height-cerceve){
            return true;
        }
            for(int i=1;i<Liste.size();i++){
            int x = Liste.get(i).getX();
            int y = Liste.get(i).getY();
            if((x == kutu.getX()) && (y == kutu.getY())){
                return true;
            }
        }
          if((yem.getX() == kutu.getX() && (yem.getY() == kutu.getY()))){
              KuyrukEkle();
              yemEkle();
          }
        return false;
    }
    class TimerKontrol implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AllHareket();
            if(DurumKontrol()){
                timer.stop();
            }          
        }
        
    }
}
