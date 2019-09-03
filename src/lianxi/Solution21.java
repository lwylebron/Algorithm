package lianxi;

import java.util.Arrays;
        import java.util.Scanner;

public class Solution21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i]  = in.nextInt();
        }

        Arrays.sort(a);

        int count = 0;

        int sum = 0;

        for(int i=0;i<n;i++){
            sum = sum+a[i];
            if(sum>s){
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}
