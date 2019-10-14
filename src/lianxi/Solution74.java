package lianxi;

import java.util.*;

public class Solution74 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] a = new int[m][2];

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int x = in.nextInt();
            int y = in.nextInt();

            map.put(x,y);
        }

        List<Integer> list = new ArrayList<>();

        list.add(1);

        boolean[] flag = new boolean[m];

        flag[0] =  true;

        while(list.size()>0){
            List list1 = new ArrayList<>(list);
            for(int i=0;i<list.size();i++){
                int b = list.get(i);
                if(map.containsKey(b)){
                    list.add(map.get(b));
                    flag[map.get(b)-1] = true;
                }
            }
        }

        for(int i=0;i<m;i++){
            if(!flag[i]){
                System.out.println(i+1+" ");
            }
        }


    }
}
