class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        // Step 1: Check if there are k nodes
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head; // less than k nodes
            temp = temp.next;
        }

        // Step 2: Reverse first k nodes
        ListNode prev = null, curr = head, next = null;
        int count = 0;
        while (count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: Recursion for remaining nodes
        head.next = reverseKGroup(curr, k);

        return prev; // new head after reversing k nodes
    }
}
