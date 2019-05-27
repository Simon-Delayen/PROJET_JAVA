package model.element.mobil;

import java.io.IOException;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class Hero extends Mobil implements ISprite{
	
	public boolean alive = true;
	
	private int counter = 1;
	
	private int delay = 1;
	
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
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
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

	@Override
    public final void doNothing() {
    	super.doNothing();
    	if(delay == 6) {
    		delay=0;
	    	switch ( getCounter() ) { //this switch is used to change the player picture when he didn't move
			case 1:
				this.setSprite(spriteMoveLeft); //first picture load, next time we do the while the second will be load
				setCounter(2);
				break;
			case 2:
				this.setSprite(spriteMoveUp); //third picture load, next time we do the while the fourth will be load
				setCounter(3);
	    		break;
			case 3:
				this.setSprite(spriteMoveRight); //first picture load, next time we do the while the second will be load
				setCounter(4);
				break;
			case 4:
				this.setSprite(spriteMoveDown); //third picture load, next time we do the while the fourth will be load
				setCounter(1);
	    		break;
	    	}
    	}
	    	else{
	    		delay++;
	        }
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
	
	public int getCounter() {
		return counter;
	}
	
<<<<<<< HEAD
	public void setCounter(int counter) {
		this.counter = counter;
=======
	public boolean alive() {
		return false;
		
>>>>>>> 8ee99f7e63c49157ada6a57a3e2bad991effb6cf
	}
}