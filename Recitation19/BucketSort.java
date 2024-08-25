public class BucketSort {
    int comparisons = 0;

    public class Pair {
        int region;
        String state;
        Pair left;
        Pair right;

        public Pair(Pair l, int r, String s, Pair ri) {
            region = r;
            state = s;
            left = l;
            right = ri;
        }

        public void setNext(Pair next) {
            right = next;
        }

        public void setBefore(Pair before) {
            left = before;
        }

        public Pair getNext() {
            return right;
        }

        public Pair getBefore() {
            return left;
        }

        public String getElement() {
            return state;
        }
    }

    public String[][] bucket = new String[7][5];
    private Pair root;
    private Pair cur;
    public int size;

    public BucketSort() { // add sequence into bucket then sort! // call this public Sequence
        root = new Pair(null, 0, null, null);
        cur = root;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void sort() {
        toBucket(); // move to bucket first

        for (int i = 0; i < bucket.length; i++) { // sort the buckets(?)
            for (int k = 1; k < bucket[i].length; k++) {
                String a = bucket[i][k - 1];
                String b = bucket[i][k];

                if (a == null || b == null) { // so messy
                    break;
                }

                comparisons++;
                if (a.compareTo(b) > 0) {// switch!
                    bucket[i][k - 1] = b;
                    bucket[i][k] = a;
                }
            }
        }

        // add back to sequence
        for (int i = 0; i < bucket.length; i++) { // sort the buckets(?)
            for (int k = 0; k < bucket[i].length; k++) {
                if (bucket[i][k] != null) {
                    addPair(i, bucket[i][k]);
                }
            }
        }

    }

    public Pair removeLast() {
        Pair p = cur;
        Pair before = cur.getBefore();
        before.setNext(null); // remove attachments
        cur.setBefore(null);

        cur = before;
        return p;
    }

    public void toBucket() {
        for (int k = 0; k < size(); k++) {
            Pair p = removeLast();
            int r = p.region;
            String s = p.state;

            // check to add in index
            int index = 0;
            for (int i = 0; i < bucket[r].length; i++) {
                if (bucket[r][i] == null) {
                    break;
                }
                index++;
            }
            bucket[r][index] = s;
        }

    }

    public void addPair(int r, String s) { // add pair to unsorted linked list
        Pair newP = new Pair(null, 0, null, null);
        if (root == null) {
            newP = new Pair(null, r, s, null);
            root = newP;
        } else {
            newP = new Pair(cur, r, s, null);
            cur.setNext(newP);
        }

        cur = newP;
        size++;
    }

    public void printSequence() {
        Pair c = root.getNext();
        int region = 0;
        while (c.getNext() != null) {
            if (c.region != region) {
                System.out.println("\nRegion " + c.region + ": ");
                region++;
            }
            System.out.println(c.state);

            c = c.getNext();
        }

    }

    public static void main(String[] args) {

        BucketSort sequence = new BucketSort();
        sequence.addPair(1, "New York");
        sequence.addPair(5, "California");
        sequence.addPair(5, "Washington");
        sequence.addPair(3, "Michigan");
        sequence.addPair(3, "Minnesota");
        sequence.addPair(4, "Texas");
        sequence.addPair(5, "Oregon");
        sequence.addPair(2, "Kentucky");
        sequence.addPair(2, "Alabama");
        sequence.addPair(1, "Maine");
        sequence.addPair(1, "New Jersey");
        sequence.addPair(2, "Georgia");

        sequence.sort();

        sequence.printSequence();

        System.out.println("\nComparisons: " + sequence.comparisons);
    }
}
