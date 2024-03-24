/**
 * 
 */
package pongpackage;

/**
 * @author Taewoo
 *
 */
public class Collidable {
	
	protected double posX;
	protected double posY;
	protected int width;
	protected int height;
	
	
	public boolean collision(Collidable col)
	{
		double pain[][] = new double[4][2];
		for(int x = 0; x < 2; x++) //Big
		{
			for(int y = 0; y < 2; y++)
			{
				pain[x + 2 * y][0] = col.getPosX() + x * col.getWidth(); 
				pain[x + 2 * y][1] = col.getPosY() + y * col.getHeight();
			}
		}
		for(int i = 0; i < 4; i++) //Small
		{
			
			if(pain[i][0] > posX && pain[i][1] > posY && pain[i][0] < posX + width && pain[i][1] < posY + height ) // top left 
			{
				
				return true;
			}
			
		}
		return false;
	}
	
	
	public double getPosY()
	{
		return posY;
	}
	public double getPosX()
	{
		return posX;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}

}
