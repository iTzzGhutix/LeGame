package main;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.david.fileSystem.textFile.TextFileReader;
import com.david.fileSystem.textFile.TextFileWriter;

public class Options {

	private static String file = "options";
	private boolean saveUsername = false;
	private boolean savePassword = false;
	private boolean autoUpdate = false;
	private float version = 0;

	public Options() {
		saveOptions();
	}
	
	public Options(boolean sU, boolean sP, boolean aU, float v) {
		saveUsername = sU;
		savePassword = sP;
		autoUpdate = aU;
		version = v;
		System.out.println(sU);
		System.out.println(sP);
		saveOptions();
	}
	
	public boolean getSaveUsername() {
		return saveUsername;
	}
	
	public void setSaveUsername(boolean b) {
		saveUsername = b;
		saveOptions();
	}
	
	public boolean getSavePassword() {
		return saveUsername;
	}
	
	public void setSavePassword(boolean b) {
		savePassword = b;
		saveOptions();
	}

	public void setSaveAll(boolean b) {
		savePassword = b;
		saveUsername = b;
		saveOptions();
	}

	public boolean getAutoUpdate() {
		return autoUpdate;
	}
	
	public void setAutoUpdate(boolean b) {
		autoUpdate = b;
		saveOptions();
	}
	
	public float getVersion() {
		return version;
	}

	public static Options getOptions(){
		try {
			TextFileReader reader = new TextFileReader(new File(file));
			String[] lines = reader.getLines();
			boolean sN = Boolean.parseBoolean(lines[0]);
			boolean sP = Boolean.parseBoolean(lines[1]);
			boolean aU = Boolean.parseBoolean(lines[2]);
			float v = Float.parseFloat(lines[3]);
			return new Options(sN, sP, aU, v);
		} catch(IOException e) {
			e.printStackTrace();
			return new Options();
		}
	}

	public void saveOptions() {
		try {
			TextFileWriter writer = new TextFileWriter(new File(file), true);
			String write = String.valueOf(saveUsername) + "\n"
					+ String.valueOf(savePassword) + "\n"
					+ String.valueOf(autoUpdate) + "\n"
					+ String.valueOf(version);
			writer.write(write);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Could not save the options",
					"Warning!", JOptionPane.OK_OPTION);
		}
	}
}