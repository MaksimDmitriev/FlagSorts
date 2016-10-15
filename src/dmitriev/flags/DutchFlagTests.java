package dmitriev.flags;

import java.util.Random;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class DutchFlagTests {

	// @Test
	// public void dutchOnlyMids() {
	// int mid = 35;
	// int[] input = { mid, mid, mid };
	// verifyDutch(input, mid);
	// }
	//
	// @Test
	// public void testDutchWithRandom() {
	// int[] input = new int[10];
	// Random random = new Random();
	// for (int i = 0; i < input.length; i++) {
	// input[i] = random.nextInt(100);
	// }
	// int mid = input[random.nextInt(input.length - 1)];
	// FlagSorts.dutchFlag(input, mid);
	// verifyDutch(input, mid);
	// }
	//
	// @Test
	// public void testDutchSmallestMid() {
	// int[] input = { 12, 34, 781, -1 };
	// int mid = -1;
	// FlagSorts.dutchFlag(input, mid);
	// verifyDutch(input, mid);
	// }
	//
	// @Test
	// public void testDutchLargestMid() {
	// int[] input = { 12, 34, 781, -1 };
	// int mid = 781;
	// FlagSorts.dutchFlag(input, mid);
	// verifyDutch(input, mid);
	// }
	//
	// @Test
	// public void testDutchWithoutMid() {
	// int[] input = { 12, 34, 781, -1 };
	// int mid = 90;
	// FlagSorts.dutchFlag(input, mid);
	// verifyDutch(input, mid);
	// }
	//
	// private int verifyDutch(int[] input, int mid) {
	// Assume.assumeFalse(input == null || input.length < 2);
	//
	// int index = -1;
	// for (int i = 1; i < input.length; i++) {
	// if (input[i] < mid) {
	// Assert.assertTrue("input[" + (i - 1) + "]>=mid, mid=" + mid, input[i - 1]
	// < mid);
	// return index;
	// } else if (input[i - 1] > mid) {
	// Assert.assertTrue("input[" + i + "]<=mid, mid=" + mid, input[i] > mid);
	// }
	// }
	// }
}