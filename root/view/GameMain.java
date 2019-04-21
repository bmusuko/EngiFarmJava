package view;
import view.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import control.Game;
import model.cell.Cell;
import model.cell.land.Land;
import model.cell.land.barn.Barn;
import model.cell.land.coop.Coop;
import model.cell.land.grassLand.Grassland;
import model.facility.Facility;
import model.facility.mixer.*;
import model.facility.truck.*;
import model.facility.well.*;
import model.farmAnimal.*;
import model.farmAnimal.eggProducingAnimal.*;
import model.farmAnimal.meatProducingAnimal.*;
import model.farmAnimal.milkProducingAnimal.*;
import model.farmAnimal.animal.buffalo.*;
import model.farmAnimal.animal.chicken.*;
import model.farmAnimal.animal.cow.*;
import model.farmAnimal.animal.duck.*;
import model.farmAnimal.animal.goat.*;
import model.farmAnimal.animal.sheep.*;
import model.farmProduct.*;
import model.farmProduct.meat.chickenMeat.*;
import model.farmProduct.meat.cowMeat.*;
import model.farmProduct.meat.buffaloMeat.*;
import model.farmProduct.meat.sheepMeat.*;
import model.farmProduct.meat.duckMeat.*;
import model.farmProduct.meat.goatMeat.*;
import model.farmProduct.milk.cowMilk.*;
import model.farmProduct.milk.goatMilk.*;
import model.farmProduct.egg.chickenEgg.*;
import model.farmProduct.egg.duckEgg.*;
import model.farmProduct.beefRolade.*;
import model.farmProduct.cheese.*;
import model.farmProduct.martabak.*;
import model.player.*;


 /* Main class
 * 
 * @author Putu Gde
 * @author Hilmi Naufal
 * @author Bram Musuko
 * @author Y. Valentino
 */
@SuppressWarnings("serial")

public class GameMain extends JFrame implements KeyListener {
    /**
     * main program, untuk tampilkan GUI
     */
    private Game g;
    private JLabel[][] map;
    private boolean first;
    Vector<ImageIcon> imageBackground;
    Vector<JLabel> dummyFarmAnimal;
    JLabel title, ketJLabel, ketMoney, ketWadahAir, invLabel, dialogbox, ipt;
    JFrame frame;
    JTextArea input;
    Border defaultBorder;
    JWindow w;

    public GameMain() throws Exception {
        g = new Game();
        frame = new JFrame();
        imageBackground = new Vector<ImageIcon>();
        dummyFarmAnimal = new Vector<JLabel>();
        first = true;

        defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        input = new JTextArea();
        input.setLayout(null);
        input.setBounds(210, 725, 500, 25);
        input.addKeyListener(this);
        input.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        frame.add(input);

        ketJLabel = new JLabel(new ImageIcon("view/resource/ket.png"));
        ketJLabel.setLayout(null);
        ketJLabel.setBounds(980, 100, 250, 600);
        frame.add(ketJLabel);

        ketMoney = new JLabel();
        Border borderBLCK = BorderFactory.createLineBorder(Color.BLACK, 3);
        ketMoney.setLayout(null);
        ketMoney.setBorder(borderBLCK);
        ketMoney.setBounds(730, 100, 230, 100);
        ketMoney.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        frame.add(ketMoney);

        ketWadahAir = new JLabel();
        ketWadahAir.setLayout(null);
        ketWadahAir.setBorder(borderBLCK);
        ketWadahAir.setBounds(730, 220, 230, 100);
        ketWadahAir.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        frame.add(ketWadahAir);

        invLabel = new JLabel();
        invLabel.setLayout(null);
        invLabel.setBorder(borderBLCK);
        invLabel.setBounds(730, 340, 230, 360);
        invLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        frame.add(invLabel);

        ipt = new JLabel("Input : ");
        ipt.setLayout(null);
        ipt.setBounds(50, 715, 150, 35);
        ipt.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        frame.add(ipt);

        imageBackground.add(new ImageIcon("view/resource/rsz_coop.jpg"));
        imageBackground.add(new ImageIcon("view/resource/rsz_coopgrass.jpg"));
        imageBackground.add(new ImageIcon("view/resource/rsz_barn.jpg"));
        imageBackground.add(new ImageIcon("view/resource/rsz_barngrass.jpg"));
        imageBackground.add(new ImageIcon("view/resource/rsz_grassland.jpg"));
        imageBackground.add(new ImageIcon("view/resource/rsz_grasslandgrass.jpg"));
        imageBackground.add(new ImageIcon("view/resource/rsz_truck.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_well.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_mixer.png"));

        imageBackground.add(new ImageIcon("view/resource/rsz_buffalo.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_buffalohungry.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_chicken.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_chickenhungry.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_cow.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_cowhungry.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_duck.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_duckhungry.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_goat.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_goathungry.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_sheep.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_sheephungry.png"));
        imageBackground.add(new ImageIcon("view/resource/rsz_player.png"));
        title = new JLabel(new ImageIcon("view/resource/judul.png"));
        map = new JLabel[10][11];
        printPeta();
        frame.revalidate();
        frame.repaint();

    }

