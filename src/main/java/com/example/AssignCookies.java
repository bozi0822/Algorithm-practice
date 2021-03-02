package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class AssignCookies {
    static Logger logger = Logger.getLogger("AssignCookies");

    /**
     *  输入两个数组，分别代表 每个孩子的饥饿度 和 饼干的大小。
     *  输出最多有多少孩子可以吃饱的数量
     **/
    static int findContentChildren(List<Integer> children, List<Integer> cookies) {
        Collections.sort(children);
        Collections.sort(cookies);
        logger.info("children => " + children);
        logger.info("cookies => " + cookies);
        int child = 0;
        int cookie = 0;
        while (child < children.size() && cookie < cookies.size()) {
            if (children.get(child) <= cookies.get(cookie)) {
                ++child;
            }
            ++cookie;
        }
        return child;
    }

    /**
     *  一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，
     *  规则：如果一个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果，
     *  所以有孩子至少要有一个糖果，求解最少需要多少个糖果
     *
     *  输入是一个数组，表示孩子的评分，输出的是最少糖果的数量
     *
     **/
    static int candy(int[] ratings) {
        int size = ratings.length;
        if (size < 2) {
            return size;
        }
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);
        logger.info("init: " + "num=>" + Arrays.toString(num));
        //从左到右
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            }
        }
        logger.info("out1: " + "num=>" + Arrays.toString(num));
        //从右到左
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                num[i - 1] = Integer.max(num[i - 1], num[i] + 1);
            }
        }
        logger.info("out2: " + "num=>" + Arrays.toString(num));

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += num[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 1};
        int res = candy(ratings);
        logger.info(String.valueOf(res));

//        List<Integer> children = new ArrayList<Integer>(Arrays.asList(1, 2));
//        List<Integer> cookies = new ArrayList<Integer>(Arrays.asList(1, 4, 5));
//        int res = findContentChildren(children, cookies);
//        logger.info(String.valueOf(res));
    }
}


