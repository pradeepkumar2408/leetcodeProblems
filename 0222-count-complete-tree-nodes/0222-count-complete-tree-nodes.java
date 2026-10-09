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
    int findLeft(TreeNode root){
        if(root == null)
            return 0;
        return 1 + findLeft(root.left);
    }
    int findRight(TreeNode root){
        if(root == null)
            return 0;
        return 1 + findRight(root.right);
    }
    public int countNodes(TreeNode root) {
        int left = findLeft(root);
        int right = findRight(root);
        if(left == right)
        return (1 << left) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}