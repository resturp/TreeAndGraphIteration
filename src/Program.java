/*
MIT License
Copyright (c) 2018 Thomas Boose
*/
import nl.frii.iteration.graph.BreadCrumbMap;
import nl.frii.iteration.graph.DistanceMap;
import nl.frii.iteration.graph.Graph;
import nl.frii.iteration.graph.examplegraphs.City;
import nl.frii.iteration.graph.examplegraphs.CityTransportExample;
import nl.frii.iteration.graph.examplegraphs.FacebookArtist;
import nl.frii.iteration.graph.examplegraphs.KarateClub;
import nl.frii.iteration.list.EnumerableList;
import nl.frii.iteration.list.ListItem;
import nl.frii.iteration.tree.BinTree;
import nl.frii.iteration.tree.InFixIterator;
import nl.frii.iteration.tree.PreFixIterator;
import nl.frii.iteration.graph.Vertex;


public class Program {
	
	public static void enumerateList() {
		EnumerableList l = new EnumerableList(8);
		for (ListItem i : l) {
			System.out.println(i.getValue());
		}
	}
	
	public static void iterOverBintree() {
		BinTree btA = new BinTree(null, null, "A");
		BinTree btC = new BinTree(null, null ,"C");
		BinTree btB = new BinTree(btA, btC , "B");
		
		BinTree btE = new BinTree(null, null, "E");
		BinTree btG = new BinTree(null, null, "G");
		BinTree btF = new BinTree(btE, btG, "F");
		BinTree btD = new BinTree(btB, btF, "D");
		
		
		btD.setIterator(new InFixIterator(btD));
		System.out.println("-Infix-");
		for (BinTree bt : btD ) {
			System.out.println(bt.toString());
		}
		
		System.out.println("-Prefix-");
		btD.setIterator(new PreFixIterator(btD));
		
		for (BinTree bt : btD ) {
			System.out.println(bt.toString());
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		
	
		enumerateList();
		iterOverBintree();
		graphOfString();
		graphOfCitys();
		
		bigGraphEcample();
		
	}

	private static void bigGraphEcample() {
		System.out.println("-Big Graph-");
		Graph<Integer> ig = new Graph<Integer>();
		DistanceMap shortest = new DistanceMap();
		BreadCrumbMap breadCrumbs = new BreadCrumbMap();
		
		new FacebookArtist().loadGraph(ig);
		Vertex<Integer> vi = ig.getVertex(9);
		vi.setDijkstraIterator(shortest, breadCrumbs);
		
		int stop = 40;
		for (Vertex<Integer> IntVertex : vi) {
			System.out.println("Reach vertex number " + IntVertex 
					            + " via vertex " + breadCrumbs.get(IntVertex) 
					            + " in " + shortest.get(IntVertex) + " steps.");
			stop--;
			if (stop <1) {
				break;
			}
		}
	}

	private static void graphOfCitys() {
		System.out.println("-Graph of SomeClass example-");
		Graph<City> cg = new Graph<City>();
		DistanceMap shortest = new DistanceMap();
		BreadCrumbMap breadCrumbs = new BreadCrumbMap();
		
		new CityTransportExample().loadGraph(cg);
		Vertex<City> zwolle = cg.getVertex(City.getCity("Zwolle"));
		
		zwolle.setDijkstraIterator(shortest, breadCrumbs);
		
		for (Vertex<City> city : zwolle) {
			System.out.println("" + city.getInnerObject() + " " + shortest.get(city));
		}		
	}

	private static void graphOfString() {
		System.out.println("-Graph of String example-");

		//Graph of Strings example:
		
		//Initialize Graph, DistanceMap and BreadcrumbMap 
		Graph<String> g = new Graph<String>();
		DistanceMap shortest = new DistanceMap();
		BreadCrumbMap breadCrumbs = new BreadCrumbMap();
		
		//Fill graph g with the karateclub members.
		new KarateClub().loadGraph(g);	
		
		//retrieve member X from graph
		Vertex<String> msHi = g.getVertex("10");
		
		//Set a new iterator on this member and connect
		//output parameters. (if you only want to iterate
		//this step can be skipped)
		msHi.setDijkstraIterator(shortest, breadCrumbs);
		
		for (Vertex<String> ioVertex : msHi) {
			System.out.println("Reach vertex number " + ioVertex 
					            + " via vertex " + breadCrumbs.get(ioVertex) 
					            + " in " + shortest.get(ioVertex) + " steps.");
		}
		
	}


}
