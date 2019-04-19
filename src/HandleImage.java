import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class HandleImage {

    public static BufferedImage engifarm;
    
    public static BufferedImage coop;
    public static BufferedImage grassland;
    public static BufferedImage barn;

    public static BufferedImage truck;
    public static BufferedImage well;
    public static BufferedImage mixer;

    public static BufferedImage chicken;
    public static BufferedImage cow;
    public static BufferedImage duck;
    public static BufferedImage sheep;
    public static BufferedImage buffalo;
    public static BufferedImage goat;

    public static BufferedImage chicken_egg;
    public static BufferedImage chicken_meat;
    public static BufferedImage cow_meat;
    public static BufferedImage cow_milk;
    public static BufferedImage duck_egg;
    public static BufferedImage duck_meat;
    public static BufferedImage sheep_meat;
    public static BufferedImage buffalo_meat;
    public static BufferedImage goat_meat;
    public static BufferedImage goat_milk;

    public static BufferedImage mainMenu;
    public static BufferedImage win;
    public static BufferedImage lose;
    public static BufferedImage credit;

    // ====================== path dari gambar ======================
    private static final String pathEngiFarm = "resource/";

    private static final String pathCoop = "resource/";
    private static final String pathGrassLand = "resource/";
    private static final String pathBarn = "resource/";

    private static final String pathTruck = "resource/truck.png";
    private static final String pathWell = "resource/well.png";
    private static final String pathMixer = "resource/mixer.jpg";

    private static final String pathChicken = "resource/chicken.jpg";
    private static final String pathCow = "resource/cow.jpg";
    private static final String pathDuck = "resource/duck.jpg";
    private static final String pathSheep = "resource/sheep.jpg";
    private static final String pathBuffalo = "resource/buffalo.jpg";
    private static final String pathGoat = "resource/goat.jpg";

    private static final String pathChicken_egg = "resource/chicken_egg.jpg";
    private static final String pathChicken_meat = "resource/chicken_meat.jpg";
    private static final String pathCow_meat = "resource/";
    private static final String pathCow_milk = "resource/";
    private static final String pathDuck_egg = "resource/";
    private static final String pathDuck_meat = "resource/";
    private static final String pathhSheep_meat = "resource/";
    private static final String pathBuffalo_meat = "resource/";
    private static final String pathGoat_meat = "resource/";
    private static final String pathGoat_milk = "resource/";

    private static final String pathMainMenu = "resource/";
    private static final String pathWin = "resource/";
    private static final String pathLose = "resource/";
    private static final String pathCredit = "resource/";

    // ===================== operasi file gambar ===================== 
    private static final File fileEngiFarm = new File(HandleImage.pathEngiFarm);
    private static final File fileCoop = new File(HandleImage.pathCoop);
    private static final File fileGrassLand = new File(HandleImage.pathGrassLand);
    private static final File fileBarn = new File(HandleImage.pathBarn);

    private static final File fileTruck = new File(HandleImage.pathTruck);
    private static final File fileWell = new File(HandleImage.pathWell);
    private static final File fileMixer = new File(HandleImage.pathMixer);

    private static final File fileChicken = new File(HandleImage.pathChicken);
    private static final File fileCow = new File(HandleImage.pathCow);
    private static final File fileDuck = new File(HandleImage.pathDuck);
    private static final File fileSheep = new File(HandleImage.pathSheep);
    private static final File fileBuffalo = new File(HandleImage.pathBuffalo);
    private static final File fileGoat = new File(HandleImage.pathGoat);

    private static final File fileChicken_egg = new File(HandleImage.pathChicken_egg);
    private static final File fileChicken_meat = new File(HandleImage.pathChicken_meat);
    private static final File fileCow_meat = new File(HandleImage.pathCow_meat);
    private static final File fileCow_milk = new File(HandleImage.pathCow_milk);
    private static final File fileDuck_egg = new File(HandleImage.pathDuck_egg);
    private static final File fileDuck_meat = new File(HandleImage.pathDuck_meat);
    private static final File filehSheep_meat = new File(HandleImage.pathhSheep_meat);
    private static final File fileBuffalo_meat = new File(HandleImage.pathBuffalo_meat);
    private static final File fileGoat_meat = new File(HandleImage.pathGoat_meat);
    private static final File fileGoat_milk = new File(HandleImage.pathGoat_milk);

    private static final File fileMainMenu = new File(HandleImage.pathMainMenu);
    private static final File fileWin = new File(HandleImage.pathWin);
    private static final File fileLose = new File(HandleImage.pathLose);
    private static final File fileCredit = new File(HandleImage.pathCredit);

    private HandleImage() {
        //
    }

    /**
     * Inisiasi file gambar
     */

    public static void initImage() {
        try {
            HandleImage.engifarm = ImageIO.read(HandleImage.fileEngiFarm);
            
            HandleImage.coop = ImageIO.read(HandleImage.fileCoop);
            HandleImage.grassland = ImageIO.read(HandleImage.fileGrassLand);
            HandleImage.barn = ImageIO.read(HandleImage.fileBarn);

            HandleImage.truck = ImageIO.read(HandleImage.fileTruck);
            HandleImage.well = ImageIO.read(HandleImage.fileWell);
            HandleImage.mixer = ImageIO.read(HandleImage.fileMixer);

            HandleImage.chicken = ImageIO.read(HandleImage.fileChicken);
            HandleImage.cow = ImageIO.read(HandleImage.fileCow);
            HandleImage.duck = ImageIO.read(HandleImage.fileDuck);
            HandleImage.sheep = ImageIO.read(HandleImage.fileSheep);
            HandleImage.buffalo = ImageIO.read(HandleImage.fileBuffalo);
            HandleImage.goat = ImageIO.read(HandleImage.fileGoat);

            HandleImage.chicken_egg = ImageIO.read(HandleImage.fileChicken_egg);
            HandleImage.chicken_meat = ImageIO.read(HandleImage.fileChicken_meat);
            HandleImage.cow_meat = ImageIO.read(HandleImage.fileCow_meat);
            HandleImage.cow_milk = ImageIO.read(HandleImage.fileCow_milk);
            HandleImage.duck_egg = ImageIO.read(HandleImage.fileDuck_egg);
            HandleImage.duck_meat = ImageIO.read(HandleImage.fileDuck_meat);
            HandleImage.sheep_meat = ImageIO.read(HandleImage.filehSheep_meat);
            HandleImage.buffalo_meat = ImageIO.read(HandleImage.fileBuffalo_meat);
            HandleImage.goat_milk = ImageIO.read(HandleImage.fileGoat_milk);
            HandleImage.goat_meat = ImageIO.read(HandleImage.fileGoat_meat);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    




}