    public static void main(String[] args) throws Exception {
        GameMain view = new GameMain();
        view.frame.setLayout(null);
        view.frame.setBounds(10, 10, 1280, 800);
        view.frame.setTitle("Engi's Farm by: SenjaGurau");
        view.title.setBounds(0, 0, 1280, 100);
        view.frame.add(view.title);
        view.frame.setResizable(false);

        view.frame.setLocationRelativeTo(null);
        view.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        view.frame.setVisible(true);
    }

    public void printPeta() {
        Cell[][] peta = g.getCell();

        FarmAnimal AnimalTemp;
        int xtemp, ytemp;
        ArrayList<FarmAnimal> ListFarmAnimal = g.getListFarmAnimal();
        Player p = g.getPlayer();
        int s = dummyFarmAnimal.size();
        for (int i = 0; i < s; i++) {
            frame.remove(dummyFarmAnimal.get(0));
            dummyFarmAnimal.remove(dummyFarmAnimal.get(0));
        }
        dummyFarmAnimal = new Vector<JLabel>();

        for (int i = 0; i < ListFarmAnimal.size() + 1; i++) {
            dummyFarmAnimal.add(new JLabel(new ImageIcon("view/resource/rsz_coop.jpg")));
            dummyFarmAnimal.get(i).setBounds(50, 100, 60, 60);
            frame.add(dummyFarmAnimal.get(i));
        }

        for (int i = 0; i < ListFarmAnimal.size(); i++) {
            AnimalTemp = (ListFarmAnimal.get(i));
            xtemp = AnimalTemp.getX();
            ytemp = AnimalTemp.getY();
            if (AnimalTemp instanceof Chicken) {
                if (AnimalTemp.isLapar()) {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(12));
                } else {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(11));
                }
            } else if (AnimalTemp instanceof Duck) {
                if (AnimalTemp.isLapar()) {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(16));
                } else {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(15));
                }
            } else if (AnimalTemp instanceof Buffalo) {
                if (AnimalTemp.isLapar()) {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(10));
                } else {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(9));
                }
            } else if (AnimalTemp instanceof Sheep) {
                if (AnimalTemp.isLapar()) {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(20));
                } else {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(19));
                }
            } else if (AnimalTemp instanceof Cow) {
                if (AnimalTemp.isLapar()) {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(14));
                } else {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(13));
                }
            } else if (AnimalTemp instanceof Goat) {
                if (AnimalTemp.isLapar()) {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(18));
                } else {
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(17));
                }

            }
            dummyFarmAnimal.get(i).setLayout(null);
            dummyFarmAnimal.get(i).setBounds(50 + (ytemp * 60), 100 + (xtemp * 60), 60, 60);
            dummyFarmAnimal.get(i).setVisible(true);

        }
        dummyFarmAnimal.get(dummyFarmAnimal.size() - 1).setIcon(imageBackground.get(21));
        dummyFarmAnimal.get(dummyFarmAnimal.size() - 1).setLayout(null);
        dummyFarmAnimal.get(dummyFarmAnimal.size() - 1).setBounds(50 + (p.getPosisiY() * 60),
                100 + (p.getPosisiX() * 60), 60, 60);
        dummyFarmAnimal.get(dummyFarmAnimal.size() - 1).setVisible(true);
        if (!first) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 11; j++) {
                    frame.remove(map[i][j]);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                map[i][j] = new JLabel(new ImageIcon("view/resource/rsz_coop.jpg"));
                map[i][j].setBounds(50 + (j * 60), 100 + (i * 60), 60, 60);
                map[i][j].setBorder(defaultBorder);
                frame.add(map[i][j]);
            }
        }
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
        ketMoney.setText("  Money : " + Integer.toString(p.getMoney()));
        ketWadahAir.setText("  Wadah Air : " + Integer.toString(p.getWadahAir()));
        if (p.getTas().isEmpty()) {
            invLabel.setText("Inventory Kosong !");
        } else {
            StringBuilder isi = new StringBuilder();
            for (int i = 0; i < p.getTas().size(); i++) {
                isi.append(p.getTas().get(i).getClass().getSimpleName() + ", ");
            }
            invLabel.setText("<html>Inventory : </br>" + isi.toString() + "</html>");
        }
        first = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            g.play(this.input.getText());
            printPeta();   
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            input.setText(null); 
        }
    }
}