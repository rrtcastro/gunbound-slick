package javagame;

import java.awt.Font;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import mdes.slick.sui.Label;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	public static GameState gs;
	
	public static final String gamename = "Gunbound";
	public static final int menu = 0;
	public static final int lobby = 1;
	public static final int gamelobby = 2;
	public static final int play = 3;
	public static final int locallobby = 4;
	
	public static final int framerate = 60;
	public static final int width = 800;
	public static final int height = 600;
	
	public static final Color red = new Color(255,0,0,255);
	public static final Color green = new Color(0,255,0,255);
	public static final Color blue = new Color(0,0,255,255);
	public static final Color white = new Color(255,255,255,255);
	public static final Color black = new Color(0,0,0,255);
	public static final Color lightBlue = new Color(0,0,155,255);
	public static final Color darkBlue = new Color(0,0,68,255);
	
	public static String server;
	public static int PORT = 12345;
	public static DatagramSocket socket;
	String serverData;
	
	public static String name;
	
	public Game(String gamename) throws SlickException{
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Lobby(lobby));
		this.addState(new GameLobby(gamelobby));
		this.addState(new Play(play));
		this.addState(new LocalLobby(locallobby));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu).init(gc, this);
		this.getState(lobby).init(gc, this);
		this.getState(gamelobby).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(locallobby).init(gc, this);
	}
	
	public static UnicodeFont getNewFont(String fontName , int fontSize)
    {
		UnicodeFont font = new UnicodeFont(new Font(fontName , Font.PLAIN , fontSize));
        font.addGlyphs("@");
        font.getEffects().add(new ColorEffect(java.awt.Color.white));
        return (font);
    }
	
	public static void send(String msg){
		try{
			byte[] buf = msg.getBytes();
        	InetAddress address = InetAddress.getByName(server);
        	DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);
        	socket.send(packet);
        }catch(Exception e){}
		
	}
	
	public static void main(String[] args) throws SlickException{
		
		server = "127.0.0.1";
		//socket = new DatagramSocket();
		name = "Randall";
		
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(width,height,false);
			appgc.setTargetFrameRate(framerate);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

}
