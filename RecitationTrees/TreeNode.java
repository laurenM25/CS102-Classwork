
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

    void printTree(TreeNode obj) {
        if (obj != null) {
            System.out.println(obj.value + "-" + obj.weight);
            for (int i = 0; i < obj.childCount; i++) {
                printTree(obj.children[i]);
            }
        }
    }

    void Remove(TreeNode tn, int w) {

        for (int i = 0; i < tn.childCount; i++) {
            TreeNode branch = tn.children[i];
            Remove(branch, w);
            if (tn.children[i].weight == w) {
                System.out.println("(removing " + branch.value + ")");
                tn.children[i] = null;
                tn.childCount--;
            }
        }
    }

    int height() {
        int result = 0;
        if (this.childCount > 0) {
            result++;
        }
        for (int i = 0; i < this.childCount; i++) {
            result += this.children[i].height();
        }
        return result;
    }

    int sumWeight() {
        int result = 0;
        result += this.weight;

        for (int i = 0; i < this.childCount; i++) {
            result += this.children[i].sumWeight();
        }

        return result;
    }

    void ReverseOrder(TreeNode tn) {

        TreeNode[] swapped = new TreeNode[100];
        int count = 0;

        for (int i = 0; i < tn.childCount; i++) {
            if (tn.children[i] != null && tn.children[i].childCount > 0) {
                tn.children[i].ReverseOrder(tn.children[i]);
            }

        }
        for (int i = 0; i < tn.childCount / 2; i++) {
            TreeNode temp = tn.children[i];
            tn.children[i] = tn.children[tn.childCount - 1 - i];
            tn.children[tn.childCount - 1 - i] = temp;

            for (int index = 0; index < tn.childCount; index++) {
                swapped[count++] = tn.children[index];
            }
        }

        tn.children = swapped;

    }
}