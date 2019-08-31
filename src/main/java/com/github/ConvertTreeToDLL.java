package com.github;

public class ConvertTreeToDLL {
    private TreeNode prev = null;
    private TreeNode head = null;

    public boolean findTarget(TreeNode root, int k) {
        getDLL(root);
        while (head != prev) {
            int sum = head.val + prev.val;
            if(sum == k) {
                return true;
            }
            if (sum < k) {
                head = head.right;
            } else {
                prev = prev.left;
            }
        }
        return false;
    }

    private void getDLL(TreeNode root) {
        if (root == null) {
            return;
        }
        getDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        getDLL(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
