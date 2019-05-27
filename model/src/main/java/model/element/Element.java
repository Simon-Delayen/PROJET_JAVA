package model.element;

import java.awt.Image;
import contract.model.*;

public class Element implements IElement{
	
	private Sprite sprite;
	
	private Permeability permeability;
	
	public Element (Sprite sprite, Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	
	
	public ISprite getSprite() {
		return this.sprite;
	}
	
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	
	public Permeability getPermeability() {
		return this.permeability;
	}
	
	
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	
		
	public Image getImage() {
		return this.getSprite().getImage();		
	}
	
}
