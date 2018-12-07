package nl.frii.iteration.graph.examplegraphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import nl.frii.iteration.graph.Graph;

public class FacebookArtist {
	
	public void loadGraph(Graph<Integer> g) {
		g.clear();
		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/thomas/eclipse-workspace/Iteration/src/nl/frii/iteration/graph/examplegraphs/artist_edges.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {		    		
		    		g.addEdge(Integer.parseInt(line.split(",")[0]), 
		    				  Integer.parseInt(line.split(",")[1]), 1.0);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
