package lianxi;

import java.util.Scanner;

public class Solution24 {

    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        int sum = 0;

        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
        }

       int[] v = new int[n];

        for(int i=0;i<n;i++){
            v[i] = 1;
        }

        int res = getResult(a,v,sum/2);

        int ww = 2*res-n;

        System.out.print(1);
        System.out.println(" ");
        System.out.print(ww);

    }

    public static int getResult(int[] w,int[] v,int c){
        if(w.length!=v.length){
            throw new IllegalArgumentException();
        }

        if(c<=0){
            return 0;
        }
        int n = w.length;

        int[][] dp =new int[n][c+1];

        for(int j=0;j<c+1;j++){
            if(w[0]>j){
                dp[0][j]=0;
            }else{
                dp[0][j]=v[0];
            }
        }
        //dp[i][j]表示背包容量为j时，尝试放入前i+1个物品所能获得的最大价值
        for(int i=1;i<n;i++){
            for(int j=0;j<c+1;j++){
                //当前物品不可以放入背包时
                if(w[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(v[i]+dp[i-1][j-w[i]],dp[i-1][j]);
                }
            }
        }
        return dp[n-1][c];
    }


}
