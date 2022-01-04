package com.java.adawang.DataStructure.StackAndQueue;

public interface Queue<E> {
	int size();
	boolean isEmpty();
	void enqueue(E e);
	E first();
	E dequeue();
}
