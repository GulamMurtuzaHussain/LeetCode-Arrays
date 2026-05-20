class ListNode {
    int val;
    ListNode next;
    ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }
}

class MyCircularDeque {
    ListNode head = null;
    int capacity = 0;
    int count = 0;

    public MyCircularDeque(int k) {
        head = null;
        capacity = k;
        count = 0;
    }

    public boolean insertFront(int value) {
        if (count >= capacity) return false;
        ListNode node = new ListNode(value, head);
        head = node;
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (count >= capacity) return false;
        if (head == null) {
            head = new ListNode(value, null);
        } else {
            ListNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new ListNode(value, null);
        }
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (count == 0) return false;
        head = head.next;
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (count == 0) return false;
        if (head.next == null) { // only one node
            head = null;
        } else {
            ListNode temp = head;
            while (temp.next.next != null) temp = temp.next;
            temp.next = null;
        }
        count--;
        return true;
    }

    public int getFront() {
        return (count == 0) ? -1 : head.val;
    }

    public int getRear() {
        if (count == 0) return -1;
        ListNode temp = head;
        while (temp.next != null) temp = temp.next;
        return temp.val;
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == capacity; }
}
