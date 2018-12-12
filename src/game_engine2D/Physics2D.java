/**
 * 
 */
package game_engine2D;

import java.util.ArrayList;

import processing.core.PVector;

/**
 * @author Rod Martin r.martin1@salford.ac.uk
 *
 */
public class Physics2D {
	public PVector velocity = new PVector(0,0);
	public BoxCollider2D boxCollider2D;
	float gravity = 0.1f;
	public boolean canJump = false;
	public boolean isGrounded = false;
	/**
	 * @param g
	 */
	public Physics2D() {
		
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see game_engine2D.GameComponent#start()
	 */

	public void start() {
		

	}

	/* (non-Javadoc)
	 * @see game_engine2D.GameComponent#update()
	 */

	public void update() {

		
		
		//if(this.boxCollider2D.checkCollision(_boundingBox))
	}
	public boolean checkCollisions(GameObject g, ArrayList<BoundingBox> objectList) {

		BoundingBox bBox = g.transform.WorldBoundingBox();
		
		
		
		for (BoundingBox bb: objectList) {
			
			if(bBox.left < bb.right && bBox.right > bb.left ) {//System.out.println(g.transform.size.y/2 +" "+ bb.objectSize);
				if(bBox.bottom > bb.bottom && bBox.top > bb.bottom) {
					velocity.y = 0;
					g.transform.position.y = bb.bottom - (g.transform.size.y/2 + bb.objectSize.y/2);
					isGrounded = true;
					canJump = true;
					return true;
					}
				

						
			}
			else {
				//isGrounded = false;
			}
		}
		return false;
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}
	public void jump(int force) {
		if(canJump) {
			velocity.y = -force;
			canJump = false;
			isGrounded = false;
		}
		
	}
	
	public void move(float force) {
		
		if (isGrounded) {
			velocity.x += force;
			
		}
}
	
	public void isGrounded() {
		canJump = true;
	}
	
	public void updatePos (GameObject g) {
		g.transform.position.y += velocity.y;
		g.transform.position.x += velocity.x;
	}
	
	public void gravityEffect() {
		if(isGrounded) return;
		velocity.y += gravity;
		if (velocity.y >= 4f) {
			velocity.y = 4f;
		}
	}


}
