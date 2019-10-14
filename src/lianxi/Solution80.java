package lianxi;

import java.util.Scanner;

public class Solution80 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int k = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        for(int i=0;i<k;i++){

            int min = Integer.MAX_VALUE;

            for(int j =0 ;j<n;j++){
                if(a[j]!=0){
                    min = Math.min(min,a[j]);
                }

            }

            if(min==Integer.MAX_VALUE){
                min = 0;
            }
            System.out.println(min);

            for(int j =0 ;j<n;j++){

                if(a[j]!=0){

                    a[j] = a[j]-min;

                }

            }
        }
    }
}
