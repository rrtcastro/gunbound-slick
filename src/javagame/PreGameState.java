package javagame;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PreGameState {

	public final int NUMBER_OF_SPRITES = 2;
	private String id;
	
	private boolean playerOne;
	private boolean playerTwo;
	private boolean playerThree;
	private boolean playerFour;
	
	private boolean[] players = {true, true, false, false};
	private int[] sprite = {0,0,-1,-1};
	
	private String[] sprites = {
			"sprite1",
			"sprite1"
	};
	private String[] spritenames = {
			"ADUKA",
			"TANKTANK"
	};
	
	public PreGameState(){
		
	}
	
	public void setSpriteDecrease(int index){
		sprite[index] = sprite[index] - 1;
		
		if(sprite[index] == -2){
			sprite[index] = NUMBER_OF_SPRITES - 1;
			players[index] = true;
		}
		
		else if(sprite[index] == -1)
			players[index] = false;
		
		else
			players[index] = true;
	}
	
	public void setSpriteIncrease(int index){
		sprite[index] = sprite[index] + 1;
		
		if(sprite[index] == NUMBER_OF_SPRITES){
			sprite[index] = -1;
			players[index] = false;
		}
		
		else
			players[index] = true;
	}
	
	public int getSprite(int index){
		
		return sprite[index];
		
	}
	
	public boolean getIfPlayer(int index){
		
		return players[index];
		
	}
	
	
	public String[] getSprites(){
		return sprites;
	}
	
	public String[] getSpriteNames(){
		return spritenames;
	}
	
}
