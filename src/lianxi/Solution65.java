package lianxi;

import java.util.Scanner;

public class Solution65 {

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int sum = in.nextInt();

        s = s.substring(1,s.length()-1);

        String[] c= s.split(",");

        int[] a = new int[c.length];

        for(int i=0;i<c.length;i++){
            a[i] = Integer.parseInt(c[i].trim());
        }

        int n = a.length;

        help(a,sum,0,a.length-1);

        System.out.println(res);

    }

    public static void help(int[] a,int sum,int count,int m){

        if(sum==0){
            res = Math.min(count,res);
        }
        if(sum<0){
            return;
        }
        if(m<0){
            return;
        }

        for(int i=m;i>=0;i--){

            int num = sum/a[i];

            for(int j=1;j<=num;j++){
                help(a,sum-j*a[i],count+j,m-1);
            }
        }
    }
}
