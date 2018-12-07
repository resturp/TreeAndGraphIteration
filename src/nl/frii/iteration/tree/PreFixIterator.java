package nl.frii.iteration.tree;
/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

import java.util.Iterator;

public class PreFixIterator implements Iterator<BinTree> {

	private BinTree next;

	public PreFixIterator(BinTree root) {
		next = root;
	}

	public boolean hasNext() {
		return next != null;
	}

	public BinTree next() {
		BinTree r = next;
		
		if (next.left != null) {
			next = next.left;
		} else {
			if (next.right != null) {
				next = next.right;
			} else {
				if (next.parent.right != null) {
					while (next.parent != null && next == next.parent.right) {
						next = next.parent;
					}
					if (next.parent != null) {
						next = next.parent.right;
					} else {
						next = null;
					}
					
				} else {
					next = null;
				}
			}
		}
		return r;
	}
}
