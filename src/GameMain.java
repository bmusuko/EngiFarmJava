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
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        // panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1280, 800);
        JLabel x  = new JLabel(new ImageIcon("resource/rsz_cow.png"));
        x.setLayout(null);
        x.setBounds(50, 100, 60, 60);
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
        //Di bawah ini contohnya
        ImageIcon icontol = new ImageIcon("resource/rsz_cow.png");
        map[1][2].setIcon(icontol);

        title.setBounds(0, 0, 1280, 100);
        panel.add(title);
        frame.setLayout(null);
        frame.setBounds(10, 10, 1280, 800);
        frame.setTitle("Engi's Farm by: SenjaGurau");
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        title.setBounds(0, 0, 1280, 100);
        frame.add(title);
    }
}