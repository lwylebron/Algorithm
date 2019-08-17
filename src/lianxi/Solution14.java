package lianxi;

import java.util.Scanner;

//题目要求范围大，用double来表示
public class Solution14 {

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        float[] a = new float[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                float min = Math.min(a[i],a[j]);
                float max = Math.max(a[i],a[j]);
                if(min>=(0.9*max)){
                    count++;
                }
            }
        }

        System.out.print(count);

    }
}
