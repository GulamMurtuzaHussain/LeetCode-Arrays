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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> Nums = new HashSet<>();

        for(int num : nums) Nums.add(num);

        int components = 0;
        while(head != null){
            if(Nums.contains(head.val)){
                while(head != null && Nums.contains(head.val)){
                    head = head.next;
                }
                components++;
            }
            else head = head.next;
        }
        return components;
    }
}
