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

	public Player getPlayer(){
		return pemain;
	}
	public Cell[][] getCell(){
		return peta;
	}
	public ArrayList<FarmAnimal> getListFarmAnimal(){
		return ListFarmAnimal;
	}
	public Game() throws Exception {
		Scanner reader = new Scanner(new File("peta.txt"));  
		ListFarmAnimal = new ArrayList<FarmAnimal>();
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
					peta[i][j] = new Coop(i,j,false,true);
				} else if(temp.charAt(j) == '-'){
					// Grassland G(i,j,false,false);
					peta[i][j] = new Grassland(i,j,false,false);
				} else if (temp.charAt(j) == '#'){
					// Grassland G(i,j,true,false);
					peta[i][j] = new Grassland(i,j,false,true);
				} else if (temp.charAt(j) == 'x'){
					// Barn B(i,j,false,false);
					peta[i][j] = new Barn(i,j,false,false);
				} else if (temp.charAt(j) == '@'){
					// Barn B(i,j,true,false);
					peta[i][j] = new Barn(i,j,false,true);
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
			c = read.next().charAt(0);
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

	public void play(String input){
		boolean found;
		int xtemp,ytemp,i;
		if (input.equalsIgnoreCase("move up")){
			if(isInRange(pemain.getPosisiX()-1,pemain.getPosisiY())){
				if(isLand(pemain.getPosisiX()-1,pemain.getPosisiY())){
					if(!peta[pemain.getPosisiX()-1][pemain.getPosisiY()].getIsObjectExist()){
						peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
						peta[pemain.getPosisiX()-1][pemain.getPosisiY()].setIsObjectExist(true);
						pemain.move(1);	
					}
				}
			}
		}else if(input.equalsIgnoreCase("move left")){
			if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()-1)){
				if(isLand(pemain.getPosisiX(),pemain.getPosisiY()-1)){
					if(!peta[pemain.getPosisiX()][pemain.getPosisiY()-1].getIsObjectExist()){
						peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
						peta[pemain.getPosisiX()][pemain.getPosisiY()-1].setIsObjectExist(true);
						pemain.move(4);
					}
				}
			}
		}else if(input.equalsIgnoreCase("move down")){
			if(isInRange(pemain.getPosisiX()+1,pemain.getPosisiY())){
				if(isLand(pemain.getPosisiX()+1,pemain.getPosisiY())){
					if(!peta[pemain.getPosisiX()+1][pemain.getPosisiY()].getIsObjectExist()){
						peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
						peta[pemain.getPosisiX()+1][pemain.getPosisiY()].setIsObjectExist(true);
						pemain.move(3);
					}				
				}
			}
		}else if(input.equalsIgnoreCase("move right")){
			if(isInRange(pemain.getPosisiX(),pemain.getPosisiY()+1)){
				if(isLand(pemain.getPosisiX(),pemain.getPosisiY()+1)){
					if(!peta[pemain.getPosisiX()][pemain.getPosisiY()+1].getIsObjectExist()){
						peta[pemain.getPosisiX()][pemain.getPosisiY()].setIsObjectExist(false);
						peta[pemain.getPosisiX()][pemain.getPosisiY()+1].setIsObjectExist(true);
						pemain.move(2);
					}
				}
			}
		}else if(input.equalsIgnoreCase("talk up")){
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
		} else if(input.equalsIgnoreCase("talk left")){
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
		} else if(input.equalsIgnoreCase("talk down")){
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
		} else if(input.equalsIgnoreCase("talk right")){
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
		} else if(input.equalsIgnoreCase("interact up")){
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

		} else if(input.equalsIgnoreCase("interact left")){
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

		} else if(input.equalsIgnoreCase("interact down")){
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
		} else if(input.equalsIgnoreCase("interact right")){
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
		} else if(input.equalsIgnoreCase("kill up")){
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
		} else if(input.equalsIgnoreCase("kill left")){
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
		} else if(input.equalsIgnoreCase("kill down")){
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
		} else if(input.equalsIgnoreCase("kill right")){
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
		} else if(input.equalsIgnoreCase("grow")){
			pemain.grow((Land)peta[pemain.getPosisiX()][pemain.getPosisiY()]);
		} else{
			System.out.println("input error");
		}
		nextTick();
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
		for (int i = 0;i<n;i++){
			for (int j = 0;j<m;j++){
				if (peta[i][j] instanceof Truck){
					Truck temp = (Truck)peta[i][j];
					temp.minCD();
				}
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