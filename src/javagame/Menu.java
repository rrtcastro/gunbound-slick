package javagame;

import mdes.slick.sui.Button;
import mdes.slick.sui.Display;
import mdes.slick.sui.Label;
import mdes.slick.sui.event.MouseEvent;
import mdes.slick.sui.event.MouseListener;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{

    UnicodeFont font;
    String mouse = "Mouse coords: 0,0";
    String pixel = "Pixel coords: 0,0";
    StateBasedGame main;
	
    private Display display;
    
	public Menu(int state){
	
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		main = sbg;
		font = Game.getNewFont("Arial" , 16);
		
		display = new Display(gc);
		
		Label la = new Label("Gunbound");
		la.setFont(font);
		la.setLocation(380, 150);
		la.setForeground(Game.white);
		la.pack();
		
		Button localBt = new Button("Local Computer");
		localBt.setBackground(Game.blue);
		localBt.setLocation(330,200);
		localBt.setSize(180,40);
		
		localBt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				main.enterState(4);
				
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
		
		Button bt = new Button("LAN");
		bt.setBackground(Game.blue);
		bt.setLocation(330, 260);
		bt.setSize(180, 40);
		
		bt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				try {
					Game.send("LOBBY JOIN 1 " + Game.name);
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
				
				main.enterState(2);
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
		
		display.add(la);
		display.add(localBt);
		display.add(bt);
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
		
	}
	
	public int getID(){
		return 0;
	}
	
}
