package lianxi;

import java.util.Scanner;

public class Solution22 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();

       String s = in.nextLine();

       char[] c = s.toCharArray();

       int num = help(c);

       String add = s.substring(num);

       String res = new String(s);

       for(int i=1;i<k;i++){
           res = res+add;
       }

       System.out.println(res);


    }

    //寻找相同的前后缀
    static int help(char[] t){
        int n = t.length;
        for(int i=1;i<n;i++){
            if(t[i]==t[0]){
                int j=i+1;
                int w = 1;
                for(;j<n;j++){
                    if(t[j]==t[w]){
                        w++;
                    }else{
                        break;
                    }
                }
                if(j==n){
                    return n-i;
                }
            }
        }
       return 0;
    }
}
