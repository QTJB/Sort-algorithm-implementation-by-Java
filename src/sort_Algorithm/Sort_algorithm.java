package sort_Algorithm;

import java.util.Arrays;

public class Sort_algorithm {

	static int number;
	static int[][] matrixIterative;
	static int indexPlace;
	private static int permutationsNumber;
	private static int[][] matrixRecursive;
	private static int[][] matrixRecursive2;
	private static int[][] matrixRecursive3;
	private static int[][] matrixRecursive4;
	private static int insertSortCount = 0;
	private static int mergeSortCount = 0;
	private static int quickSortCount = 0;
	private static int selectSortCount = 0;

//	Setting All permutation.
	static void setAllCondition() {
		permutationsNumber = totalPermutationsNumber(number);

		System.out.println("\n" + "************************************************");
		System.out.println("Total number of all permutations possibility: " + permutationsNumber + "\n");
		setAllConditionByRecursive(number);
		setConditionByIterative(number);
	}

	private static void setAllConditionByRecursive(int number) {

		matrixRecursive = setConditionByRecursive(number);
		matrixRecursive2 = setConditionByRecursive(number);
		matrixRecursive3 = setConditionByRecursive(number);
		matrixRecursive4 = setConditionByRecursive(number);

//		Notifying user that the function is completed.
		System.out.println("Initial condition established through recursive algorithm." + "\n");
	}

//  Setting start condition through nextPermutation Recursive algorithm.
	private static int[][] setConditionByRecursive(int number) {

		int[][] matrix = new int[permutationsNumber][number];
		int[] list = new int[number];

		for (int i = 0; i <= number - 1; ++i) { // initial permutation:{1,2,3,4,.......n}.
			list[i] = i + 1;
		}

		matrix[0] = Arrays.copyOf(list, list.length); // set first element of martixRecursive.

//		setting the rest of element.
		for (int i = 1; i <= permutationsNumber - 1 && NextPermutation.nextPermutation(list, 0, number); ++i) {
			matrix[i] = Arrays.copyOf(list, list.length);
		}

		return matrix;
	}

//	Setting start condition through Iterative algorithm nextPermutation.
	private static void setConditionByIterative(int number) {

		matrixIterative = new int[permutationsNumber][number];
		int[] list = new int[number];

		for (int i = 0; i <= number - 1; ++i) { // initial permutation:{1,2,3,4,.......n}.
			list[i] = i + 1;
		}

		matrixIterative[0] = Arrays.copyOf(list, list.length); // set first element of martixIterative.
		indexPlace++;

//		setting the rest of element.
		NextPermutation.nextPermutation(list);

//		Notifying user that the function is completed.
		System.out.println("Initial condition established through iterative algorithm." + "\n");

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
		selectSortToMatrix();

		System.out.println("************************************************" + "\n" + "Summary:");
		System.out.println("Total number of comparisons via insertionSort of matrix are :" + insertSortCount);
		System.out.println("Total number of comparisons via MergeSort of matrix are :" + mergeSortCount);
		System.out.println("Total number of comparisons via Quick Sort of matrix are :" + quickSortCount);
		System.out.println("Total number of comparisons via Selection Sort of matrix are :" + selectSortCount + "\n");

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
		System.out.println("The average number of element comparisons of selection sort is: " + selectSortCount + "/"
				+ permutationsNumber + " = "
				+ String.format("%.4f", (Double.valueOf(selectSortCount) / permutationsNumber)));

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

//	Using selection sort.
	private static void selectSortToMatrix() {

		for (int i = 0; i <= matrixRecursive4.length - 1; ++i) {
			SelectSort.selectionSort(matrixRecursive4[i]);
		}

		System.out.println("************************************************");
		System.out.println("Total number of comparisons via selectSort of Recursive matrix:  " + selectSortCount);

	}

	/*--------------------------------------------------------
	 * 
	 * 
	 * 
	 * The function of following are all auxiliary functions.
	 */

//	Calculating the total number of all permutations possibility.

	static int[][] matrixRecursive() {
		return matrixRecursive;
	}

	static int[][] matrixIterative() {
		return matrixIterative;
	}

	private static int totalPermutationsNumber(int number) {

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
		case 4:
			selectSortCount++;
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
	static int indexOfMaximalElement(int[] list, int number) {

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

	static void displayAllSortedMatrix() {
		testFunction(matrixRecursive);
		testFunction(matrixRecursive2);
		testFunction(matrixRecursive3);
		testFunction(matrixRecursive4);

	}

//	Reserving the order of elements.
	static void reverse(int[] list, int start, int end) {
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
