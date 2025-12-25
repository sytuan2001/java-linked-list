public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList(E data) {
        head = new Node(data);
        numNodes++;
    }
    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E e) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }
    public void add(int index, E e) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(e);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node holder = temp.next;
        temp.next = new Node(e);
        temp.next.next = holder;
        numNodes++;
    }
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        for (int i=0;i<index;i++) {
            temp=temp.next;
        }
        return (E) temp.getData();
    }
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;

        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.getData();
        }

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node removed = temp.next;
        temp.next = removed.next;
        numNodes--;

        return (E) removed.getData();
    }
    public boolean contains(E o) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
