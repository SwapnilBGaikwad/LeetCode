package com.github;

public class BuilderBST {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(preorder[i]);
        }
        TreeNode root = new TreeNode(preorder[i]);
        int mid = arrangeElements(preorder, i, j);
        root.left = bstFromPreorder(preorder, i + 1, mid - 1);
        root.right = bstFromPreorder(preorder, mid, j);
        return root;
    }

    int arrangeElements(int[] preorder, int i, int j) {
        int root = preorder[i];
        i++;
        while (i <= j && preorder[i] < root) {
            i++;
        }
        return i;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
