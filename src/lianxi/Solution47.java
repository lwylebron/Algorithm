package lianxi;

import java.util.Scanner;

public class Solution47 {
    public static void main(String[] args) {
        char[] a = new char[]{'a','b','c','a','b','d','a'};
        int[] b = getNext(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
    }

    //得到数组a的每个位置的相同前后缀长度
    public static int[] getNext(char[] a){

        int j=1;
        int k=0;
        int len = a.length;
        int[] next = new int[len];
        next[0] = 0;

        while(j<len){
            if(a[j]==a[k]){
                j++;
                k++;
                next[j-1] = k;
            }else{
                k=0;
                j++;
            }
        }

        return next;

    }
}
