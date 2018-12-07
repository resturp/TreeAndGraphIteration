package nl.frii.iteration.tree;
/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

import java.util.Iterator;

public class BinTree implements Iterable<BinTree> {
	public BinTree left, right, parent;
	
	private String value;
	private Iterator<BinTree> iterator;
	
	
	public BinTree (BinTree left, BinTree right, String value ) {
		this.left = left;
		this.right = right;
		this.value = value;
		
		if (left != null) {
			left.parent = this;
		}
		if (right != null) {
			right.parent = this;
		}
		
	}

	
	@Override
	public Iterator<BinTree> iterator() {
		return iterator;
	}
	
	public String toString() {
		return value;
	}


	public void setIterator(Iterator<BinTree> iter) {
		this.iterator = iter;
		
	}
	

}
