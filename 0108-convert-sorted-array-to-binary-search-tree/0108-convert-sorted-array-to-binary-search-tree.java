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
    TreeNode Make(int low, int high, int[] nums) {

        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = Make(low, mid - 1, nums);
        root.right = Make(mid + 1, high, nums);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return Make(0, nums.length - 1, nums);
    }
}