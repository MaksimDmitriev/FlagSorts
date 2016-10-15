package dmitriev.flags;

public class Utils {

	private Utils() {
		throw new AssertionError();
	}

	public static void swap(int[] input, int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
