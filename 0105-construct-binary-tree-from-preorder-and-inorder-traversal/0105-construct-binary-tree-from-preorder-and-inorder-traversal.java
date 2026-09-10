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
    int index = 0;
    TreeNode form(int[] preorder, int[] inorder, int left, int right, Map<Integer,Integer> mp){
        if(right < left)
            return null;
        TreeNode root = new TreeNode(preorder[index++]);
        int mid = mp.get(root.val);
        root.left = form(preorder,inorder,left,mid-1,mp);
        root.right = form(preorder,inorder,mid+1,right,mp);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i < n ; i++){
            mp.put(inorder[i],i);
        }
        TreeNode root = new TreeNode();
        root = form(preorder,inorder,0,n-1,mp);
        return root;
    }
}