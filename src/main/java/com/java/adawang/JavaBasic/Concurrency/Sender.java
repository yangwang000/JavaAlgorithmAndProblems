package com.java.adawang.JavaBasic.Concurrency;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.ErrorManager;

public class Sender implements Runnable {
	private Data data;
	private ErrorManager Log;

	public Sender(Data data) {
		this.data = data;
	}

	// standard constructors

	public void run() {
		String packets[] = {
				"First packet",
				"Second packet",
				"Third packet",
				"Fourth packet",
				"End"
		};

		for (String packet : packets) {
			data.send(packet);
			System.out.println("Send : "+packet);

			// Thread.sleep() to mimic heavy server-side processing
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e)  {
				Thread.currentThread().interrupt();
				Log.error("Thread interrupted", e, -1);
			}
		}
	}
}
