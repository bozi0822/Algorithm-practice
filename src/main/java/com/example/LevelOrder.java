package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 **/
public class LevelOrder {
//             3
//            / \
//           9   20
//              /  \
//             15   7
//        [
//          [3],
//          [9,20],
//          [15,7]
//        ]
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);//将 首个元素的左节点 插入queue
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);//将 首个元素的右节点 插入queue
                }
                subList.add(queue.poll().val);//将 首个元素的val 弹出 queue
            }

            wrapList.add(subList);// 将 每层节点 插入 结果集
        }
        return wrapList;
    }

    public static void main(String[] args) {
        A.left = B;
        A.right = C;
        C.left = D;
        C.right = E;
        A.val = 3;
        B.val = 9;
        C.val = 20;
        D.val = 15;
        E.val = 7;
        A.setRoot();
        List<List<Integer>> res = levelOrder(A);
        System.out.println(res);
    }

    static TreeNode A = new TreeNode();
    static TreeNode B = new TreeNode();
    static TreeNode C = new TreeNode();
    static TreeNode D = new TreeNode();
    static TreeNode E = new TreeNode();
}
