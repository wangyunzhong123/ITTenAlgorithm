package com.wyz.StringAbout;

import java.util.ArrayList;

/**
 * Created by yzwang on 2017/8/24.
 */
public class Triangle {

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int l = triangle.size() - 1;

        for (int i = 0; i < triangle.get(l).size(); i++) {
            total[i] = triangle.get(l).get(i);
        }

        // iterate from last second row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }

        return total[0];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

        ArrayList list1 = new ArrayList();
        list1.add(2);
        triangle.add(list1);

        ArrayList list2 = new ArrayList();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        ArrayList list3 = new ArrayList();
        list3.add(6);
        list3.add(5);
        list3.add(1);
        triangle.add(list3);

        ArrayList list4 = new ArrayList();
        list4.add(4);
        list4.add(7);
        list4.add(9);
        list4.add(2);
        triangle.add(list4);

        System.out.println(minimumTotal(triangle));
    }

}
