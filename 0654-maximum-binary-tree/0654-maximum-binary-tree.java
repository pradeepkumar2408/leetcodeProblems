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
    TreeNode Make(int low, int high, int[] nums){
        if(low > high)
            return null;
        int MaxNum = Integer.MIN_VALUE, MaxIn = -1;
        for(int i = low ; i <= high ; i++){
            if(MaxNum < nums[i]){
                MaxNum = nums[i];
                MaxIn = i;
            }
        }
        TreeNode root = new TreeNode(MaxNum);
        root.left = Make(low, MaxIn - 1, nums);
        root.right = Make(MaxIn + 1, high, nums);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return Make(0, nums.length - 1, nums);
    }
}