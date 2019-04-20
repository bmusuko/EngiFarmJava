import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

/**
 * Main class
 * 
 * @author Putu Gde
 * @author Hilmi Naufal
 * @author Bram Musuko
 * @author Y. Valentino
 */

public class dummy extends JFrame implements ActionListener{
    /** 
     * main program, untuk tampilkan GUI
     */
    public int nilai = 100;
    public void plusnilai(){
        this.nilai+=60;
    }
    public static void main(String[] args) {
        dummy game = new dummy();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel title = new JLabel(new ImageIcon("resource/truck.png"));
        JTextArea input = new JTextArea();
        JButton inputButton = new JButton("Input!");
        JLabel x  = new JLabel(new ImageIcon("resource/rsz_cow.png"));
        // panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1280, 800);
        title.setLayout(null);
        title.setBounds(0, 0, 1280, 100);
        title.setVisible(true);
        panel.add(title);
        // System.out.println(frame.nilai);
        inputButton.setLayout(null);
        inputButton.setBounds(560, 725, 150,25);
        inputButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String cobaxx = input.getText();
                System.out.println(cobaxx);
                game.plusnilai();
                x.setBounds(50,game.nilai,60,60);
            }
        });
        panel.add(inputButton);
        
        x.setLayout(null);
        x.setBounds(50, 100, 60, 60);
        x.setVisible(true);
        // x.setSize(60, 60);
        panel.add(x);
        input.setLayout(null);
        input.setBounds(50, 725, 500, 25);
        panel.add(input);
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
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        title.setBounds(0, 0, 1280, 100);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

