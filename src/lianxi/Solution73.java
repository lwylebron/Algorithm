package lianxi;

import java.util.Scanner;

public class Solution73 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

         long n = in.nextLong();

        long res = 1;

        for(long i=n;i>=1;i--){
            res = res*i;
        }

        System.out.println(Math.floorMod(res,1000003));


    }

}
