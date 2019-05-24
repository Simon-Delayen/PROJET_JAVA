package model.element;

import java.awt.Image;

public class Sprite {
	public Image image;
	public String imageName;
	public char consoleImage;
	private boolean imageLoaded;
	
	public Sprite(char charactere, String imageName) {
		
	}
	
	public Image getImage() {
		return image;
		
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void loadimage() {
		
	}
	
	public char getConsoleImage() {
		return consoleImage;
		
	}
	
	

}
