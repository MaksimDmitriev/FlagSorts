package dmitriev.flags;

public class DutchFlag {

	public static final int VERIFY_INDEX_OK = -1;

	private DutchFlag() {
		throw new AssertionError();
	}

	public static void dutchFlag(int[] input, int mid) {
		if (input == null || input.length < 2) {
			return;
		}
		int i = 0; // the end of the red region (exclusive)
		int j = 0; // the element under consideration
		int k = input.length - 1; // the start of the blue region (exclusive)
		while (j <= k) {
			if (input[j] < mid) {
				Utils.swap(input, i, j);
				i++;
				j++;
			} else if (input[j] == mid) {
				j++;
			} else {
				Utils.swap(input, j, k);
				k--;
			}
		}
	}

	public static int verifyDutch(int[] input, int mid) {
		for (int i = 1; i < input.length; i++) {
			if (input[i] < mid) {
				if (input[i - 1] == mid) {
					return i;
				} else if (input[i - 1] > mid) {
					return i - 1;
				}
			} else if (input[i] > mid) {
				if (input[i - 1] <= mid) {
					return i;
				}
			}
		}
		return VERIFY_INDEX_OK;
	}
}
