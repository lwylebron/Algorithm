package lianxi;

import java.util.Scanner;

//vipkid
public class Solution37 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();

        int count =  0;

        while(a!=0){
            count++;
            a = a&(a-1);

        }

        System.out.println(count);
    }
}
