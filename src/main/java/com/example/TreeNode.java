package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树
 *
 *
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode root;

    TreeNode() {
    }

    /**
     * 设置根节点
     **/
    void setRoot() {
        this.root = this;
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 前序遍历
     * (根 左 右)
     **/
    public void preorder() {
        Stack<TreeNode> stack = new Stack<>();
        List<Object> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        System.out.println(res);
    }

    /**
     * 后序遍历
     * (左 右 根)
     * (根 右 左  reverse)
     **/
    public void afterOrder() {
        Stack<TreeNode> stack = new Stack<>();
        List<Object> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }

            TreeNode cur = stack.pop();
            root = cur.left;
        }
        Collections.reverse(res);
        System.out.println(res);
    }

    /**
     * 后序遍历
     * (左 根 右)
     **/
    public void inOrder() {
        Stack<TreeNode> stack = new Stack<>();
        List<Object> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        System.out.println(res);
    }
}
