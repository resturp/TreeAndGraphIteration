package nl.frii.iteration.tree;
/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

import java.util.Iterator;

public class InFixIterator implements Iterator<BinTree> {

	private BinTree next;

	public InFixIterator(BinTree root) {
		next = root;
		if (next == null)
			return;

		while (next.left != null)
			next = next.left;
	}

	public boolean hasNext() {
		return next != null;
	}

	public BinTree next() {
		BinTree r = next;

		if (next.right != null) {
			next = next.right;
			while (next.left != null)
				next = next.left;
			return r;
		}

		while (true) {
			if (next.parent == null) {
				next = null;
				return r;
			}
			if (next.parent.left == next) {
				next = next.parent;
				return r;
			}
			next = next.parent;
		}
	}
}
