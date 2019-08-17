package lianxi;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 将一个数组变为严格先增后减的形式，并且只能增加里面的元素，求最小一共增加多少
 * 如 1 4 3 2 5 到 1 4 5 6 5，一共增加6
 */
public class Solution15 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }


    }

    public static long minSum(int n ,long[] nums) {
        if(n == 1)
            return 0;
        if(n == 2 && nums[0] == nums[1])
            return 1;
        if(n == 2 && nums[0] != nums[1])
            return 0;
        long[] temp = Arrays.copyOf(nums, n);
        int i = 0;
        while(i < n-1 && nums[i] < nums[i+1])
            i++;
        int j = n-1;
        while(j > 0 && nums[j] < nums[j-1])
            j--;
        while(i < j) {
            if(nums[i] < nums[j]) {
                if(nums[i+1] < nums[i]+1)
                    nums[i+1] = nums[i] + 1;
                i++;
            } else {
                if(nums[j-1] < nums[j]+1)
                    nums[j-1] = nums[j] + 1;
                j--;
            }
        }
        return Arrays.stream(nums).sum() - Arrays.stream(temp).sum();}
}
