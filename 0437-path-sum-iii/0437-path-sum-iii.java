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
    int cnt = 0;
    void recursion(TreeNode root, int targetSum, long sum){
        if(root == null)
            return;
        if(root.val + sum == targetSum)
            cnt++;
        recursion(root.left, targetSum, sum + root.val);
        recursion(root.right, targetSum, sum + root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        recursion(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return cnt;
    }
}