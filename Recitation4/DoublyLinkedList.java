public class DoublyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        private Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    // public E first(){} // Idc right now about these methods
    // public E last(){}
    public void addFirst(E e) {
    }

    public void addLast(E e) {
    }

    public E removeFirst() {
    }

    public E removeLast() {
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> sucessor = node.getNext();
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    // WHAT WE ADDED
    public void swap() {
        int index1 = size / 2; // these give middle values
        int index2 = size / 2 + 1;

        Node<E> BOne;
        Node<E> One;
        Node<E> Two;
        Node<E> ATwo;//

        Node<E> current = header;

        BOne.setNext(Two);
        Two.setNext(One);
        One.setNext(ATwo);

        Two.setPrev(BOne);
        One.setPrev(Two);
        ATwo.setPrev(One);

        //
    }

}
