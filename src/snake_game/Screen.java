package snake_game;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Screen extends JFrame {
     /*
        Berk Akay
        06.04.2019
    */
    private int width = 600;
    private int height = 600;
    private static Screen mPencere = null;
    private Screen(){
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Ekran kapatıldığında programıda sonlandırmasını söylüyoruz.
        setPosition(width, height);
        setResizable(false);
        Snake snake = new Snake();
        add(snake);
    }
    public static Screen pencereOlustur(){
        //Daha önceden pencere oluşturulup oluşturulmadığını kontrol ediyoruz.
        //Ona Göre Bir Pencere Oluşturup Değerini Gönderiyoruz.
        if(mPencere == null){
            mPencere = new Screen();
        }
        return mPencere;
    }
    public void setPosition(int width, int height){
        //Sistemden Ekran Boyutlarını Alıyoruz.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Ekranın Başlangıç Kordinatları
        int posX = 0;
        int posY = 0;
        
        //Alınan Ekran Boyutlarına Göre Ekranın Boyutunu Ayarlıyoruz.
        if(width+100 > dim.width){
            width = dim.width-100;
        }
        if(height + 100 > dim.height){
            height = dim.height - 100;
        }
        
        //Pozisyonları Buluyoruz.
        
        posX = (dim.width - width) / 2 ;
        posY = (dim.height - height ) / 2;
        
        //Pozisyonları Aktif Hale Getiriyoruz.
        
        setBounds(posX,posY,width,height);
        
    }
}
