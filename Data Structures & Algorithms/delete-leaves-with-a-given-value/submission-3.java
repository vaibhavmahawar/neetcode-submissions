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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visit = new HashSet<>();
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                if (node.val == target) {
                    TreeNode p = parents.get(node);
                    if (p == null) {
                        return null;
                    }
                    if (p.left == node) {
                        p.left = null;
                    }
                    if (p.right == node) {
                        p.right = null;
                    }
                }
            } else if (!visit.contains(node)) {
                visit.add(node);
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                    parents.put(node.left, node);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    parents.put(node.right, node);
                }
            }
        }
        return root;
    }
}