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
    private boolean first;
    Vector<ImageIcon> imageBackground;
    Vector<JLabel> dummyFarmAnimal;
    JLabel title;
    JFrame frame;

    public GameMainDummy() throws Exception{
        g = new Game();
        frame = new JFrame();
        imageBackground = new Vector<ImageIcon>();
        dummyFarmAnimal = new Vector<JLabel>();
        first = true;
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

        title = new JLabel(new ImageIcon("resource/truck.png"));
        map = new JLabel[10][11];
        printPeta();
        frame.revalidate();
        frame.repaint();
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
        // frame.pack();
        view.frame.setLocationRelativeTo(null);
        view.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        view.title.setBounds(0, 0, 1280, 100);
        view.frame.add(view.title);
        // nanti object nya game, di add ke frame
        // frame.add(gim);
        



    }
    public void printPeta(){
        Cell[][] peta = g.getCell();

        FarmAnimal AnimalTemp;
        int xtemp,ytemp;
        ArrayList<FarmAnimal> ListFarmAnimal = g.getListFarmAnimal();
        // for (int i=0;i<dummyFarmAnimal.size();i++){
        //     frame.remove(dummyFarmAnimal.get(i));
        // }
        Player p = g.getPlayer();
        for(int i=0;i<dummyFarmAnimal.size();i++){
            dummyFarmAnimal.remove(dummyFarmAnimal.get(i));
        }
        dummyFarmAnimal = new Vector<JLabel>();

        for(int i=0;i<ListFarmAnimal.size()+1;i++){
            dummyFarmAnimal.add(new JLabel(new ImageIcon("resource/rsz_coop.jpg")));
            dummyFarmAnimal.get(i).setBounds(50,100,60,60);
            frame.add(dummyFarmAnimal.get(i));
        }
        // cout<<"i = "<<ListFarmAnimal.size<<endl;
        for(int i=0;i<ListFarmAnimal.size();i++){
            AnimalTemp = (ListFarmAnimal.get(i));
            xtemp = AnimalTemp.getX();
            ytemp = AnimalTemp.getY();
            if(AnimalTemp instanceof Chicken){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(12));
                } else{
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(11));
                }
            } else if (AnimalTemp instanceof Duck){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(16));
                } else{
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(15));
                }
            } else if(AnimalTemp instanceof Buffalo){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(10));
                } else{
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(9));
                }
            } else if(AnimalTemp instanceof Sheep){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(20));
                } else{
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(19));
                }
            } else if(AnimalTemp instanceof Cow){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(14));
                } else{
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(13));
                }
            } else if(AnimalTemp instanceof Goat){
                if(AnimalTemp.isLapar()){
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(18));
                } else{
                    dummyFarmAnimal.get(i).setIcon(imageBackground.get(17));
                }

            }
            dummyFarmAnimal.get(i).setLayout(null);
            dummyFarmAnimal.get(i).setBounds(50+(ytemp*60),100+(xtemp*60), 60, 60);
            dummyFarmAnimal.get(i).setVisible(true);
            // cout<<"Samp "<<i<<endl;
        }
        dummyFarmAnimal.get(dummyFarmAnimal.size()-1).setIcon(imageBackground.get(21));
        dummyFarmAnimal.get(dummyFarmAnimal.size()-1).setLayout(null);
        dummyFarmAnimal.get(dummyFarmAnimal.size()-1).setBounds(50+(p.getPosisiY()*60),100+(p.getPosisiX()*60), 60, 60);
        dummyFarmAnimal.get(dummyFarmAnimal.size()-1).setVisible(true);
        if(!first){
            for(int i=0;i<10;i++){
                for(int j=0;j<11;j++){
                    frame.remove(map[i][j]);
                }
            }
        }
        for (int i = 0;i<10;i++){
            for (int j = 0;j<11;j++){
                map[i][j] = new JLabel(new ImageIcon("resource/rsz_coop.jpg"));
                map[i][j].setBounds(50+(j*60),100+(i*60),60,60);
                frame.add(map[i][j]);
            }
        }
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
        first = false;
    }



}