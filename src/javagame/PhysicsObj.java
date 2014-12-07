package javagame;

import org.newdawn.slick.SlickException;

public interface PhysicsObj {

	public float getX();
	public float getY();
	public float getVX();
	public float getVY();
	
	public float getHeight();
	public float getWidth();
	
	public void setX(float pX);
	public void setY(float pY);
	public void setVX(float vX);
	public void setVY(float vY);
	public void checkConstraints() throws SlickException;
	
}
