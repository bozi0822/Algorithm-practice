package com.example;

import java.util.*;

/**
  * 去除重复区间（贪心算法）
  *
 **/
public class EraseOverlapIntervals {

    public static int eraseOver(List<List<Integer>> intervals){
        if (intervals.isEmpty()){
            return 0;
        }
        int n = intervals.size();

        intervals.sort(Comparator.comparingInt(a -> a.get(1)));
        System.out.println("2 " + intervals);
        int total = 0;
        int prev = intervals.get(0).get(1);
        for (int i = 1; i < n; i++) {
            if (intervals.get(i).get(0) < prev){
                total++;
                System.out.println("remove items: " + intervals.get(i));
            }else {
                prev = intervals.get(i).get(1);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 4),
                        Arrays.asList(1, 3),
                        Arrays.asList(2, 3)
                ));
        System.out.println("1 " + intervals);
        int res = eraseOver(intervals);
        System.out.println(res);
    }
}
