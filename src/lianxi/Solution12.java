package lianxi;

import java.util.Scanner;

public class Solution12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<a.length;i++){
            a[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE;

        if(a.length==1||a.length==0){
            System.out.println("null");
        }
        int i=1;
        int j=1;
        for(;i<a.length;i++){

            int c = Math.abs(a[i]-a[i-1]);
            if(c<min){
                j=i;
                min = c;
            }
        }

        System.out.println(a[j-1]+" "+a[j]);
    }
}
