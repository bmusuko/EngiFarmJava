import javax.swing.JFrame;
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
        // Masukin obejct game disini
        // Gameplay gim = new Gameplay();
        frame.setBounds(10, 10, 1280, 800);
        frame.setTitle("Engi's Farm by: SenjaGurau");
        frame.setResizable(false);
        frame.setVisible(true);
        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // nanti object nya game, di add ke frame
        // frame.add(gim);
    }

    
}