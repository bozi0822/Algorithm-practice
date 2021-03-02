package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173.实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 **/
public class BSTIterator {

    private Deque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }

    static TreeNode A = new TreeNode();
    static TreeNode B = new TreeNode();
    static TreeNode C = new TreeNode();
    static TreeNode D = new TreeNode();
    static TreeNode E = new TreeNode();

    public static void main(String[] args) {
        init();
//                  7
//             3       15
//                    9  20

        BSTIterator iterator = new BSTIterator(A);
        Integer a1 = iterator.next();    // 返回 3
        Integer a2 = iterator.next();    // 返回 7
        Boolean b1 = iterator.hasNext(); // 返回 true
        Integer a3 = iterator.next();    // 返回 9
        Boolean b2 = iterator.hasNext(); // 返回 true
        Integer a4 = iterator.next();    // 返回 15
        Boolean b3 = iterator.hasNext(); // 返回 true
        Integer a5 = iterator.next();    // 返回 20
        Boolean b4 = iterator.hasNext(); // 返回 false

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(a3);
        System.out.println(b2);
        System.out.println(a4);
        System.out.println(b3);
        System.out.println(a5);
        System.out.println(b4);
    }

    public static void init() {
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
    }
}
