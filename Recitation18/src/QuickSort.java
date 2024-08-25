
/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Comparator;
import java.util.Random;

class QuickSort {

  public static int comparisons = 0;
  public static Random r = new Random();

  // -------- support for in-place quick-sort of an array --------
  /** Quick-sort contents of a queue. */
  public static void quickSortInPlace1(int[] S, Comparator<Integer> comp) { // hahah....
    quickSortInPlace1(S, comp, 0, S.length - 1);
  }

  public static void quickSortInPlace2(int[] S, Comparator<Integer> comp) {
    quickSortInPlace2(S, comp, 0, S.length - 1);
  }

  public static void quickSortInPlace3(int[] S, Comparator<Integer> comp) {
    quickSortInPlace3(S, comp, 0, S.length - 1);
  }

  public static void quickSortInPlace4(int[] S, Comparator<Integer> comp) {
    quickSortInPlace4(S, comp, 0, S.length - 1);
  }

  public static void resetComparisons() {
    comparisons = 0;
  }

  public static int randomPiv(int a, int b) {
    return r.nextInt(b - a + 1);
  }

  /** Sort the subarray S[a..b] inclusive. */

  private static void quickSortInPlace1(int[] S, Comparator<Integer> comp,
      int a, int b) {
    comparisons++;
    if (a >= b)
      return; // subarray is trivially sorted
    int left = a;
    int right = b - 1;
    int pivot = b; // for right most
    int temp; // temp object used for swapping

    comparisons++;
    while (left <= right) {
      // scan until reaching value equal or larger than pivot (or right marker)
      comparisons++;
      while (left <= right && comp.compare(S[left], pivot) < 0)
        left++;
      // scan until reaching value equal or smaller than pivot (or left marker)
      comparisons++;
      while (left <= right && comp.compare(S[right], pivot) > 0)
        right--;
      comparisons++;
      if (left <= right) { // indices did not strictly cross
        // so swap values and shrink range
        temp = S[left];
        S[left] = S[right];
        S[right] = temp;
        left++;
        right--;
      }
    }

    // put pivot into its final place (currently marked by left index)
    temp = S[left];
    S[left] = S[b];
    S[b] = temp;
    quickSortInPlace1(S, comp, a, right - 1);
    quickSortInPlace1(S, comp, left + 1, b);
  }

  private static void quickSortInPlace2(int[] S, Comparator<Integer> comp,
      int a, int b) {
    comparisons++;
    if (a >= b)
      return; // subarray is trivially sorted
    int left = a + 1;
    int right = b;
    int pivot = a; // for left most element
    int temp; // temp object used for swapping

    comparisons++;
    while (left <= right) {
      // scan until reaching value equal or larger than pivot (or right marker)
      comparisons++;
      while (left <= right && comp.compare(S[left], pivot) < 0)
        left++;
      // scan until reaching value equal or smaller than pivot (or left marker)
      comparisons++;
      while (left <= right && comp.compare(S[right], pivot) > 0)
        right--;
      comparisons++;
      if (left <= right) { // indices did not strictly cross
        // so swap values and shrink range
        temp = S[left];
        S[left] = S[right];
        S[right] = temp;
        left++;
        right--;
      }
    }

    // put pivot into its final place (currently marked by right index)
    temp = S[right];
    S[right] = S[b];
    S[b] = temp;

    quickSortInPlace2(S, comp, a, right - 1);
    quickSortInPlace2(S, comp, left + 1, b);
  }

  private static void quickSortInPlace3(int[] S, Comparator<Integer> comp,
      int a, int b) {
    comparisons++;
    if (a >= b)
      return; // subarray is trivially sorted
    int left = a;
    int right = b;
    int pivot = S[a + randomPiv(a, b)]; // for random
    int temp; // temp object used for swapping

    comparisons++;
    while (left <= right) {
      // scan until reaching value equal or larger than pivot (or right marker)
      comparisons++;
      while (left <= right && comp.compare(S[left], pivot) < 0)
        left++;
      // scan until reaching value equal or smaller than pivot (or left marker)
      comparisons++;
      while (left <= right && comp.compare(S[right], pivot) > 0)
        right--;
      comparisons++;
      if (left <= right) { // indices did not strictly cross
        // so swap values and shrink range
        temp = S[left];
        S[left] = S[right];
        S[right] = temp;
        left++;
        right--;
      }
    }

    // make recursive calls
    quickSortInPlace3(S, comp, a, right);
    quickSortInPlace3(S, comp, left, b);
  }

  private static void quickSortInPlace4(int[] S, Comparator<Integer> comp,
      int a, int b) {
    comparisons++;
    if (a >= b)
      return; // subarray is trivially sorted
    int left = a;
    int right = b;
    int pivot = S[a + (b - a) / 2]; // for middle
    int temp; // temp object used for swapping

    comparisons++;
    while (left <= right) {
      // scan until reaching value equal or larger than pivot (or right marker)
      comparisons++;
      while (left <= right && comp.compare(S[left], pivot) < 0)
        left++;
      // scan until reaching value equal or smaller than pivot (or left marker)
      comparisons++;
      while (left <= right && comp.compare(S[right], pivot) > 0)
        right--;
      comparisons++;
      if (left <= right) { // indices did not strictly cross
        // so swap values and shrink range
        temp = S[left];
        S[left] = S[right];
        S[right] = temp;
        left++;
        right--;
      }
    }
    quickSortInPlace4(S, comp, a, right);
    quickSortInPlace4(S, comp, left, b);
  }

}
