package lianxi;

import java.util.Scanner;

public class Solution63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int[] res = new int[b];

        int i=0;
        int j=0;

        while(a>0){
            if(i==b) {
                i=0;
                j++;
            }
            if(a>=b*j+i+1){
                res[i] = res[i]+b*j+i+1;
                a=a-(b*j+i+1);
            }else{
                res[i] = res[i]+a;
                break;
            }

            i++;

        }

        System.out.print("[");
        for(int m=0;m<b;m++){
            if(m==b-1){
                System.out.print(res[m]);
            }else{
                System.out.print(res[m]+",");
            }

        }
        System.out.print("]");
    }
}
