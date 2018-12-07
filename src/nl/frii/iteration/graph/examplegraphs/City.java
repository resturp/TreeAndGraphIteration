package nl.frii.iteration.graph.examplegraphs;

import java.util.HashMap;
import java.util.Map;

public class City extends SomeClass {
	
	private static Map<String, City> allCities = new HashMap<String,City>();
	
	private City(String name) {
		super(name);	
	}
	
	public static synchronized City getCity(String name) {
		if (!allCities.keySet().contains(name)) {
			allCities.put(name, new City(name));
		} 
		return allCities.get(name);
	}
	
    public String toString() {
		return "City " + super.toString();
    	
    }
	
	

}
