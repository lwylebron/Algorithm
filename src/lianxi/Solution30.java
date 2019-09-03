package lianxi;



import java.util.Arrays;
import java.util.Scanner;

//京东第一题
public class Solution30 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long[] a = new long[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextLong();
        }

        long[] m = Arrays.copyOf(a,a.length);

        Arrays.sort(m);

        int count=0;
        int j=0;
        for(int i=0;i<n;i++){
            if(help(j,i,a,m)){
                count++;
                j=i+1;
            }
        }

        System.out.println(count);


    }

    static boolean help(int i,int j,long[] s1,long[] s2){
        long m = s1[j]^s2[j];
        for(int k=i;k<j;k++){
            m^= s1[k]^(s2[k]);
        }
        return m==0;
    }
}
