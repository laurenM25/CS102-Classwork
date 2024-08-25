public class SelectionSort {

    static void sort(Student arr[]) {
        int n = arr.length;
        int comparesS = 0;
        GPAComp comp = new GPAComp();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (comp.compare(arr[j], arr[min_idx]) == -1) { // if j was less than min_idx
                    min_idx = j;
                    comparesS++;
                }
            }

            // Swap the found minimum element with the first
            // element
            Student temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        System.out.println("comparisons: " + comparesS);
    }

}