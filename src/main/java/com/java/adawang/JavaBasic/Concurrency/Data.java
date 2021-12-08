package com.java.adawang.JavaBasic.Concurrency;

import java.util.logging.ErrorManager;

public class Data {
	private String packet;

	// True if receiver should wait
	// False if sender should wait
	private boolean transfer = true;
	private ErrorManager Log;

	public synchronized void send(String packet) {
		while (!transfer) {
			try {
				wait();
			} catch (InterruptedException e)  {
				Thread.currentThread().interrupt();
				Log.error("Thread interrupted", e, -1);
			}
		}
		transfer = false;

		this.packet = packet;
		notifyAll();
	}

	public synchronized String receive() {
		while (transfer) {
			try {
				wait();
			} catch (InterruptedException e)  {
				Thread.currentThread().interrupt();
				Log.error("Thread interrupted", e, -1);
			}
		}
		transfer = true;

		notifyAll();
		return packet;
	}
}
