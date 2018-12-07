package nl.frii.iteration.graph.examplegraphs;

/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

public class SomeClass {
	private String name;
	
	public SomeClass(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name + " (" + this.hashCode() +")"; 
	};

}
