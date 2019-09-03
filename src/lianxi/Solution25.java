package lianxi;

import java.util.Arrays;
import java.util.Scanner;

//重量差最小，数量差最大
public class Solution25 {

    public static void main(String[] args) {

        Scanner in  =new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        int[] res = new int[2];
        res = getProducts(n,a);

        System.out.print(res[0]);
        System.out.print(" ");
        System.out.print(res[1]);
    }

    public static int[] getProducts(int n, int[] nums) {

        int[] res = new int[2];

        if(n == 0 || nums == null || nums.length == 0)
            return res;

        int sum = 0;

        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        int target = sum / 2;

        int[] dp = new int[target+1];

        for(int num: nums) {
            for(int i = target; i >= num; i--) {
                dp[i] = Math.max(dp[i], dp[i-num]+num);
            }
        }

        res[0] = Math.abs(dp[target] - (sum- dp[target]));

        int[] dpCount = new int[dp[target]+1];

        Arrays.fill(dpCount, dp[target]+1);

        dpCount[0] = 0;

        for(int num: nums) {
            for(int i = dp[target]; i >= num; i--) {
                dpCount[i] = Math.min(dpCount[i], dpCount[i-num]+1);
            }
        }

        res[1] = Math.abs(dpCount[dp[target]] - (n - dpCount[dp[target]]));

        return res;
    }
}
