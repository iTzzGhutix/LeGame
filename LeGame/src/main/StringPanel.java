package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class StringPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private String TITLE = "The title";
	private JPasswordField pwdPassword;
	private JTextField txtUsername;
	public StringPanel() {
		
		new JFrame(this.TITLE);
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		JFrame frame = new JFrame(this.TITLE);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		frame.getContentPane().setLayout(new BorderLayout()); 
		frame.getContentPane().add(this,BorderLayout.CENTER);
		setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("password");
		pwdPassword.setBounds(10, 469, 141, 20);
		add(pwdPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Stencil", Font.PLAIN, 11));
		txtUsername.setText("username");
		txtUsername.setBounds(10, 451, 141, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
  
		Button button = new Button("Login");
		button.setActionCommand("Login");
		button.setBounds(148, 450, 94, 39);
		add(button);
			
	  JMenuBar menuBar = new JMenuBar(); 
	  menuBar.setToolTipText("this is a button thing"); 
	  menuBar.setBounds(0, 0, 500, 20);
	  add(menuBar); 
	  
	  List list = new List();
	  list.add("hello");
	  list.setBounds(10, 60, 480, 379);
	  add(list);
	  
	  JTextPane txtpnSelectStuffFrom = new JTextPane();
	  txtpnSelectStuffFrom.setFont(new Font("Stencil", Font.PLAIN, 11));
	  txtpnSelectStuffFrom.setText("Select stuff from list(to be implented)");
	  txtpnSelectStuffFrom.setBounds(10, 34, 480, 20);
	  add(txtpnSelectStuffFrom);
	  frame.setResizable(false);
	  frame.pack();
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	  this.setupPanel();
	 }
	 private  void setupPanel(){
	  setBackground(Color.WHITE);
	  setForeground(SystemColor.textHighlight);
	 }
}
