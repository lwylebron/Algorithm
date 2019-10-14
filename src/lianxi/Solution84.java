package lianxi;

import java.util.Arrays;
import java.util.Scanner;

public class Solution84 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] res = new int[9];

        int[][] num = new int[n][2];

        for(int i=0;i<n;i++){
            num[i][0] = in.nextInt();
            num[i][1] = in.nextInt();
        }


        for(int i=0;i<n;i++){

            int[] arr = help(num[i][0],num[i][1]);

            for(int j=0;j<9;j++){
                System.out.print(arr[j]);
                System.out.print(" ");
            }
            System.out.println();

            res = add(res,arr);

        }

        int[] resb = new int[9];

        for(int i=0;i<9;i++){
            resb[i] = res[i];
        }

        Arrays.sort(res);

        int max = res[8];

        for(int i=0;i<9;i++){
            if(resb[i]==max){
                System.out.println(i+1);
                break;
            }
        }


    }


    public static int[] help(int a,int b){

        int[] res = new int[9];

        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);

        int[] res1 = help1(s1);
        int[] res2 = help1(s2);

        res = add(res1,res2);

        for(int i=s2.length()-1;i>=0;i--){
            int m = s2.charAt(i)-'0';
            String s3 = String.valueOf(m*a);
            int[] res3 =help1(s3);
            res = add(res,res3);
        }

        String s4 = String.valueOf(a*b);
        int[] res4 = help1(s4);
        res = add(res,res4);

        return res;
    }

    public static int[] help1(String s1){

        int[] res = new int[9];

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!='0'){
                int m = s1.charAt(i)-'0';
                if(m>0&&m<=9){
                    res[m-1]++;
                }

            }
        }

        return res;

    }

    public  static int[] add(int[] res1,int[] res2){

        int n = res1.length;

        int[] res = new int[9];

        for(int i=0;i<9;i++){

            res[i] = res1[i]+res2[i];

        }

        return res;
    }


}
