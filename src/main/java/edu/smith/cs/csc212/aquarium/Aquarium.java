package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */



public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 * 
	 */
	// create new bubble
	Bubble bubble = new Bubble();
	Bubble [] bubbles = new Bubble[10];
	
	
	
	boolean move;
	
	
	
	
	
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
		

			

		for (int i=0; i<bubbles.length; i++) {
			
			bubbles[i] = new Bubble ();
			
			
		}
			
	
	}
	
	// creating new fishes
	Fish fish1 = new Fish(Color.cyan, true);
	Fish nemo = new Fish(Color.pink, false);
	Fish shark = new Fish(Color.black, false); // this is the predator named shark
	Fish blueFish = new Fish(Color.blue, true);
	Fish redFish = new Fish(Color.red, false);
	Fish yellowFish = new Fish(Color.yellow, false);
	Fish HungryFishy = new Fish(Color.magenta, false);
	
	

	
	
	int gr =255;
	int bl = 0;
	int r = 0;
	
	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		if (bl < 250) {
			
			this.gr -= 1;
			this.bl += 1;
			Color color = new Color(r, gr, bl);
			g.setColor(color);
			g.fillRect(0, 0, 500, 500);
			System.out.println(color);
			if (bl < 180) {
				algorithm.move();
				}else {
					algorithm.speedY = 0;
					algorithm.speedX = 0;// my snail memontariry stops
				}
			}
		
		
		else {
			while(gr < 150) {
				
			this.gr += 1;
			this.bl -= 1;
			Color colors = new Color(r, bl, gr);
			System.out.println(colors);
			g.setColor(colors);
			g.fillRect(0, 0, 500, 500);
		}}
		
		
		

		
		
		
		
		//Drawing the chest for bubbles
		g.setColor(Color.red);
		g.fillRect(250, 400, 100, 100);
		
		// Drawing the food
		g.setColor(Color.pink);
		g.fillOval(10,400, 100, 100);
		
		//Draw bubble
		bubble.draw(g);
		
		
	// Draw the fish!
	fish1.draw(g);
    nemo.draw(g);
	shark.draw(g);
	redFish.draw(g);
	yellowFish.draw(g);
	blueFish.draw(g);
	HungryFishy.isHungry();
	HungryFishy.draw(g);
		
		
			

		for (Bubble b:this.bubbles) {
			b.draw(g);
		}


		// Draw our snail!
		algorithm.draw(g);
		
		

}
		
		
			
//			if (bl <  240 && bl > 10) {
//				gr -= 1;
//				bl += 1;
//				Color color = new Color(r, gr, bl);
//				g.setColor(color);
//				g.fillRect(0, 0, getWidth(), getHeight());
//				System.out.print(color);
//			}
			
		
	
	
	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}
	}
	
