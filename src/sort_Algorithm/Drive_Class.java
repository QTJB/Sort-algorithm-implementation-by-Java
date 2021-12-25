package sort_Algorithm;

import java.util.Scanner;

public class Drive_Class {

	public static void main(String[] args) {

		System.out.println("Please input an Integer number (Number>0):");

		Scanner input = new Scanner(System.in);

		Sort_algorithm.number = input.nextInt();

		input.close();

		Sort_algorithm.setAllCondition();

		System.out.println(
				"All Initial condition established." + "\n" + "************************************************");

		testFunction();

		Sort_algorithm.allSortMethodToMatrix();

//		testFunction();

	}

	/*
	 * three function below is use for display the matrix and check whether
	 * permutation is same. Due to these function consume lots of times and resource
	 * when N = 10. Therefore, use this Function If when we needed instead of keep
	 * using this methods.
	 */
	private static void testFunction() {
//		Sort_algorithm.displayTwoMatrix();
		Sort_algorithm.displayAllSortedMatrix();

//		Sort_algorithm.checkIsAnyRepeat(Sort_algorithm.matrixIterative());
//		Sort_algorithm.checkIsAnyRepeat(Sort_algorithm.matrixRecursive());
	}
}
