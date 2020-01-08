package edu.smith.cs.csc212.aquarium;

import java.awt.Color;

import java.awt.Graphics2D;
import java.util.Random;


public class Fish {
	//Color of every fish
	Color color;
	
	//every Fish has a size
	boolean isLittle;
	boolean Hungry = false;
	// position of every fish
	Random rand = new Random();
	int x;
	int y;
	int destX;
	int destY;
	int speedX;
	int speedY;
	
	//position for the predator
	int predesY;
	int predstX;
	
//	boolean moving;
	boolean facingLeft;
	
	boolean facingRight;
	
	boolean moving;
	
	//mark hungry fish
	public void isHungry() {
		this.Hungry = true;
	}
	
	// construct a fish at position with color
	public void HungryFish() {
		
		
		if (10<= this.x && this.x <= 150 && this.y>=400) {
			this.color = Color.white;
			
		}
		else if (this.y < 200) {
			this.color = Color.red;
			this.destX = rand.nextInt(100);
			this.destY = rand.nextInt(500-400) + 400;
			
		}
		else {
			this.color = Color.orange;
		}
		
	}
	
	public Fish(Color c, boolean isLittle) {
		this.color = c;
		
		this.isLittle = isLittle;
		
		Random rand = new Random();
		this.destX = rand.nextInt(500);
		this.destY = rand.nextInt(500);
		this.x = rand.nextInt(Aquarium.WIDTH);
		this.y = rand.nextInt(Aquarium.HEIGHT);
		
		this.speedX = 1;
		this.speedY = 1;
//		this.moving = false;
		
	}
	 
	
	public void draw(Graphics2D window) {
		this.swim();
		if(this.Hungry) {
			HungryFish();
		}

			DrawFish.smallFacingRight(window, this.color, this.x, this.y);
//		}
//		else {
//			DrawFish.facingRight(window, this.color, this.x, this.y);
//		}
//		
		
		
		if (this.facingLeft ) {
			//DrawFish.smallFacingRight(window, this.color, this.x, this.y);
			 
			//DrawFish.facingRight(window, this.color, this.x, this.y);
			DrawFish.facingLeft(window, this.color, this.x, this.y);

		}
		
		else {
			
			DrawFish.facingRight(window, this.color, this.x, this.y);
		}
		
	}
	 
	 public void swim() {
//		 this.x -= 1;
//		 this.y -=1;
	 if (this.destY > 450 || this.destY < 10 ) {
			this.destY = rand.nextInt(Aquarium.WIDTH);}
	if (this.destX < 50 || this.destX > 490) {
					this.destX = rand.nextInt(Aquarium.WIDTH);}
			
		 
		 if (this.x  + this.speedX < this.destX  ) {
		 facingLeft = false;
		 this.x += this.speedX;
		 }
		 else if (this.y + this.speedY > this.destY) {
			 this.y -= this.speedY;
		 }
		 
		 if(this.x  + this.speedX > this.destX ){
		 facingLeft = true;
		 this.x -= this.speedX; }
		 else if(this.y + this.speedY < this.destY) {
			 this.y += this.speedY;
			 }
		// Creating a random destination
		 if ((Math.abs(this.destX-this.x)<= this.speedX) && (Math.abs(this.destY - this.y)<= this.speedY )){
			 this.destX = rand.nextInt(500)-50;
//			 if (this.destX >Aquarium.WIDTH) {
//				 System.out.println(destX);
//			 }
//			 this.destY = rand.nextInt(500)-50;
//			 if (this.destY >Aquarium.WIDTH) {
//				 System.out.println(destY);
//			 }
		 }}
		 
			 
			 
			 
		 }
	 
