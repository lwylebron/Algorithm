package lianxi;


import java.util.Arrays;
import java.util.Scanner;

public class Solution68 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        int sum = 0;

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
            sum = sum+a[i];
        }

        int aim = sum/2;

        Arrays.sort(a);

        int[][] dp =new int[n][aim+1];

        for(int j=0;j<aim+1;j++){
            if(a[0]>j){
                dp[0][j]=0;
            }else{
                dp[0][j]=a[0];
            }
        }

        //dp[i][j]表示背包容量为j时，尝试放入前i+1个物品所能获得的最大价值
        for(int i=1;i<n;i++){
            for(int j=0;j<aim+1;j++){
                //当前物品不可以放入背包时
                if(a[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(a[i]+dp[i-1][j-a[i]],dp[i-1][j]);
                }
            }
        }

        System.out.println(sum-2*dp[n-1][aim]);
    }
}
