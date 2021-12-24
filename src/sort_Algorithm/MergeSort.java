package sort_Algorithm;

public class MergeSort {
	/*
	 * Merge Sort function includes 3 parts. *mergeSort. *mergeSortPart. *merge.
	 */
	static void mergeSort(int[] list) {
		mergeSortPart(list, 0, list.length - 1);
	}

	static void mergeSortPart(int[] list, int first, int last) {
		if (last > first) {
			int mid = (first + last) / 2;
			mergeSortPart(list, first, mid);
			mergeSortPart(list, mid + 1, last);
			merge(list, first, mid, last);
		}
	}

	static void merge(int[] list, int first, int mid, int last) {
		int[] temp = new int[last + 1];
		int first1 = first;
		int last1 = mid;
		int first2 = mid + 1;
		int last2 = last;
		int index = first1;

		while (last1 >= first1 && last2 >= first2) {
			if (Sort_algorithm.comparisonWithCounters(list[first2], list[first1], 2, false)) {
				temp[index++] = list[first1++];
			} else {
				temp[index++] = list[first2++];
			}
		}
		while (last1 >= first1) {
			temp[index++] = list[first1++];
		}
		while (last2 >= first2) {
			temp[index++] = list[first2++];
		}

		for (index = first; index <= last; ++index) {
			list[index] = temp[index];
		}
	}

}
