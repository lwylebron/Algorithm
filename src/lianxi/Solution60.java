package lianxi;
import java.util.Scanner;
public class Solution60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        System.out.println(add(s1,s2));
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
