/**
 * 
 */
package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Player extends Sprite {
	float speed = 3f;
	float gravity = 0.1f;
	public PVector size = new PVector(12,12);
	public int stroke = parent.color(120,120,255);
	public int fill = parent.color(255);
	public BoundingBox bBox;
	public boolean isMovingLeft = false;
	public boolean isMovingRight = false;
	/**
	 * @param p
	 */
	public Player(PApplet p) {
		super(p);
		
		// TODO Auto-generated constructor stub
	}
	 public Player(PApplet p, float x, float y, float w, float h) {
	        super(p);
	        speed = 3.0f;
	        bBox = new BoundingBox();
			this.transform.boundingBox.fromSize(size);
	    }
	 public void start() {
		 this.transform.position.x = (parent.width / 2);
		 this.transform.position.y = (parent.height / 2);
		 this.transform.boundingBox.fromSize(size);
		 this.physics = new Physics2D();
		 this.transform.size = size;
	 }
	 public void checkCollisions(BoundingBox bb) {
		 //this.physics.checkCollisions(bb);
	 }
	/* (non-Javadoc)
	 * @see game_engine2D.Sprite#update()
	 */
	@Override
	public void update() {
		
		//System.out.println(this.isMovingRight);

		System.out.println(this.physics.isGrounded);

	}
	@Override
	public void render(){
		super.render();
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rectMode(PConstants.CORNERS);
		parent.fill(0,255,0);
		parent.rect(this.transform.position.x + this.transform.boundingBox.left, this.transform.position.y + this.transform.boundingBox.bottom, this.transform.position.x + this.transform.boundingBox.right, this.transform.position.y + this.transform.boundingBox.top);

	}
	 public void keyPressed(char key, int keyCode) {
	    	//mapped key pressed
		 if (key == 'w') {
			 this.physics.jump(4);
			 System.out.println("Jumping");
		 }
		 
		 if (key == 'd' && !isMovingRight) {
			 this.physics.move(speed);
			 System.out.println("Right");
			 isMovingRight = true;
		 }
			 
		 if (key == 'a' && !isMovingLeft) {
			 this.physics.move(-speed);
			 System.out.println("Left");
			 isMovingLeft = true;
		 }
		 		 
	    }
	 public void keyReleased(char key, int keyCode) {
		 
		 if (key == 'd' && isMovingRight) {
			 this.physics.velocity.x = 0;
			 System.out.println(" Stop Right ");
			 isMovingRight = false;
		 
	 }
		 if (key == 'a' && isMovingLeft) {
			 this.physics.velocity.x = 0;
			 System.out.println(" Stop Left ");
			 isMovingLeft = false;
		 
	 }
 	}
}