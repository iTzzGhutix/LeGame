package david;

import java.util.ArrayList;
import java.util.List;

public class Kleinheid {

	public String name;
	public double rek;
	public List<Kleinheid> compat = new ArrayList<Kleinheid>();
	
	public Kleinheid(String name, double rek){
		this.name = name;
		this.rek = rek;
	}
	
	public void addCompat(Kleinheid[] com){
		for(Kleinheid k:com){
			compat.add(k);
		}
	}
	
	public double calc(Kleinheid k, double value){
		if(compat.contains(k)){
			return (rek*k.rek)*value;
		}
		return -1;
	}
	
	
	public String toString(){
		return name;
	}
	
}