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
    boolean flag = false;
    void find(TreeNode root, int targetSum){
        if(root == null)
            return;
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            if(targetSum == 0)
                flag = true;
        }
        
        find(root.left,targetSum);
        find(root.right, targetSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        find(root,targetSum);
        return flag;
    }
}