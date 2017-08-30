package com.wyz.StringAbout;

import java.util.HashSet;

/**
 * Created by yzwang on 2017/8/24.
 */
public class LongeSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;

        HashSet<Character> set = new HashSet<Character>();

        int max=0;

        int i=0;
        int start=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                max = Math.max(max, set.size());

                while(start<i&&s.charAt(start)!=c){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }

            i++;
        }

        max = Math.max(max, set.size());

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));


    }

    int numberOf1(int n){
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n & flag) !=0)
                count ++;
            flag = flag << 1;
        }

        return count;
    }

}
