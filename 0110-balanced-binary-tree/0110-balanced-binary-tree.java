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
    int find(TreeNode root){
        if(root == null)
            return 0;
        int left = find(root.left);
        int right = find(root.right);
        if(left == -1 || right == -1)
            return -1;
        if(Math.abs(right - left) > 1)
            return -1;
        return 1 + Math.max(right, left);
    }
    public boolean isBalanced(TreeNode root) {
        return find(root) != -1;
    }
}