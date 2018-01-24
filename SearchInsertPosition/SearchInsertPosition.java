import java.util.LinkedList;

public class SearchInsertPosition {
    private BSTreeNode root;
    public SearchInsertPosition(){
        root=null;
    }
    public SearchInsertPosition(BSTreeNode root){
        this.root=root;
    }
    public void inRootTreverse(BSTreeNode T){
        if(T!=null){
            inRootTreverse(T.lchild);
            System.out.print(T.date);
            inRootTreverse(T.rchild);
        }
    }
    public void inRootTreverse(){
        BSTreeNode T = root;
        LinkedList<BSTreeNode> s = new LinkedList<>();
        if(T!=null){
            s.push(T);
            while(!s.isEmpty()) {
                while (s.peek() != null)
                    s.push(s.peek().lchild);
                s.pop();
                if (!s.isEmpty()) {
                    T = s.pop();
                    System.out.print(T.date);
                    s.push(T.rchild);
                }
            }
        }
    }
    public boolean insert(int target,BSTreeNode T){
        if(T==null){
            T=new BSTreeNode(target);
        }
        if(T.date==target)
            return false;
        if(target<T.date)
            if(T.lchild==null)
                T.lchild=new BSTreeNode(target);
            else
                return insert(target,T.lchild);
        else
            if(T.rchild==null)
                T.rchild= new BSTreeNode(target);
            else
                return insert(target,T.rchild);
        return false;
    }
    public static int searchInsert(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        int mid;
        while(low<=high){
            mid=(high+low)/2;
            if(target==nums[mid])
                return mid;
            else if(target<nums[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return high;
    }
    public static void main(String args[]){
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));

        BSTreeNode a1 = new BSTreeNode(1);
        BSTreeNode a3 = new BSTreeNode(3);
        BSTreeNode a5 = new BSTreeNode(5);
        BSTreeNode a6 = new BSTreeNode(6);

        SearchInsertPosition bstree = new SearchInsertPosition(a3);
        a3.lchild=a1;
        a3.rchild=a5;
        a5.rchild=a6;

        bstree.inRootTreverse();
        bstree.insert(2,a3);
        bstree.inRootTreverse(a3);
    }
}
