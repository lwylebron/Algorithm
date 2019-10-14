package lianxi;

import java.util.Scanner;

//小红书
public class Solution38 {

    public static void main(String[] args) {

        Scanner in  =new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int k = in.nextInt();

        int[][] a = new int[m][n];

        for(int i=0;i<k;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            a[x][y] = 1;
        }

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        if(a[0][1]==0){
            dp[0][1]=1;
        }
        if(a[1][0]==0){
            dp[1][0]=1;
        }

        if(help(a,dp,m-1,n-1,m-1,n-1)==Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(help(a,dp,m-1,n-1,m-1,n-1));
        }


    }

    public static int help(int[][] a,int[][] dp,int i,int j,int m,int n){
        int x1;
        int x2;
        int x3;
        int x4;
        x1 = x2 = x3 = x4 = Integer.MAX_VALUE;
        if(i-1>=0&&a[i-1][j]==0){
             x1 = dp[i-1][j];
        }
        if(i+1<=m-1&&a[i+1][j]==0){
            x2 = dp[i+1][j];
        }
        if(j-1>=0&&a[i][j-1]==0){
            x3 = dp[i][j-1];
        }
        if(j+1<=n-1&&a[i][j+1]==0){
            x4 = dp[i][j+1];
        }

        return Math.min(Math.min(x1,x2),Math.min(x3,x4))<Integer.MAX_VALUE?
                Math.min(Math.min(x1,x2),Math.min(x3,x4))+1:Integer.MAX_VALUE;
    }
}
