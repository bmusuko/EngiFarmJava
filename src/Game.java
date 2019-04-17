import java.util.*;
class Game{
	private Cell[][] peta;
	private int tick;
	private LinkedList<FarmAnimal> ListFarmAnimal;
	private int n;
	private int m;
	private Player pemain;

	public Game(){
		Scanner reader = new Scanner(new File("input.txt"));  
		n = reader.nextInt();
		m = reader.nextInt();
		peta = new Cell[n][m];
		String temp;
		for(int i=0;i<n;i++){
			temp = reader.readline();
			for(int j=0;j<m;j++){
				if(temp[j] == 'o'){
					// Coop C(i,j,false,false);
					peta[i][j] = new Coop(i,j,false,false);
				} else if(temp[j] == '*'){
					// Coop C(i,j,true,false);
					peta[i][j] = new Coop(i,j,true,false);
				} else if(temp[j] == '-'){
					// Grassland G(i,j,false,false);
					peta[i][j] = new Grassland(i,j,false,false);
				} else if (temp[j] == '#'){
					// Grassland G(i,j,true,false);
					peta[i][j] = new Grassland(i,j,true,false);
				} else if (temp[j] == 'x'){
					// Barn B(i,j,false,false);
					peta[i][j] = new Barn(i,j,false,false);
				} else if (temp[j] == '@'){
					// Barn B(i,j,true,false);
					peta[i][j] = new Barn(i,j,true,false);
				} else if (temp[j] == 'T'){
					// Truck T(i,j);
					peta[i][j] = new Truck(i,j);
				} else if (temp[j] == 'M'){
					// Mixer M(i,j);
					peta[i][j] = new Mixer(i,j);
				} else if (temp[j] == 'W'){
					// Well W(i,j);
					peta[i][j] = new Well(i,j);
				}
			}
		}
		Scanner read = new Scanner(new File("dll.txt"));
		char c;
		int x,y;
		while(read.hasNextLine()){
			c = (char)(read.nextByte());
			x = read.nextInt();
			y = read.nextInt();
			if(c == 'A'){
				// Chicken C(x,y);
				ListFarmAnimal.add(new Chicken(x,y));
				peta[x][y]->setIsObjectExist(true);
			} else if (c == 'D'){
				// Duck D(x,y);
				ListFarmAnimal.add(new Duck(x,y));
				peta[x][y]->setIsObjectExist(true);
			} else if (c == 'B'){
				// Buffalo B(x,y);
				ListFarmAnimal.add(new Buffalo(x,y));
				peta[x][y]->setIsObjectExist(true);
			} else if (c == 'S'){
				// Sheep S(x,y);
				ListFarmAnimal.add(new Sheep(x,y));
				peta[x][y]->setIsObjectExist(true);
			} else if (c == 'C'){
				ListFarmAnimal.add(new Cow(x,y));
				peta[x][y]->setIsObjectExist(true);
			} else if (c == 'G'){
				// Goat G(x,y);
				ListFarmAnimal.add(new Goat(x,y));
				peta[x][y]->setIsObjectExist(true);
			} else if (c == 'P'){
				peta[x][y]->setIsObjectExist(false);
				pemain.setX(x);
				pemain.setY(y);
			}
		}
	}	

	
	public void listCommand(){
		System.out.println("!--- LIST COMMAND ---!");
		System.out.println("talk up");
		System.out.println("talk left");
		System.out.println("talk right");
		System.out.println("talk down");
		System.out.println("interact up");
		System.out.println("interact left");
		System.out.println("interact right");
		System.out.println("interact down");
		System.out.println("kill up");
		System.out.println("kill left");
		System.out.println("kill right");
		System.out.println("kill down");
		System.out.println("grow");
		System.out.println("status");
		System.out.println("tutorial");
		System.out.println("keterangan");
		System.out.println("listCommand");
		System.out.println("exit");
	}

	public void tutorial(){
		cout<<"!--- TUTORIAL ---!"<<endl<<endl;
		keterangan();
		listCommand();
	}

	public void keterangan(){
		cout<<"--- KETERANGAN ---"<<endl;
		cout<<"A : Ayam"<<endl;
		cout<<"D : Bebek"<<endl;
		cout<<"B : Kerbau"<<endl;
		cout<<"S : Domba"<<endl;
		cout<<"C : Sapi"<<endl;
		cout<<"G : Kambing"<<endl;
		cout<<"P : Player"<<endl;
		cout<<"- : Grassland"<<endl;
		cout<<"x : Barn"<<endl;
		cout<<"o : Coop"<<endl;
		cout<<"*,@,# : Land dengan rumput"<<endl<<endl;
	}

	public int isInRange(int x,int y){
		return ( (x>=0) && (x<n) &&  (y>=0) && (y<m) );
	}

	public int isLand(int x,int y){
		return (typeid(Grassland)==typeid(*peta[x][y]) || typeid(Barn)==typeid(*peta[x][y]) || typeid(Coop)==typeid(*peta[x][y]) );
	}

}