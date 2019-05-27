package model.element.mobil;

import java.awt.Point;
import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

public class Mobil extends Element {
	
	private Point position;
	
	public Mobil(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	
	public Mobil(int x, int y, Sprite sprite, Permeability permeability) {
		this(sprite, permeability);
		this.setX(x);
		this.setY(y);
	}

	public void moveUp() {
		this.setY(getY() - 1);
	}
	

	public void moveDown() {
		this.setY(getY() + 1);
	}
	
	
	public void moveLeft() {
		this.setX(this.getX() - 1);
		
	}
	
	
	public void moveRight() {
		this.setX(getX() + 1);
	}
	

	public int getX() {
		return this.getPosition().x;
	}
	
	public void setX(int x) {
		this.getPosition().x = x;
	}
	
	
	
	public int getY() { 
		return this.getPosition().y;
	}
	
	public void setY(int y) {
		this.getPosition().y = y;
	}
	
	
	
	public Point getPosition() {
		return this.position;
	}
	
	public void setPosition(final Point position) {
		this.position = position;
	}
}
