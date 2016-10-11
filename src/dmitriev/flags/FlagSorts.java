package dmitriev.flags;

public class FlagSorts {

	private FlagSorts() {
		throw new AssertionError();
	}

	public static void myUsFlagSort(int[] input, int stripeLen, int red, int white) {
		// Input: 1, 2, 1, 1, 1, 2, 2, 2
		// Output: 1, 1, 2, 2, 1, 1, 2, 2

		// Let 1 be red
		// Let 2 be white

		// Red stripes are at 0, 1, 4, 5 ...
		int redIndex = 0;

		// White stripes are at 2, 3, 6, 7 ...
		int whiteIndex = 2;

		while (redIndex < input.length && whiteIndex < input.length) {
			if (input[redIndex] == red) {
				redIndex = getNewRedIndex(redIndex);
			} else {
				if (input[whiteIndex] == red) {
					swap(input, redIndex, whiteIndex);
					redIndex = getNewRedIndex(redIndex);
				}
				if (whiteIndex % 2 == 0) {
					whiteIndex++;
				} else {
					whiteIndex += 3;
				}
			}
		}
	}

	private static int getNewRedIndex(int redIndex) {
		if (redIndex % 4 == 0) {
			redIndex++;
		} else {
			redIndex += 3;
		}
		return redIndex;
	}

	public static void dutchFlag(int[] input, int mid) {
		if (input == null || input.length < 2) {
			return;
		}
		int i = 0; // the end of the red region
		int j = 0; // the element under consideration
		int k = input.length - 1; // the start of the blue region
		while (j <= k) {
			if (input[j] < mid) {
				swap(input, i, j);
				i++;
				j++;
			} else if (input[j] == mid) {
				j++;
			} else {
				swap(input, i, k);
				k--;
			}
		}
	}

	private static void swap(int[] input, int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

	public static void russianFlagProblem(int[] input, int red, int white, int blue) {
		// input: 1, 2, 3, 1, 1, 2, 3, 1, 1
		// Dutch: 1, 1, 1, 1, 1, 2, 2, 3, 3

		// (1 - red, 2 - white, 3 - blue)

		// Russian: 2 - white, 3 - blue, 1 - red
		// output: 2, 2, 3, 3, 1, 1, 1, 1, 1

		int i = 0; // the end of the white region (exclusive)
		int j = 0; // the current element
		int k = input.length - 1; // the start of the blue region (exclusive)

		while (j <= k) {
			if (input[j] == white) {
				swap(input, j++, i++);
			} else if (input[j] == red) {
				swap(input, j, k--);
			} else {
				j++;
			}
		}
	}

	/**
	 * Elements of the input array must be in [1, 100]. The given pivot can be
	 * any number
	 * 
	 * @param input
	 * @param pivot
	 */
	public static void britishFlagProblem(int[] input, int pivot) {
		// input: [1, pivot, 2, 4, 1, 45, 5]
		// output: [1, 2, 4 pivot 45, 5, 1]

		// TODO
	}
}
