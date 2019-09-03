package lianxi;

import java.util.Arrays;
import java.util.Scanner;

//顺丰第二题，最长上升子序列
public class Solution33 {

    public static void main(String[] args) {

        Scanner in = new Scanner((System.in));

        int n = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        System.out.println(Lift(a));

    }

    public static int Lift(int[] nums){
        int L = nums.length;
        if(L==0){
            return 0;
        }
        if(L==1){
            return 1;
        }

        int[] dp = new int[L];
        Arrays.fill(dp,1);
        for(int i=1;i<L;i++){
            int curVal = nums[i];
            for(int j=0;j<i;j++){
                if(curVal>nums[j]){
                    dp[i] = Integer.max(dp[j]+1,dp[i]);
                }
            }
        }

        int res = dp[0];
        for(int i=0;i<L;i++){
            res = Integer.max(res,dp[i]);
        }
        return res;
    }
}
