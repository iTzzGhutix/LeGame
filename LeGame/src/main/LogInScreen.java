package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LogInScreen extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField updates = new JTextField();
	private JButton play = new JButton();
	private String imgName = "/firstTry.png";
	private ImageIcon img;
	private JLabel label = new JLabel();
	private String[] args;
	
	private LogInScreen(){
		super("LeGame");
		try {
			img = new ImageIcon(ImageIO.read(LogInScreen.class.getResourceAsStream(imgName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		play.setText("Play");
		play.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					play();
				
				}
			});
		play.setToolTipText("Play!");
		updates.setToolTipText("These are the updates of out game");
		updates.setText(getUpdates());
		updates.setEditable(false);
		label.setIcon(img);
		this.add(label,BorderLayout.NORTH);
		this.add(updates, BorderLayout.WEST);
		this.add(play , BorderLayout.EAST);
	}
	
	private String getUpdates() {
		return "Nog niks";
	}

	private void setArgs(String[] ar){
		args=ar;
	}
	
	public static void main(String[] arg){
		LogInScreen screen = new LogInScreen();
		screen.pack();
		screen.setVisible(true);
		screen.setArgs(arg);
		
		
	}
	
	public void play(){
		this.setEnabled(false);
		System.out.println("Ik doe ook commit :'(");
		this.dispose();
		
		Game.main(args);
	}
}
