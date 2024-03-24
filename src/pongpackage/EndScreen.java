package pongpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import pongpackage.Credits.Alabama;
import pongpackage.Window.Texas;

public class EndScreen extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	enum Ohio
	{
		 PONE,
		             																											PTWO,
		LBOZO
	}
	private Ohio winner;
	private static final long serialVersionUID = -1740321929396448392L;
	public JLabel trophy;
	public JLabel yipee;
	public JLabel ok;
	public Window w;
	public Timer timer;
	
	 public EndScreen(Ohio winner)
	 {
		System.out.println("yipee?");
		this.winner = winner;
		setBounds(0, 0, Window.SIZE_W, Window.SIZE_H);
		this.setBackground(Color.black);
		this.setLayout(null);
		//ok
		ok = new JLabel("ok",SwingConstants.CENTER);
		ok.setFont(new Font("Comic Sans MS",3,35));
		ok.setForeground(Color.blue);
		ok.setBounds(300,485, 100,100);
		this.add(ok);
		
		switch(winner) {
		case PONE:
			//yipee
			yipee = new JLabel("PLAYER 1 WON",SwingConstants.CENTER);
			break;
		case PTWO:
			yipee = new JLabel("PLAYER 1 STILL WON HAHA L",SwingConstants.CENTER);
			break;
		 case LBOZO:
		 	yipee = new JLabel("IDK I STILL WON",SwingConstants.CENTER);
		 	break;
			
		 }
		 yipee.setFont(new Font("Comic Sans MS",3,50));
		 yipee.setForeground(Color.white);
		 yipee.setBounds(100,0, 600,250);
		 this.add(yipee);
		 
		 ActionListener taskPerformer = new ActionListener() {
             public void actionPerformed(ActionEvent evt) 
             {repaint();}
		 };
		
		 timer = new Timer(17 ,taskPerformer);
		 timer.setRepeats(false);
		 timer.start();
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
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ENTER)
		{
				w.changeScreen(Texas.ENDSTART);
				
				
//				SwingUtilities.invokeLater(() -> {
//					new Window(Texas.PONG);
//				});
		}

		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
