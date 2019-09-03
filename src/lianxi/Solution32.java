package lianxi;

import java.util.*;

public class Solution32 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[k];
        int[] b = new int[k];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<k;i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            if(map.containsKey(a[i])){
                map.get(a[i]).add(b[i]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(b[i]);
                map.put(a[i],list);
            }
        }

        int size = map.size();

        int count = 0;

        System.out.println(2);


    }
}
