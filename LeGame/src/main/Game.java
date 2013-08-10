package main;

import java.awt.Canvas;

import javax.swing.JFrame;


public class Game extends Canvas{
	private static final long serialVersionUID = 1L;

	public static String TITLE = "LeGame";
	
	
	
	
	public static void main(String[] args) {
		Game game = new Game();
		
		JFrame frame = new JFrame(Game.TITLE);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
