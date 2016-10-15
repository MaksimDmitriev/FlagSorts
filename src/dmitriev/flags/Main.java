package dmitriev.flags;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] input = { 12, 34, 781, -1 };
		int mid = -1;
		FlagSorts.dutchFlag(input, mid);
		System.out.println(Arrays.toString(input));
	}
}
