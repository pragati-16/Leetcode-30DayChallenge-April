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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preLeft = dummyNode;
        ListNode left = head;
        ListNode preRight = dummyNode;
        ListNode right = head;

		// find the k-th node
        for (int i = 1; i < k; i++) {
            preLeft = preLeft.next;
            left = left.next;
        }

		// find the k-th last node
        ListNode curNode = left;
        while (curNode.next != null) {
            curNode = curNode.next;
            preRight = preRight.next;
            right = right.next;
        }

        ListNode tempNode = left.next;
		// if right is the left neighbor of left 
        if (preLeft == right) {
            preRight.next = left;
            left.next = right;
            right.next = tempNode;
        } else if (left == preRight) { // if left is the right neighbor of left
            left.next = right.next;
            preLeft.next = right;
            right.next = left;
        } else { // common cases.
            preLeft.next = right;
            left.next = right.next;
            preRight.next = left;
            right.next = tempNode;
        }

        return dummyNode.next;
    }
    }
