import java.util.Random;
import java.util.Arrays;

public class QCTest {
	public static void main(String[] args) {
		/*
		 * 1) Change Attached Code to select the pivot as below the right most element.
		 * � � a) the left most element
		 * � � b) a random number between 1 and 100
		 * � � c) the middle element
		 * For each pivot selection , print out the number of comparisons that are
		 * needed
		 * 
		 * 2) Run 100 sorts of 1000 randomly chosen numbers from 1 to 100. For each
		 * test, determine the number of comparisons. Output the minimum, maximum and
		 * average of this number across the 100 sorts.
		 * 
		 * 3) Generate a series of numbers that cause a n squared number of comparisons,
		 * the QuickSort worst case.
		 */
		// some starter code
		final int ARRAYLENGTH = 1000;
		Random r = new Random(3);
		int[] numberA = new int[ARRAYLENGTH]; // inefficient, but want to do 4 pivots
		int[] numberB = new int[ARRAYLENGTH];
		int[] numberC = new int[ARRAYLENGTH];
		int[] numberD = new int[ARRAYLENGTH];
		int[] comparisons_arr_a = new int[100]; // keep track of each round's comparisons
		int[] comparisons_arr_b = new int[100];
		int[] comparisons_arr_c = new int[100];
		int[] comparisons_arr_d = new int[100];
		int sum_a = 0;
		int sum_b = 0;
		int sum_c = 0;
		int sum_d = 0;

		// do this 100 times
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < ARRAYLENGTH; i++) {
				int randN = r.nextInt(100) + 1;
				numberA[i] = randN;
				numberB[i] = randN;
				numberC[i] = randN;
				numberD[i] = randN;
			} // numbers from 1 to 99
				// PrintArray(numbers);
			IntegerComp ic = new IntegerComp();

			// PIVOT 1
			QuickSort.quickSortInPlace1(numberA, ic);
			int comparisons = QuickSort.comparisons;
			comparisons_arr_a[k] = comparisons;
			sum_a += comparisons; // to calculate avg at end
			QuickSort.resetComparisons();

			// PIVOT 2
			QuickSort.quickSortInPlace2(numberB, ic);
			comparisons = QuickSort.comparisons;
			comparisons_arr_b[k] = comparisons;
			sum_b += comparisons; // to calculate avg at end
			QuickSort.resetComparisons();

			// PIVOT 3
			QuickSort.quickSortInPlace3(numberC, ic);
			comparisons = QuickSort.comparisons;
			comparisons_arr_c[k] = comparisons;
			sum_c += comparisons; // to calculate avg at end
			QuickSort.resetComparisons();

			// PIVOT 4
			QuickSort.quickSortInPlace4(numberD, ic);
			comparisons = QuickSort.comparisons;
			comparisons_arr_d[k] = comparisons;
			sum_d += comparisons; // to calculate avg at end
			QuickSort.resetComparisons();
		}

		// PIVOT A RESULTS
		int min = Arrays.stream(comparisons_arr_a).min().getAsInt();
		int max = Arrays.stream(comparisons_arr_a).max().getAsInt();
		int avg = sum_a / 100;

		System.out.println("\nPivot 1:\nMin: " + min + "\nMax: " + max + "\nAvg: " + avg);

		// PIVOT B RESULTS
		min = Arrays.stream(comparisons_arr_b).min().getAsInt();
		max = Arrays.stream(comparisons_arr_b).max().getAsInt();
		avg = sum_b / 100;

		System.out.println("\nPivot 2:\n" + //
				"Min: " + min + "\nMax: " + max + "\nAvg: " + avg);

		// PIVOT C RESULTS
		min = Arrays.stream(comparisons_arr_c).min().getAsInt();
		max = Arrays.stream(comparisons_arr_c).max().getAsInt();
		avg = sum_c / 100;

		System.out.println("\nPivot 3:\n" + //
				"Min: " + min + "\nMax: " + max + "\nAvg: " + avg);

		// PIVOT D RESULTS
		min = Arrays.stream(comparisons_arr_d).min().getAsInt();
		max = Arrays.stream(comparisons_arr_d).max().getAsInt();
		avg = sum_d / 100;

		System.out.println("\nPivot 4:\n" + //
				"Min: " + min + "\nMax: " + max + "\nAvg: " + avg);

		////////////// worst case scenario //////////////
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < numberA.length; i++) {
				numberA[i] = r.nextInt(100) + 1;
			} // numbers from 1 to 99
				// PrintArray(numbers);
			IntegerComp ic = new IntegerComp();
			QuickSort.quickSortInPlace1(numberA, ic);
			int comparisons = QuickSort.comparisons;

			comparisons_arr_a[k] = comparisons;
			sum_a += comparisons; // to calculate avg at end
			QuickSort.resetComparisons();
		}
	}

	public static void PrintArray(int inarray[]) {
		System.out.println();
		for (int i = 0; i < inarray.length; i++) {
			System.out.print(inarray[i]);
			System.out.print(" ");
		}
	}
}
