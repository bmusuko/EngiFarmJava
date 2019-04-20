import java.io.*; 
import java.util.*;

public class Game{
	private Cell[][] peta;
	private char[][] petaTemp;
	private int tick;
	private ArrayList<FarmAnimal> ListFarmAnimal;
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
			temp = reader.next();
			for(int j=0;j<m;j++){
				if(temp.charAt(j) == 'o'){
					// Coop C(i,j,false,false);
					peta[i][j] = new Coop(i,j,false,false);
				} else if(temp.charAt(j) == '*'){
					// Coop C(i,j,true,false);
					peta[i][j] = new Coop(i,j,true,false);
				} else if(temp.charAt(j) == '-'){
					// Grassland G(i,j,false,false);
					peta[i][j] = new Grassland(i,j,false,false);
				} else if (temp.charAt(j) == '#'){
					// Grassland G(i,j,true,false);
					peta[i][j] = new Grassland(i,j,true,false);
				} else if (temp.charAt(j) == 'x'){
					// Barn B(i,j,false,false);
					peta[i][j] = new Barn(i,j,false,false);
				} else if (temp.charAt(j) == '@'){
					// Barn B(i,j,true,false);
					peta[i][j] = new Barn(i,j,true,false);
				} else if (temp.charAt(j) == 'T'){
					// Truck T(i,j);
					peta[i][j] = new Truck(i,j);
				} else if (temp.charAt(j) == 'M'){
					// Mixer M(i,j);
					peta[i][j] = new Mixer(i,j);
				} else if (temp.charAt(j) == 'W'){
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
				peta[x][y].setIsObjectExist(true);
			} else if (c == 'D'){
				// Duck D(x,y);
				ListFarmAnimal.add(new Duck(x,y));
				peta[x][y].setIsObjectExist(true);
			} else if (c == 'B'){
				// Buffalo B(x,y);
				ListFarmAnimal.add(new Buffalo(x,y));
				peta[x][y].setIsObjectExist(true);
			} else if (c == 'S'){
				// Sheep S(x,y);
				ListFarmAnimal.add(new Sheep(x,y));
				peta[x][y].setIsObjectExist(true);
			} else if (c == 'C'){
				ListFarmAnimal.add(new Cow(x,y));
				peta[x][y].setIsObjectExist(true);
			} else if (c == 'G'){
				// Goat G(x,y);
				ListFarmAnimal.add(new Goat(x,y));
				peta[x][y].setIsObjectExist(true);
			} else if (c == 'P'){
				peta[x][y].setIsObjectExist(false);
				pemain = new Player(x,y);
			}
		}
	}	

	public void printPeta(){

		petaTemp = new char[n][m];

		// for(int i=0;i<n;i++){
		// 	for(int j=0;j<m;j++){
		// 		petaTemp[i][j] = '/';
		// 	}
		// }

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
	public void play(){
		System.out.println("Selamat datang di Engi's Farm");
		printPeta();
		String input;
		tutorial();
		System.out.println("Masukkan inputan permainan :");
		Scanner in = new Scanner(System.in);
		input = in.next();
		boolean found;
		int xtemp,ytemp,i;
		while(input != "exit"){
			if (input == "move up"){
				if(isInRange(pemain.getPosisiX()-1,pemain.getPosisiY())){
					if(isLand(pemain.getPosisiX()-1,pemain.getPosisiY())){
						if(!peta[pemain.getPosisiX()-1][pemain.getPosisiY()].getIsObjectExist()){
							peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
							peta[pemain.getPosisiX()-1][pemain.getPosisiY()].setIsObjectExist(true);
							pemain.move(1);	
						}
					}
				}
			}else if(input == "move left"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()-1)){
					if(isLand(pemain.getPosisiX(),pemain.getPosisiY()-1)){
						if(!peta[pemain.getPosisiX()][pemain.getPosisiY()-1].getIsObjectExist()){
							peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
							peta[pemain.getPosisiX()][pemain.getPosisiY()-1].setIsObjectExist(true);
							pemain.move(4);
						}
					}
				}
			}else if(input == "move down"){
				if(isInRange(pemain.getPosisiX()+1,pemain.getPosisiY())){
					if(isLand(pemain.getPosisiX()+1,pemain.getPosisiY())){
						if(!peta[pemain.getPosisiX()+1][pemain.getPosisiY()].getIsObjectExist()){
							peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
							peta[pemain.getPosisiX()+1][pemain.getPosisiY()].setIsObjectExist(true);
							pemain.move(3);
						}				
					}
				}
			}else if(input == "move right"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()+1)){
					if(isLand(pemain.getPosisiX(),pemain.getPosisiY()+1)){
						if(!peta[pemain.getPosisiX()][pemain.getPosisiY()+1].getIsObjectExist()){
							peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
							peta[pemain.getPosisiX()][pemain.getPosisiY()+1].setIsObjectExist(true);
							pemain.move(2);
						}
					}
				}
			}else if(input == "talk up"){
				if(isInRange(pemain.getPosisiX()-1,pemain.getPosisiY())){
					if(isLand(pemain.getPosisiX()-1,pemain.getPosisiY())){
						if(peta[pemain.getPosisiX()-1][pemain.getPosisiY()].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX()-1 && ytemp==pemain.getPosisiY()){
									AnimalTemp.suara();
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "talk left"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()-1)){
					if(isLand(pemain.getPosisiX(),pemain.getPosisiY()-1)){
						if(peta[pemain.getPosisiX()][pemain.getPosisiY()-1].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX() && ytemp==pemain.getPosisiY()-1){
									AnimalTemp.suara();
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "talk down"){
				if(isInRange(pemain.getPosisiX()+1,pemain.getPosisiY())){
					if(isLand(pemain.getPosisiX()+1,pemain.getPosisiY())){
						if(peta[pemain.getPosisiX()+1][pemain.getPosisiY()].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX()+1 && ytemp==pemain.getPosisiY()){
									AnimalTemp.suara();
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "talk right"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()+1)){
					if(isLand(pemain.getPosisiX(),pemain.getPosisiY()+1)){
						if(peta[pemain.getPosisiX()][pemain.getPosisiY()+1].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX() && ytemp==pemain.getPosisiY()+1){
									AnimalTemp.suara();
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "interact up"){
				if(isInRange(pemain.getPosisiX()-1,pemain.getPosisiY())){
	                if(isLand(pemain.getPosisiX()-1,pemain.getPosisiY())){
	                    if(peta[pemain.getPosisiX()-1][pemain.getPosisiY()].getIsObjectExist()){
	                        found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX()-1 && ytemp==pemain.getPosisiY()){
									if(AnimalTemp.getHasilProduct()){
	        							if (AnimalTemp instanceof EggProducingFarmAnimal ){
	                           	        	pemain.addElTas(( ((EggProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		} else if( AnimalTemp instanceof MilkProducingFarmAnimal) {
	                            			pemain.addElTas(( ((MilkProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		}
	                            	    found = true;
									}
								}
								i++;
							}
	                    }
	                }else if (peta[pemain.getPosisiX()-1][pemain.getPosisiY()] instanceof Well){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()-1][pemain.getPosisiY()]);
	                }else if(peta[pemain.getPosisiX()-1][pemain.getPosisiY()] instanceof Truck){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()-1][pemain.getPosisiY()]);
	                }else if (peta[pemain.getPosisiX()-1][pemain.getPosisiY()] instanceof Mixer){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()-1][pemain.getPosisiY()]);
	                }
	            }

			} else if(input == "interact left"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()-1)){
	                if(isLand(pemain.getPosisiX(),pemain.getPosisiY()-1)){
	                    if(peta[pemain.getPosisiX()][pemain.getPosisiY()-1].getIsObjectExist()){
	                        found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX() && ytemp==pemain.getPosisiY()-1){
									if(AnimalTemp.getHasilProduct()){
	        							if (AnimalTemp instanceof EggProducingFarmAnimal ){
	                           	        	pemain.addElTas(( ((EggProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		} else if( AnimalTemp instanceof MilkProducingFarmAnimal) {
	                            			pemain.addElTas(( ((MilkProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		}
	                            	    found = true;
									}
								}
								i++;
							}
	                    }
	                }else if (peta[pemain.getPosisiX()][pemain.getPosisiY()-1] instanceof Well){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()][pemain.getPosisiY()-1]);
	                }else if(peta[pemain.getPosisiX()][pemain.getPosisiY()-1] instanceof Truck){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()][pemain.getPosisiY()-1]);
	                }else if (peta[pemain.getPosisiX()][pemain.getPosisiY()-1] instanceof Mixer){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()][pemain.getPosisiY()-1]);
	                }
	            }

			} else if(input == "interact down"){
				if(isInRange(pemain.getPosisiX()+1,pemain.getPosisiY())){
	                if(isLand(pemain.getPosisiX()+1,pemain.getPosisiY())){
	                    if(peta[pemain.getPosisiX()+1][pemain.getPosisiY()].getIsObjectExist()){
	                        found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX()+1 && ytemp==pemain.getPosisiY()){
									if(AnimalTemp.getHasilProduct()){
	        							if (AnimalTemp instanceof EggProducingFarmAnimal ){
	                           	        	pemain.addElTas(( ((EggProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		} else if( AnimalTemp instanceof MilkProducingFarmAnimal) {
	                            			pemain.addElTas(( ((MilkProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		}
	                            	    found = true;
									}
								}
								i++;
							}
	                    }
	                }else if (peta[pemain.getPosisiX()+1][pemain.getPosisiY()] instanceof Well){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()+1][pemain.getPosisiY()]);
	                }else if(peta[pemain.getPosisiX()+1][pemain.getPosisiY()] instanceof Truck){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()+1][pemain.getPosisiY()]);
	                }else if (peta[pemain.getPosisiX()+1][pemain.getPosisiY()] instanceof Mixer){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()+1][pemain.getPosisiY()]);
	                }
	            }
			} else if(input == "interact right"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()+1)){
	                if(isLand(pemain.getPosisiX(),pemain.getPosisiY()+1)){
	                    if(peta[pemain.getPosisiX()][pemain.getPosisiY()+1].getIsObjectExist()){
	                        found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX() && ytemp==pemain.getPosisiY()+1){
									if(AnimalTemp.getHasilProduct()){
	        							if (AnimalTemp instanceof EggProducingFarmAnimal ){
	                           	        	pemain.addElTas(( ((EggProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		} else if( AnimalTemp instanceof MilkProducingFarmAnimal) {
	                            			pemain.addElTas(( ((MilkProducingFarmAnimal)AnimalTemp).respondInteract()));
	                            		}
	                            	    found = true;
									}
								}
								i++;
							}
	                    }
	                }else if (peta[pemain.getPosisiX()][pemain.getPosisiY()+1] instanceof Well){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()][pemain.getPosisiY()+1]);
	                }else if(peta[pemain.getPosisiX()][pemain.getPosisiY()+1] instanceof Truck){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()][pemain.getPosisiY()+1]);
	                }else if (peta[pemain.getPosisiX()][pemain.getPosisiY()+1] instanceof Mixer){
	                    pemain.interact((Facility)peta[pemain.getPosisiX()][pemain.getPosisiY()+1]);
	                }
	            }
			} else if(input == "kill up"){
				if(isInRange(pemain.getPosisiX()-1,pemain.getPosisiY())){
					if(isLand(pemain.getPosisiX()-1,pemain.getPosisiY())){
						if(peta[pemain.getPosisiX()-1][pemain.getPosisiY()].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i < ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX()-1 && ytemp==pemain.getPosisiY()){
									if(AnimalTemp instanceof MeatProducingFarmAnimal){
										peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
										Product temp = ((MeatProducingFarmAnimal)AnimalTemp).respondKill();
										ListFarmAnimal.remove(AnimalTemp);
										pemain.addElTas(temp);
										//cout<<temp.getCode()<<" "<<temp.getHarga()<<endl;
									}
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "kill left"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()-1)){
					if(isLand(pemain.getPosisiX(),pemain.getPosisiY()-1)){
						if(peta[pemain.getPosisiX()][pemain.getPosisiY()-1].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX() && ytemp==pemain.getPosisiY()-1){
									if(AnimalTemp instanceof MeatProducingFarmAnimal){
										peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
										Product temp = ((MeatProducingFarmAnimal)AnimalTemp).respondKill();
										ListFarmAnimal.remove(AnimalTemp);
										pemain.addElTas(temp);
										//cout<<temp.getCode()<<" "<<temp.getHarga()<<endl;
									}
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "kill down"){
				if(isInRange(pemain.getPosisiX()+1,pemain.getPosisiY())){
					if(isLand(pemain.getPosisiX()+1,pemain.getPosisiY())){
						if(peta[pemain.getPosisiX()+1][pemain.getPosisiY()].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX()+1 && ytemp==pemain.getPosisiY()){
									if(AnimalTemp instanceof MeatProducingFarmAnimal){
										peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
										Product temp = ((MeatProducingFarmAnimal)AnimalTemp).respondKill();
										ListFarmAnimal.remove(AnimalTemp);
										pemain.addElTas(temp);
										//cout<<temp.getCode()<<" "<<temp.getHarga()<<endl;
									}
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "kill right"){
				if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()+1)){
					if(isLand(pemain.getPosisiX(),pemain.getPosisiY()+1)){
						if(peta[pemain.getPosisiX()][pemain.getPosisiY()+1].getIsObjectExist()){
							found = false;
							i = 0;
							FarmAnimal AnimalTemp;
							while(!found && i <ListFarmAnimal.size()){
								AnimalTemp = (ListFarmAnimal.get(i));
								xtemp = AnimalTemp.getX();
								ytemp = AnimalTemp.getY();
								if(xtemp==pemain.getPosisiX() && ytemp==pemain.getPosisiY()+1){
									if(AnimalTemp instanceof MeatProducingFarmAnimal){
										peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
										Product temp = ((MeatProducingFarmAnimal)AnimalTemp).respondKill();
										ListFarmAnimal.remove(AnimalTemp);
										pemain.addElTas(temp);
										//cout<<temp.getCode()<<" "<<temp.getHarga()<<endl;
									}
									found = true;
								}
								i++;
							}
						}
					}
				}
			} else if(input == "grow"){
				pemain.grow((Land)peta[pemain.getPosisiX()][pemain.getPosisiY()]);
			} else if(input == "tutorial"){
				tutorial();
			} else if(input == "keterangan"){
				keterangan();
			} else if(input == "status"){
				pemain.displayStatus(); 
			} else if(input == "listCommand"){
				listCommand();
			} else{
				System.out.println("input error");
			}
			nextTick();
			printPeta();
			System.out.println("Masukkan inputan permainan :");
			input = in.next();
		}
	}
	public void nextTick(){
		FarmAnimal AnimalTemp;
		int xtemp,ytemp;
		for(int i=0;i<ListFarmAnimal.size();i++){
			AnimalTemp = (ListFarmAnimal.get(i));
			xtemp = AnimalTemp.getX();
			ytemp = AnimalTemp.getY();
			AnimalTemp.setLapar((AnimalTemp.getLapar())-1);
			Random rand = new Random();
			if(AnimalTemp.isLapar()){
				if(peta[xtemp][ytemp].getIsGrassExist()){
					AnimalTemp.eat();
					peta[xtemp][ytemp].setIsGrassExist(false);
				}
			}
			int n = rand.nextInt(4);
			if (n == 0){
				xtemp -= 1;
			} else if(n==1){
				xtemp += 1;
			} else if(n==2){
				ytemp -= 1;
			} else if(n==3){
				ytemp += 1;
			}
			if (isInRange(xtemp,ytemp)){
					if(!peta[xtemp][ytemp].getIsObjectExist()){
					if(peta[xtemp][ytemp] instanceof Barn){
						if(AnimalTemp instanceof MeatProducingFarmAnimal){
							// cout<<"masuk meat"<<endl;
							peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
							AnimalTemp.move(xtemp,ytemp);
							peta[xtemp][ytemp].setIsObjectExist(true);
						}		
					} else if(peta[xtemp][ytemp] instanceof Grassland){
						if(AnimalTemp instanceof MilkProducingFarmAnimal){
							peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
							AnimalTemp.move(xtemp,ytemp);
							peta[xtemp][ytemp].setIsObjectExist(true);
						}
					} else if(peta[xtemp][ytemp] instanceof Coop){
						if(AnimalTemp instanceof EggProducingFarmAnimal){
							peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
							AnimalTemp.move(xtemp,ytemp);
							peta[xtemp][ytemp].setIsObjectExist(true);
						}
					}
				}
			}
			if(AnimalTemp.getLapar()<=-5){
				peta[AnimalTemp.getX()][AnimalTemp.getY()].setIsObjectExist(false);
				ListFarmAnimal.remove(AnimalTemp);
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
		//System.out.println("!--- TUTORIAL ---!"<<endl<<endl;
		keterangan();
		listCommand();
	}

	public void keterangan(){
		// cout<<"--- KETERANGAN ---"<<endl;
		// cout<<"A : Ayam"<<endl;
		// cout<<"D : Bebek"<<endl;
		// cout<<"B : Kerbau"<<endl;
		// cout<<"S : Domba"<<endl;
		// cout<<"C : Sapi"<<endl;
		// cout<<"G : Kambing"<<endl;
		// cout<<"P : Player"<<endl;
		// cout<<"- : Grassland"<<endl;
		// cout<<"x : Barn"<<endl;
		// cout<<"o : Coop"<<endl;
		// cout<<"*,@,# : Land dengan rumput"<<endl<<endl;
	}

	public boolean isInRange(int x,int y){
		return ( (x>=0) && (x<n) &&  (y>=0) && (y<m) );
	}

	public boolean isLand(int x,int y){
		return ((peta[x][y] instanceof Grassland) || (peta[x][y] instanceof Barn) || (peta[x][y] instanceof Coop) );
	}

}