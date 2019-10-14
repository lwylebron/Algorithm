package lianxi;

import java.util.*;

public class Solution78 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] time = new int[n][2];

        for(int i=0;i<n;i++){
            time[i][0] = in.nextInt();
            time[i][1] = in.nextInt();
        }


        System.out.println(minTime(time));
    }

    public static int minTime(int[][] time){
        sort(time,new int[]{1});
        int res=0;
        int i=0;int j=time.length-1;
        while(i<j){
            if(res<time[i][0]+time[j][0]){
                res = time[i][0]+time[j][0];
            }
            if(time[i][1]==time[j][1]){
                i++;
                j--;
            }
            else if(time[i][1]<time[j][1]){
                time[j][1]-=time[i][1];
                i++;
            }
            else{
                time[i][1]-=time[j][1];
                j--;
            }
        }
        if(i==j&&res<time[i][0]*2){
            res = time[i][0]*2;

        }
        return res;
    }

    public static void sort(int[][] ob, final int[] order) {
        Arrays.sort(ob, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                for (int i = 0; i < order.length; i++) {
                    int k = order[i];
                    if (one[k] < two[k]) {
                        return 1;
                    } else if (one[k] > two[k]) {
                        return -1;
                    } else {
                        continue;  //如果按一条件比较结果相等，就使用第二个条件进行比较。
                    }
                }
                return 0;
            }
        });
    }



}
