import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Main class
 * 
 * @author Putu Gde
 * @author Hilmi Naufal
 * @author Bram Musuko
 * @author Y. Valentino
 */
@SuppressWarnings("serial")

public class GameMain extends JFrame implements ActionListener {
    /**
     * main program, untuk tampilkan GUI
     */
    private Game g;
    private JLabel[][] map;
    Vector<ImageIcon> imageBackground;
    JLabel title,labelKeterangan;
    JFrame frame;
    JTextArea input;
    JButton inputButton;

    public GameMain() throws Exception {
        g = new Game();
        frame = new JFrame();
        imageBackground = new Vector<ImageIcon>();
        imageBackground.add(new ImageIcon("resource/rsz_coop.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_coopgrass.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_barn.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_barngrass.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_grassland.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_grasslandgrass.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_truck.png"));
        imageBackground.add(new ImageIcon("resource/rsz_well.png"));
        imageBackground.add(new ImageIcon("resource/rsz_mixer.png"));
        title = new JLabel(new ImageIcon("resource/judul.png"));
        map = new JLabel[10][11];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                map[i][j] = new JLabel(new ImageIcon("resource/rsz_coop.jpg"));
                map[i][j].setBounds(50 + (j * 60), 100 + (i * 60), 60, 60);
                frame.add(map[i][j]);
            }
        }
        printPeta();
        input = new JTextArea();
        input.setLayout(null);
        input.setBounds(50, 725, 500, 25);
        frame.add(input);
        inputButton = new JButton("Input!");
        inputButton.setLayout(null);
        inputButton.setBounds(560, 725, 150, 25);
        inputButton.addActionListener(this);
        frame.add(inputButton);
        labelKeterangan = new JLabel();
        labelKeterangan.setLayout(null);
        labelKeterangan.setBounds(980, 100, 250, 600);
        String text = "";
        labelKeterangan.setText(text);
        frame.add(labelKeterangan);
    }

    public void printPeta() {
        Cell[][] peta = g.getCell();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                if (peta[i][j] instanceof Grassland) {
                    if (peta[i][j].getIsGrassExist()) {
                        map[i][j].setIcon(imageBackground.get(5));
                    } else {
                        map[i][j].setIcon(imageBackground.get(4));
                    }
                } else if (peta[i][j] instanceof Barn) {
                    if (peta[i][j].getIsGrassExist()) {
                        map[i][j].setIcon(imageBackground.get(3));
                    } else {
                        map[i][j].setIcon(imageBackground.get(2));
                    }
                } else if (peta[i][j] instanceof Coop) {
                    if (peta[i][j].getIsGrassExist()) {
                        map[i][j].setIcon(imageBackground.get(1));
                    } else {
                        map[i][j].setIcon(imageBackground.get(0));
                    }
                } else if (peta[i][j] instanceof Truck) {
                    map[i][j].setIcon(imageBackground.get(6));
                } else if (peta[i][j] instanceof Mixer) {
                    map[i][j].setIcon(imageBackground.get(8));
                } else if (peta[i][j] instanceof Well) {
                    map[i][j].setIcon(imageBackground.get(7));
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("kontol");
    }

    public static void main(String[] args) throws Exception {
        GameMain view = new GameMain();
        view.frame.setLayout(null);
        view.frame.setBounds(10, 10, 1280, 800);
        view.frame.setTitle("Engi's Farm by: SenjaGurau");
        view.title.setBounds(0, 0, 1280, 100);
        view.frame.add(view.title);
        view.frame.setResizable(false);
        view.frame.setVisible(true);

        view.frame.setLocationRelativeTo(null);
        view.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        view.title.setBounds(0, 0, 1280, 100);
        view.frame.add(view.title);
    }

    

    
}