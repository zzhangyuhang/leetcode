public class RotateList {
    class ListNode{  //链表节点
        public int val;
        public ListNode next;
        public ListNode(){
            val = 0;
            next = null;
        }
        public ListNode(int val){
            this.val=val;
            next = null;
        }
    }
    ListNode head; //头指针
    public RotateList(){
        head = null;
    }
    public RotateList(ListNode head){
        this.head = head;
    }
    public RotateList(int[] nums){
        head = new ListNode(nums[0]);
        ListNode p = head;
        for(int i = 1;i<nums.length;i++){
            ListNode q = new ListNode(nums[i]);
            p.next = q;
            p=q;
        }
    }
    public void display(){
        ListNode p = head;
        while(p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
    }
    public void rotateRight(int k){
        int i = 0;
        //p为先行指针，先走k个位置
        ListNode p = head;
        while(i<k){
            p = p.next;
            i++;
        }
        //q为后行指针，走的位置为p再次走的位置
        //p停下的位置为最后一个节点
        //q停下的位置为倒数第k+1个节点
        ListNode q = head;
        while(p.next!=null){
            q=q.next;
            p=p.next;
        }
        //交换节点，注意我们这里的q是倒是第k+1个节点，就是倒数第k个节点的前一个节点
        p.next=head;// head指针后移
        head = q.next;//倒数第k个指针前移
        q.next = null;//在q节点处断链
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4,5};
        RotateList list = new RotateList(nums);
        list.rotateRight(2);
        list.display();
    }
}
