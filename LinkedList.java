public class LinkedList {
    private Node head;
    private Node tail;

    public static class Node {
        private int value;
        private Node next;
        private Node prev;
        Node(int x) {value=x;}

        public void displayNodeData() {
            System.out.print(value + " -> ");
        }
    }

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void fillingLinkedList(int value,LinkedList linkedList) {
        for (int i = 0; i < value; i++) {
            linkedList.add(i + 1);
        }
    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println("NULL");
    }

    public void reverse() {
        Node currentNode = head;
        while(currentNode != null) {
            Node nextNode = currentNode.next;
            Node prevNode = currentNode.prev;
            currentNode.next = prevNode;
            currentNode.prev = nextNode;
            if (prevNode == null) {
                tail = currentNode;
            }
            if (nextNode == null) {
                head = currentNode;
            }
            currentNode = nextNode;
        }
    }



    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.fillingLinkedList(5, linkedList);
        linkedList.printLinkedList();
        linkedList.reverse();
        linkedList.printLinkedList();
    }
}
