package lianxi;

import java.util.*;

public class Solution54 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] res = new int[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        while(in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            List<Integer> list = map.get(a);
            list.add(a);
            map.put(a,list);
        }

        int count = 1;
        for(int i=1;i<=n;i++){
            if(map.get(i).size()==0){
                res[i] = count;
                map.remove(i);
                for(Integer j:map.keySet()){
                    List list = map.get(j);
                    list.remove(i);
                }

            }
            count++;
        }
    }
}
