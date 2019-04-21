package model.farmAnimal;

import java.util.*;

abstract public class FarmAnimal {
	protected int lapar;
	protected boolean hasilProduct;
	protected int x;
	protected int y;
	protected int laparMax;

	public FarmAnimal(int x, int y, int lapar) {
		this.x = x;
		this.y = y;
		this.lapar = lapar;
		this.laparMax = lapar;
	}

	abstract public String suara();

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void eat() {
		this.lapar = this.laparMax;
		hasilProduct = true;
	}

	public int getLapar() {
		return lapar;
	}

	public boolean getHasilProduct() {
		return hasilProduct;
	}

	public void setLapar(int lapar) {
		this.lapar = lapar;
	}

	public void setHasilProduct(boolean hasilProduct) {
		this.hasilProduct = hasilProduct;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isLapar() {
		return (lapar <= 0);
	}
}