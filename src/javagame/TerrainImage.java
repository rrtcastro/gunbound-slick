package javagame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TerrainImage extends Image {
	
	byte[] a;
	
	public TerrainImage() throws SlickException{
		super("res/bg.png");
		
		a = super.pixelData;
		int s = super.getWidth();
	}

}
