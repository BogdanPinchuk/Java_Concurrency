package org.listing_1_1;

import java.util.Random;

public class UnsafeSequence {
	private int value;

	public int getNext() throws InterruptedException {
		Thread.sleep(50 + new Random().nextInt(10));
		return value++;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
