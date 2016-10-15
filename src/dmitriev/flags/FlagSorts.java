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
					Utils.swap(input, redIndex, whiteIndex);
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

	// [22, 46, 68, 47, 43, 47, 58, 43, 0, 27]
	// mid=43
	// [22, 27, 0, 47, 43, 58, 43, 47, 68, 46]




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
				Utils.swap(input, j++, i++);
			} else if (input[j] == red) {
				Utils.swap(input, j, k--);
			} else {
				j++;
			}
		}
	}

	/**
	 * Elements of the input array must be in [1, 10]. The given pivot can be
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

	public static int[] countingSortReversed(int[] a, int k) {
		int[] c = new int[k];
		int[] b = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}

		for (int i = c.length - 1; i > 0; i--) {
			c[i - 1] += c[i];
		}

		for (int i = 0; i < a.length; i++) {
			b[--c[a[i]]] = a[i];
		}
		return b;
	}

	public static int[] countingSort(int[] a, int k) {
		int c[] = new int[k];
		for (int i = 0; i < a.length; i++)
			c[a[i]]++;
		
		for (int i = 1; i < k; i++)
			c[i] += c[i - 1];
		
		int b[] = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--)
			b[--c[a[i]]] = a[i];

		return b;
	}

	// public static int[] countingSort(int[] input, int k) {
	// // 0 <= input[i] <= k
	// int[] result = new int[input.length];
	// int[] auxiliary = new int[k + 1];
	//
	// for (int j = 0; j < input.length; j++) {
	// auxiliary[input[j]] = auxiliary[input[j]] + 1;
	// }
	// System.out.println(Arrays.toString(auxiliary));
	// int resultIndex = 0;
	// for (int i = 0; i < auxiliary.length; i++) {
	// if (auxiliary[i] != 0) {
	// for (int m = 0; m < auxiliary[i]; m++) {
	// result[resultIndex++] = i;
	// }
	// }
	// }
	// return result;
	// }
}
