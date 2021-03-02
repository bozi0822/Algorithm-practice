package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  103.给定一个二叉树，返回其节点值的锯齿形层序遍历。
 *  （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 **/
//             3
//            / \
//           9   20
//              /  \
//             15   7
//        [
//          [3],
//          [20,9],
//          [15,7]
//        ]
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode c = root;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (c == null) {
            return ans;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            while (!s1.isEmpty()) {
                c = s1.pop();
                tmp.add(c.val);
                if (c.left != null) {
                    s2.push(c.left);
                }
                if (c.right != null) {
                    s2.push(c.right);
                }
            }
            ans.add(tmp);
            tmp = new ArrayList<Integer>();
            while (!s2.isEmpty()) {
                c = s2.pop();
                tmp.add(c.val);
                if (c.right != null) {
                    s1.push(c.right);
                }
                if (c.left != null) {
                    s1.push(c.left);
                }
            }
            if (!tmp.isEmpty()) {
                ans.add(tmp);
            }
        }
        return ans;
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
        List<List<Integer>> res;
        res = zigzagLevelOrder(A);
        System.out.println(res);
    }

    static TreeNode A = new TreeNode();
    static TreeNode B = new TreeNode();
    static TreeNode C = new TreeNode();
    static TreeNode D = new TreeNode();
    static TreeNode E = new TreeNode();
}
