package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    public static int treeDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            level++;
            for (int i = len; i > 0; i--) {
                TreeNode temp = queue.peek();
                queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        A.left = B;
        A.right = C;
        C.left = D;
        C.right = E;
        E.left = F;
        A.val = 3;
        B.val = 9;
        C.val = 20;
        D.val = 15;
        E.val = 7;
        A.setRoot();
        int depth = treeDepth(A);
        System.out.println(depth);

    }

    static TreeNode A = new TreeNode();
    static TreeNode B = new TreeNode();
    static TreeNode C = new TreeNode();
    static TreeNode D = new TreeNode();
    static TreeNode E = new TreeNode();
    static TreeNode F = new TreeNode();
}
