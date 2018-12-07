package nl.frii.iteration.graph.examplegraphs;

import nl.frii.iteration.graph.Graph;

public class CityTransportExample {
	
	public void loadGraph(Graph<City> g) {
		g.addEdge(City.getCity("Zwolle") , City.getCity("Apeldoorn") , 30);
		g.addEdge(City.getCity("Apeldoorn") , City.getCity("Amersfoort") , 20);
		g.addEdge(City.getCity("Apeldoorn") , City.getCity("Arnhem") , 20);
		g.addEdge(City.getCity("Arnhem") , City.getCity("Nijmegen") , 15);
		g.addEdge(City.getCity("Nijmegen") , City.getCity("Utrecht") , 60);
		g.addEdge(City.getCity("Amersfoort") , City.getCity("Utrecht") , 20);
		g.addEdge(City.getCity("Utrecht") , City.getCity("Amsterdam") , 45);
		g.addEdge(City.getCity("Utrecht") , City.getCity("Gouda") , 30);
		g.addEdge(City.getCity("Gouda") , City.getCity("Den Haag") , 15);
		g.addEdge(City.getCity("Gouda") , City.getCity("Rotterdam") , 20);
		g.addEdge(City.getCity("Zwolle") , City.getCity("Assen") , 50);
		g.addEdge(City.getCity("Assen") , City.getCity("Leeuwarden") , 40);
		g.addEdge(City.getCity("Leeuwarden") , City.getCity("Zwolle") , 50);
		g.addEdge(City.getCity("Leeuwarden") , City.getCity("Sneek") , 20);
		g.addEdge(City.getCity("Sneek") , City.getCity("Bolsward") , 10);
		g.addEdge(City.getCity("Bolsward") , City.getCity("Den Helder") , 45);		
		g.addEdge(City.getCity("Den Helder") , City.getCity("Amsterdam") , 60);
		g.addEdge(City.getCity("Amsterdam") , City.getCity("Leiden") , 30);
		g.addEdge(City.getCity("Leiden") , City.getCity("Den Haag") , 20);
		g.addEdge(City.getCity("Den Haag") , City.getCity("Rotterdam") , 15);		
		
	}
}
