package com.example;

import java.util.*;

public class BinTree {
    private BinTree left;
    private BinTree right;
    private BinTree root;

    private Object data;
    private List<BinTree> datas;// 存节点
    private Stack<BinTree> stack = new Stack<>();
    private List<Object> res = new ArrayList<>();

    public BinTree(BinTree left, BinTree right, Object data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinTree(Object obj) {
        this(null, null, obj);
    }

    public BinTree() {
    }

    public void create(Object[] objs) {
        datas = new ArrayList<>();
        for (Object obj : objs) {
            datas.add(new BinTree(obj));
        }
        // 第一个数作为根节点
        root = datas.get(0);

        for (int i = 0; i < objs.length / 2; i++) {
            datas.get(i).left = datas.get(i * 2 + 1);
            // 避免越界
            if (i * 2 + 2 < datas.size()) {
                datas.get(i).right = datas.get(i * 2 + 2);
            }
        }
    }

    // 根 左 右
    public void preorder() {
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.data);
                stack.push(root);
                root = root.left;
            }
            BinTree cur = stack.pop();
            root = cur.right;
        }
        System.out.println(res);
    }

    // 左 右 根
    // 根 右 左  reverse
    public void afterOrder() {
        while (root != null || !stack.isEmpty()){
            while (root != null){
                res.add(root.data);
                stack.push(root);
                root = root.right;
            }

            BinTree cur = stack.pop();
            root = cur.left;
        }
        Collections.reverse(res);
        System.out.println(res);
    }

    // 左 根 右
    public void inOrder(){
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.data);
            root = root.right;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Object[] objects = {6, 2, 7, 5, 1, 10, 13, 4};
        BinTree binTree = new BinTree();
        binTree.create(objects);
        binTree.preorder();// 根 左 右     [6, 2, 5, 1, 7, 10]    [6, 2, 5, 4, 1, 7, 10, 13]
//        binTree.inOrder();// 左 根 右      [5, 2, 1, 6, 10, 7]      [4, 5, 2, 1, 6, 10, 7, 13]
//        binTree.afterOrder();// 左 右 根   [5, 1, 2, 10, 7, 6]    [4, 5, 1, 2, 10, 13, 7, 6]
    }

//            6
//        2       7
//      5   1   10  13
//    4

//    Leetcode
//    v 144、94、145、173、102、
//      103、107

}
