package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static String TITLE = "LeGame";
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public boolean isRunning = false;
	public World world;
	
	public void start() {
		isRunning = true;
		new Thread(this).start();
	}
	
	public void stop() {
		isRunning = false;
	}
	
	@Override
	public void run() {
		init();

		while (isRunning) {

			tick();
			render();

			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void init() {

	}

	public void render(){
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer==null){
			this.createBufferStrategy(2);
			requestFocus();
			return;
		}
		BufferedImage img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		//Put stuff here to render
		g.setColor(Color.BLUE);
		g.fillOval(15, 15, 15, 15);
		//stop with stuff to render
		int ww = getWidth();
		int hh = getHeight();
		Graphics gBase = buffer.getDrawGraphics();
		gBase.fillRect(0, 0, ww, hh);
		gBase.clearRect(0, 0, ww, hh);
		gBase.drawImage(img, 0, 0, null);
		gBase.dispose();
		buffer.show();
	}
	
	public void tick() {

	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		game.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		JFrame frame = new JFrame(Game.TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		frame.setLayout(new BorderLayout());
		frame.add(game,BorderLayout.CENTER);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

}