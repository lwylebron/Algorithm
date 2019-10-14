package lianxi;

import java.util.Scanner;

public class Solution53 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        System.out.println(help1(n,k));
    }

    public static int help1(long n,long k){
        if(n<=k+1){
            return 1;
        }
        if(n%2==0&&k%2!=0){
            return 1;
        }
        if(n%2!=0&&k%2==0){
            return 1;
        }
        long left = (n+k)/2;
        long right = (n-k)/2;
        return help1(left,k)+help1(right,k);
    }
}
