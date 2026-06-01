class ListNode{
    int val;
    ListNode next;

    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

class MyCircularQueue {
    ListNode head = null;
    ListNode temp = null;
    int size = 0;
    int length = 0;
    public MyCircularQueue(int k) {
        size = k;
    }
    
    public boolean enQueue(int val) {
        if(head == null){
            head = new ListNode(val,null);
            temp = head;
            length++;
            return true;
        }
        else if(length < size){
            temp.next = new ListNode(val,null);
            temp = temp.next;
            length++;
            return true;
        }
        else return false;
    }
    
    public boolean deQueue() {
        if(length > 0){
            head = head.next;
            length--; return true;
        }
        else return false;
    }
    
    public int Front() {
        if(length > 0){
            return head.val;
        }
        else return -1;
    }
    
    public int Rear() {
        if(length > 0) return temp.val;
        return -1;
    }
    
    public boolean isEmpty() {
        if(length == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(length == size) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
