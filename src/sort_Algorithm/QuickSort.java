package sort_Algorithm;

public class QuickSort {
	/*
	 * Quick Sort function includes 3 parts. *quickSort. *quickSortPart. *partition.
	 */
	static void quickSort(int[] list) {
		quickSortPart(list, 0, list.length - 1);
	}

	static void quickSortPart(int[] list, int left, int right) {

		int pivot = partition(list, left, right);
		if (left < pivot - 1) {
			quickSortPart(list, left, pivot - 1);
		}
		if (pivot + 1 < right) {
			quickSortPart(list, pivot + 1, right);
		}
		return;
	}

	static int partition(int[] list, int left, int right) {

		while (true) {
			while (left < right && Sort_algorithm.comparisonWithCounters(list[right], list[left], 3, false)) {
				right--;
			}
			if (left < right) {
				Sort_algorithm.swap(list, left++, right);
			} else {
				return left;
			}
			while (left < right && Sort_algorithm.comparisonWithCounters(list[right], list[left], 3, false)) {
				left++;
			}
			if (left < right) {
				Sort_algorithm.swap(list, left, right--);
			} else {
				return left;
			}
		}

	}
}
