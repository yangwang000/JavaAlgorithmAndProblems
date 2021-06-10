package com.java.adawang.datastructure.Trees;

import com.java.adawang.datastructure.ListAndIterator.Position;

public interface BinaryTree<E> extends Tree<E> {
	Position<E> left(Position<E> p) throws IllegalArgumentException;
	Position<E> right(Position<E> p) throws IllegalArgumentException;
	Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
