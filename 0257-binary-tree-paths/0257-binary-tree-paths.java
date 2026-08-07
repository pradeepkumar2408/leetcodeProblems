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
    void find(TreeNode root, List<String> res, String str) {
        if (root == null)
            return;
        str += ("->" + root.val);
        if (root.left == null && root.right == null) {
            res.add(str);
            return;
        }
        find(root.left, res, str);
        find(root.right, res, str);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String str = String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(str);
        }
        find(root.left, res, str);
        find(root.right, res, str);
        return res;
    }
}