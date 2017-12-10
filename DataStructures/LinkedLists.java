// github.com/cohaolain

package DataStructures;

public class LinkedLists {

    // Test the Linked List class
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        int lowest = 0;
        int highest = 10;

        for (int i = lowest; i<highest+1; i++) {
            ll.insertAtTail(i);
        }
        for (int i = lowest+1; i<highest+1; i++) {
            ll.insertAtHead(i);
        }

        Link current = ll.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

        System.out.println(ll.isValid()?"valid":"invalid");
        System.out.println(ll.isCircular()?"circular":"non-circular");

        ll.head.previous = ll.tail;
        ll.tail.next = ll.head;

        System.out.println(ll.isValid()?"valid":"invalid");
        System.out.println(ll.isCircular()?"circular":"non-circular");

    }

}

class Link {

    public Object value;
    public Link next;
    public Link previous;

    public Link (Object input) {
        value = input;
    }

}

class LinkedList {

    public Link head;
    public Link tail;

    public boolean isEmpty() {
        if (head==null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertAtTail(Object input) {
        if (isEmpty()) {
            tail = new Link(input);
            head = tail;
        } else {
            Link newTail = new Link(input);
            newTail.previous = tail;
            tail.next = newTail;
            tail = newTail;
        }
    }

    public void insertAtHead(Object input) {
        if (isEmpty()) {
            head = new Link(input);
            tail = head;
        } else {
            Link newHead = new Link(input);
            newHead.next= head;
            head.previous = newHead;
            head = newHead;
        }
    }

    public boolean isValid() {
        Link current = head;
        while (current!=null) {
            if (current==tail) {
                break;
            }
            if (current.next.previous != current) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public boolean isCircular() {
        if (head.previous==tail || tail.next==head) {
            return true;
        }
        else {
            return false;
        }
    }
}
