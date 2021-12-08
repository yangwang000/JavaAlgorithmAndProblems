package com.java.adawang.JavaBasic.Concurrency;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.ErrorManager;

class Receiver implements Runnable {
	private Data load;
	private ErrorManager Log;

	public Receiver(Data data) {
		this.load = data;
	}

	// standard constructors

	public void run() {
		for(String receivedMessage = load.receive();
			!"End".equals(receivedMessage);
			receivedMessage = load.receive()) {

			System.out.println("Recieve : " + receivedMessage);

			// ...
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				Log.error("Thread interrupted", e, -1);
			}
		}
	}
}
