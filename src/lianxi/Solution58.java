package lianxi;

import java.util.Scanner;

public class Solution58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        if(a<0||b<0){
            System.out.println(a+b);
        }else {
            String str1 = Long.toString(a);
            String str2 = Long.toString(b);

            System.out.println(add(str1,str2));
        }
    }
    public static String add(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int m = Math.max(s1.length,s2.length);
        int[] a = new int[m+1];
        int[] b = new int[m+1];
        for(int i=0;i<s1.length;i++){
            a[i] = s1[m-i-1]-'0';
        }
        for(int i=0;i<s2.length;i++){
            b[i] = s2[m-i-1]-'0';
        }
        for(int i=0;i<m;i++){
            int temp = a[i]+b[i];
            if(temp>=10){
                a[i]=temp%10;
                a[i+1]+=temp/10;
            }else{
                a[i]=temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(a[m]!=0){
            sb.append(a[m]);
        }
        for(int i=m-1;i>=0;i--){
            sb.append(a[i]);
        }

        return sb.toString();
    }
}
