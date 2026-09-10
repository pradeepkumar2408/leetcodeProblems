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
    int ans = 0;
    int diameter(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right); 

        ans = Math.max(ans,leftHeight + rightHeight);
        
        return Math.max(leftHeight , rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return ans;
    }
}