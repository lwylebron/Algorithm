package lianxi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
3
H
ASDFGH
ASDFDSAG
 */

public class Solution85 {

    static String temp = "ASDFGH";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        in.nextLine();

        String[] s = new String[n];

        for(int i=0;i<n;i++){
            s[i] = in.nextLine();
        }

        for(int i=0;i<n;i++){
            if(s[i].length()>6){
                boolean[] flag = new boolean[6];
                int res = Integer.MAX_VALUE;
                permutation_2(0,6,s[i],"",res,flag);
                System.out.println(res);
            }else{
                System.out.println(s[i].length()-1);
            }
        }

    }
    public static void permutation_2(int cur, int n, String s0,String s1,int min,boolean[] flag){
        
        if(cur == n){
            min = Math.min(min, help(s0,s1));
        }

        for(int i = 0; i < n; i++){

            if(!flag[i]){
                s1 = s1+temp.charAt(i);
                flag[i] = true;
                permutation_2( cur++,n,s0,s1,min,flag);
                flag[i] = false;
                s1 = s1.substring(0,s1.length()-1);
            }

        }
    }


    public static int help(String s,String temp){

        char[] c1 = s.toCharArray();

        char[] c2 = temp.toCharArray();

        Map<Character,Integer> map = new HashMap<>();

        for (int i=0;i<c2.length;i++){
            map.put(c2[i],i);
        }

        int res = map.get(c1[0]);

        for(int i=1;i<c1.length;i++){
            int a = Math.abs(map.get(c1[i])-map.get(c1[i-1]));
            res = res+a;
        }


        return res;
    }



}
