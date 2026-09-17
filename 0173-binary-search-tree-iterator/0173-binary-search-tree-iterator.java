/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Queue<Integer> q =  new LinkedList<>();
    void Iterator(TreeNode root){
         if(root == null)
            return;
        Iterator(root.left);
        q.add(root.val);
        Iterator(root.right);
    }
    public BSTIterator(TreeNode root) {
       Iterator(root);
    }
    
    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        if(!q.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */