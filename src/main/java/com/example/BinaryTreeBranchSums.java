package com.example;

import java.util.Stack;

public class BinaryTreeBranchSums {

    public static void preOrderSum(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer sum = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                sum += root.val;
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        A.left = B;
        A.right = C;
        C.left = D;
        C.right = E;
        A.val = 7;
        B.val = 3;
        C.val = 15;
        D.val = 9;
        E.val = 20;
        A.setRoot();
        A.preorder();

        preOrderSum(A);
    }

    static TreeNode A = new TreeNode();
    static TreeNode B = new TreeNode();
    static TreeNode C = new TreeNode();
    static TreeNode D = new TreeNode();
    static TreeNode E = new TreeNode();
}
