package com.java.adawang.DataStructure.ListAndIterator;

import java.util.*;

public class ArrayList<E> implements List<E> {
	private class ArrayIterator implements Iterator<E>{
		private int j=0;
		private boolean removable=false;
		@Override
		public boolean hasNext() {
			return j<size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if(j==size) throw new NoSuchElementException(
					"No next element");
			removable = true;
			return data[j++];
		}

		public void remove() throws IllegalStateException{
			if(!removable) throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j-1);
			j--;
			removable=false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

	public static final int CAPACITY=16;
	private E[] data;
	private int size = 0;

	public ArrayList() {this(CAPACITY);}
	public ArrayList(int capacity){
		data=(E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		checkIndex(index, size);
		return data[index];
	}

	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException{
		checkIndex(index, size);
		E temp = data[index];
		data[index] = element;
		return temp;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException,IllegalStateException{
		checkIndex(i, size+1);
		if(size==data.length)
			throw new IllegalStateException("Array is " +
					"full");
		for(int k=size-1; k>=i;k--)
			data[k+1] = data[k];
		data[i] = e;
		size++;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException{
		checkIndex(index, size);
		E temp = data[index];
		for(int k=index; k< size-1; k++)
			data[k] = data[k+1];
		data[size-1] = null;
		size--;
		return temp;
	}

	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if(i<0 || i>=n)
			throw new IndexOutOfBoundsException("Illegal " +
					"index: "+i);
	}

	@Override
	public boolean add(E e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
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
	public boolean addAll(int index, Collection<? extends E> c) {
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
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}
}
