package com.java.adawang.DataStructure.Trees;

import com.java.adawang.DataStructure.ListAndIterator.Position;
import com.java.adawang.DataStructure.PriorityQueue.Entry;

import java.util.Comparator;

public class AVLTree<K,V> extends BinarySearchTree<K,V>{
	public AVLTree() {super();}
	public AVLTree(Comparator<K> comp) {super(comp);}

	protected int height(Position<Entry<K,V>> p){
		return tree.getAux(p);
	}

	protected void recomputeHeight(Position<Entry<K,V>> p){
		tree.setAux(p, 1+ Math.max(height(tree.left(p)
		), height(tree.right(p))));
	}

	protected boolean isBalanced(Position<Entry<K,V>> p){
		return Math.abs(height(tree.left(p)) - height(tree.right(p))) <= 1;
	}

	// returns a child of p with height no smaller than
	// that of the other child
	protected Position<Entry<K,V>> tallerChild(Position<Entry<K,V>> p){
		//clear winner
		if(height(tree.left(p)) > height(tree.right(p))) return tree.left(p);
		if(height(tree.left(p)) < height(tree.right(p))) return tree.right(p);
		// equal height children; break tie while
		// matching parent`s orientation
		if(tree.isRoot(p)) return tree.left(p); //choice
		// is irrelevant
		if(p==tree.left(tree.parent(p))) return tree.left(p);
		else return tree.right(p);
	}

	protected void rebalance(Position<Entry<K,V>> p){
		int oldHeight, newHeight;
		do{
			oldHeight = height(p);
			if(!isBalanced(p)){
				p =
						tree.restructure(tallerChild(tallerChild(p)));
				recomputeHeight(tree.left(p));
				recomputeHeight(tree.right(p));
			}
			recomputeHeight(p);
			newHeight = height(p);
			p = tree.parent(p);
		}while (oldHeight!=newHeight && p != null);
	}

	protected void rebalanceInsert(Position<Entry<K,V>> p){
		rebalance(p);
	}

	protected void rebalanceDelete(Position<Entry<K,V>> p){
		if(!tree.isRoot(p))
			rebalance(p);
	}
}
