package sort_Algorithm;

import java.util.Arrays;

public class NextPermutation {
//  Recursive algorithm nextPermutation.

	/*
	 * If (a1,a1,....,an) is an arbitrary permutation of the numbers 1,2,‚Ä?,n, then:
	 * ÔÅ? If the maximal element of the permutation (which is n) is not the first
	 * element of the permutation, say, n = a(i), where i > 1, then swap a(i) and
	 * a(i-1) and return true(1). ÔÅ? If the maximal element of the permutation is in
	 * the first position, i.e. n = a1, call nextPermutation algorithm for the
	 * smaller (n-1)-element permutation (a2,‚Ä?,an) (this is a recursive step!) and:
	 * ÔÇ? if this call returns true (1), append a1 to the obtained permutation of
	 * (n-1) elements and return true (1). ÔÇ? else return false (0).
	 */
	static boolean nextPermutation(int[] list, int start, int maximum) {

		int index = Sort_algorithm.indexOfMaximalElement(list, maximum);
		int temp = 0;

		if (index != start) {
			temp = list[index];
			list[index] = list[index - 1];
			list[index - 1] = temp;
			return true;

		} else {
			temp = list[start];
			if (nextPermutation(list, start + 1, maximum - 1)) {

				for (int i = start; i <= list.length - 2; ++i) {
					list[i] = list[i + 1];
				}
				list[list.length - 1] = temp;
				return true;
			} else {
				return false;
			}
		}
	}

//  Iterative algorithm nextPermutation.
	static void nextPermutation(int[] list) {

		int index = 0;
		while (true) {
			for (int i = list.length - 2; i >= 0; --i) {
				if (list[i + 1] > list[i]) {
					index = i;
					break;
				} else if (i == 0) {
					return;
				}
			}
			for (int j = list.length - 1; j >= 0; --j) {
				if (list[j] > list[index]) {
					Sort_algorithm.swap(list, j, index);
					break;
				}
			}
			Sort_algorithm.reverse(list, index + 1, list.length - 1);

			Sort_algorithm.matrixIterative[Sort_algorithm.indexPlace] = Arrays.copyOf(list, list.length);
			++Sort_algorithm.indexPlace;

		}

	}
}
