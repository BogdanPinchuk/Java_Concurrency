import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.listing_1_1.UnsafeSequence;
import org.listing_1_2.Sequence;

class SequenceTest {

	@Test
	void test_getNext() throws InterruptedException {
		// Arrange
		// Act
		// Assert
		int countThreads = 100;
		List<Thread> threads = new ArrayList<>();
		Sequence sequence = new Sequence();

		{
			Thread thread;
			for (int i = 0; i < countThreads; i++) {
				thread = new Thread(() -> {
					try {
						sequence.getNext();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					print(sequence.toString());
				});

				threads.add(thread);
				thread.start();
			}
		}

		for (Thread thread : threads) {
			thread.join();
		}

		print("Result:");
		print(sequence.toString());
	}

	private void print(String s) {
		System.out.println(s);
	}
}
