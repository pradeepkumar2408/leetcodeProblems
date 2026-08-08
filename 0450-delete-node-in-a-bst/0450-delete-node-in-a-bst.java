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
    TreeNode findRight(TreeNode root){
        if(root.right == null)
            return root;
        return findRight(root.right);
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key){
            if(root.left == null && root.right == null)
                return null;
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            
            TreeNode rightTree = root.right;
            root = root.left;

            TreeNode RightMost = findRight(root);
            RightMost.right = rightTree;
        }
       

        if(root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
}