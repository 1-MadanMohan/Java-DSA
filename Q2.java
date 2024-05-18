// Find the middle of LinkedList
class Q2 {
    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode middleNode(ListNode head) {
        int index=0;
        ListNode temp = head;
        while(temp.next !=null){
            temp = temp.next;
            index++;
        }
        if(index%2==0){
        for(int i=0;i<index/2;i++){
            head = head.next;
        }}
        else{for(int i=0;i<=index/2;i++){
            head= head.next;
        }

        }
        return head;
    }

}
