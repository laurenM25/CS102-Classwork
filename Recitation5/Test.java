public class Test {

    public static void main(String[] args){
        DoublyLinkedList<String> list = new DoublyLinkedList();
        list.addFirst("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.addLast("F");
        System.out.println(list.toString());

        list.swap();
        System.out.println("\nSwapped: ");
        System.out.println(list.toString());
    }
}
