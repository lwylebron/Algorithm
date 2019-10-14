package lianxi;

import java.util.Scanner;

public class Solution82 {

    public static void main(String[] args) {
        Scanner  in=  new Scanner(System.in);

        int n = in.nextInt();

        int[] a=  new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        for(int i=0;i<n;i++){
            System.out.println(help(a[i]));
        }


    }

    static String help(int n){

        int count = n*(n-1)/2;

        int res = 0;

        for(int i=1;i<n;i++){
           for(int j=i+1;j<=n;j++){
               if(get(i,j)){

                   res = res+i*j;
               }
           }
        }

        return getDiv(res,count);



    }


    private static boolean get(int n, int m) {//其函数为求最大公约数，当公约数为1的时候，则其互质

        int t=0;
        while(m>0) {
            t=n%m;
            n=m;
            m=t;//当=0说明两个数之间存在倍数关系
        }
        if(n==1)return true;
        return false;
    }

    private static String getDiv(int n, int m) {
        if(n%m==0){
            int a = n/m;
            return String.valueOf(a);
        }
        if(n == 0)
            return "0";
        int p = getMax(n,m);
        n = n/p;
        m = m/p;
        return Integer.toString(n) + "/" + Integer.toString(m);
    }
    private static int getMax(int n, int m) {
      			if(n < m){
      			    int tp = n;
      			    n = m;
      			    m = tp;
      			}
      			int p = n%m;
      			while(p != 0){
      			    n = m;
      			    m = p;
      			    p = n%m;
      			}
      			return m;
    }

}



