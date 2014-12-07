package javagame;

import java.net.InetAddress;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


/*
 * Ref: Joseph Anthony C. Hermocilla
 * 
 */
public class Player implements PhysicsObj{

	private float x, y;
	
	private float velX, velY;
	
	private float height, width;
	private float angle;
	private int power;
	
	private InetAddress address;
	private int port;
	
	private String name;
	
	public boolean onGround = false;
	public boolean topBlocked = false;
	
	private boolean goLeft = false;
	private boolean goRight = false;
	
	public boolean isLeft = true;
	
	int[] duration = {200,200};
	public Image moveLeft, moveRight, sprite;
	
	int health;
	
	public Player(String name, InetAddress address, int port){
		this.name = name;
		this.address = address;
		this.port = port;
		
		health = 1000;
		
	}
	
	public Player(String name, float x, float y, float width, float height, boolean isLeft){
		this.name = name;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.angle = 0;
		this.power = 0;
		
		
		this.isLeft = isLeft;
		
		health = 1000;
		
		try{
			
			moveLeft = new Image("res/spriteleft.png");
			moveRight = new Image("res/spriteright.png");
			
			sprite = moveLeft;
		} catch(Exception e){}
		
	}
	
	public InetAddress getAddress(){
		return address;
	}
	
	public int getPort(){
		return port;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getVX() {
		return velX;
	}

	public float getVY() {
		return velY;
	}
	
	public float getHeight(){
		return height;
	}
	
	public float getWidth(){
		return width;
	}

	public void setX(float pX) {
		this.x = pX;
	}

	public void setY(float pY) {
		this.y = pY;
	}

	public void setVX(float vX) {
		this.velX = vX;
	}

	public void setVY(float vY) {
		this.velY = vY;
	}
	
	public void setAngle(float angle){
		this.angle = angle;
	}
	public float getAngle(){
		return angle;
	}
	
	public void setPower(int power){
		this.power = power;
	}
	public int getPower(){
		return power;
	}
	
	public void moveRight(){
		goRight = true;
		sprite = moveRight;
	}
	
	public void moveLeft(){
		goLeft = true;
		sprite = moveLeft;
	}
	
	public void stopRight(){
		goRight = false;
	}
	
	public void stopLeft(){
		goLeft = false;
	}

	public void checkConstraints() {
		
	    if (goRight) {
	    	velX = 3;
	    }
	    
	    else if(velX > 0){
	    	velX -= 1;
	    }
	    
	    if (goLeft) {
	    	velX = -3;
	    }
	    
	    else if(velX < 0){
	    	velX += 1;
	    }
		
		onGround = false;
		topBlocked = false;
		
		if(y>=1100){
		
			for(int i = (int)(x - width/2);i < x + width/2; i++){
				if(Game.gs.terrain.isSolid(i, (int)(y + height/2))){
					
					onGround = true;
					
					for(int j = (int)(y + height/4); j < (int)(y + height/2); j++){
						
						if(Game.gs.terrain.isSolid(i,j)){
							
							y = j - height/2;
							break;
							
						}
						
					}
					
					if(velY > 0)
						velY *= -0.25f;
					
				}
			}

			
		    // start with the top edge
		    for (int i = (int)(x - width/2); i <= (int)(x + width/2); i++) {
		      if (Game.gs.terrain.isSolid(i, (int)(y - height/2 - 1))) { // if the pixel is solid
		        topBlocked = true;
		        if (velY < 0) {
		          velY *= -0.5f; 
		        }
		        
		      } 
		    }
		    
		    
		    
		 
		    
		
		}
		
	}
	
}
