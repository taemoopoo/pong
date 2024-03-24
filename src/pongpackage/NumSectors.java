package pongpackage;

import java.awt.Graphics;

public class NumSectors {
	
	private int posX; 
    private int posY; 
    private int width;
    private int height;
    private boolean visible;
    
    public NumSectors(int posX, int posY, int width, int height, boolean visible)
    {
    	this.posX = posX;
    	this.posY = posY;
    	this.width = width;
    	this.height = height;
    	this.visible = false;
    }
    
    public boolean isVisible()
    {
    	return visible;
    }
    public void visbility(boolean input)
    {
    	visible = input;
    }
    public void point(Graphics g)
    {
    	if(visible)
    	{
    		g.fillRect(posX, posY, width, height);
    	}
    }

}
