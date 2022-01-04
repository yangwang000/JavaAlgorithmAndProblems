package com.java.adawang.DataStructure.Trees;

import com.java.adawang.DataStructure.ListAndIterator.ArrayList;
import com.java.adawang.DataStructure.ListAndIterator.Position;
import com.java.adawang.DataStructure.MapHashTable.AbstractSortedMap;
import com.java.adawang.DataStructure.PriorityQueue.Entry;

import java.util.Comparator;

public class BinarySearchTree<K,V> extends AbstractSortedMap<K,V> {
	protected static class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>>{
		protected static class BSTNode<E> extends Node<E>{
			int aux = 0;
			public BSTNode(E e, Node<E> parent,
						   Node<E> leftChild, Node<E> rightChild) {
				super(e, parent, leftChild, rightChild);
			}
			public int getAux() {return aux;}
			public void setAux(int value) {aux=value;}
		}

		public int getAux(Position<Entry<K,V>> p){
			return ((BSTNode<Entry<K,V>>) p).getAux();
		}
		public void setAux(Position<Entry<K,V>> p,
						   int value){
			((BSTNode<Entry<K,V>>) p).setAux(value);
		}

		protected Node<Entry<K,V>> createNode(Entry<K,V> e, Node<Entry<K,V>> parent, Node<Entry<K,V>> left, Node<Entry<K,V>> right){
			return new BSTNode<>(e,parent,left,right);
		}

		protected void rebalanceInsert(Position<Entry<K,
				V>> p) {}
		protected void rebalanceDelete(Position<Entry<K,
				V>> p) {}
		protected void rebalanceAccess(Position<Entry<K,
				V>> p) {}

		/* relinks a parent node with its oriented child
		node */
		private void relink(Node<Entry<K,V>> parent,
							Node<Entry<K,V>> child,
							boolean makeLeftChild){
			child.setParent(parent);
			if(makeLeftChild)
				parent.setLeft(child);
			else
				parent.setRight(child);
		}

		/* rotates position p above its parent */
		public void rotate(Position<Entry<K,V>> p){
			Node<Entry<K,V>> x = validate(p);
			Node<Entry<K,V>> y = x.getParent();
			Node<Entry<K,V>> z = y.getParent();
			if(z == null){
				root = x;
				x.setParent(null);
			}else
				relink(z,x,y==z.getLeft());

			if(x == y.getLeft()){
				relink(y,x.getRight(),true);
				relink(x,y,false);
			}else{
				relink(y, x.getLeft(), false);
				relink(x, y, true);
			}
		}

