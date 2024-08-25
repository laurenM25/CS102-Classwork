import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Student[] arr1 = new Student[1000];
        Student[] arr2 = new Student[1000];
        String[] names = { "Becca", "Albert", "Stephanie", "George", "Kamala", "Loucas", "Lauren", "Joyce", "Avi",
                "Moody" };

        Random rand = new Random();
        GPAComp compareyyy = new GPAComp();

        for (int i = 0; i < arr1.length; i++) { // arr1
            arr1[i] = new Student();
            int n = (int) (rand.nextDouble() * 100000000);
            String id = "N" + n;
            // gpa
            double nn = rand.nextDouble() + 3;
            String roundedS = String.format("%.4f", nn); // use Math.round(*1000)/1000 next time
            double rounded = Double.parseDouble(roundedS);
            // random name
            int r = rand.nextInt(10);

            // set variables
            arr1[i].setID(id);
            arr1[i].setGPA(rounded);
            arr1[i].setName(names[r]);
        }

        for (int i = 0; i < arr2.length; i++) { // arr2
            arr2[i] = new Student();
            int n = (int) (rand.nextDouble() * 100000000);
            String id = "N" + n;
            // gpa
            double nn = rand.nextDouble() + 3;
            String roundedS = String.format("%.4f", nn); // use Math.round(*1000)/1000 next time
            double rounded = Double.parseDouble(roundedS);
            // random name
            int r = rand.nextInt(10);

            // set variables
            arr2[i].setID(id);
            arr2[i].setGPA(rounded);
            arr2[i].setName(names[r]);
        }

        // part 2
        System.out.println("Part 2");
        SelectionSort.sort(arr1);
        // System.out.println("\nsorted:");

        // for (Student student : arr1) {
        // System.out.println(student.getName() + " | " + student.getGPA2());
        // }

        Student[] arr3 = new Student[arr1.length + arr2.length];

        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
            index++;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[i + index] = arr2[i];
        }

        // part 3
        System.out.println("\nStep3:");
        SelectionSort.sort(arr3);
        // for (Student student : arr3) { // see output
        // System.out.println(student.getName() + " | " + student.getGPA2()); // later
        // don't print this
        // }

        // part 4
        arr3 = new Student[arr1.length + arr2.length];

        index = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
            index++;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[i + index] = arr2[i];
        }

        System.out.println("\nPart3:");
        MergeSortBook.mergeSort(arr3, compareyyy);
        System.out.println("Comparisons: " + MergeSortBook.comparisons);

        System.out.println("\nPart4:");
        MergeSortBook.merge(arr1, arr2, arr3, compareyyy);
        System.out.println("Comparisons: " + MergeSortBook.comparisons);

    }

}
