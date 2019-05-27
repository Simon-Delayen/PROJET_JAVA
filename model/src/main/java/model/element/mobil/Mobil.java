package model.element.mobil;

import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

public class Mobil {
	public int x;
	public int y;
	
	public int getx() {
		return this.x;
	}
	
	public void setx(int x) {
		this.x = x;
	}
	
	public int gety() { 
		return this.y;
	}
	
	public void sety(int y) {
		this.y = y;
	}

	public void moveUP() {}
	
	public void moveRIGHT() {}
	
	public void moveDOWN() {}
	
	public void moveLEFT() {}
	
	public void alive() {}
}
