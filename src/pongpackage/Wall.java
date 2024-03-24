package pongpackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Wall extends Collidable{
	
	private Color colour;
	
	
	
	
	public Wall(Color colour, int x, int y, int width, int height)
	{
		this.colour = colour;
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
	}
	
	public int getNormForce()
	{
		return 0;
	}
	
	public void changeColour()
	{
		colour = new Color((int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1));
	}
	

    public void point(Graphics g) {
        g.setColor(colour);
        g.fillRect((int)(posX),(int)(posY),width,height);
   
    }

}
