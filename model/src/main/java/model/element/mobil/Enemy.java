package model.element.mobil;

import java.io.IOException;
import java.lang.Math;


import contract.model.ISprite;
import model.element.Sprite;
import contract.model.Permeability;

public class Enemy extends Mobil implements ISprite{
	
	private static final Sprite sprite = new Sprite('@', "monstre .png");
	boolean win = false;
	int nb; 

	
	public Enemy (int x, int y ) throws IOException {
		super(x, y, sprite, Permeability.KILLING );
		sprite.loadImage();
		
	}
/*	
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

*/
	@Override
	public void loadImage() throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public char getConsoleImage() {
		// TODO Auto-generated method stub
		return 0;
	}{

	while (win == false) {
	
	nb = (int) (Math.random()*4);
	//System.out.println(nb);
	
	switch (nb) {
	
	case 0 : 
		super.moveLeft();
		this.setSprite(sprite);
		System.out.println(nb);
		break;
		
	case 1 :
		super.moveRight();
		this.setSprite(sprite);
		System.out.println(nb);
		break;
		
	case 2 : 
		super.moveUp();
		this.setSprite(sprite);
		System.out.println(nb);
		break;
		
	case 3 : 
		super.moveDown();
		this.setSprite(sprite);
		System.out.println(nb);	
		break;
		}
	
	}
	
}}
