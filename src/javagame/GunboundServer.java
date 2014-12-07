package javagame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.newdawn.slick.SlickException;

/*
 * ref: Joseph Anthony C. Hermocilla
 */

public final class GunboundServer implements Runnable{

	private int port = 12345;
	private int gameID = 0;
	private int numberOfGames = 0;
	private Map<String, GameState> games = new HashMap<String, GameState>();
	
	private String playerData;
	
	private DatagramSocket serverSocket;
	private Thread t = new Thread(this);
	
	int playerCount=0;
	int numPlayers;
	
	private GameState gamestate;
	
	public GunboundServer(){
		
		try{
			serverSocket = new DatagramSocket(port);
			serverSocket.setSoTimeout(100);
		} catch(IOException e){
			System.err.println("Could not listen on port: " + port);
			System.exit(-1);
		} catch(Exception e){}

		//gamestate = new GameState();
		
		t.start();
		
	}
	
	private void send(Player player, String message){
		
		DatagramPacket packet;	
		byte buf[] = message.getBytes();		
		packet = new DatagramPacket(buf, buf.length, player.getAddress(),player.getPort());
		try{
			serverSocket.send(packet);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	
	private void broadcast(String message){
		for(Iterator ite=gamestate.getPlayers().keySet().iterator();ite.hasNext();){
			String name=(String)ite.next();
			Player player=(Player)gamestate.getPlayers().get(name);			
			send(player,message);	
		}
		
	}
	
	public void run(){
		while(true){
			
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try{
				serverSocket.receive(packet);
			}catch(Exception e){}
			
			playerData = new String(buf);
			playerData = playerData.trim();
			
			if(playerData.startsWith("LOBBY")){
				
				String tokens[] = playerData.split(" ");
				
				switch(tokens[1]){
				
					case "REFRESH":
						//games.put("asd", "asd");
						Object[] rooms = games.keySet().toArray();
						System.out.println(games.get(rooms[0]).getTitle());
						break;
						
					case "JOIN":
						if(playerCount<=4){
							
							Player player = new Player(tokens[3],packet.getAddress(),packet.getPort());
							System.out.println("Player connected: "+tokens[3]);
							gamestate.update(tokens[3],player);
							
							playerCount += 1;
							
							broadcast("CONNECTED " + tokens[3]);
							
						}
						else{}
						break;
						
					case "CREATE":
						//GameState gs = new GameState(tokens[2], Integer.toString(gameID));
						//games.put(Integer.toString(gameID), gs);
						break;
				
				}
				
			}
			else if(playerData.startsWith("GAME")){
				
				String tokens[] = playerData.split(" ");
				
				switch(tokens[2]){
				
					case "CHAT":
						broadcast(playerData);
						break;
				
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		new GunboundServer();
	}

}
