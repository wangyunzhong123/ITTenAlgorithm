package com.wyz.StringAbout;

import java.util.*;

/**
 * Created by yzwang on 2017/8/25.
 */
public class Friends {

    public static void main(String[] args) {

        System.out.println(com());

    }

    public static int com(){
        int [][]  a = new int[][]{{1,1,0,0,0,0},{1,1,0,1,0,0},{0,0,1,0,0,0},
                {0,1,0,1,0,1},{0,0,0,0,1,0},{0,0,0,1,0,1}};
        int size = a.length;

        Set set = new HashSet();
        int count = 0;

        for (int j = 0; j < size; j++) {

            if(!set.contains(j)) {
                set.add(j);
                count ++;
            }else
                continue;

            Deque nodeDeque = new ArrayDeque();

            nodeDeque.add(j);

            while(!nodeDeque.isEmpty()){

                int node = (Integer) nodeDeque.removeFirst();

                for (int i = 0; i < size; i++) {
                    if(i!=node && a[node][i] ==1 && !set.contains(i)){
                        nodeDeque.add(i);
                        set.add(i);
                    }
                }
            }
        }

        return count;

    }
}
