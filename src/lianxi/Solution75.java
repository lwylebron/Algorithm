package lianxi;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class Solution75 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int m = in.nextInt();

        int n = in.nextInt();

        int[][] a = new int[n][2];

        for(int i=0;i<n;i++){
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i][1]==a[j][0]){
                    count++;
                    break;
                }
            }
        }

        int res = (m-count)/2;

        res = res*2;

        System.out.println(res);
    }
}
