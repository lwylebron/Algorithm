package ClassicAlgorithm;

import java.util.Scanner;

public class Solution84 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M=  in.nextInt();
        int N = in.nextInt();

        int[] a = new int[M];

        for(int i=0;i<M;i++){
            a[i] = in.nextInt();
        }

        double sum = 0;

        for(int i=0;i<N;i++){
            sum = sum+a[i];
        }

        double max = 0;

        for(int i = N;i<M;i++){

            sum = sum + a[i] - a[i - N];
            max = Math.max(sum,max);
        }

        double d = max/N;

        String s = String.format("%.3f", d);

        System.out.println(s);
    }
}
