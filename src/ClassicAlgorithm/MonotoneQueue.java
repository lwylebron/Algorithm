package ClassicAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MonotoneQueue {
    /**
     * 单调队列: 用来求出在数组的某个区间范围内求出最大值
     * 最经典的问题: 滑动窗口的最大值:
     * 题目链接: https://www.lintcode.com/problem/sliding-window-maximum/description
     */
    public static void main(String[] args) {
         int[] nums = new int[]{1,2,3,4,5,6,7,8};
         List<Integer> list = maxSlidingWindow(nums,3);

        Iterator iterator =list.iterator();
        while(iterator.hasNext()){
            int a  =(Integer) iterator.next();  //object转为int
            System.out.print(nums[a]+" ");
        }
    }

    //求滑动窗口的最大值
    public static List<Integer> maxSlidingWindow(int[] nums,int k){
        if(nums==null||k<0||nums.length<k){
            return null;
        }
        List<Integer> res =new ArrayList<>();

        LinkedList<Integer> queue = new LinkedList<>();//使用双端队列，保存的是下标

        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&(nums[i]>=queue.peekLast())){ //若队列不为空且num[i]比队列中元素大
                queue.pollLast();
            }
            queue.addLast(i);

            if(i-k==queue.peekFirst()){  //去除队列首部不在范围内的元素
                queue.pollFirst();
            }
            if(i>=k-1){   //  形成窗口
                res.add(queue.peekFirst()); //队列首部元素最大
            }
        }

        return res;
    }




}
