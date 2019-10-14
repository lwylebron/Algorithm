package lianxi;

import java.util.Scanner;

public class Solution48 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        int[] res = new int[n];

        res[n-1] = 0;

        for(int i=n-2;i>=0;i--){
            int min = 0;
            for(int j=i+1;j<n;j++){
                if(a[j]>min&&a[j]<=a[i]){
                    res[i]++;
                    min = a[j];
                }else{
                    break;
                }
            }
        }

        int index=0;
        int max = 0;

        for(int i=0;i<n;i++){
            if(res[i]>max){
                index = i;
                max = res[i];
            }
        }

        System.out.println(a[index]);

    }
}
