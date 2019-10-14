package lianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution79 {

    public static void main(String[] args) {

        Scanner in  = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());

        List<String> list = new ArrayList<>();

        for(int i=0;i<t;i++){
            int a = Integer.parseInt(in.nextLine());
            String s = in.nextLine().trim();
            list.add(help(s,a));
        }

        for(int i=0;i<t;i++){
            System.out.println(list.get(i));
        }
    }

    public static String help(String s,int n){

        if(n<11){
            return "NO";
        }

        if(n==11){
            if(s.charAt(0)!='8'){
                return "NO";
            }
        }

        int i=0;

        while(n>11){
            if(s.charAt(i)=='8'){
                return "YES";
            }else{
                i++;
                n--;
            }
        }

        if(n==11&&s.charAt(i)!='8'){
            return "NO";
        }

        return "YES";
    }

}
