package lianxi;

import java.util.Scanner;

public class Solution46 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long m = in.nextLong();
        long n = in.nextLong();


        System.out.println(help(m,n)%1000000007);
    }

    public static long help(long m,long n){

        if(m==1){
            return 1;
        }
        if(n==1){
            return m;
        }

        long res = 0;

        for(long i=1;i<n;i++){
            res = res+help(m-1,n-i);
        }

        return (m*res+help(m-1,n));
    }
}
