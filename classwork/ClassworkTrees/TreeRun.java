import java.util.Arrays;

public class TreeRun {

    public static void main(String[] args) {
        TreeNode menu = new TreeNode("Fruits", 1);
        TreeNode item = menu.addChild("A Letter Fruits", 2);
        item.addChild("Apple", 3);

        item = menu.addChild("C letter Fruits", 5);
        item.addChild("Cherry", 10);
        TreeNode item1 = item.addChild("Cantaloupe", 3);
        item1.addChild("Orange Cantaloupe", 12);
        item1.addChild("Green Cantaloupe", 4);

        menu.printTree(menu); // next test: we are going to print a tree RECURSIVELY
        // want to print starting at menu (the root)
        System.out.println(menu.count(3)); // count all the weight = 3's
    }
}
