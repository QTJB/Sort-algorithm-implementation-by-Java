package Sort_algorithm;

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

		/*
		 * three function below is use for display the matrix and check whether
		 * permutation is same. Due to these function consume lots of times and resource
		 * when N = 10. Therefore, use this Function If when we needed instead of keep
		 * using this methods.
		 */

//		Sort_algorithm.displayTwoMatrix();
//		Sort_algorithm.displaythreeSortedMatrix();
//		Sort_algorithm.checkIsAnyRepeat(matrixIterative);
//		Sort_algorithm.checkIsAnyRepeat(matrixRecursive);

		Sort_algorithm.allSortMethodToMatrix();

//		Sort_algorithm.displayTwoMatrix();
//		Sort_algorithm.displaythreeSortedMatrix();

	}

}
