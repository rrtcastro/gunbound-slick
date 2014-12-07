package javagame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.SlickException;

/*
 * Ref: Joseph Anthony C. Hermocilla
 * 
 * The class that contains the state of the game.
 * 
 */

public class GameState {
	
	private String title;
	private int gameMode;
	private Map playersData = new HashMap();
	
	public List<Player> players;
	public List<PhysicsObj> objects;
	public Physics physics;
	public Terrain terrain;
	
	public int numOfObj;
	private int numOfPlayers = 0;
	
	public GameState(String terrainloc, int gameMode) throws SlickException{
		playersData = new HashMap<String, Player>();
		players = new ArrayList<Player>();
		objects = new ArrayList<PhysicsObj>();
		physics = new Physics();
		terrain = new Terrain(terrainloc);
		terrain.init();
		
		numOfObj = 0;
		
		this.gameMode = gameMode;
		
	}
	
	public String getTitle(){
		return title;
	}
	
	public void update(String name, Player player){
		
		if(!playersData.containsKey("name")){
			physics.add(player);
			objects.add(player);
			players.add(player);
			numOfObj++;
			numOfPlayers++;
		}
			
			
		playersData.put(name, player);
	}
	public void update(){
		
	}
	
	public Map getPlayers(){
		return playersData;
	}
	
	public int getGameMode(){
		return gameMode;
	}
	
	public int getNumOfPlayers(){
		return numOfPlayers;
	}
	
}