		public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x){
			Position<Entry<K,V>> y = parent(x);
			Position<Entry<K,V>> z = parent(y);
			if((x==right(y)) == (y==right(z))){
				rotate(y);
				return y;
			}else {
				rotate(x);
				rotate(x);
				return x;
			}
		}
	}
	protected BalanceableBinaryTree<K,V> tree =
			new BalanceableBinaryTree<>();

	public BinarySearchTree(){
		super();
		tree.addRoot(null);
	}

	public BinarySearchTree(Comparator<K> comp){
		super(comp);
		tree.addRoot(null);
	}

	public int size(){
		return (tree.size()-1)/2; //only internal nodes
		// have entries
	}

	private void expandExternal(Position<Entry<K,V>> p,
								Entry<K,V> entry){
		tree.set(p, entry);
		tree.addLeft(p, null);
		tree.addRight(p, null);
	}

	protected Position<Entry<K,V>> root() {return tree.root();}

	private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key){
		if(tree.isExternal(p))
			return p;
		int comp = compare(key, p.getElement());
		if(comp==0)
			return p; //key found
		else if (comp < 0)
			return treeSearch(tree.left(p), key);
		else
			return treeSearch(tree.right(p), key);
	}

	public V get(K key) throws IllegalArgumentException{
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		tree.rebalanceAccess(p);
		if(tree.isExternal(p)) return null;
		return p.getElement().getValue();
	}

	public V put(K key, V value) throws IllegalArgumentException{
		checkKey(key);
		Entry<K,V> newEntry = new MapEntry<>(key, value);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(tree.isExternal(p)){
			expandExternal(p, newEntry);
			tree.rebalanceInsert(p);
			return null;
		}else{
			V old = p.getElement().getValue();
			tree.set(p, newEntry);
			tree.rebalanceAccess(p);
			return old;
		}
	}

	@Override
	public V remove(K key) throws IllegalArgumentException{
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(tree.isExternal(p)){
			tree.rebalanceAccess(p);
			return null;
		}else {
			V old = p.getElement().getValue();
			if(tree.isInternal(tree.left(p)) && tree.isInternal(tree.right(p))){
				//both children are internal
				Position<Entry<K,V>> replacement =
						treeMax(tree.left(p));
				tree.set(p, replacement.getElement());
				p = replacement;
			}
			//now p has at most one child that is an
			// internal node
			Position<Entry<K,V>> leaf =
					(tree.isExternal(tree.left(p))?
							tree.left(p):tree.right(p));
			Position<Entry<K,V>> sib = tree.sibling(leaf);
			tree.remove(leaf);
			tree.remove(p);
			tree.rebalanceDelete(sib);
			return old;
		}
	}

	/*Returns the position with the maximum key in
	subtree rooted at position p*/
	protected Position<Entry<K,V>> treeMax(Position<Entry<K,V>> p){
		Position<Entry<K,V>> walk = p;
		while(tree.isInternal(walk))
			walk = tree.right(walk);
		return tree.parent(walk);
	}

	public Entry<K,V> lastEntry(){
		if(isEmpty()) return null;
		return treeMax(root()).getElement();
	}

	/*returns the entry with greatest key less than or
	equal to given key(if any)*/
	public Entry<K,V> floorEntry(K key) throws IllegalArgumentException{
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(tree.isInternal(p)) return p.getElement();
		while(!tree.isRoot(p)){
			if(p== tree.right(tree.parent(p)))
				return tree.parent(p).getElement();
			else
				p = tree.parent(p);
		}
		return null;
	}

	/* returns the entry with greatest key strictly less
	than given key(if any) */
	public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException{
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(tree.isInternal(p) && tree.isInternal(tree.left(p)))
			return treeMax(tree.left(p)).getElement();

		while (!tree.isRoot(p)){
			if(p == tree.right(tree.parent(p)))
				return tree.parent(p).getElement();
			else
				p = tree.parent(p);
		}
		return null;
	}

	/* returns an iterable collection of all key-value
	entries of the map */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K,V>> buffer =
				new ArrayList<>(size());
		for(Position<Entry<K,V>> p: tree.inorder())
			if(tree.isInternal(p))
				buffer.add(p.getElement());
		return buffer;
	}

	public Iterable<Entry<K,V>> subMap(K fromKey, K toKey){
		ArrayList<Entry<K,V>> buffer =
				new ArrayList<>(size());
		if(compare(fromKey, toKey) < 0)
			subMapRecurse(fromKey, toKey, root(), buffer);
		return buffer;
	}

	private void subMapRecurse(K fromKey, K toKey,
							   Position<Entry<K,V>> p,
							   ArrayList<Entry<K,V>> buffer){
		if(tree.isInternal(p))
			if(compare(p.getElement(), fromKey) < 0)
//				p`s key is less than fromkey, so any
				//				relevant entries are to
				//				the right
				subMapRecurse(fromKey, toKey,
						tree.right(p), buffer);
			else {
				subMapRecurse(fromKey, toKey,
						tree.right(p), buffer); // first
				// consider left subtree
				if(compare(p.getElement(), toKey) < 0){
					// p is within range
					buffer.add(p.getElement()); // so add
					// it to buffer, and consider right
					// subtree as well
					subMapRecurse(fromKey, toKey,
							tree.right(p), buffer);
				}
			}
	}
}
