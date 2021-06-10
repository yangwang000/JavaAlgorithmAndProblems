package com.java.adawang.datastructure.StackAndQueue;

import com.java.adawang.datastructure.LinkedList.SinglyLinkedList;

import java.util.Stack;

public class LinkedStack<E> extends Stack<E> {
	private SinglyLinkedList<E> list =
			new SinglyLinkedList<>();
	public LinkedStack(){}
	public int size() {return list.size();}
	public boolean isEmpty() {return list.isEmpty();}
	public E push(E element) {list.addFirst(element);
		return element;
	}
	public E top(){return list.first();}
	public E pop(){return list.removeFirst();}
}
