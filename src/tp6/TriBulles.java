package tp6;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class TriBulles {
    Node head;

    public void bubbleSort() {
        if (head == null) {
            return;
        }

        boolean swapped;
        Node current;
        Node last = null;

        do {
            swapped = false;
            current = head;

            while (current.next != last) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;

        if (head != null) {
            head.prev = new_node;
        }

        head = new_node;
    }

    public void MontrerListe() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}