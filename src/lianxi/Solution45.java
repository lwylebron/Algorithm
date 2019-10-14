package lianxi;

import java.util.Scanner;

/*
  华为第一题
 */
public class Solution45 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] a = s.split(" ");
        int len = a.length;
        int[] arr = new int[len];

        for(int i=0;i<len;i++){
            arr[i] = Integer.parseInt(a[i]);
        }
        System.out.println(help(arr));
    }

    public  static int help(int[] arr){
        if(arr.length==1){
            return -1;
        }
        int step = 0;
        int len = arr.length;
        int lastCover=0;
        int maxCover = 0;
        for(int i=0;i<=maxCover&&i<len-1;i++){

            if(arr[i]+i==len-1){
                step++;
                maxCover = arr[i]+i;
                break;
            }
            if(i>lastCover){
                step++;
                lastCover = maxCover;
            }
            if(i+arr[i]>maxCover&&(i+arr[i]<len-1)){
                maxCover = i+arr[i];
            }

        }
        if(maxCover!=len-1){
            return -1;
        }
        return step;
    }
}
