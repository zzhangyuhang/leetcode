public class SwapNodesInPairs {
    public static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(){
            this.next=null;
        }
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ListNode contructList(int[] nums){
        ListNode head = new ListNode();
        ListNode p = new ListNode();
        p=head;
        for(int i : nums){
            ListNode q = new ListNode(i);
            p.next=q;
            p=q;
        }
        return head;
    }
    public static void displayList(ListNode head){
        ListNode p = new ListNode();
        p=head.next;
        while(p!=null){
            if(p.next!=null)
                System.out.print(p.val+"->");
            else
                System.out.print(p.val);
            p=p.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {

        int i=0;
        ListNode temp;
        ListNode p = new ListNode();
        p=head;
        while(p.next.next!=null){
            if (i % 2 == 0) {
                    temp = new ListNode(p.next.val);
                    temp.next=p.next.next.next;
                    p.next.next.next=temp;
                    p.next=p.next.next;
            }
            i+=1;
            p=p.next;
        }
        return head;
    }
    public static void main(String args[])throws NullPointerException{
        int[] nums = new int[]{1,2,3,4,5,6,8};
        ListNode head =contructList(nums);
        displayList(swapPairs(head));

    }
}
