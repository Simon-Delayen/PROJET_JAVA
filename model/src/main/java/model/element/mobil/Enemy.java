package model.element.mobil;

import java.io.IOException;

import contract.model.ISprite;
import model.element.Sprite;
import contract.model.Permeability;

public class Enemy extends Mobil implements ISprite{
	
	private static final Sprite sprite = new Sprite('@', "monstre .png");

	
	public Enemy (int x, int y ) throws IOException {
		super(x, y, sprite, Permeability.KILLING );
		sprite.loadImage();
		
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(sprite);
	}
	
	@Override
	public void moveRight() {
		super.moveRight();
		this.setSprite(sprite);
	}
	
	@Override
	public void moveUp() {
		super.moveUp();
		this.setSprite(sprite);
	}
	
	@Override
	public void moveDown() {
		super.moveDown();
		this.setSprite(sprite);
	}


	@Override
	public void loadImage() throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public char getConsoleImage() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
