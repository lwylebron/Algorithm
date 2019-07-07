import java.io.*;
import java.util.*;
public class Main1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        int C = in.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        int[][] dp = new int[n+1][C + 1];


        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i-1][j];
                if (w[i-1] <= j) {
                    if(dp[i-1][j - w[i-1]] + v[i-1]>dp[i-1][j]) {
                        dp[i][j] = dp[i-1][j - w[i-1]] + v[i-1];
                    }
                }
            }
        }


        System.out.print(dp[0][0]);

    }
}