package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.david.fileSystem.textFile.TextFile;

public class DavidLogIn {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 570;
	private float pullVersion;
	private Image logoImage;
	final String TITLE = "Log in iTzz & David games";
	private JFrame frame;
	private TextFile userPassSave = new TextFile(new File("sample"));
	private String[] linesSave;
	private Rectangle rPass = new Rectangle(605, 490, 93, 20);
	private Rectangle rName = new Rectangle(605, 470, 93, 20);
	private Rectangle rSaveAll = new Rectangle(605, 510, 93, 20);
	private Rectangle rStart = new Rectangle(700, 470, 80, 60);
	private Rectangle rUpdates = new Rectangle(0, 40, 800, 426);
	private Rectangle rLogo = new Rectangle(0, 0, 800, 40);
	private Rectangle rOption = new Rectangle(5, 470, 80, 40);
	private Rectangle rUpdate = new Rectangle(5, 510, 80, 20);
	private Options options = Options.getOptions();
	
	private JButton startButton;
	private JButton optionButton;
	private JButton updateButton;
	private HintPassField password;
	private HintTextField name;
	private JCheckBox saveAll;
	private JPanel panel;
	private JLabel logo;
		
	public DavidLogIn() {
		BufferedInputStream in = null;
		try {
			URL link = new URL(
					"https://dl.dropboxusercontent.com/s/0jzj27jaxesb5hh/version?token_hash=AAFtacItVE8vkpCnkhsTjRW8qHdKasxG1CQdDkxQj49w8g&dl=1");
			in = new BufferedInputStream((link).openStream());
			byte[] data = new byte[1024];
			in.read(data, 0, 1024);
			pullVersion = Float.parseFloat(new String(data));
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
			pullVersion = options.getVersion();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		try {
			String[] t = userPassSave.readLines();
			linesSave = t.length > 1 ? t : new String[] { "", "" };
		} catch (IOException e) {
			e.printStackTrace();
			linesSave = new String[] { "", "" };
		}

		try {
			logoImage = ImageIO.read(new File("logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
			logoImage = new BufferedImage((int) rLogo.getWidth(),
				(int) rLogo.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g = logoImage.getGraphics();
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, logoImage.getWidth(null),
				logoImage.getHeight(null));
		}
		frame = new JFrame(TITLE);
		frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reload();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				reload();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				reload();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				reload();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reload();
			}
		});
		// End frame and pull up text
		
		startButton = new JButton("Start");
		startButton.setBounds(rStart);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						save();
						Game.main(new String[] {});
						stop();
					}

				}).start();
				;
			}
		});
		frame.add(startButton);
		
		optionButton = new JButton("Options");
		optionButton.setToolTipText("Open options");
		optionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OptionFrame(frame, options).start();
			}
		});
		optionButton.setBounds(rOption);
		frame.add(optionButton);
		
		updateButton = new JButton("Update");
		updateButton.setToolTipText("Update");
		updateButton.setEnabled(options.getVersion() != pullVersion);
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		updateButton.setBounds(rUpdate);
		frame.add(updateButton);

		password = new HintPassField("Enter password");
		password.setToolTipText("Enter your password here");
		password.setBounds(rPass);
		String p = getPassword();
		if (options.getSavePassword() && (!p.equals(""))) {
			password.setText(p);
			password.setEchoChar((char) 9679);
		}
		frame.add(password);
		
		name = new HintTextField("Enter username");
		name.setToolTipText("Enter your name here");
		name.setBounds(rName);
		String n = getUsername();
		if (options.getSaveUsername() && (!n.equals(""))) {
			name.setText(n);
		}
		frame.add(name);
		
		saveAll = new JCheckBox("Save login");
		saveAll.setBounds(rSaveAll);
		saveAll.setToolTipText("Save username and password");
		saveAll.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					options.setSaveAll(false);
				} else if (e.getStateChange() == ItemEvent.SELECTED) {
					options.setSaveAll(true);
				}
			}
		});
		saveAll.setSelected((options.getSavePassword())
				&& (options.getSaveUsername()));
		frame.add(saveAll);
		
		panel = new JPanel();
		panel.setBounds(rUpdates);
		panel.setBackground(Color.GRAY);
		frame.add(panel);
		
		logo = new JLabel();
		logo.setBounds(rLogo);
		logo.setIcon(new ImageIcon(logoImage));
		frame.add(logo);
	}
	
	public void reload() {
		saveAll.setSelected((options.getSavePassword())
				&& (options.getSaveUsername()));
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
	
	public String getUsername() {
		return linesSave[0];
	}

	public String getPassword() {
		return linesSave[1];
	}

	public void save() {
		String data = (options.getSaveUsername() ? name.getText() : " ") + "\n"
				+ (options.getSavePassword() ? password.getText() : " ");
		if (options.getSaveUsername() || options.getSavePassword()) {
			try {
				userPassSave.override(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public class HintTextField extends JTextField implements FocusListener {

		private static final long serialVersionUID = 1L;
		private final String hint;

		public HintTextField(String hint) {
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
				this.setText("");
	            super.setEchoChar((char)9679);
	        }
	    }
	    @Override
	    public void focusLost(FocusEvent e) {
	        if(this.getText().isEmpty()) {
				this.setText(hint);
	            super.setEchoChar((char)0);
	        }
	    }

	    @Override
	    public String getText() {
	        String typed = new String(super.getPassword());
	        return typed.equals(hint) ? "" : typed;
	    }

	}
	
	public static void main(String[] a){
		DavidLogIn screen = new DavidLogIn();
		screen.start();
	}
	

}
