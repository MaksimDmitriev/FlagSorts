package dmitriev.flags;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class DutchFlagTests {

	@Test
	public void dutchOnlyMids() {
		int mid = 35;
		int[] array = { mid, mid, mid };
		int midCount = getMidCount(array, mid);
		int i = DutchFlag.dutchFlag(array, mid);
		verifyDutch(array, mid, i, midCount);
	}

	@Test
	public void testDutchWithRandom() {
		int[] array = new int[10];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println("testDutchWithRandom array: " + Arrays.toString(array));
		int mid = array[random.nextInt(array.length - 1)];
		int midCount = getMidCount(array, mid);
		int i = DutchFlag.dutchFlag(array, mid);
		System.out.println("testDutchWithRandom output: " + Arrays.toString(array));
		verifyDutch(array, mid, i, midCount);

	}

	@Test
	public void testDutchSmallestMid2() {
		int[] array = { 12, 34, 781, -1 };
		int mid = -1;
		int midCount = getMidCount(array, mid);
		int i = DutchFlag.dutchFlag(array, mid);
		verifyDutch(array, mid, i, midCount);
	}

	@Test
	public void testDutchSmallestMid() {
		int[] array = { 12, 34, 781, -1 };
		int mid = -1;
		int midCount = getMidCount(array, mid);
		int i = DutchFlag.dutchFlag(array, mid);
		verifyDutch(array, mid, i, midCount);
	}

	@Test
	public void testDutchLargestMid() {
		int[] array = { 12, 34, 781, -1 };
		int mid = 781;
		int midCount = getMidCount(array, mid);
		int i = DutchFlag.dutchFlag(array, mid);
		verifyDutch(array, mid, i, midCount);
	}

	@Test
	public void testDutchWithoutMid() {
		int[] array = { 12, 34, 781, -1 };
		int mid = 90;
		int midCount = getMidCount(array, mid);
		int i = DutchFlag.dutchFlag(array, mid);
		verifyDutch(array, mid, i, midCount);
	}

	private int getMidCount(int[] input, int mid) {
		if (input == null) {
			throw new NullPointerException("the array cannot be null");
		}
		int midCount = 0;
		for (int elem : input) {
			if (elem == mid) {
				midCount++;
			}
		}
		return midCount;
	}

	private void verifyDutch(int[] output, int mid, int midStart, int midCount) {
		for (int i = 0; i < midStart; i++) {
			Assert.assertTrue(output[i] < mid);
		}
		int midEnd = midStart + midCount;
		for (int i = midStart; i < midEnd; i++) {
			Assert.assertEquals(mid, output[i]);
		}
		for (int i = midEnd + 1; i < output.length; i++) {
			Assert.assertTrue(output[i] > mid);
		}
	}
}