package pongpackage;

import java.awt.Color;
import java.awt.Graphics;

public class ScoreBoard {
	
	private int p1Score;
	private int p2Score;
	private double posX; //general AREA of where the numbers be.
    private double posY; //^^
    private double width;
    private double height;
    
    final private boolean[][] VISIBILITY;
    
    private NumSectors[] segments;
    private NumSectors[] segments2;
	
	
	public ScoreBoard(double posX, double posY) 
	{
		 this.posX = posX;
		 this.posY = posY;
		 p1Score = 0;
		 p2Score = 0;
		 VISIBILITY = new boolean[][] {{true,true,true,false,true,true,true} , {false,false,true,false,false,true,false} , {true, false, true, true, true, false, true} , {true, false, true, true, false, true, true} , {false, true, true, true, false, true, false} , {true, true, false, true, false, true, true} , {true, true, false, true, true, true, true} , {true, false, true, false, false, true, false} , {true, true, true, true, true, true, true} , {true, true, true, true, false, true, true} };
		 segments = new NumSectors[] { new NumSectors(91, 33, 64, 9, false) , new NumSectors(82, 40, 9, 64, false) , new NumSectors(155, 40, 9, 64, false), new NumSectors(91, 104, 64, 9, false), new NumSectors(82, 113, 9, 64, false) ,new NumSectors(155, 113, 9, 64, false), new NumSectors(91, 176, 64, 9, false)};
		 segments2 = new NumSectors[] { new NumSectors(645 -  64, 33, 64, 9, false) , new NumSectors(636 - 64, 40, 9, 64, false) , new NumSectors(155 + 490, 40, 9, 64, false), new NumSectors(91 + 490, 104, 64, 9, false), new NumSectors(82 + 490, 113, 9, 64, false) ,new NumSectors(155 + 490, 113, 9, 64, false), new NumSectors(91 + 490, 176, 64, 9, false)};
	} //0,1,2,3,4,5,6,7
	
	public void point(Graphics g)
	{
		 g.setColor(Color.white); //zigzag pattern
		
		 for(int i = 0; i < 7; i++)
		 {
		 	segments[i].visbility(VISIBILITY[p1Score % 10][i]);
		 	segments2[i].visbility(VISIBILITY[p2Score % 10][i]);
		 	segments[i].point(g);
		 	segments2[i].point(g);
		 }
		
//		NumSectors segOne = new NumSectors(91, 33, 64, 9, false);	
//		NumSectors segTwo = new NumSectors(82, 40, 9, 64, false);	
//		NumSectors segThree = new NumSectors(155, 40, 9, 64, false);	
//		NumSectors segFour = new NumSectors(91, 104, 64, 9, false);
//		NumSectors segFive = new NumSectors(82, 113, 9, 64, false);
//		NumSectors segSix = new NumSectors(155, 113, 9, 64, false);
//		NumSectors segSeven = new NumSectors(91, 176, 64, 9, false);	

		
		
	}
	
	public void addPoint(String player)
	{
		 
		 if(player.equalsIgnoreCase("p1"))
		 {
			p1Score++;
			
				
		 }
		 else if(player.equalsIgnoreCase("p2"))
		 {
			p2Score++;
		 }
	}
	public EndScreen.Ohio check()
	{
		 if(p1Score == 1)
		 {
			return EndScreen.Ohio.PONE;
		 }
		 if(p2Score == 1000000)
		 {
			return EndScreen.Ohio.PTWO;
		 }
		 return EndScreen.Ohio.LBOZO;
	}
	@Override
	public String toString()
	{
	   return "P1: " + p1Score + " | P2: " + p2Score;
	}
}
