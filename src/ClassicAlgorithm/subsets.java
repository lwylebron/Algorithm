package ClassicAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class subsets {

    public static List<List<Integer>> subset(int[] nums){
        List<List<Integer>>  list =new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    static void backtrack(List<List<Integer>> list,List<Integer> tempList,int[] nums,int start){
        list.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    //当nums中包含重复元素时
    static void backtrack1(List<List<Integer>> list,List<Integer> tempList,int[] nums,int start){
        list.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]){
                continue;   //跳过重复
            }
            tempList.add(nums[i]);
            backtrack1(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> list = subset(nums);
        for(int i=0;i<list.size();i++){
            List<Integer> list1 = list.get(i);
            for(int j=0;j<list1.size();j++){
                System.out.print(list1.get(j));
            }
            System.out.println();
        }
    }


}
