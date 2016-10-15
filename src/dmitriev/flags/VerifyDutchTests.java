package dmitriev.flags;

import org.junit.Assert;
import org.junit.Test;

public class VerifyDutchTests {

	@Test
	public void dutchBigInRed() {
		int mid = 35;
		int[] input = { 12, 34, 67, mid, 120 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(2, index);
	}

	@Test
	public void dutchBigIsFirstInRed() {
		int mid = 35;
		int[] input = { 45, 34, 12, mid, 120 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(0, index);
	}

	@Test
	public void dutchBigInWhite() {
		int mid = 35;
		int[] input = { 12, 34, 12, mid, mid, 45, mid, 120 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(5, index);
	}

	@Test
	public void dutchBigInWhite2() {
		int mid = 35;
		int[] input = { 12, 34, 12, mid, 45, mid, mid, 120 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(4, index);
	}

	@Test
	public void dutchSmallInWhite() {
		int mid = 35;
		int[] input = { 12, 34, 12, mid, mid, 1, mid, 120 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(5, index);
	}

	@Test
	public void dutchSmallInBlue() {
		int mid = 35;
		int[] input = { 12, 34, 12, mid, mid, mid, 1, 120 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(6, index);
	}

	@Test
	public void dutchTwoSmallsInWhite() {
		int mid = 35;
		int[] input = { 12, 34, 12, mid, 1, 1, mid, 120 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(4, index);
	}

	@Test
	public void testDutchSmallAfterMid() {
		int mid = 35;
		int[] input = { 12, mid, 34, 75 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(2, index);
	}
	
	@Test
	public void testDutchBigBeforeMid() {
		int mid = 35;
		int[] input = { 12, 100, mid, 34, 75 };
		int index = DutchFlag.verifyDutch(input, mid);
		Assert.assertEquals(1, index);
	}

}
