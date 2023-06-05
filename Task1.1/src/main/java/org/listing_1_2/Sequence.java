package org.listing_1_2;

import java.util.Random;

public class Sequence {
	private int value;

	public synchronized int getNext() throws InterruptedException {
		Thread.sleep(50 + new Random().nextInt(10));
		return value++;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
