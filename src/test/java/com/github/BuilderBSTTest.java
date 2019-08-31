package com.github;

import org.junit.Test;

public class BuilderBSTTest {
    @Test
    public void test() {
        BuilderBST builderBST = new BuilderBST();
        int[] arr = {8, 5, 1, 7, 10, 12};
        BuilderBST.TreeNode treeNode = builderBST.bstFromPreorder(arr);
        print(treeNode);
    }

    private void print(BuilderBST.TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.val);
        print(root.left);
        print(root.right);
    }
}