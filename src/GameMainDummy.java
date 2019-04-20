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

public class GameMainDummy extends JFrame {
    /**
     * main program, untuk tampilkan GUI
     */
    private Game g;
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        JLabel title = new JLabel(new ImageIcon("resource/truck.png"));
        JLabel[][] map = new JLabel[10][11];
        g = new Game();
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
    public void printPeta(){
        peta = g.getCell();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // cout<<"Tipe pointer "<<i<<" "<<j<<" : "<<typeid(*peta[i][j]).name()<<endl;
                if(peta[i][j] instanceof Grassland){
                    if(peta[i][j].getIsGrassExist()){
                        petaTemp[i][j] = '#';
                    } else{
                        petaTemp[i][j] = '-';
                    }
                } else if(peta[i][j] instanceof Barn){
                    if(peta[i][j].getIsGrassExist()){
                        petaTemp[i][j] = '@';
                    } else{
                        petaTemp[i][j] = 'x';
                    }
                } else if(peta[i][j] instanceof Coop){
                    if(peta[i][j].getIsGrassExist()){
                        petaTemp[i][j] = '*';
                    } else{
                        petaTemp[i][j] = 'o';
                    }
                } else if(peta[i][j] instanceof Truck){
                    petaTemp[i][j] = 'T';
                } else if(peta[i][j] instanceof Mixer){
                    petaTemp[i][j] = 'M';
                } else if(peta[i][j] instanceof Well){
                    petaTemp[i][j] = 'W';
                }
            }
        }
        FarmAnimal AnimalTemp;
        int xtemp,ytemp;
        // cout<<"i = "<<ListFarmAnimal.size<<endl;
        for(int i=0;i<ListFarmAnimal.size();i++){
            
            AnimalTemp = (ListFarmAnimal.get(i));
            xtemp = AnimalTemp.getX();
            ytemp = AnimalTemp.getY();

            // cout<<"i = "<<i<<" "<<typeid(AnimalTemp).name()<<"x = "<<xtemp<<" y = "<<ytemp<<endl;
            // cout<<"i = "<<i<<" "<<typeid(&AnimalTemp).name()<<"x = "<<xtemp<<" y = "<<ytemp<<endl;
            // cout<<"i = "<<i<<" "<<typeid(*AnimalTemp).name()<<"x = "<<xtemp<<" y = "<<ytemp<<endl;
            // cout<<"i = "<<typeid(Chicken).name()<<endl;
            
            if(AnimalTemp instanceof Chicken){
                petaTemp[xtemp][ytemp] = 'A';
            } else if (AnimalTemp instanceof Duck){
                petaTemp[xtemp][ytemp] = 'D';
            } else if(AnimalTemp instanceof Buffalo){
                petaTemp[xtemp][ytemp] = 'B';
            } else if(AnimalTemp instanceof Sheep){
                petaTemp[xtemp][ytemp] = 'S';
            } else if(AnimalTemp instanceof Cow){
                petaTemp[xtemp][ytemp] = 'C';
            } else if(AnimalTemp instanceof Goat){
                petaTemp[xtemp][ytemp] = 'G';
            }
            // cout<<"Samp "<<i<<endl;
        }
        // cout<<"Sampe 2"<<endl;
        petaTemp[pemain.getPosisiX()][pemain.getPosisiY()] = 'P';
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println((petaTemp[i][j])+" ");
            }
            System.out.println();
        }
    }
}