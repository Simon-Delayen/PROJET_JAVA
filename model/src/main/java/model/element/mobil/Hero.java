package model.element.mobil;

import java.io.IOException;
import model.element.Permeability;
import model.element.Sprite;

public class Hero extends Mobil{
	
	
	private static final Sprite sprite = new Sprite('@', "pause.png");

	   
	private static final Sprite spriteMoveLeft  = new Sprite('@', "gauche 1.png");

	 
	private static final Sprite spriteMoveRight = new Sprite('@', "droite 1.png");
	   
	  
	private static final Sprite spriteMoveUp  = new Sprite('@', "dos.png");

	  
	private static final Sprite spriteMoveDown = new Sprite('@', "descend 1.png");
	    
	    
	private static final Sprite spriteDie  = new Sprite('@', "tomber.png");
	
	public Hero(final int x, final int y) throws IOException {
		super(x, y, sprite, Permeability.BLOCKING);
		sprite.loadImage();
	    spriteMoveLeft.loadImage();
	    spriteMoveRight.loadImage();
	    spriteMoveUp.loadImage();
	    spriteMoveDown.loadImage();
	    spriteDie.loadImage();

	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteMoveLeft);
	}
	
	@Override
	public void moveRight() {
		super.moveRight();
		this.setSprite(spriteMoveRight);
	}
	
	@Override
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteMoveUp);
	}
	
	@Override
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteMoveDown);
	}
	
}