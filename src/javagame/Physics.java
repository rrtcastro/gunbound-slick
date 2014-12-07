package javagame;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;

public class Physics {
	
	final float gravity = (float)980;
	
	public static List<PhysicsObj> objects;
	public static int num;
	
	PhysicsObj obj;
	
	long currentTime, previousTime = 0;
	
	public Physics(){
		objects = new ArrayList<PhysicsObj>();
		num = 0;
	}
	
	public void add(PhysicsObj object){
		
		objects.add(object);
		
		num += 1;
		
	}
	
	public static void remove(PhysicsObj object){
		
		objects.remove(object);
		
		num -= 1;
		
	}
	
	public void update() throws SlickException{
		
		for(int i = 0; i < num; i++){
			
			obj = objects.get(i);
			
			float vY = obj.getVY();
			float vX = obj.getVX();
			float y = obj.getY();
			
			vY += gravity/60;
			obj.setVY(vY);
			
			obj.setX(obj.getX() + vX);
			
			if(obj instanceof Player){
				if(!(((Player) obj).onGround && vY > 0))
					obj.setY((float)(y + vY/60.0));
			}
			
			else{
				obj.setY((float)(y + vY/60.0));
			}
			
			obj.checkConstraints();
			
		}
		
	}
	
}
