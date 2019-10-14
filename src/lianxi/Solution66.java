package lianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//快手
public class Solution66 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        List<Character> list = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }

        String[] s1 = s.split(".");

        if(list.contains(':')){
            System.out.println("IPv6");
        }else{
            int i=0;
            for(;i<s1.length;i++){
                int a = Integer.parseInt(s1[i]);
                if(a<0||a>255){
                    System.out.println("IPv4");
                }
            }
            if(i==s1.length){
                System.out.println("Neither");
            }
        }
    }
}
