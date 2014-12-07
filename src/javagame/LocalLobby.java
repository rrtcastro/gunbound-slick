package javagame;

import javax.swing.SpringLayout.Constraints;

import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Display;
import mdes.slick.sui.Label;
import mdes.slick.sui.TextField;
import mdes.slick.sui.event.MouseEvent;
import mdes.slick.sui.event.MouseListener;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LocalLobby extends BasicGameState{

	UnicodeFont font;
	String mouse = "Mouse coords: 0,0";
	String pixel = "Pixel coords: 0,0";
	StateBasedGame main;
	GameContainer gamecon;
	static PreGameState pgs;
	
	static Label characterImage1;
	static Label characterImage2;
	static Label characterImage3;
	static Label characterImage4;
	
	static Label char1;
	static Label char2;
	static Label char3;
	static Label char4;
	
	TextField characterName1;
	TextField characterName2;
	TextField characterName3;
	TextField characterName4;
	
	private Display display;
	
	public LocalLobby(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		pgs = new PreGameState();
		
		main = sbg;
		gamecon = gc;
		font = Game.getNewFont("Arial" , 16);
		
		display = new Display(gc);
		
		Container mainPane = new Container();
		mainPane.setSize(Game.width - 40, Game.height - 40);
		mainPane.setOpaque(true); //ensures that the background is drawn
		mainPane.setBackground(Game.lightBlue); //sets the background color
		mainPane.setLocation(20, 20);
		
		Container characterPane1 = new Container();
		characterPane1.setSize(170,170);
		characterPane1.setLocation(10, 20);
		characterPane1.setOpaque(true);
		characterPane1.setBackground(Game.darkBlue);
		
		characterImage1 = new Label("");
		characterImage1.setImage(new Image("res/sprites/sprite1-right.png"));
		characterImage1.setOpaque(false);
		characterImage1.setLocation(50, 50);
		characterImage1.setSize(70, 70);
		
		characterPane1.add(characterImage1);
		
		Container characterPane2 = new Container();
		characterPane2.setSize(170,170);
		characterPane2.setLocation(200, 20);
		characterPane2.setOpaque(true);
		characterPane2.setBackground(Game.darkBlue);
		
		characterImage2 = new Label("");
		characterImage2.setImage(new Image("res/sprites/sprite1-right.png"));
		characterImage2.setOpaque(false);
		characterImage2.setLocation(50, 50);
		characterImage2.setSize(70, 70);
		
		characterPane2.add(characterImage2);
		
		Container characterPane3 = new Container();
		characterPane3.setSize(170,170);
		characterPane3.setLocation(390, 20);
		characterPane3.setOpaque(true);
		characterPane3.setBackground(Game.darkBlue);
		
		characterImage3 = new Label("");
		characterImage3.setOpaque(false);
		characterImage3.setLocation(50, 50);
		characterImage3.setSize(70, 70);
		
		characterPane3.add(characterImage3);
		
		Container characterPane4 = new Container();
		characterPane4.setSize(170,170);
		characterPane4.setLocation(580, 20);
		characterPane4.setOpaque(true);
		characterPane4.setBackground(Game.darkBlue);
		
		characterImage4 = new Label("");
		characterImage4.setOpaque(false);
		characterImage4.setLocation(50, 50);
		characterImage4.setSize(70, 70);
		
		characterPane4.add(characterImage4);
	
		Label char1left = new Label("");
		char1left.setImage(new Image("res/button-left.jpg"));
		char1left.setOpaque(false);
		char1left.setLocation(10, 190);
		char1left.setSize(35, 35);
		char1left.addMouseListener(new ChangeSpriteToTheLeft(char1, characterImage1, pgs.getSprites(), pgs.getSpriteNames(), 0));
		
		char1 = new Label("ADUKA");
		char1.setOpaque(true);
		char1.setLocation(50, 200);
		char1.setSize(90, 20);
		char1.setForeground(Color.black);
		
		Label char1right = new Label("");
		char1right.setImage(new Image("res/button-right.jpg"));
		char1right.setOpaque(false);
		char1right.setLocation(145, 190);
		char1right.setSize(35, 35);
		char1right.addMouseListener(new ChangeSpriteToTheRight(char1, characterImage1, pgs.getSprites(), pgs.getSpriteNames(), 0));
		
		Label char2left = new Label("");
		char2left.setImage(new Image("res/button-left.jpg"));
		char2left.setOpaque(false);
		char2left.setLocation(200, 190);
		char2left.setSize(35, 35);
		char2left.addMouseListener(new ChangeSpriteToTheLeft(char2, characterImage2, pgs.getSprites(), pgs.getSpriteNames(), 1));
		
		char2 = new Label("ADUKA");
		char2.setOpaque(true);
		char2.setLocation(240, 200);
		char2.setSize(90, 20);
		char2.setForeground(Color.black);
		
		Label char2right = new Label("");
		char2right.setImage(new Image("res/button-right.jpg"));
		char2right.setOpaque(false);
		char2right.setLocation(335, 190);
		char2right.setSize(35, 35);
		char2right.addMouseListener(new ChangeSpriteToTheRight(char2, characterImage2, pgs.getSprites(), pgs.getSpriteNames(), 1));
		
		
		Label char3left = new Label("");
		char3left.setImage(new Image("res/button-left.jpg"));
		char3left.setOpaque(false);
		char3left.setLocation(390, 190);
		char3left.setSize(35, 35);
		char3left.addMouseListener(new ChangeSpriteToTheLeft(char3, characterImage3, pgs.getSprites(), pgs.getSpriteNames(), 2));
		
		char3 = new Label("----------------");
		char3.setOpaque(true);
		char3.setLocation(430, 200);
		char3.setSize(90, 20);
		char3.setForeground(Color.black);
		
		Label char3right = new Label("");
		char3right.setImage(new Image("res/button-right.jpg"));
		char3right.setOpaque(false);
		char3right.setLocation(525, 190);
		char3right.setSize(35, 35);
		char3right.addMouseListener(new ChangeSpriteToTheRight(char3, characterImage3, pgs.getSprites(), pgs.getSpriteNames(), 2));
		
		
		Label char4left = new Label("");
		char4left.setImage(new Image("res/button-left.jpg"));
		char4left.setOpaque(false);
		char4left.setLocation(580, 190);
		char4left.setSize(35, 35);
		char4left.addMouseListener(new ChangeSpriteToTheLeft(char4, characterImage4, pgs.getSprites(), pgs.getSpriteNames(), 3));
		
		char4 = new Label("----------------");
		char4.setOpaque(true);
		char4.setLocation(620, 200);
		char4.setSize(90, 20);
		char4.setForeground(Color.black);
		
		Label char4right = new Label("");
		char4right.setImage(new Image("res/button-right.jpg"));
		char4right.setOpaque(false);
		char4right.setLocation(715, 190);
		char4right.setSize(35, 35);
		char4right.addMouseListener(new ChangeSpriteToTheRight(char4, characterImage4, pgs.getSprites(), pgs.getSpriteNames(), 3));
		
		
		characterName1 = new TextField(140);
		characterName1.setSize(170, 30);
		characterName1.setLocation(10, 250);
		characterName1.setText("Player 1");
		
		characterName2 = new TextField(140);
		characterName2.setSize(170, 30);
		characterName2.setLocation(200, 250);
		characterName2.setText("Player 2");
		
		characterName3 = new TextField(140);
		characterName3.setSize(170, 30);
		characterName3.setLocation(390, 250);
		characterName3.setText("Player 3");
		
		characterName4 = new TextField(140);
		characterName4.setSize(170, 30);
		characterName4.setLocation(580, 250);
		characterName4.setText("Player 4");
		
		Container mapcontainer = new Container();
		Label map = new Label("res/map-ice.png");
		map.setImage(new Image("res/map-ice550-260.png"));
		map.setSize(550,260);
		map.setLocation(0, 0);
		mapcontainer.setBackground(Color.gray);
		
		map.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("asdasd");
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
		
		mapcontainer.setSize(550, 260);
		mapcontainer.setLocation(10, 290);
		mapcontainer.setOpaque(true);
		mapcontainer.add(map);
		
		Button start = new Button("Start");
		start.setLocation(580, 290);
		start.setSize(170, 260);
		
		start.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				try{
				Game.gs = new GameState("res/map-ice.png",0);
				} catch(Exception e){}
				for(int i = 0; i < 4; i++){
					
					if(pgs.getIfPlayer(i)){
						
						String playername = "";
						switch(i){
							case 0:
								playername = characterName1.getText();
								break;
							case 1:
								playername = characterName2.getText();
								break;
							case 2:
								playername = characterName3.getText();
								break;
							case 3:
								playername = characterName4.getText();
								break;
						}
						
						Player player = new Player(playername,400,1300,65,65,true);
						Game.gs.update(playername, player);
						
					}
					
				}
				
				main.enterState(3);
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
		
		mainPane.add(characterPane1);
		mainPane.add(characterPane2);
		mainPane.add(characterPane3);
		mainPane.add(characterPane4);
		
		mainPane.add(char1left);
		mainPane.add(char1);
		mainPane.add(char1right);
		
		mainPane.add(char2left);
		mainPane.add(char2);
		mainPane.add(char2right);
		
		mainPane.add(char3left);
		mainPane.add(char3);
		mainPane.add(char3right);
		
		mainPane.add(char4left);
		mainPane.add(char4);
		mainPane.add(char4right);
		
		mainPane.add(characterName1);
		mainPane.add(characterName2);
		mainPane.add(characterName3);
		mainPane.add(characterName4);
		
		mainPane.add(mapcontainer);
		
		mainPane.add(start);
		
		display.add(mainPane);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		
		display.render(gc, g);
		
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
		return 4;
	}
	
}

