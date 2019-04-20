import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Main class
 * 
 * @author Putu Gde
 * @author Hilmi Naufal
 * @author Bram Musuko
 * @author Y. Valentino
 */

public class GameMain extends JFrame {
    /**
     * main program, untuk tampilkan GUI
     */
    public Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
    
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
    
        return resizedImg;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1280, 800);
        JLabel x  = new JLabel(new ImageIcon("resource/cow.png"));
        x.setLayout(null);
        x.setBounds(50, 100, 500, 500);
        x.setVisible(true);
        // x.setSize(60, 60);
        panel.add(x);
        JLabel title = new JLabel(new ImageIcon("resource/truck.png"));
        JLabel[][] map = new JLabel[10][11];
        for (int i = 0;i<10;i++){
            for (int j = 0;j<11;j++){
                map[i][j] = new JLabel(new ImageIcon("resource/Grassland.jpg"));
                map[i][j].setLayout(null);
                map[i][j].setBounds(50+(j*60),100+(i*60),60,60);
                panel.add(map[i][j]);
            }
        }
        
        
        frame.setLayout(null);
        frame.setBounds(10, 10, 1280, 800);
        frame.setTitle("Engi's Farm by: SenjaGurau");
        title.setBounds(0, 0, 1280, 100);
        frame.add(title);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        title.setBounds(0, 0, 1280, 100);
        frame.add(title);
        // nanti object nya game, di add ke frame
        // frame.add(gim);
        



    }
}