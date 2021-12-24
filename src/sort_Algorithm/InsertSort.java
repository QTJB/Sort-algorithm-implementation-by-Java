package sort_Algorithm;

public class InsertSort {

	static void insertionSort(int[] list) {

		/*
		 * Insertion Sort function.
		 */
		int temp = 0;
		int tempIndex = 0;

		for (int i = 0; i <= list.length - 2; ++i) {
			tempIndex = i;
//			To calculate the number of element comparisons.
			for (int j = tempIndex + 1; j > 0
					&& Sort_algorithm.comparisonWithCounters(list[tempIndex], list[j], 1, false); --j, --tempIndex) {

				temp = list[tempIndex];
				list[tempIndex] = list[j];
				list[j] = temp;

			}
		}

	}
}
