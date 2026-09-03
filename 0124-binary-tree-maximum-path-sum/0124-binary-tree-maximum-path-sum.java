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
class Solution {
    int res = Integer.MIN_VALUE;
    int recursion(TreeNode root){
        if(root == null)
            return 0;
        int lsum = 0, rsum = 0;
        if(root.left != null){
             lsum = Math.max(0, recursion(root.left));
        }
        if(root.right != null){
             rsum = Math.max(0, recursion(root.right));
        }
        res = Math.max(res, root.val + lsum + rsum);
        return root.val + Math.max(lsum, rsum);
    }
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return res;    
    }
}