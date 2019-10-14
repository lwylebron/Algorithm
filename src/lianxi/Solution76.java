package lianxi;

import java.util.Scanner;

public class Solution76 {

    public static void main(String[] args) {

        Scanner in =  new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[] a = new int[m];

        for(int i=0;i<m;i++){
            a[i] = in.nextInt();
        }

        int res = Integer.MAX_VALUE;

        for(int i = m;i>=n;i--){
            for(int j=0;j<=m-i;j++){
                int count = 0;
                for(int x = j;x<i+j;x++){
                    count = count+a[x];
                }
                res = Math.min(count,res);
            }
        }

        System.out.println(res);
    }
}
