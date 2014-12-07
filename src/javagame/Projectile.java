package javagame;

import org.newdawn.slick.SlickException;

public class Projectile implements PhysicsObj {

	private float x, y;
	
	private float velX, velY;
	
	private float height, width;
	
	public Projectile(float x, float y, float velX, float velY, float width, float height){
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getVX() {
		return velX;
	}

	@Override
	public float getVY() {
		return velY;
	}
	
	public float getHeight(){
		return height;
	}
	
	public float getWidth(){
		return width;
	}

	@Override
	public void setX(float pX) {
		this.x = pX;
	}

	@Override
	public void setY(float pY) {
		this.y = pY;
	}

	@Override
	public void setVX(float vX) {
		this.velX = vX;
	}

	@Override
	public void setVY(float vY) {
		this.velY = vY;
	}

	@Override
	public void checkConstraints() throws SlickException{
		
		if(y>=1100){
			
			for(int i = (int)(x - width/2); i < (int)(x + width/2); i++){
			
				if(Game.gs.terrain.isSolid(i,(int)( y - height/2))){
					Game.gs.objects.remove(this);
					Game.gs.numOfObj--;
						
					Physics.remove(this);
					
					Play.explode(i,(int)( y - height/2),20);
					
					return;
						
				}
				
				else if(Game.gs.terrain.isSolid(i,(int)( y + height/2))){
					Game.gs.objects.remove(this);
					Game.gs.numOfObj--;
						
					Physics.remove(this);
					
					Play.explode(i,(int)( y + height/2),20);
					
					return;
						
				}
				
			}
			
			for(int j = (int)(y - height/2); j < (int)(y	 + height/2); j++){
			
				if(Game.gs.terrain.isSolid((int)( x - width/2),j)){
					Game.gs.objects.remove(this);
					Game.gs.numOfObj--;
						
					Physics.remove(this);
					
					Play.explode((int)( x - width/2),j,20);
					
					return;
						
				}
				
				else if(Game.gs.terrain.isSolid((int)( x + width/2),j)){
					Game.gs.objects.remove(this);
					Game.gs.numOfObj--;
						
					Physics.remove(this);
					
					Play.explode((int)( x + width/2),j,20);
					
					return;
						
				}
				
			}
		}
	}

}
