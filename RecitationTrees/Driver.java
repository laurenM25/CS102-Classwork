public class Driver {

    public static void main(String[] args) {
        TreeNode menu = new TreeNode("Fruits", 1);
        TreeNode item = menu.addChild("A Letter Fruits", 2);
        item.addChild("Apple", 4);
        item.addChild("Apricot", 6);
        item.addChild("Avocado", 5);
        item.addChild("Acai", 3);

        item = menu.addChild("C letter Fruits", 5);
        item.addChild("Cherry", 10);
        item.addChild("Coconut", 10);
        item.addChild("Cranbury", 6);
        TreeNode item1 = item.addChild("Cantaloupe", 3);
        item1.addChild("Orange Cantaloupe", 12);
        item1.addChild("Green Cantaloupe", 4);

        System.out.println("\nPrinting original list: ");
        menu.printTree(menu);
        System.out.println("\nweight: " + menu.sumWeight());
        System.out.println("height: " + menu.height());

        System.out.println("\nRemove weight 3's:");
        menu.Remove(menu, 3);
        menu.printTree(menu);

        menu.ReverseOrder(menu);
        System.out.println("\nReverse Order: ");
        menu.printTree(menu);

    }
}
