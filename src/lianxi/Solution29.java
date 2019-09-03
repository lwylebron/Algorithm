package lianxi;

import java.util.Scanner;

public class Solution29 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(i==0){
                    System.out.print('o');
                }else if(i==1){
                    if(j==0||j==n-1){
                        System.out.print('o');
                    }else{
                        System.out.println('k');
                    }
                }else{
                    if(j==0||j==n-1){
                        System.out.print('o');
                    }else if(j==1||j==n-2){
                        System.out.print('k');
                    }else{
                        int m = i-2;

                    }
                }

                System.out.println();

            }
        }
    }
}
