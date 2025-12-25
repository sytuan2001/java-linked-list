public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(10);
        list.addFirst(5);
        list.addLast(20);
        list.add(1, 7);

        list.printList(); // 5 7 10 20
        list.remove(2);
        list.printList(); // 5 7 20
    }
}
