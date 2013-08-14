package david;

import java.util.ArrayList;
import java.util.List;

public class Kleinheid {

	public String name;
	public double rek;
	public List<Kleinheid> compat = new ArrayList<Kleinheid>();
	public boolean metric;
	public Grootheid grootheid;
	public boolean calcIn = false;
	
	public Kleinheid(String name, double rek,Grootheid g, boolean metric){
		this.name = name;
		this.rek = rek;
		this.metric = metric;
		grootheid = g;
		if(rek==1){
			calcIn = true;
		}
	}
	
	public void addCompat(List<Kleinheid> com){
		for(Kleinheid k:com){
			if(k.grootheid==grootheid&&!k.name.equalsIgnoreCase(name)){
				compat.add(k);
			}
		}
	}
	
	public double calc(Kleinheid k, double value){
		//to come
		
		
		return value;
	}
	
	public List<Kleinheid> getCompat(){
		return compat;
	}
	
	public String toString(){
		return name;
	}

	public static Kleinheid[] getAll() {
		Kleinheid[] k = new Kleinheid[6];
		k[0] = new Kleinheid("Centimeter" , 100,Grootheid.LENGTH,true );
		k[1] = new Kleinheid("Meter" , 1,Grootheid.LENGTH,true );
		k[2] = new Kleinheid("Kilometer" , 0.001,Grootheid.LENGTH,true );
		k[3] = new Kleinheid("Inch" , 0,Grootheid.LENGTH,false );
		k[4] = new Kleinheid("Yard" , 0,Grootheid.LENGTH,false );
		k[5] = new Kleinheid("Mile" , 0,Grootheid.LENGTH,false );
		
		return k;
	}
	
	public enum Grootheid {
		LENGTH(0.3048), //Meter en yard
		AREA(1);
		
		private double toMtr;
		
		Grootheid(double toMtr){
			this.toMtr = toMtr;
		}
	}
	
}
