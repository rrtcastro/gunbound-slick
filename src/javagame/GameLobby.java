package javagame;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Display;
import mdes.slick.sui.Label;
import mdes.slick.sui.ScrollPane;
import mdes.slick.sui.TextField;
import mdes.slick.sui.event.KeyEvent;
import mdes.slick.sui.event.KeyListener;
import mdes.slick.sui.event.MouseEvent;
import mdes.slick.sui.event.MouseListener;
import mdes.slick.sui.layout.RowLayout;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameLobby extends BasicGameState implements Runnable{

	UnicodeFont font;
	String mouse = "Mouse coords: 0,0";
	String pixel = "Pixel coords: 0,0";
	StateBasedGame main;
	
	private Display display;
	TextField chatInput;
	Container content;
	
	int chatIndex = 0;
	
	List<String> chatHistory = new ArrayList<String>();
	
	String serverData;
	Thread t = new Thread(this);
	
	public GameLobby(int state){
		t.start();
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		main = sbg;
		font = Game.getNewFont("Arial" , 16);
		
		display = new Display(gc);
		
		content = new Container();
		content.setSize(Game.width - 300, Game.height - 220);
        content.setOpaque(true); //ensures that the background is drawn
        content.setBackground(Color.darkGray); //sets the background color
        
        ScrollPane pane = new ScrollPane(content);
        pane.setLocation(20,Game.height - 440);
        pane.setSize(Game.width - 300, Game.height - 220);
        pane.setOpaque(true);
        
        chatInput = new TextField(140);
        chatInput.setSize(Game.width - 360, 20);
        chatInput.setLocation(20, Game.height - 60);
        chatInput.grabFocus();
        
        Button send = new Button("Send");
        send.setSize(60, 20);
        send.setLocation(460, Game.height - 60);
        
        send.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String input = chatInput.getText();
				chatInput.setText("");
				
				try {
					Game.send("GAME 1 CHAT " + Game.name + " " + input);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				chatInput.grabFocus();
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        display.add(pane);
        display.add(chatInput);
        display.add(send);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		Image bgImage = new Image("res/sleepingfoxcopy.png");
		g.drawImage(bgImage, 0, 0);
		
		display.render(gc, g);
		
		g.setColor(Game.white);
		g.drawString(mouse, 10, 30);
		g.drawString(pixel, 10, 50);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
		display.update(gc, delta);
		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		mouse = "Mouse coords: " + xpos + "," + ypos;
		pixel = "Pixel coords: " + xpos + "," + (Game.height - ypos);
		
		font.loadGlyphs();
		
		Input inputs = gc.getInput();
		if(inputs.isKeyPressed(Input.KEY_ENTER)){
			String input = chatInput.getText();
			chatInput.setText("");
			
			try {
				Game.send("GAME 1 CHAT " + Game.name + " " + input);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			chatInput.grabFocus();
		}
		
	}
	
	public int getID(){
		return 2;
	}
	
	public void run(){
		
		while(true){
			
			try{
				Thread.sleep(1);
			}catch(Exception ioe){}
			
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			try{
     			Game.socket.receive(packet);
			}catch(Exception ioe){}
			
			serverData = new String(buf);
			serverData = serverData.trim();
			
			if(serverData.startsWith("GAME")){
				
				String tokens[] = serverData.split(" ");
				
				switch(tokens[2]){
				
					case "CHAT":
						
						String input = "";
						for(int z = 4;z<tokens.length;z++)
							input = input + tokens[z] + " ";
							
						chatHistory.add("[" + tokens[3] + "]:  " + input);
							
						Label insert = new Label("[" + tokens[3] + "]:  " + input);
						insert.setFont(font);
						insert.setForeground(Game.white);
						insert.setLocation(10, 20*chatIndex);
						insert.pack();
							
						content.add(insert);
						chatIndex+=1;
						break;
				
				}
				
			}
			
		}
		
	}
	
}
