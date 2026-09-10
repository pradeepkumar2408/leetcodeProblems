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
    int findSum(TreeNode root){
      if(root == null)
        return 0;
       return root.val + findSum(root.left) + findSum(root.right);
    }
    int findCount(TreeNode root){
        if(root == null)
            return 0;
        return 1 + findCount(root.left) + findCount(root.right);
    }
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        
        if(root == null){
            return res;
        }
            int sum = findSum(root);
            int n = findCount(root);
            if(sum / n == root.val){
                res++;
            }
            averageOfSubtree(root.left);
            averageOfSubtree(root.right);
        
        return res;
    }
}