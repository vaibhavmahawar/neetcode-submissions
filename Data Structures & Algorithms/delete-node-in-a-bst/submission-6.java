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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null && cur.val != key) {
            parent = cur;
            if (key > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (cur == null) return root;
        if (cur.left == null || cur.right == null) {
            TreeNode child = (cur.left != null) ? cur.left : cur.right;
            if (parent == null) return child;
            if (parent.left == cur) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            TreeNode par = null;
            TreeNode delNode = cur;
            cur = cur.right;
            while (cur.left != null) {
                par = cur;
                cur = cur.left;
            }
            if (par != null) {
                par.left = cur.right;
                cur.right = delNode.right;
            }
            cur.left = delNode.left;
            if (parent == null) return cur;
            if (parent.left == delNode) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
        }
        return root;
    }
}