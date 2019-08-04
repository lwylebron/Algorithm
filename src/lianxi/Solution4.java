package lianxi;

/**
 * n个任务，任务之间存在依赖关系，求最小时间
 */

import java.util.*;

public class Solution4 {

    public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      int m = in.nextInt();
      int n = in.nextInt();

      int[] a = new int[m];
      int[][] b = new int[n][2];

      for(int i=0;i<m;i++){
          a[i] = in.nextInt();
      }

      for(int i=0;i<n;i++){
          b[i][0] = in.nextInt();
          b[i][1] =in.nextInt();
      }




    }

}
