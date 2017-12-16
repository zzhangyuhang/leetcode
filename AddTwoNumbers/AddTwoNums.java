/*
This program is error by myself!
The problem:
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */



public class AddTwoNums {

    public static class ListNode{
        int val;
        ListNode next;
        public  ListNode(){

        }
        public ListNode(int val){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode ListBuilder(int[] nums){
        ListNode head,last,newlist;
        head = new ListNode();
        head.next=null;
        last = new ListNode();
        for(int i=0;i<nums.length;i++){
            newlist = new ListNode(nums[i]);
            if(head.next==null){
                head.next=newlist;
                last=newlist;
                last.next=null;
            }
            else{
                last.next=newlist;
                last=newlist;
                last.next=null;
            }
        }
        return head;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i=0;
        int j=0;
        double sum=0;
        ListNode listnodehead,listnode,lastnode;
        listnodehead = new ListNode();
        listnodehead.next=null;
        listnode = new ListNode();
        lastnode = new ListNode();
        listnode=l1;
        while(listnode.next!=null){
            sum=sum+(listnode.next.val)*Math.pow(10,i);
            i=i+1;
        }
        listnode=l2;
        while(listnode.next!=null){
            sum=sum+(listnode.next.val)*Math.pow(10,j);
            j=j+1;
        }
        listnode=null;
        lastnode=null;

        String s = Double.toString(sum);
        System.out.print(sum);
        for(;i>=0;i--){

            listnode.val=(int)s.charAt(i);
            if(listnodehead.next==null){
                listnodehead.next=listnode;
                lastnode=listnode;
                lastnode.next=null;
            }
            else {
                lastnode.next=listnode;
                lastnode=listnode;
                lastnode.next=null;
            }

        }


        return listnodehead;
    }

    public static void main(String args[]){

        int[] nums1=new int[]{2,4,3};
        ListNode l1 =ListBuilder(nums1);
        int[] nums2=new int[]{5,6,4};
        ListNode l2 =ListBuilder(nums2);


        ListNode res = addTwoNumbers(l1,l2);
        while(res.next!=null){
            System.out.print(res.next.val);
            res=res.next;
        }




    }




}
