class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        myCode sol  = new myCode();
        sol.reversePrint(head);
    }
    public void reversePrint(ListNode head) {
        if(head == null) return;
        reversePrint(head.next);
        System.out.print(head.val);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val =x;
    }
}
