package lianxi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution1 {
    public static int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            int c = nums[i];
            if(set.contains((Object)c)){
                set.remove((Object)c);
            }else{
                set.add(c);
            }
        }

        int a=0;

        for(Integer b:set){
            a = b;
        }


        return a;
    }

    public static void main(String[] args) {

        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 1;
        System.out.println(singleNumber(nums));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(3);

        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