class ChangeSpriteToTheLeft implements MouseListener{

	int index;
	Label stringLabel;
	Label imageLabel;
	String[] sprites;
	String[] names;

	public ChangeSpriteToTheLeft(Label label1, Label label2, String[] sprites, String[] names, int index){
		this.index = index;
		this.stringLabel = label1;
		this.imageLabel = label2;
		this.sprites = sprites;
		this.names = names;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		LocalLobby.pgs.setSpriteDecrease(index);
		
		int temp = LocalLobby.pgs.getSprite(index);
		if(temp != -1){
			
			switch(index){
			
				case 0:
					LocalLobby.char1.setText(names[temp]);
					try {
						LocalLobby.characterImage1.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 1:
					LocalLobby.char2.setText(names[temp]);
					try {
						LocalLobby.characterImage2.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					LocalLobby.char3.setText(names[temp]);
					try {
						LocalLobby.characterImage3.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					LocalLobby.char4.setText(names[temp]);
					try {
						LocalLobby.characterImage4.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
			
			}
		
		}
		else{
			
			switch(index){
				
				case 0:
					LocalLobby.char1.setText("------------");
					try {
						LocalLobby.characterImage1.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 1:
					LocalLobby.char2.setText("------------");
					try {
						LocalLobby.characterImage2.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					LocalLobby.char3.setText("------------");
					try {
						LocalLobby.characterImage3.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					LocalLobby.char4.setText("------------");
					try {
						LocalLobby.characterImage4.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
			}
	
		}
		
	}
	
}

class ChangeSpriteToTheRight implements MouseListener{

	int index;
	Label stringLabel;
	Label imageLabel;
	String[] sprites;
	String[] names;
	
	public ChangeSpriteToTheRight(Label label1, Label label2, String[] sprites, String[] names, int index){
		this.index = index;
		this.stringLabel = label1;
		this.imageLabel = label2;
		this.sprites = sprites;
		this.names = names;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		LocalLobby.pgs.setSpriteIncrease(index);
		
		int temp = LocalLobby.pgs.getSprite(index);
		if(temp != -1){
			
			switch(index){
			
				case 0:
					LocalLobby.char1.setText(names[temp]);
					try {
						LocalLobby.characterImage1.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 1:
					LocalLobby.char2.setText(names[temp]);
					try {
						LocalLobby.characterImage2.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					LocalLobby.char3.setText(names[temp]);
					try {
						LocalLobby.characterImage3.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					LocalLobby.char4.setText(names[temp]);
					try {
						LocalLobby.characterImage4.setImage(new Image("res/sprites/" + sprites[temp] + "-right.png"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
			
			}
		
		}
		else{
			
			switch(index){
				
				case 0:
					LocalLobby.char1.setText("------------");
					try {
						LocalLobby.characterImage1.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 1:
					LocalLobby.char2.setText("------------");
					try {
						LocalLobby.characterImage2.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					LocalLobby.char3.setText("------------");
					try {
						LocalLobby.characterImage3.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					LocalLobby.char4.setText("------------");
					try {
						LocalLobby.characterImage4.setImage(new Image("res/button-left.jpg"));
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
			}
	
		}
	}
	
}