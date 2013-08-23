package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class OptionFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int WIDTH = 240;
	private final int HEIGHT = 240;
	private Component par;
	private Options options;

	public OptionFrame(Component p, Options opt) {
		super("Options");
		this.par = p;
		this.options = opt;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JCheckBox saveName = new JCheckBox("Save username");
		saveName.setSelected(options.getSaveUsername());
		saveName.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					options.setSaveUsername(false);
				} else if (e.getStateChange() == ItemEvent.SELECTED) {
					options.setSaveUsername(true);
				}
			}
		});
		add(saveName);
		
		JCheckBox savePass = new JCheckBox("Save password");
		savePass.setSelected(options.getSavePassword());
		savePass.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					options.setSavePassword(false);
				} else if (e.getStateChange() == ItemEvent.SELECTED) {
					options.setSavePassword(true);
				}
			}
		});
		add(savePass);
	}

	public void start() {
		pack();
		setEnabled(true);
		setLocationRelativeTo(par);
		setVisible(true);
		requestFocus();
	}

	public void stop() {
		setEnabled(false);
	}

}
