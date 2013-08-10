package david;

import java.util.ArrayList;
import java.util.List;

public class Kleinheid {

	public String name;
	public int rek;
	public List<Kleinheid> compat = new ArrayList<Kleinheid>();
	
	public Kleinheid(String name, int rek){
		this.name = name;
		this.rek = rek;
	}
	
	public void addCompat(Kleinheid[] com){
		for(Kleinheid k:com){
			compat.add(k);
		}
	}
	
	
	public String toString(){
		return name;
	}
	
}