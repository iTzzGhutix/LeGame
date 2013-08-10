package david;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class DavidCrazyStuff {
	//USA & UK CONVERTER
	
	Method m;
	
	private JFrame frame = new JFrame("Converter");
	private List<Kleinheid> keys = new ArrayList<Kleinheid>();
	
	
	private JTextField input = new JTextField();
	private JButton calc = new JButton();
	
	public DavidCrazyStuff(){
	}
	
	public void init(){
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		DavidCrazyStuff s = new DavidCrazyStuff();
		s.init();
	}
	
}