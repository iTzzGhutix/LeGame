package david;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class DavidCrazyStuff {
	//USA & UK CONVERTER
	
	Method m;
	
	private Kleinheid[] kleinheid = Kleinheid.getAll();
	
	private JFrame frame = new JFrame("Converter");
	private List<Kleinheid> kleinheden = new ArrayList<Kleinheid>();
	
	
	private JTextField input = new JTextField("Input",8);
	private JButton calc = new JButton("Calculate");
	private JList<String> engList = new JList<String>();
	private List<Kleinheid> engListK = new ArrayList<Kleinheid>();
	private JList<String> mtrList = new JList<String>();
	private List<Kleinheid> mtrListK = new ArrayList<Kleinheid>();
	private JTextField output = new JTextField(8);
	private List<Kleinheid> currentMtr = new ArrayList<Kleinheid>();
	
	public DavidCrazyStuff(){
	}
	
	public void init(){
		input.setSize(20, 80);
		output.setSize(20, 80);
		engList.setSize(20, 80);
		mtrList.setSize(20, 80);
		calc.setSize(20, 50);
		for(Kleinheid k : kleinheid){
			kleinheden.add(k);
		}
		for(Kleinheid k : kleinheden){
			k.addCompat(kleinheden);
			if(k.metric){
				mtrListK.add(k);
			}else{
				engListK.add(k);
			}
		}
		String[] eng = new String[engListK.size()];
		for (int i = 0; i < engListK.size(); i++) {
			eng[i] = engListK.get(i).name;
		}			
		String[] mtr = new String[engListK.size()];
		for (int i = 0; i < mtrListK.size(); i++) {
			mtr[i] = mtrListK.get(i).name;
		}
		
		engList.setListData(eng);
		engList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		engList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		engList.setVisibleRowCount(-1);
		JScrollPane listScrollerEng = new JScrollPane(engList);
		listScrollerEng.setPreferredSize(new Dimension(60, 50));
		
		mtrList.setListData(eng);
		mtrList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mtrList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		mtrList.setVisibleRowCount(-1);
		JScrollPane listScrollerMtr = new JScrollPane(mtrList);
		listScrollerMtr.setPreferredSize(new Dimension(60, 50));
		
		currentMtr.clear();
		
		frame.setLayout(new FlowLayout());
		frame.add(listScrollerEng);
		frame.add(input);
		frame.add(listScrollerMtr);
		frame.add(calc);
		frame.add(output);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		DavidCrazyStuff s = new DavidCrazyStuff();
		s.init();
	}
	
}