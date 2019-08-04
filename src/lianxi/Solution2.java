package lianxi;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n  = in.nextInt();

        int[] a = new int[n];

        int b = in.nextInt();

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        Arrays.sort(a); //对a排序

        int[] arr  = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        if(a[1]-a[0]>b){
            arr[2] = 0;
        }else{
            arr[2] = 1;
        }


    }




}
