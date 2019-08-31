package com.github;

import org.junit.Test;

public class ConvertTreeToDLLTest {
    @Test
    public void test() {
        ConvertTreeToDLL convertTreeToDLL = new ConvertTreeToDLL();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(convertTreeToDLL.findTarget(root, 3));
    }
}