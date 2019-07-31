package lianxi;

import java.util.Scanner;

public class Solution5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();

        int[] a = new int[m];
        int[] b = new int[m];

        for(int i=0;i<m;i++){
            a[i] = in.nextInt();
        }

        for(int i=0;i<m;i++){
            b[i] = in.nextInt();
        }

        int max = 0;

        for(int i=0;i<m;i++){
            max = Math.max(max,help(a,b,i));
        }

        System.out.print(max);
    }

    static int help(int[] a,int[] b,int i){
        return a.length-4;
    }
}
