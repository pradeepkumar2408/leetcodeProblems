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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        while(!q.isEmpty()){
            int size = q.size();
             List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                int v = temp.val;
                ans.add(v);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            res.add(ans);
        }
        return res;
    }
}