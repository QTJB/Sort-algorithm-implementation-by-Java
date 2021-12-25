package sort_Algorithm;

public class BubbleSort {

	static void bubbleSort(int[] list) {
		for (int i = list.length - 1; i > 0; i--) {
			for (int j = 0; i < j - 1; i++) {
				if (Sort_algorithm.comparisonWithCounters(list[j], list[j + 1], 5, false)) {
					Sort_algorithm.swap(list, list[j], list[j + 1]);
				}
			}
		}
	}
}
