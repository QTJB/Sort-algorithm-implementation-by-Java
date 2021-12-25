package sort_Algorithm;

public class SelectSort {

	static void selectionSort(int[] list) {
		int maxNumberIndex = 0;
		for (int i = list.length - 1; i > 0; i--) {
			maxNumberIndex = indexOfMaximalElement(list, 0, i);
			Sort_algorithm.swap(list, maxNumberIndex, i);
		}
	}

//	Finding the index of maximum number of the list between given place.
	private static int indexOfMaximalElement(int[] list, int startIndex, int lastIndex) {
		int max = list[startIndex];
		int index = startIndex;

		for (int i = startIndex; i <= lastIndex; i++) {
			if (Sort_algorithm.comparisonWithCounters(list[i], max, 4, true)) {
				max = list[i];
				index = i;
			}
		}

		return index;
	}
}
