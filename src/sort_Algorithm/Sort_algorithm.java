package sort_Algorithm;

import java.util.Arrays;

public class Sort_algorithm {

	private static int permutationsNumber;
	private static int[][] matrixRecursive;
	private static int[][] matrixRecursive2;
	private static int[][] matrixRecursive3;
	private static int[][] matrixIterative;
	static int number;
	private static int indexPlace;
	private static int insertSortCount = 0;
	private static int mergeSortCount = 0;
	private static int quickSortCount = 0;

//	Setting All permutation.
	static void setAllCondition() {
		permutationsNumber = totalPermutationsNumber(number);

		System.out.println("\n" + "************************************************");
		System.out.println("Total number of all permutations possibility: " + permutationsNumber + "\n");
		setConditionByRecursive(number);
		setConditionByIterative(number);
	}

//  Setting start condition through nextPermutation Recursive algorithm.
	static void setConditionByRecursive(int number) {

		matrixRecursive = new int[permutationsNumber][number];
		matrixRecursive2 = new int[permutationsNumber][number];
		matrixRecursive3 = new int[permutationsNumber][number];
		int[] list = new int[number];

		for (int i = 0; i <= number - 1; ++i) { // initial permutation:{1,2,3,4,.......n}.
			list[i] = i + 1;
		}

		matrixRecursive[0] = Arrays.copyOf(list, list.length); // set first element of martixRecursive.
		matrixRecursive2[0] = Arrays.copyOf(list, list.length);
		matrixRecursive3[0] = Arrays.copyOf(list, list.length);

//		setting the rest of element.
		for (int i = 1; i <= permutationsNumber - 1 && nextPermutation(list, 0, number); ++i) {
			matrixRecursive[i] = Arrays.copyOf(list, list.length);
			matrixRecursive2[i] = Arrays.copyOf(list, list.length);
			matrixRecursive3[i] = Arrays.copyOf(list, list.length);
		}

//		Notifying user that the function is completed.
		System.out.println("Initial condition established through recursive algorithm." + "\n");

	}

//	Setting start condition through Iterative algorithm nextPermutation.
	static void setConditionByIterative(int number) {

		matrixIterative = new int[permutationsNumber][number];
		int[] list = new int[number];

		for (int i = 0; i <= number - 1; ++i) { // initial permutation:{1,2,3,4,.......n}.
			list[i] = i + 1;
		}

		matrixIterative[0] = Arrays.copyOf(list, list.length); // set first element of martixIterative.

//		setting the rest of element.
		nextPermutation(list);

//		Notifying user that the function is completed.
		System.out.println("Initial condition established through iterative algorithm." + "\n");

	}

//  Recursive algorithm nextPermutation.

	/*
	 * If (a1,‚Ä?,an) is an arbitrary permutation of the numbers 1,2,‚Ä?,n, then: ÔÅ?
	 * If the maximal element of the permutation (which is n) is not the first
	 * element of the permutation, say, n = a(i), where i > 1, then swap a(i) and
	 * a(i-1) and return true(1). ÔÅ? If the maximal element of the permutation is in
	 * the first position, i.e. n = a1, call nextPermutation algorithm for the
	 * smaller (n-1)-element permutation (a2,‚Ä?,an) (this is a recursive step!) and:
	 * ÔÇ? if this call returns true (1), append a1 to the obtained permutation of
	 * (n-1) elements and return true (1). ÔÇ? else return false (0).
	 */
	private static boolean nextPermutation(int[] list, int start, int maximum) {

		int index = indexOfMaximalElement(list, maximum);
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

	private static void nextPermutation(int[] list) {

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
					swap(list, j, index);
					break;
				}
			}
			reverse(list, index + 1, list.length - 1);

			matrixIterative[indexPlace] = Arrays.copyOf(list, list.length);
			++indexPlace;

		}

	}

	/*--------------------------------------------------------
	 * 
	 * 
	 * 
	 * the function of following are use to sort all the list on the matrix.
	 *   All the permutation will become in order after these function used.
	 *   if want to see the all permutation. 
	 *   Please use void testFunction OR void displayTwoMartix before use these function.
	 */

