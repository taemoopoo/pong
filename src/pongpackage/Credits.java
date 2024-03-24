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

import pongpackage.StartScreen.State;
import pongpackage.Window.Texas;

public class Credits extends JPanel implements KeyListener{

	/**
	 * 
	 */
	enum Alabama
	{
		BACK,
		OTHER
	}
	private Alabama selector;
	private static final long serialVersionUID = 6819954607440168853L;
	public JLabel names;
	public JLabel back;
	public Window w;
	

	
	
	public Credits()
	{
		//me
		selector = Alabama.BACK;
		setBounds(0, 0, Window.SIZE_W, Window.SIZE_H);
		this.setBackground(Color.black);
		this.setLayout(null);
		names = new JLabel("ME",SwingConstants.CENTER);
		names.setFont(new Font("Comic Sans MS",3,75));
		names.setForeground(Color.white);
		names.setBounds(100,0, 600,250);
	    this.add(names);
	    //back
	    back = new JLabel("Back",SwingConstants.CENTER);
	    back.setFont(new Font("Comic Sans MS",3,35));
	    back.setForeground(Color.blue);
	    back.setBounds(0,485, 100,100);
	    this.add(back);
	    
	
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
			switch(selector) {
		      case BACK:
		        selector = selector.OTHER;
		        names.setForeground(Color.BLUE);
		        back.setForeground(Color.WHITE);
		        back.setFont(new Font("Comic Sans MS",3,20));
		        break;
		      case OTHER:
		    	  selector = selector.BACK;
		    	  back.setForeground(Color.BLUE);
		    	  back.setFont(new Font("Comic Sans MS" ,3, 35));
		    	  names.setForeground(Color.WHITE);
		        break;
			}
			
		
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			switch(selector) {
			case BACK:
		        selector = selector.OTHER;
		        names.setForeground(Color.BLUE);
		        back.setForeground(Color.WHITE);
		        back.setFont(new Font("Comic Sans MS",3,20));
		        break;
		      case OTHER:
		    	  selector = selector.BACK;
		    	  back.setForeground(Color.BLUE);
		    	  back.setFont(new Font("Comic Sans MS" ,3, 35));
		    	  names.setForeground(Color.WHITE);
		        break;
			}
		
		}
		if(keyCode == KeyEvent.VK_ENTER)
		{
			if(selector == Alabama.BACK)
			{
			
				w.changeScreen(Texas.START);
				
				
//				SwingUtilities.invokeLater(() -> {
//					new Window(Texas.PONG);
//				});
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
