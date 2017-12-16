public class AddTwoNums_2 {

    public static class ListNode{   //构造链表节点结构体
        int val;
        ListNode next;
        public ListNode(){

        }
        public ListNode(int val){
            this.val=val;
        }
    }


    public static ListNode listBuilder(int[] nums){   //链表节点生成链表
        ListNode head , last , newnode;        //初始化
        head = new ListNode();
        head.next=null;
        last = new ListNode();

        for(int i=0;i<nums.length;i++){
            newnode = new ListNode(nums[i]);
            if(head.next==null){
                head.next=newnode;
                last=newnode;
                last.next=null;
            }
            else{
                last.next=newnode;
                newnode.next=null;
                last=newnode;
            }
        }
        return head;
    }

    public static void showList(ListNode ln){
        ListNode p = new ListNode();
        p = ln.next;
        while(p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        int sum=0;
        int carry=0; //进位

        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1 = l1.next;
        p2 = l2.next;

        ListNode head = new ListNode();
        head.next=null;
        ListNode last = new ListNode();
        ListNode newnode;

        while(p1!=null || p2!=null){

            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            sum = carry + x + y;
            carry = sum / 10 ;

            newnode = new ListNode(sum % 10);
            if(head.next==null){
                head.next=newnode;
                last=newnode;
                last.next=null;
            }
            else {
                last.next=newnode;
                newnode.next=null;
                last=newnode;
            }
            if(p1 != null)
                p1 = p1.next;
            if(p2 != null)
                p2 = p2.next;
        }

        return head;
    }


    public static void main(String args[]){
        int[] nums1 = new int[]{2,4,3};
        int[] nums2 = new int[]{5,6,4};

        ListNode l1 = listBuilder(nums1);
        ListNode l2 = listBuilder(nums2);
        showList(l1);
        showList(l2);

        ListNode res = addTwoNumbers(l1,l2);
        showList(res);
    }


}
