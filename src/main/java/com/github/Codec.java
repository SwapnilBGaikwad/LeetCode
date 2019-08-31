package com.github;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        int h = height(root);
        Integer[] arr = new Integer[(int) Math.pow(2, h) - 1];
        convertToArray(root, arr, 0);
        return getString(arr);
    }

    void convertToArray(TreeNode root, Integer[] arr, int index) {
        if(root == null) {
            return;
        }
        arr[index] = root.val;
        convertToArray(root.left, arr, 2 * index + 1);
        convertToArray(root.right, arr, 2 * index + 2);
    }

    String getString(Integer[] arr) {
        StringBuilder builder = new StringBuilder();
        for(Integer no : arr) {
            if(no == null) {
                builder.append("-,");
            } else {
                builder.append(no.toString() + ",");
            }
        }
        return builder.toString();
    }

    Integer[] getArray(String string) {
        String[] strs = string.split(",");
        int i = 0;
        Integer[] arr = new Integer[strs.length];
        for(String str : strs) {
            if(str.equals("-")) {
                arr[i] = null;
            } else {
                arr[i] = Integer.parseInt(str);
            }
            i++;
        }
        return arr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) {
            return null;
        }
        Integer[] arr = getArray(data);
        return deserialize(arr, 0);
    }

    TreeNode deserialize(Integer[] arr, int index) {
        if(index >= arr.length) {
            return null;
        }
        if(arr[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = deserialize(arr, 2 * index + 1);
        root.right = deserialize(arr, 2 * index + 2);
        return root;
    }
}