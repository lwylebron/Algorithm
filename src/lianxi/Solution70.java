package lianxi;

import java.util.Scanner;

public class Solution70 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int max = 0;

        for(int i=1;i<s.length();i++){
            int m=0;int j=i;

            while(m<s.length()&&j<s.length()&&s.charAt(m)==s.charAt(j)){
                m++;
                j++;
            }

            max = Math.max(max,m);
        }

        String s1 = s.substring(max);

        System.out.println(s+s1);
    }
}
