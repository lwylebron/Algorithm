package lianxi;

import java.util.Scanner;

public class Solution23 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long m = in.nextLong();

        int[] x = new int[n];
        int[] y = new int[n];

        for(int i=0;i<n;i++){

            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        long count = 0;
        int weight = 0;

        for(int i=0;i<n;i++){

            if(m<0){
                break;
            }

            int num = x[i];
            int w = y[i];

            for(int j=0;j<num;j++){
                m = m-w;
                if(m>=0){
                    count++;
                }else{
                    m = m+w;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
