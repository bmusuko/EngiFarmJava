import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.util.*;
import java.io.*;
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
@SuppressWarnings("serial")

public class GameMainDummy extends JFrame {
    /**
     * main program, untuk tampilkan GUI
     */
    private Game g;
    private JLabel[][] map;
    Vector<ImageIcon> imageBackground;
    Vector<JLabel> dummyFarmAnimal;
    JLabel title;
    JFrame frame;

    public GameMainDummy() throws Exception{
        g = new Game();
        frame = new JFrame();
        frame.setLayout(null);
        imageBackground = new Vector<ImageIcon>();
        dummyFarmAnimal = new Vector<JLabel>();
        
        imageBackground.add(new ImageIcon("resource/rsz_coop.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_coopgrass.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_barn.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_barngrass.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_grassland.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_grasslandgrass.jpg"));
        imageBackground.add(new ImageIcon("resource/rsz_truck.png"));
        imageBackground.add(new ImageIcon("resource/rsz_well.png"));
        imageBackground.add(new ImageIcon("resource/rsz_mixer.png"));

        imageBackground.add(new ImageIcon("resource/rsz_buffalo.png"));
        imageBackground.add(new ImageIcon("resource/rsz_buffalohungry.png"));
        imageBackground.add(new ImageIcon("resource/rsz_chicken.png"));
        imageBackground.add(new ImageIcon("resource/rsz_chickenhungry.png"));
        imageBackground.add(new ImageIcon("resource/rsz_cow.png"));
        imageBackground.add(new ImageIcon("resource/rsz_cowhungry.png"));
        imageBackground.add(new ImageIcon("resource/rsz_duck.png"));
        imageBackground.add(new ImageIcon("resource/rsz_duckhungry.png"));
        imageBackground.add(new ImageIcon("resource/rsz_goat.png"));
        imageBackground.add(new ImageIcon("resource/rsz_goathungry.png"));
        imageBackground.add(new ImageIcon("resource/rsz_sheep.png"));
        imageBackground.add(new ImageIcon("resource/rsz_sheephungry.png"));
        imageBackground.add(new ImageIcon("resource/rsz_player.png"));
        JLabel x = new JLabel();
        Player p = g.getPlayer();
        x.setIcon(imageBackground.get(imageBackground.size()-1));
        x.setLayout(null);
        x.setBounds(50+(p.getPosisiY()*60),100+(p.getPosisiX()*60), 60, 60);
        this.frame.add(x);
        //imageBackground.add(new ImageIcon("resource/rsz_grasslandgrass.jpg"))
        // imageBackground.add(new ImageIcon("resource/Grassland(grass).jpg"))
        title = new JLabel(new ImageIcon("resource/truck.png"));
        map = new JLabel[10][11];
        for (int i = 0;i<10;i++){
            for (int j = 0;j<11;j++){
                map[i][j] = new JLabel(new ImageIcon("resource/rsz_coop.jpg"));
                map[i][j].setBounds(50+(j*60),100+(i*60),60,60);
                frame.add(map[i][j]);
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        GameMainDummy view = new GameMainDummy();
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
        view.printPeta();

    }
    public void printPeta(){
        Cell[][] peta = g.getCell();
        for(int i=0;i<10;i++){
            for(int j=0;j<11;j++){
                // cout<<"Tipe pointer "<<i<<" "<<j<<" : "<<typeid(*peta[i][j]).name()<<endl;
                if(peta[i][j] instanceof Grassland){
                    if(peta[i][j].getIsGrassExist()){
                        map[i][j].setIcon(imageBackground.get(5));
                    } else{
                        map[i][j].setIcon(imageBackground.get(4));
                    }
                } else if(peta[i][j] instanceof Barn){
                    if(peta[i][j].getIsGrassExist()){
                        map[i][j].setIcon(imageBackground.get(3));
                    } else{
                        map[i][j].setIcon(imageBackground.get(2));
                    }
                } else if(peta[i][j] instanceof Coop){
                    if(peta[i][j].getIsGrassExist()){
                        map[i][j].setIcon(imageBackground.get(1));
                    } else{
                        map[i][j].setIcon(imageBackground.get(0));
                    }
                } else if(peta[i][j] instanceof Truck){
                    map[i][j].setIcon(imageBackground.get(6));
                } else if(peta[i][j] instanceof Mixer){
                    map[i][j].setIcon(imageBackground.get(8));
                } else if(peta[i][j] instanceof Well){
                    map[i][j].setIcon(imageBackground.get(7));
                }
            }
        }
        FarmAnimal AnimalTemp;
        int xtemp,ytemp;
        ArrayList<FarmAnimal> ListFarmAnimal = g.getListFarmAnimal();
        // for (int i=0;i<dummyFarmAnimal.size();i++){
        //     frame.remove(dummyFarmAnimal.get(i));
        // }
        Player p = g.getPlayer();
        // frame.revalidate();
        // frame.repaint();
        dummyFarmAnimal = new Vector<JLabel>();
        // cout<<"i = "<<ListFarmAnimal.size<<endl;
        for(int i=0;i<ListFarmAnimal.size();i++){
            AnimalTemp = (ListFarmAnimal.get(i));
            xtemp = AnimalTemp.getX();
            ytemp = AnimalTemp.getY();
            if(AnimalTemp instanceof Chicken){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(12)));
                } else{
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(11)));
                }
            } else if (AnimalTemp instanceof Duck){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(16)));
                } else{
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(15)));
                }
            } else if(AnimalTemp instanceof Buffalo){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(10)));
                } else{
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(9)));
                }
            } else if(AnimalTemp instanceof Sheep){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(20)));
                } else{
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(19)));
                }
            } else if(AnimalTemp instanceof Cow){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(14)));
                } else{
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(13)));
                }
            } else if(AnimalTemp instanceof Goat){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(18)));
                } else{
                    dummyFarmAnimal.add(new JLabel(imageBackground.get(17)));
                }
            }
            JLabel peler = dummyFarmAnimal.get(i);
            peler.setLayout(null);
            peler.setBounds(50+(ytemp*60),100+(xtemp*60), 60, 60);
            frame.add(peler);
            // cout<<"Samp "<<i<<endl;
        }
        // cout<<"Sampe 2"<<endl;
        dummyFarmAnimal.add((new JLabel(imageBackground.get(20))));
        
        dummyFarmAnimal.get(ListFarmAnimal.size()-1).setLayout(null);
        dummyFarmAnimal.get(ListFarmAnimal.size()-1).setBounds(50+(p.getPosisiY()*60),100+(p.getPosisiX()*60), 60, 60);
        dummyFarmAnimal.get(ListFarmAnimal.size()-1).setVisible(true);
        frame.add(dummyFarmAnimal.get(ListFarmAnimal.size()-1));
    }
}