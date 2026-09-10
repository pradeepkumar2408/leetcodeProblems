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
    int ans = -1;
    int count = 0;
    void find(TreeNode root, int k){
         if(root == null)
            return;
         if(ans != -1) return;
        find(root.left,k);
        count++;
        if(k == count){
            ans =  root.val;
            return;
        }else
        find(root.right,k);
    
    }
    public int kthSmallest(TreeNode root, int k) {
       find(root,k);
        return ans;
       
    }
}