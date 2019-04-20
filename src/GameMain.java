import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        JLabel title = new JLabel(new ImageIcon("resource/truck.png"));
        JLabel[][] map = new JLabel[10][11];
        for (int i = 0;i<10;i++){
            for (int j = 0;j<11;j++){
                map[i][j] = new JLabel(new ImageIcon("resource/Grassland.jpg"));
                map[i][j].setBounds(50+(j*60),100+(i*60),60,60);
                frame.add(map[i][j]);
            }
        }
        // map[2][3].setIcon(new ImageIcon("resource/cow.png"));
        // Masukin obejct game disini
        // Gameplay gim = new Gameplay();
        
        frame.setLayout(null);
        frame.setBounds(10, 10, 1280, 800);
        frame.setTitle("Engi's Farm by: SenjaGurau");
        title.setBounds(0, 0, 1280, 100);
        frame.add(title);
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