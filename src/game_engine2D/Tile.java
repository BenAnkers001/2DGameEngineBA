/**
 * 
 */
package game_engine2D;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * @author rod martin r.martin1@salford.ac.uk
 *
 */
public class Tile extends Sprite {

	int strokeColour;
	int fillColour;
	public Tile(PApplet p, int x, int y, int w, int h) {
		super(p, x, y);
		this.transform.size.x = w;
		this.transform.size.y = h;
		this.strokeColour = parent.color(255, 255, 255);
		this.fillColour = parent.color(0, 0, 0);
		bBox = new BoundingBox();
		this.transform.boundingBox.fromSize(this.transform.size);
		
	}

	@Override
	public void start() {
		super.start();
		
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		super.render();
		parent.pushMatrix(); // reset the translation and rotation
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rectMode(PConstants.CENTER);
		parent.rect(0, 0, this.transform.size.x, this.transform.size.y);
		//System.out.println(this.transform.boundingBox.top);
		parent.popMatrix();
	}
}
