/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head.next == null)
            return new int[] { 0 };
        List<Integer> Stack = new ArrayList<>();

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int[] ans = new int[length];
        int a = 0;

        Stack.add(head.val);
        head = head.next;

        while (head != null) {
            if (head.val > Stack.get(Stack.size() - 1)) {
                int size = Stack.size() - 1;
                while ((size >= 0) && Stack.get(size) < head.val) {
                    if (ans[size] != 0) {
                        size--;
                        continue;
                    }
                    ans[size] = head.val;
                    // Stack.remove(size);
                    size--;
                }
                // Stack.add(head.val);
            }
            Stack.add(head.val);
            head = head.next;
        }

        return ans;
    }
}
