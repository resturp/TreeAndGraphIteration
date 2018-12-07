package nl.frii.iteration.list;
/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

import java.util.Iterator;

public class EnumerableList implements EnumerableItem{

	private ListItem[] list;
	private int current = 0; 
	
	public EnumerableList(int number) {
		this.list = new ListItem[number];
		for (int i = 0; i<number ; i++) {
			list[i] = new ListItem();
		}
	}
	
	@Override
	public boolean hasNext() {
		return current < list.length;
	}

	@Override
	public ListItem next() {
		return list[current++];
	}

	@Override
	public Iterator<ListItem> iterator() {
		return this;
	}

}
