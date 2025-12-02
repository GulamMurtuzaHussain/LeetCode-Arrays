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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> Nums = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            Nums.add(nums[i]);
        }

        while(head != null && Nums.contains(head.val)) head = head.next;
       
        ListNode curr = head;
        ListNode prev = null;
       
        while(curr != null){
            if(Nums.contains(curr.val)){
                prev.next = curr.next;
                curr = curr.next;
            }
            else{
                prev = curr;
                if(curr != null) curr = curr.next;
                else curr = curr;
            }
        }
       
        return head;
    }
}
