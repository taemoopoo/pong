package pongpackage;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import pongpackage.StartScreen.State;

public class Window extends JFrame 
{
	
	enum Texas{
		PONG,
		START,
		ENDSTART,
		ENDSCREEN,
		CREDITS,
		QUIT
	}
	public Texas screen;
	public static final int SIZE_W = 800;
	public static final int SIZE_H = 600;
	public GamePong game;
	public StartScreen start;
	public EndScreen end;
	public Credits credit;
	
	
	
	
	public Window(Texas screen)
	{
		this.screen = screen;
		setTitle("The Most Amazin Game ever lmao");
		setSize(SIZE_W , SIZE_H);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        changingScreen(screen);
        
        
        
	}
	
	public void changeScreen(Texas screen)
	{
		if(screen == Texas.START)
		{
			this.remove(credit);
			
			
		}
		if(screen == Texas.ENDSTART)
		{
			this.remove(end);
		}
	    if(screen == Texas.CREDITS)
		{
			
			this.remove(start);
			
		}
	    if(screen == Texas.ENDSCREEN)
	    {
	    	this.remove(game);
	    	game.timer.stop();
	    }
	    changingScreen(screen);	
		this.repaint();
	}
	
	public void changingScreen(Texas screen)
	{
		switch(screen) {
    	case PONG:
    		
	        game = new GamePong();
	        game.addKeyListener(game);
	        game.w = this;
	        game.setFocusable(true);
	        add(game);
	        game.requestFocus(true);
	        this.setLocationRelativeTo(null);
	        break;
    	case START:
    		
    		start = new StartScreen();
    		start.addKeyListener(start);
    		start.w = this;
    		start.setFocusable(true);
    		this.add(start);
    		start.requestFocus(true);
    		this.setLocationRelativeTo(null);
    		this.setVisible(true);
    		this.setLayout(null);
    		
    		break;
    	case ENDSTART:
    		
    		start = new StartScreen();
    		start.addKeyListener(start);
    		start.w = this;
    		start.setFocusable(true);
    		this.add(start);
    		start.requestFocus(true);
    		this.setLocationRelativeTo(null);
    		this.setVisible(true);
    		this.setLayout(null);
    	case ENDSCREEN:
    		
    		end = new EndScreen(game.score.check());
    		end.addKeyListener(end);
    		end.w = this;
    		end.setFocusable(true);
    		this.add(end);
    		end.requestFocus(true);
    		this.setLocationRelativeTo(null);
    		this.setVisible(true);
    		this.setLayout(null);
    		break;
    	case CREDITS:
    		
    		
    		credit = new Credits();
    		credit.addKeyListener(credit);
    		credit.w = this;
    		credit.setFocusable(true);
    		this.add(credit);
    		credit.requestFocus(true);
    		this.setLocationRelativeTo(null);
    		this.setVisible(true);
    		this.setLayout(null);
    		break;
    	case QUIT:
    		
		}	
	}
	
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(() -> {
             new Window(Texas.START);
        });
		
		
    


			

	}
	
}
