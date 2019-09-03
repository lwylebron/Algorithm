package lianxi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//vipkid
public class Solution36 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        String[] s1 = s.split(",");

        Set<Long> set = new HashSet();

        for(int i=0;i<s1.length;i++){
            Long a = help(s1[i]);
            for(int j=i+1;j<s1.length;j++){
                Long b = help(s1[j]);
                if(a+b==0){

                 long min = Math.min(a,b);

                 set.add(min);
                }
            }
        }

        System.out.println(set.size());
    }

    public static long help(String s){
        s = s.trim();
        if(s.charAt(0)=='-'){
            return 0-Long.parseLong(s.substring(1));
        }else{
            return Long.parseLong(s);
        }
    }
}
