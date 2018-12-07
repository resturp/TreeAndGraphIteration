package nl.frii.iteration.graph.util;
/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import nl.frii.iteration.graph.DistanceMap;
import nl.frii.iteration.graph.Vertex;


public class MapUtil {

	public static DistanceMap sortByValue(DistanceMap dm) {
		
		List<Entry<Vertex, Double>> list = new ArrayList(dm.entrySet());
		list.sort(Entry.comparingByValue());

		DistanceMap result = new DistanceMap();
		for (Entry<Vertex, Double> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
		
	}
}