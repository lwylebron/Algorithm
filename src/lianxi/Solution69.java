package lianxi;

import java.util.Arrays;
import java.util.Scanner;

public class Solution69 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();

       }

        Arrays.sort(a);

        int res=0;

        for(int i=0;i<a.length;i++){
            int b = a[i];

            if(i==a.length-1){
                break;
            }

            int count = 2;

            int d  =a[i+1]-a[i];

            for(int j=i+2;j<a.length;j++){
                if(a[j]-a[j-1]==d){
                    count++;
                }else{
                    break;
                }
            }

            res = Math.max(count,res);
        }


        System.out.println(res);
    }
}
