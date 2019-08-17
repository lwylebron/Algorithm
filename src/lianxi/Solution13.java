package lianxi;

import java.util.Scanner;

/*
最长上升子序列
 */
 public class Solution13{
     public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[1002];//arr数组表示输入的序列
        int[] dp = new int[1002];
        for(int i = 1;i <= n;i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }

     int result = -1;
     for(int i = 1;i <= n;i++) {
         dp[i] = 1;
         for(int j = 1;j < i;j++) {
             if(arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                 dp[i] = dp[j] + 1;
             }
         }
         result = Math.max(result, dp[i]);
     }
     System.out.println(result);
 }
 }

