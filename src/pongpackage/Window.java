package pongpackage;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	public JPanel currentScreen;
	
	
	
	
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
		if(currentScreen instanceof GamePong)
		{
			GamePong game = (GamePong)currentScreen;
			game.timer.stop();
		}
		this.remove(currentScreen);
	    changingScreen(screen);	
		this.repaint();
	}
	
	public void changingScreen(Texas screen)
	{
		switch(screen) {
    	case PONG:
	        currentScreen = new GamePong();
	        ((GamePong)currentScreen).addKeyListener((GamePong)currentScreen);
	        ((GamePong)currentScreen).w = this;
	        currentScreen.setFocusable(true);
	        add(currentScreen);
	        currentScreen.requestFocus(true);
	        this.setLocationRelativeTo(null);
	        break;
    	case START:
		case ENDSTART:
    		currentScreen = new StartScreen();
    		((StartScreen)currentScreen).addKeyListener((StartScreen)currentScreen);
    		((StartScreen)currentScreen).w = this;
    		currentScreen.setFocusable(true);
    		this.add(currentScreen);
    		currentScreen.requestFocus(true);
    		this.setLocationRelativeTo(null);
    		this.setVisible(true);
    		this.setLayout(null);
    		break;
    	case ENDSCREEN:
    		System.out.print(" Endscreen");
    		currentScreen = new EndScreen(((GamePong)currentScreen).score.check());
    		((EndScreen)currentScreen).addKeyListener((EndScreen)currentScreen);
    		((EndScreen)currentScreen).w = this;
    		currentScreen.setFocusable(true);
    		this.add(currentScreen);
    		currentScreen.requestFocus(true);
    		this.setLocationRelativeTo(null);
    		this.setVisible(true);
    		this.setLayout(null);
    		break;
    	case CREDITS:
    		System.out.print(" credits");
    		currentScreen = new Credits();
    		((Credits)currentScreen).addKeyListener((Credits)currentScreen);
    		((Credits)currentScreen).w = this;
    		currentScreen.setFocusable(true);
    		this.add(currentScreen);
    		currentScreen.requestFocus(true);
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
