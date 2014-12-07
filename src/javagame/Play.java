package javagame;

import java.util.ArrayList;
import java.util.List;

import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Display;
import mdes.slick.sui.ScrollPane;
import mdes.slick.sui.TextField;
import mdes.slick.sui.event.MouseEvent;
import mdes.slick.sui.event.MouseListener;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Drawable;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{

    public static Image terrainImg;
    
	int worldPosX = 0;
	int worldPosY = -1000;
	
	Image bg;
	
	int turn = 0;
	
	private float shotAngle = 0;
	private int shotPower = 0;
	
	private int gameTime = 30;
	private float gameWind = 5;
	
	Display display;
	TextField chatInput;
	Container content;

	Player playerDebug;
	
	public Play(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		//numOfObj = 0;
		//physics = new Physics();
		
		/*playerDebug = new Player("Randall",400,1300,65,65,true);
		
		players.add(playerDebug);
		
		playerDebug = new Player("Marrianne",1600,1300,65,65,false);
		
		players.add(playerDebug);*/
		
		
		//terrain = new Terrain("res/map-ice.png");
		
		//terrain.init();
		bg = new Image("res/Skies0201_1_L.png");
		//objects = new ArrayList<PhysicsObj>();
		//objects.add(players.get(0));
		//physics.add(players.get(0));
		//numOfObj += 1;
		
		//objects.add(players.get(1));
		//physics.add(players.get(1));
		//numOfObj += 1;
		
		//terrainImg = terrain.getTerrain();
		
		
		//HUD
			display = new Display(gc);
		
		
			content = new Container();
			content.setSize(Game.width - 300, Game.height - 220);
	        content.setOpaque(true); //ensures that the background is drawn
	        content.setBackground(new Color(255, 255, 255, 40)); //sets the background color
	        
	        ScrollPane pane = new ScrollPane(content);
	        pane.setLocation(150,410);
	        pane.setSize(500, 150);
	        pane.setOpaque(true);
	        pane.setBackground(new Color(255, 255, 255, 40));
	        
	        chatInput = new TextField(140);
	        chatInput.setSize(440, 20);
	        chatInput.setLocation(150, 560);
	        chatInput.grabFocus();
	        
	        Button send = new Button("Send");
	        send.setSize(60, 20);
	        send.setLocation(590, 560);
	        
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
	        display.setVisible(false);
	        
	}
	
	
	public static void explode(int x, int y, int radius) throws SlickException{
		Game.gs.terrain.remove(x,y,radius);
		
		//terrainImg = terrain.getTerrain();
		
	}
	
	public void showNormals(Graphics g) {
		  
		  // Scan the terrain in a gridlike pattern, and only draw normals at pixels that have a range of solid pixels surrounding them
		  for (int x = 0; x < 2000; x += 10) {
		    for (int y = 1150; y < 1600; y += 10) {
		      int solidCount = 0;
		      // scan solid pixels around this pixel
		      for (int i = -5; i <= 5; i++) {
		        for (int j = -5; j <= 5; j++) {
		          if (Game.gs.terrain.isSolid(x+i,y+j)) {
		            solidCount++;
		          }
		        }
		      }
		      // if there's too many solid pixels, then it's probably underground, and not a surface
		      // if there's not enough solid pixels, then it's probably in the air, and not a surface
		      if (solidCount < 110 && solidCount > 10) {
		        float[] pixelNormal = Game.gs.terrain.getNormal(x,y);
		        if (pixelNormal.length > 0 && !Float.isNaN(pixelNormal[0]) && !Float.isNaN(pixelNormal[1])){
		        	g.setColor(Color.orange);
		        	g.drawLine(x,y, x + 20 * pixelNormal[0], y + 20 * pixelNormal[1]);
		        	g.setColor(Color.white);
		          
		        }
		      }
		    }
		  }
		}
	
	
	public void showHUD(Graphics g){
			
		g.setColor(Color.blue);
		g.fillRect(20, 500, 100, 80);
		g.setColor(Color.white);
		g.drawString("Angle: " + shotAngle,30,520);
		g.drawString("Power: " + shotPower, 30, 540);
			
			
		g.setColor(Color.blue);
		g.fillRect(680, 500, 100, 80);
		g.setColor(Color.white);
		g.drawString("Time: " + gameTime, 690, 520);
		g.drawString("Wind: " + gameWind, 690, 540);
		
	}
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.pushTransform();
		
		g.translate(worldPosX, worldPosY);
		
		g.drawImage(bg, 0, 0);
		g.popTransform();
		
		g.pushTransform();
		
		g.translate(worldPosX, worldPosY);
	    
	    g.drawImage(Game.gs.terrain.getTerrain(), 0, 0);
	    
	    //showNormals(g);
		
		g.popTransform();
		
		g.pushTransform();
		
		g.translate(worldPosX, worldPosY);
		g.setColor(Game.white);
		
		PhysicsObj temp;
		for(int i = 0; i < Game.gs.numOfObj; i++){
			temp = Game.gs.objects.get(i);
			if(temp instanceof Player){
				g.drawImage(((Player) temp).sprite, temp.getX() - temp.getWidth()/2, temp.getY() - temp.getHeight()/2);
				
				if(temp == playerDebug){
					
					double s = Math.sin((double)shotAngle);
					double c = Math.cos((double)shotAngle);
					g.drawLine(temp.getX(), temp.getY(), (float)(temp.getX()-c*250), (float)(temp.getY()-s*250));
					
				}
				
			}
			else
				g.fillRect(temp.getX() - temp.getWidth()/2, temp.getY() - temp.getHeight()/2, temp.getWidth(), temp.getHeight());
		
		}
		g.popTransform();
		
		showHUD(g);
		display.render(gc, g);
		
		Game.gs.physics.update();
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{

		if(Game.gs.getGameMode()==1)
			display.setVisible(true);
		
		
		display.update(gc, delta);
		
		playerDebug = Game.gs.players.get(turn);
		
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			if(worldPosX > -1200)
				worldPosX -= 10;
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			if(worldPosX < 0)	
				worldPosX += 10;
		}
		
		if(input.isKeyDown(Input.KEY_UP)){
			
			
			if(worldPosY < 0)	
				worldPosY += 10;
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			
			if(worldPosY > -1000)
				worldPosY -= 10;
			
		}
		
		if(input.isKeyDown(Input.KEY_D)){
			
			float x = playerDebug.getX();
			
			if(x <= 1950)
				playerDebug.moveRight();
			else
				playerDebug.stopRight();
		}
		
		else{
			playerDebug.stopRight();
		}
		
		if(input.isKeyDown(Input.KEY_A)){
			
			float x = playerDebug.getX();
			
			if(x >= 0)
				playerDebug.moveLeft();
			
			else
				playerDebug.stopLeft();
			
			
		}
		
		else{
			playerDebug.stopLeft();
		}
		
		if(input.isKeyPressed(Input.KEY_W)){

			if(playerDebug.onGround){
				playerDebug.onGround = false;
				playerDebug.setVY(-500);
			}
			
		}
		
		if(input.isKeyDown(Input.KEY_Q)){
			float angle = playerDebug.getAngle();
			angle += 3.14/180;
			playerDebug.setAngle(angle);
			
			shotAngle = angle;
			
		}
		
		if(input.isKeyDown(Input.KEY_E)){
			float angle = playerDebug.getAngle();
			angle -= 3.14/180;
			playerDebug.setAngle(angle);
			
			shotAngle = angle;
			
		}
		
		if(input.isKeyDown(Input.KEY_SPACE)){
			
			int power = playerDebug.getPower();
			if(power<=50)
				power += 1;
			playerDebug.setPower(power);
			
		}
		
		else if(playerDebug.getPower()!=0){

			double velX = (playerDebug.getPower())*Math.cos(shotAngle);
			double velY = (playerDebug.getPower())*Math.sin(shotAngle);
			
			
			Projectile asd = new Projectile(playerDebug.getX(),playerDebug.getY(),-(float)velX/2,-(float)velY*25,10,10);
			
			Game.gs.physics.add(asd);
			Game.gs.objects.add(asd);
			Game.gs.numOfObj++;
			
			turn = (turn + 1) % Game.gs.getNumOfPlayers();
			
			playerDebug.setPower(0);
			
		}
		
	}
	
	public int getID(){
		return 3;
	}
	
}
