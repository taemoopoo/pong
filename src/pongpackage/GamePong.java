package pongpackage;
import javax.swing.*;

import pongpackage.Window.Texas;

import java.awt.*;
import java.awt.event.*;


public class GamePong extends JPanel implements KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7506351305190591018L;
	
	public Wall top;
	public Wall bottom;
	public Wall back;
	public Paddle p1;
	public Paddle p2;
	public Ball pong;
	public ScoreBoard score;
	public Window w;
	public Wall sBack;
	
	public Timer timer;
	
	
	double sped = 8;
	int axis1 = 0;
	int axis2 = 0;
	int numOutOfBounds = 0;
	int in;
	
	
	
	public GamePong()
	{
		//name = new class( colour, posX, posY, length, width );
		setBounds(0, 0, Window.SIZE_W, Window.SIZE_H);
		back = new Wall(Color.BLACK, 0, 0, 800, 600);
		score = new ScoreBoard(0,0); 
		top = new Wall(Color.white , 0 , 0 , 800 , 25);
		bottom = new Wall(Color.white, 0, 535, 800, 25);
		pong = new Ball(Color.white, 395,295); //og: new Color(128,0,128)
		pong.returnToZero(sped);
		p1 = new Paddle(Color.white, 10, 250);
		p2 = new Paddle(Color.white, 765, 250);
		
	
		ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) 
            {
            	double newDirY = 0.0;
            	double newDirX = 0.0;
            	
            	//MAKE THE SCORE SUSTEM. HINT: MAKE A WAY TO DRAW THE SCORE & KEEP TRACK PS: THIS HINT SUCKS
            	
				pong.step();
				if(bottom.collision(pong))
				{
					 newDirY = Math.abs(pong.getDirY()) * -1;
					 pong.changeDirY(newDirY);
					 bottom.changeColour();
					 
					 
				}
				else if(top.collision(pong))
				{
					 newDirY = Math.abs(pong.getDirY());
					 pong.changeDirY(newDirY);
					 top.changeColour();
					 
				}
				else if(pong.getPosX() < 0 || pong.getPosX() > 775)
				{
					
					//back to origin
					if(pong.getPosX() < 0)
					{
						score.addPoint("p2");
					}
					else if(pong.getPosX() > 775)
					{
						score.addPoint("p1");
					}
					switch(score.check()) {
			    	case PONE:
			    		System.out.println("You like kissing boys don't you?");
			    		w.changeScreen(Texas.ENDSCREEN);
			    		break;
			    	case PTWO:
			    		System.out.println("What about MEN.");
			    		w.changeScreen(Texas.ENDSCREEN);
			    		break;
					}
			    		
					pong.returnToZero(sped);
					numOutOfBounds ++;
					if(numOutOfBounds % 3 == 0)
					{
						sped++;
						
					}
					System.out.println(score);
					
					//bounce off left
//					 newDirX = pong.getDirX() * -1;
//					 pong.changeDirX(newDirX);
				}
				else if (p1.collision(pong))
				{
					newDirX = pong.getDirX() * -1;
					 pong.changeDirX(newDirX);
					 p1.changeColour();
				}
				else if(p2.collision(pong))
				{
					newDirX = pong.getDirX() * -1;
					 pong.changeDirX(newDirX);
					 p2.changeColour();
				}
				
				if(axis1 > 0)
				{
					if (!bottom.collision(p1))
					{
						p1.move(axis1);
					}
				}
				else if(axis1 < 0)
				{
					if (!top.collision(p1))
					{
						p1.move(axis1);
					}
				}
				if(axis2 > 0)
				{
					if (!bottom.collision(p2))
					{
						p2.move(axis2);
					}
				}
				else if(axis2 < 0)
				{
					if (!top.collision(p2))
					{
						p2.move(axis2);
					}
				}
				
					
				repaint();
				
            }
        };
        
        
        timer = new Timer(17 ,taskPerformer);
        timer.setRepeats(true);
        timer.start();

        
		
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        back.point(g);
        score.point(g);
        top.point(g);
        bottom.point(g);
        pong.point(g);
        p1.point(g);
        p2.point(g);
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_W)
		{
			axis1 = -1;
			
		}
		else if(keyCode == KeyEvent.VK_S)
		{
			axis1 = 1;
			
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			axis2 = -1;
		
		}
		else if(keyCode == KeyEvent.VK_DOWN)
		{
			axis2 = 1;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_W)
		{
			axis1 = 0;
			
		}
		else if(keyCode == KeyEvent.VK_S)
		{
			axis1 = 0;
			
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			axis2 = 0;
		
		}
		else if(keyCode == KeyEvent.VK_DOWN)
		{
			axis2 = 0;
		}
		
	}

}
