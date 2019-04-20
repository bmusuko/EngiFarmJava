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
    JLabel title;
    JFrame frame;

    public GameMainDummy() throws Exception{
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
        printPeta();
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
    }
    //     FarmAnimal AnimalTemp;
    //     int xtemp,ytemp;
    //     // cout<<"i = "<<ListFarmAnimal.size<<endl;
    //     for(int i=0;i<ListFarmAnimal.size();i++){
            
    //         AnimalTemp = (ListFarmAnimal.get(i));
    //         xtemp = AnimalTemp.getX();
    //         ytemp = AnimalTemp.getY();

    //         // cout<<"i = "<<i<<" "<<typeid(AnimalTemp).name()<<"x = "<<xtemp<<" y = "<<ytemp<<endl;
    //         // cout<<"i = "<<i<<" "<<typeid(&AnimalTemp).name()<<"x = "<<xtemp<<" y = "<<ytemp<<endl;
    //         // cout<<"i = "<<i<<" "<<typeid(*AnimalTemp).name()<<"x = "<<xtemp<<" y = "<<ytemp<<endl;
    //         // cout<<"i = "<<typeid(Chicken).name()<<endl;
            
    //         if(AnimalTemp instanceof Chicken){
    //             petaTemp[xtemp][ytemp] = 'A';
    //         } else if (AnimalTemp instanceof Duck){
    //             petaTemp[xtemp][ytemp] = 'D';
    //         } else if(AnimalTemp instanceof Buffalo){
    //             petaTemp[xtemp][ytemp] = 'B';
    //         } else if(AnimalTemp instanceof Sheep){
    //             petaTemp[xtemp][ytemp] = 'S';
    //         } else if(AnimalTemp instanceof Cow){
    //             petaTemp[xtemp][ytemp] = 'C';
    //         } else if(AnimalTemp instanceof Goat){
    //             petaTemp[xtemp][ytemp] = 'G';
    //         }
    //         // cout<<"Samp "<<i<<endl;
    //     }
    //     // cout<<"Sampe 2"<<endl;
    //     petaTemp[pemain.getPosisiX()][pemain.getPosisiY()] = 'P';
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             System.out.println((petaTemp[i][j])+" ");
    //         }
    //         System.out.println();
    //     }
    // }
}