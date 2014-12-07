package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import mdes.slick.sui.ScrollPane;
import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Display;
import mdes.slick.sui.event.MouseEvent;
import mdes.slick.sui.event.MouseListener;
import mdes.slick.sui.layout.RowLayout;

public class Lobby extends BasicGameState{

	//TextField text;
	UnicodeFont font;
	String mouse = "Mouse coords: 0,0";
	String pixel = "Pixel coords: 0,0";
	StateBasedGame main;
	
	private Display display;
	
	public Lobby(int state){
	
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		main = sbg;
		font = Game.getNewFont("Arial" , 16);
		
		display = new Display(gc);
		
		Container content = new Container();
		content.setSize(Game.width - 300, 2000);
		content.setLocation(20,20); //sets panel loc relative to parent (display)
        content.setOpaque(true); //ensures that the background is drawn
        content.setBackground(Color.darkGray); //sets the background color
	
        RowLayout layout = new RowLayout(true, RowLayout.LEFT, RowLayout.CENTER);
        layout.setAutoSpacing(false);
        layout.setHorizontal(false);
        layout.setVerticalAlignment(RowLayout.TOP);
        content.setLayout(layout);
        
        Button refresh = new Button("Refresh");
        refresh.setBackground(Game.blue);
        refresh.setLocation(20, 540);
        refresh.setSize(380, 40);
        
        refresh.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
		
		Button create = new Button("Create Game");
		create.setBackground(Game.blue);
		create.setLocation(400, 540);
		create.setSize(380, 40);
		
		create.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
        
		Container createPane = new Container();
		createPane.setSize(Game.width - 570, Game.height - 100);
		createPane.setLocation(540,20); //sets panel loc relative to parent (display)
		createPane.setOpaque(true); //ensures that the background is drawn
		createPane.setBackground(Color.darkGray); //sets the background color
                
        ScrollPane pane = new ScrollPane(content);
        pane.setLocation(20,20);
        pane.setSize(Game.width - 300, Game.height - 100);
        pane.setOpaque(true);
        
        display.add(pane);
        display.add(createPane);
        display.add(refresh);
        display.add(create);
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
		return 1;
	}
	
}
