package pongpackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Paddle extends Collidable {
	
	private Color colour;
	private double directionX;
	private double directionY;

	
	public Paddle(Color colour, double posX, double posY)
	{
		this.colour = colour;
		this.posX = posX;
		this.posY = posY;
		this.height = 100;
		this.width = 10;
	}
	public void step() // collision
	{
		posX += directionX;
		posY += directionY;	
		
	}
	
	public void move(int direction)
	{
		posY += direction * 10;
	}
	
	public void changeColour()
	{
		colour = new Color((int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1));
	}
	
	public void point(Graphics g) {
        g.setColor(colour);
        g.fillRect((int)(posX),(int)(posY),width , height);
   
    }

}
