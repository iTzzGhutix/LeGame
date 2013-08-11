package david;

import java.util.ArrayList;
import java.util.List;

public class Kleinheid {

	public String name;
	public double rek;
	public List<Kleinheid> compat = new ArrayList<Kleinheid>();
	public boolean metric;
	public Grootheid grootheid;
	
	public Kleinheid(String name, double rek,Grootheid g, boolean metric){
		this.name = name;
		this.rek = rek;
		this.metric = metric;
		grootheid = g;
	}
	
	public void addCompat(List<Kleinheid> com){
		for(Kleinheid k:com){
			if(k.grootheid==grootheid&&!k.name.equalsIgnoreCase(name)){
				compat.add(k);
			}
		}
	}
	
	public double calc(Kleinheid k, double value){
		if(compat.contains(k)){
			return (rek*k.rek)*value;
		}
		return -1;
	}
	
	public List<Kleinheid> getCompat(){
		return compat;
	}
	
	public String toString(){
		return name;
	}

	public static Kleinheid[] getAll() {
		Kleinheid[] k = new Kleinheid[3];
		k[0] = new Kleinheid("Centimeter" , 100,Grootheid.LENGTH,true );
		k[1] = new Kleinheid("Meter" , 1,Grootheid.LENGTH,true );
		k[2] = new Kleinheid("Kilometer" , 0.01,Grootheid.LENGTH,true );
		
		return k;
	}
	
	public enum Grootheid {
		LENGTH,
		AREA
	}
	
}