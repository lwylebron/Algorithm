package lianxi;

import java.util.HashMap;
import java.util.Map;

public class Solution56 {

    private static int solution(int[] input) {

        int res = 0;

        int len = input.length;

        boolean[] flag = new boolean[len];

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<len;i++){
            map.put(input[i],getL(input,input[i]));
        }

        for(Integer key:map.keySet()){
            res = res +map.get(key)^2;
        }

        return res;



    }

    public static int getL(int[] a,int b){
        int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==b){
                count++;
            }
        }
        return count;
    }

    public static int getMax(int[] a){
        int max = 0;
        int res = 0;
        for(int i=0;i<a.length;i++){
            if(getL(a,a[i])>max){
                res = i;
            }
        }

        return res;
    }

    public static int find(int[] a){
        int len = a.length;
        int startIndex = getMax(a) ;
        int endIndex = 0;
        return 0;

    }
}
