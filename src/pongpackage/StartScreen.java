package pongpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import pongpackage.Window.Texas;

public class StartScreen extends JPanel implements KeyListener
{	
	enum State{
		START,
		CREDITS,
		PONG,
		QUIT
	}
	private State arrow;
	private static final long serialVersionUID = 8871346110567855410L;
	public JLabel gameTitle;
	public JLabel startOption;
	public JLabel creditOption;
	public JLabel quit;
	public Window w;
	public boolean begin;
	
	
	
	public StartScreen()
	{
		System.out.print(" start");
		begin = false;
		setBounds(0, 0, Window.SIZE_W, Window.SIZE_H);
		arrow = arrow.START;
		this.setBackground(Color.black);
		this.setLayout(null);
		gameTitle = new JLabel("PING PONG!",SwingConstants.CENTER);
		gameTitle.setFont(new Font("Comic Sans MS",3,75));
		gameTitle.setForeground(Color.WHITE);
	    gameTitle.setBounds(100,0, 600,250);
	    this.add(gameTitle);
	    //start
	    startOption = new JLabel("Start",SwingConstants.CENTER);
	    startOption.setFont(new Font("Comic Sans MS",3,35));
	    startOption.setForeground(Color.BLUE);
	    startOption.setBounds(250,150,300,200);
	    this.add(startOption);
	    //credits
	    creditOption = new JLabel("Credits",SwingConstants.CENTER);
	    creditOption.setFont(new Font("Comic Sans MS",3,20));
	    creditOption.setForeground(Color.WHITE);
	    creditOption.setBounds(250,200,300,200);
	    this.add(creditOption);
	    //Quit
	    quit = new JLabel("Quit",SwingConstants.CENTER);
	    quit.setFont(new Font("Comic Sans MS",3,20));
	    quit.setForeground(Color.WHITE);
	    quit.setBounds(250,250,300,200);
	    this.add(quit);
	    
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	
	

	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_DOWN)
		{
			
			switch(arrow) {
		      case START:
		        arrow = arrow.CREDITS;
		        creditOption.setForeground(Color.BLUE);
		        creditOption.setFont(new Font("Comic Sans MS",3,35));
		        startOption.setForeground(Color.WHITE);
		        startOption.setFont(new Font("Comic Sans MS",3,20));
		        break;
		      case CREDITS:
		    	  arrow = arrow.QUIT;
		    	  quit.setForeground(Color.BLUE);
		    	  quit.setFont(new Font("Comic Sans MS" ,3, 35));
			      creditOption.setForeground(Color.WHITE);
			      creditOption.setFont(new Font("Comic Sans MS",3,20));
		        break;
		      case QUIT:
		    	  arrow = arrow.START;
		    	  startOption.setForeground(Color.BLUE);
		    	  startOption.setFont(new Font("Comic Sans MS",3,35));
			      quit.setForeground(Color.WHITE);
			      quit.setFont(new Font("Comic Sans MS" ,3, 20));
		        break;
			}
			
		
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			switch(arrow) {
		      case START:
		        arrow = arrow.QUIT;
		        quit.setForeground(Color.BLUE);
		        quit.setFont(new Font("Comic Sans MS",3,35));
		        startOption.setForeground(Color.WHITE);
		        startOption.setFont(new Font("Comic Sans MS",3,20));
		        break;
		      case CREDITS:
		    	  arrow = arrow.START;
		    	  startOption.setForeground(Color.BLUE);
		    	  startOption.setFont(new Font("Comic Sans MS",3,35));
			      creditOption.setForeground(Color.WHITE);
			      creditOption.setFont(new Font("Comic Sans MS",3,20));
		        break;
		      case QUIT:
		    	  arrow = arrow.CREDITS;
		    	  creditOption.setForeground(Color.BLUE);
		    	  creditOption.setFont(new Font("Comic Sans MS",3,35));
			      quit.setForeground(Color.WHITE);
			      quit.setFont(new Font("Comic Sans MS",3,20));
		        break;
			}
		
		}
		if(keyCode == KeyEvent.VK_ENTER)
		{
			if(arrow == State.START)
			{
				
				w.changeScreen(Texas.PONG);
				
				
			}
			if(arrow == State.CREDITS)
			{
			
				w.changeScreen(Texas.CREDITS);
			}
			if(arrow == State.QUIT)
			{
				System.exit(0);
			}
			
		}
		
		
	}
	
	public boolean startPong()
	{
		return begin;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