//	Combined to one method.
	static void allSortMethodToMatrix() {
		insertionSortToMatrix();
		mergeSortToMatrix();
		quickSortToMatrix();

		System.out.println("************************************************" + "\n" + "Summary:");
		System.out.println("Total number of comparisons via insertionSort of matrix are :" + insertSortCount);
		System.out.println("Total number of comparisons via MergeSort of matrix are :" + mergeSortCount);
		System.out.println("Total number of comparisons via Quick Sort of matrix are :" + quickSortCount + "\n");

		System.out.println(
				"The permutation possibility of this Arrays are: " + permutationsNumber + "." + "\n\n" + "Therefore:");
		System.out.println("The average number of element comparisons of Insertion sort is: " + insertSortCount + "/"
				+ permutationsNumber + " = "
				+ String.format("%.4f", (Double.valueOf(insertSortCount) / permutationsNumber)));
		System.out.println("The average number of element comparisons of Merge sort is: " + mergeSortCount + "/"
				+ permutationsNumber + " = "
				+ String.format("%.4f", (Double.valueOf(mergeSortCount) / permutationsNumber)));
		System.out.println("The average number of element comparisons of Quick sort is: " + quickSortCount + "/"
				+ permutationsNumber + " = "
				+ String.format("%.4f", (Double.valueOf(quickSortCount) / permutationsNumber)));

		System.out.println("************************************************");
	}

//	Using insertion sort.
	private static void insertionSortToMatrix() {

		for (int i = 0; i <= matrixRecursive.length - 1; ++i) {
			InsertSort.insertionSort(matrixRecursive[i]);
		}

		System.out.println("************************************************");
		System.out.println("Total number of comparisons via insertionSort of Recursive matrix:  " + insertSortCount);

	}

//	Using merge sort.
	private static void mergeSortToMatrix() {

		for (int i = 0; i <= matrixRecursive2.length - 1; ++i) {
			MergeSort.mergeSort(matrixRecursive2[i]);
		}

		System.out.println("************************************************");
		System.out.println("Total number of comparisons via mergeSort of Recursive matrix:  " + mergeSortCount);

	}

//	Using quick sort.
	private static void quickSortToMatrix() {

		for (int i = 0; i <= matrixRecursive3.length - 1; ++i) {
			QuickSort.quickSort(matrixRecursive3[i]);
		}

		System.out.println("************************************************");
		System.out.println("Total number of comparisons via quickSort of Recursive matrix:  " + quickSortCount);

	}

	/*--------------------------------------------------------
	 * 
	 * 
	 * 
	 * The function of following are all auxiliary functions.
	 */

//	Calculating the total number of all permutations possibility.
	static int totalPermutationsNumber(int number) {

		if (number == 1) {
			return 1;
		} else {
			return number * totalPermutationsNumber((number - 1));
		}
	}

	/*
	 * To calculate the number of element comparisons. If equal is true means
	 * compare whether first element is bigger or equal to second. If equal is false
	 * means compare whether first element is bigger to second. Different typeOfSort
	 * number represents different sort algorithm. 1 -Insert sort 2 - Merge sort 3 -
	 * Quick sort
	 */
	static boolean comparisonWithCounters(int firstElement, int secondElement, int typeOfSort, boolean equal) {

		switch (typeOfSort) {
		case 1:
			insertSortCount++;
			break;
		case 2:
			mergeSortCount++;
			break;
		case 3:
			quickSortCount++;
			break;
		default:
			throw new IllegalArgumentException("Unexpected typeOfSort number: " + typeOfSort);
		}

		if (equal) {
			if (firstElement >= secondElement) {
				return true;
			} else {
				return false;
			}
		} else {
			if (firstElement > secondElement) {
				return true;
			} else {
				return false;
			}
		}

	}

//	Finding out maximum number's index of list.
	private static int indexOfMaximalElement(int[] list, int number) {

		int numberIndex = 0;

		for (int i = 0; i <= list.length - 1; ++i) {
			if (list[i] == number) {
				numberIndex = i;
			}
		}
		return numberIndex;
	}

	// This is a test function to display one specify matrix.
	private static void testFunction(int[][] matrix) {

		System.out.println("martix details: " + "\n");

		for (int i = 0; i <= matrix.length - 1; ++i) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		System.out.println("******************");
	}

//	Swapping two elements on the list.
	static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

//	Display the both matrix.
	static void displayTwoMatrix() {
		testFunction(matrixRecursive);
		testFunction(matrixIterative);

	}

	static void displaythreeSortedMatrix() {
		testFunction(matrixRecursive);
		testFunction(matrixRecursive2);
		testFunction(matrixRecursive3);

	}

//	Reserving the order of elements.
	private static void reverse(int[] list, int start, int end) {
		while (start < end) {
			swap(list, start, end);
			++start;
			--end;
		}
	}

//	check whether the matrix has same permutation.
	static void checkIsAnyRepeat(int[][] matrix) {
		int number = 0;

		for (int i = 0; i <= matrix.length - 1; i++) {
			for (int j = i + 1; j <= matrix.length - 2; j++) {
				if (java.util.Arrays.equals(matrix[i], matrix[j])) {
					number++;
				}
			}

		}

		System.out.println("This martix has: " + number + " same permutation.");
	}
}
