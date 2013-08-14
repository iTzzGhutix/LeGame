package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DavidLogIn {

	private static final int WIDTH = 2560;
	private static final int HEIGHT = 1600;
	final String TITLE = "Log in iTzz & David games";
	JFrame frame;
	Rectangle rPass = new Rectangle(605,490,93,20);
	Rectangle rName = new Rectangle(605,470,93,20);
	Rectangle rStart = new Rectangle(700,470,80,40);
	Rectangle rUpdates = new Rectangle(0, 0, 800, 466);
	Rectangle rOption = new Rectangle(5,470,80,40);
	
		
	public DavidLogIn(){
		frame = new JFrame(TITLE);
		frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(rStart);
		frame.add(startButton);
		
		JButton optionButton = new JButton("Options");
		optionButton.setBounds(rOption);
		frame.add(optionButton);
		
		HintPassField password = new HintPassField("Enter password");
		password.setToolTipText("Enter your password here");
		password.setBounds(rPass);
		frame.add(password);
		
		HintTextField name = new HintTextField("Enter username");
		name.setToolTipText("Enter your name here");
		name.setBounds(rName);
		frame.add(name);
		
		JPanel panel = new JPanel();
		panel.setBounds(rUpdates);
		panel.setBackground(Color.GRAY);
		frame.add(panel);
		
		
	}
	
	public void start(){
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocus();
	}
	
	public void stop(){
		frame.setEnabled(false);
		frame.dispose();
	}
	

	public class HintTextField extends JTextField implements FocusListener {

		private static final long serialVersionUID = 1L;
		private final String hint;

	    public HintTextField(final String hint) {
	        super(hint);
	        this.hint = hint;
	        super.addFocusListener(this);
	    }

	    @Override
	    public void focusGained(FocusEvent e) {
	        if(this.getText().isEmpty()) {
	            super.setText("");
	        }
	    }
	    @Override
	    public void focusLost(FocusEvent e) {
	        if(this.getText().isEmpty()) {
	            super.setText(hint);
	        }
	    }

	    @Override
	    public String getText() {
	        String typed = super.getText();
	        return typed.equals(hint) ? "" : typed;
	    }
	}
	
	public class HintPassField extends JPasswordField implements FocusListener {

		private static final long serialVersionUID = 1L;
		private final String hint;

	    public HintPassField(final String hint) {
	        super(hint);
	        super.setEchoChar((char)0);
	        this.hint = hint;
	        super.addFocusListener(this);
	    }

	    @Override
	    public void focusGained(FocusEvent e) {
	        if(this.getText().isEmpty()) {
	            super.setText("");
	            super.setEchoChar((char)9679);
	        }
	    }
	    @Override
	    public void focusLost(FocusEvent e) {
	        if(this.getText().isEmpty()) {
	            super.setText(hint);
	            super.setEchoChar((char)0);
	        }
	    }

	    @Override
	    public String getText() {
	        String typed = new String(super.getPassword());
	        return typed.equals(hint) ? "" : typed;
	    }
	}
	
	public class OptionFrame extends JFrame {

		private static final long serialVersionUID = 1L;
		private final int WIDTH = 80;
		private final int HEIGHT = 240;
		
		public OptionFrame(String s){
			super(s);
			setPreferredSize(new Dimension(WIDTH,HEIGHT));
			setMaximumSize(new Dimension(WIDTH,HEIGHT));
			setMinimumSize(new Dimension(WIDTH,HEIGHT));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
		}
		
		public void start(){
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			requestFocus();
		}
		
		public void stop(){
			setEnabled(false);
			dispose();
		}
		
	}
	
	public static void main(String[] a){
		DavidLogIn screen = new DavidLogIn();
		screen.start();
	}
	

}
