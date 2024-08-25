import java.util.Arrays;
//import java.util.Comparator;

public class MergeSortBook {
    public static int comparisons = 0;

    public static void merge(Student[] S1, Student[] S2, Student[] S, GPAComp comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            comparisons++;
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            else
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
        }
    }

    public static <K> void mergeSort(Student[] S, GPAComp comp) {
        int n = S.length;
        if (n < 2)
            return; // array is trivially sorted
        // divide
        int mid = n / 2;
        Student[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        Student[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp); // sort copy of first half
        mergeSort(S2, comp); // sort copy of second half
        // merge results
        merge(S1, S2, S, comp); // merge sorted halves back into original
    }
}
