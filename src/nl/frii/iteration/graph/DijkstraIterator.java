package nl.frii.iteration.graph;
/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

import java.util.Iterator;

/*
 * Dijkstra iterator is an iterator that will iterate over all 
 * connected vertices whitin a network of vertices.
 * 
 * It will do so in order of the closest reachable vertex (it self)
 * to the most distant connected vertex.
 * 
 * The network of connected vertices gets explored with each 
 * iteration only as far is this exploration is necessary.  
 */
public class DijkstraIterator implements Iterator<Vertex>  {

	//keep a stack of all vertex TO BE explored. 
	//accompanied by the shortest distance known to reach it.
	private DistanceMap mapStackVertDist = new DistanceMap();
	//keep a stack of all vertex that HAVE BEEN explored. 
	private DistanceMap shortest;
	//keep a stack of all vertex that HAVE BEEN explored. 
	//accompanied by the vertex to use when traveling back to 
	//the origin.
	private BreadCrumbMap bread;

	public DijkstraIterator(Vertex origin, DistanceMap shortest, BreadCrumbMap bread) {
		this.shortest = shortest;
		this.bread = bread;
		mapStackVertDist.put(origin, 0.0);
		shortest.put(origin, 0.0);
	}

	public DijkstraIterator(Vertex origin, BreadCrumbMap bread) {
		this(origin, new DistanceMap(), bread);
	}
	public DijkstraIterator(Vertex origin, DistanceMap shortest) {
		this(origin, shortest, new BreadCrumbMap());
	}
	public DijkstraIterator(Vertex origin) {
		this(origin, new DistanceMap(), new BreadCrumbMap());
	}
	
	public DistanceMap getStack() {
		return mapStackVertDist;
	}
	public DistanceMap getShortest() {
		return shortest;
	}	
	public BreadCrumbMap getBreadCrumb() {
		return bread;
	}
	
	@Override
	public boolean hasNext() {
		return !mapStackVertDist.isEmpty();
	}

	@Override
	public Vertex next() {
		mapStackVertDist = (DistanceMap) MapUtil.sortByValue(mapStackVertDist);
		//get the first key from stack TO BE explored.
		Vertex keyToRemove = mapStackVertDist.keySet().iterator().next();
		//get the first distance from the stack TO BE explored.
		Double firstDistance = mapStackVertDist.values().iterator().next();

		for (Object keyForNeighbour : keyToRemove.getNeighbours().keySet()) {
			Double newDistance = firstDistance + (Double)keyToRemove.getNeighbours().get(keyForNeighbour);
			if (!shortest.containsKey(keyForNeighbour) || newDistance < shortest.get(keyForNeighbour)) {
				bread.put((Vertex) keyForNeighbour, keyToRemove);
				shortest.put((Vertex) keyForNeighbour, newDistance);
				mapStackVertDist.put((Vertex) keyForNeighbour, newDistance);
			}
		}
		
		mapStackVertDist.remove(keyToRemove);
		return keyToRemove;
	}

}
