package com.java.adawang.datastructure.StackAndQueue;

import com.java.adawang.datastructure.LinkedList.SinglyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LinkedQueue<E> implements Queue<E> {
	private SinglyLinkedList<E> list=
			new SinglyLinkedList<>();
	public LinkedQueue(){}
	public int size() {return list.size();}
	public boolean isEmpty() {return list.isEmpty();}
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	public E first() {return list.first();}
	public E dequeue() {return list.removeFirst();}

	@Override
	public boolean add(E e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean offer(E e) {
		return false;
	}

	@Override
	public E remove() {
		return null;
	}

	@Override
	public E poll() {
		return null;
	}

	@Override
	public E element() {
		return null;
	}

	@Override
	public E peek() {
		return null;
	}
}
