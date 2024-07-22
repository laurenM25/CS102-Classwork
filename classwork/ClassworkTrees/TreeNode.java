public class TreeNode<T> {
    private T value = null;
    private int weight = 0;
    private TreeNode[] children = new TreeNode[100];

    private int childCount = 0;

    TreeNode(T value, int w) {
        this.value = value;
        this.weight = w;
    }

    public TreeNode addChild(T value, int w) {
        TreeNode newChild = new TreeNode(value, w);
        children[childCount++] = newChild;
        return newChild;
    }

    void printTree(TreeNode obj) { // pre-order traversal
        if (obj != null) {
            System.out.println(obj.value + "-" + obj.weight); // do myself first
            for (int i = 0; i < obj.childCount; i++) { // then do children
                printTree(obj.children[i]); // print this subtree!!
            }
        }
    }

    void printTreePostOrder(TreeNode obj) { // post order traversal
        if (obj != null) {
            for (int i = 0; i < obj.childCount; i++) {
                printTreePostOrder(obj.children[i]); // THIS IS RECURSIVE, breaks down into subtrees
            }
            System.out.println(obj.value + "-" + obj.weight);
        }
    }

    int largestWeight() { // biggest weight is either me or one of the child
        int max = 0;
        for (int i = 0; i < this.childCount; i++) {
            max = Math.max(max, this.children[i].largestWeight()); // this has the recursive element
        }
        return Math.max(max, this.weight);
    }

    int count(int srchnum) {
        int result = 0;
        if (this.weight == srchnum) {
            result++;
        }
        for (int i = 0; i < this.childCount; i++) {
            result += this.children[i].count(srchnum);
        }

        return result;
    }
}
// if children's responses affect how you are going to look at yourself, you
// need to do children first.