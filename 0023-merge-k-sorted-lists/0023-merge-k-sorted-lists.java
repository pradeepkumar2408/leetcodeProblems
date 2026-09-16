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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i++){
            ListNode head = lists[i];
            while(head != null){
                pq.add(head.val);
                head = head.next;
            }
        }
        if(pq.size() == 0)
            return null;
        ListNode head = new ListNode(pq.poll());
        ListNode tail = head;
        while(!pq.isEmpty()){
            tail.next = new ListNode(pq.poll());
            tail = tail.next;
        }
        return head;
    }
}