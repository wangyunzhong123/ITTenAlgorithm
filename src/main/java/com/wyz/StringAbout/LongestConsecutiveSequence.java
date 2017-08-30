package com.wyz.StringAbout;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yzwang on 2017/8/24.
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : num)
            set.add(e);

        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }

    public static void main(String[] args) {

        int []num  = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));
    }
}
