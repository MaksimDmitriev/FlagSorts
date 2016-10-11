package dmitriev.flags;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class FlagSortsTests {
	
	@Test
	public void testDutch() {
		int[] input = new int[10];
		Random random = new Random();
		for (int i = 0; i < input.length; i++) {
			input[i] = random.nextInt(100);
		}
		System.out.println(Arrays.toString(input));
		int midIndex = random.nextInt(input.length - 1);
		int mid = input[midIndex];
		System.out.println("mid=" + mid);
		FlagSorts.dutchFlag(input, mid);
		verifyDutch(input, midIndex);
	}
	
	private void verifyDutch(int[] input, int midIndex) {
		if (input == null || input.length < 2) {
			return;
		}
		for (int index = 1; index < input.length; index++) {
			if (index < midIndex) {
				Assert.assertTrue(
						Arrays.toString(input)
						+ ", input[" + index + "] > input[" + midIndex + "]",
						input[index] < input[midIndex]);
			} else if (index > midIndex) {
				Assert.assertTrue(
						"input[" + (index) + "] > input[" + index + "]",
						input[index] < input[midIndex]);
			}

		}
	}
}