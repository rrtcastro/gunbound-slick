package javagame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class Terrain {

	String imageLoc;

	Image bg;
	Image maskImage;
	
	ImageBuffer mask;
	
	int a;
	
	public Terrain(String imageLoc){
		this.imageLoc = imageLoc;
	}
	
	public void init() throws SlickException{
		bg = new Image(imageLoc);
		/*
		mask = new ImageBuffer(2000,1600);
		
		for(int i = 0; i < 2000; i++){
			
			for(int j = 0; j < 1600; j++){
				
				if(bg.getColor(i, j).getAlpha() == 0)
					mask.setRGBA(i, j, 0, 0, 0, 0);
				
				else
					mask.setRGBA(i, j, 255, 255, 255, 255);
				
			}
			
		}
		
		maskImage = mask.getImage();*/
		
	}
	
	public Image getTerrain(){
		return bg;
	}

	public Image getMask(){
		return maskImage;
	}
	
	public boolean isSolid(int x, int y){
		
		if((x>=0&&x<2000)&&(y>=0&&y<1600)){
			
			Color c = bg.getColor(x, y);
			
			if(c.getAlpha() == 0){
				return false;
			}
			else
				return true;
		}
		return false;
	}
	
	public float[] getNormal(int x, int y) {
	    // First find all nearby solid pixels, and create a vector to the average solid pixel from (x,y)
	    float avgX = 0;
	    float avgY = 0;
	    for (int w = -3; w <= 3; w++) {
	      for (int h = -3; h <= 3; h++) {
	        if (isSolid(x + w, y + h)) {
	          avgX -= w;
	          avgY -= h;
	        }
	      }
	    }
	    float len = (float) Math.sqrt(avgX * avgX + avgY * avgY); // get the distance from (x,y)
	    return new float[]{avgX/len, avgY/len}; // normalize the vector by dividing by that distance
	  }
	
	public void remove(int x, int y, int radius) throws SlickException{
		/*If you really want to make this from an Image object then you must:

	    Get the texture with img.getTexture()
	    Retrieve the inherent pixel data with texture.getTextureData()
	    Parse the byte-array until you reach the pixel (x, y)
	    Change the RGB value of this pixel*/
		
		Graphics g = bg.getGraphics();
		g.setColor(new Color(0,0,0,0));
		
		g.setDrawMode(Graphics.MODE_COLOR_MULTIPLY);
		
		g.fillArc(x - 30, y - 30, 70, 50, 0, 360);
		g.flush();
		
	}
	
}
