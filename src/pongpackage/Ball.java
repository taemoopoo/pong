package pongpackage;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Collidable
{
	private double directionX;
	private double directionY;
	private Color colour;
	
	public Ball(Color colour, double posX, double posY)
	{
		this.colour = colour;
		this.posX = posX;
		this.posY = posY;
		this.directionX = 2.4;
		this.directionY = 2.4;
		this.width = 10;
		this.height = 10;

	}
	
	public void step()
	{
		posX += directionX;
		posY += directionY;	
		
		//bounce part
		//originally this would change posY
		
	}
	
	public void returnToZero(double sped)
	{
		posY = 295;
		posX = 395;
		directionX = ((Math.random() * 2) -1);
		if(directionX > 0)
		{
			directionX += 0.3;
		}
		else if(directionX < 0)
		{
			directionX -= 0.3;
		}
		directionY = ((Math.random() * 1) -0.5);
		double hypo = (Math.sqrt((Math.pow(directionX, 2) + Math.pow(directionY, 2))));
		directionX /= hypo;
		directionX *= sped;
		directionY /= hypo;
		directionY *= sped;
		//colour = new Color((int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1));
		
		//if I want the ball to go fast as fuck boi		
//		directionX = (int)(directionX - 1) * (Math.random() + 2);
//		directionY = (int)(directionY - 1) * (Math.random() + 2);
	}
	
	public double getPosY()
	{
		return posY;
	}
	public double getDirY()
	{
		return directionY;
	}
	public void changeDirY(double dirY)
	{
		this.directionY = dirY;
		//colour = new Color((int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1));
	}
	
	public void point(Graphics g) {
        g.setColor(colour);
        g.fillRect((int)(posX),(int)(posY),width , height); 
   
    }
	
	
	
	//temporary 
	public void changeDirX(double dirX)
	{
		this.directionX = dirX;
		//colour = new Color((int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1) , (int)(Math.random() * 255 + 0 - 1));
	}
	public double getPosX()
	{
		return posX;
	}
	public double getDirX()
	{
		return directionX;
	}
}
