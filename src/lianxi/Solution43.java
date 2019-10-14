package lianxi;

import java.util.Scanner;

/*
在m个节点的分布式计算系统中，有一批任务需要执行，
每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，
每个节点只能执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间

先计算subarrays sum的上下界，在该范围内二分法搜索满足条件的sum
（以该sum贪心划分array 看能否满足sum>=所有subarray的sum）。并记录最小的sum。
 */
public class Solution43 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int schedule(int m,int[] array) {

        int high = 0, low = 0, mid = 0, ans = 0;
        for (int num : array) {
            high += num;
            low = Math.max(num, low);
        }

        if (m == 1)
            return high;
        if (m == array.length)
            return low;
        ans = high;
        while (low <= high) {
            mid = low + (high - low) / 2;

            boolean flag = true;
            int sum = array[0];
            int count = 1;
            for (int i = 1; i < array.length; i++) {
                sum += array[i];
                if (sum > mid) {
                    count++;
                    sum = array[i];
                }
                if (count > m) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
