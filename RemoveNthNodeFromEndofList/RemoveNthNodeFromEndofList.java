public class RemoveNthNodeFromEndofList {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val=val;
        }
    }
    public static ListNode constructListNode(int[] nums){
        ListNode head = new ListNode();
        ListNode p = head;
        for(int i=0;i<nums.length;i++){
            ListNode node = new ListNode();
            node.val=nums[i];
            node.next=null;
            p.next=node;
            p=node;
        }
        return head;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int count=-1;
        int i=0;
        ListNode p =head;
        while(p!=null){
            p=p.next;
            count+=1;
        }


        p=head;
        while(p!=null){
            if(i==count-n){
                p.next=p.next.next;
            }
            i+=1;
            p=p.next;
        }

        return head;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode first = head.next;
        ListNode second = head;
        for(int i=0;i<n;i++){
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return head;
    }
    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4,5};
        ListNode head = constructListNode(nums);
        ListNode p =head.next;
        while(p!=null){
            System.out.print(p.val);
            p=p.next;
        }
        System.out.println();
        head = removeNthFromEnd2(head,2);
        p =head.next;
        while(p!=null){
            System.out.print(p.val);
            p=p.next;
        }
    }
}
