package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Game extends Canvas{
	private static final long serialVersionUID = 1L;

	public static String TITLE = "LeGame";
	public static final int WIDTH = 250;
	public static final int LEGTH = 250;
	
	
	
	
	
	
	
	
	
	
	public void render(){
		BufferStrategy buffer = getBufferStrategy();
		if(buffer==null){
			this.createBufferStrategy(2);
			requestFocus();
			return;
		}
		BufferedImage img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		//Put stuff here to render
		g.fillOval(15, 15, 15, 15);
		
		
		//stop with stuff to render
		int ww = getWidth();
		int hh = getHeight();
		Graphics gBase = buffer.getDrawGraphics();
		gBase.fillRect(0, 0, ww, hh);
		gBase.clearRect(0, 0, ww, hh);
		gBase.drawImage(img, 0, 0, null);
		gBase.dispose();
		if(!buffer.contentsLost()){
			buffer.show();
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		game.setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		
		JFrame frame = new JFrame(Game.TITLE);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}