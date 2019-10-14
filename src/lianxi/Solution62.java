package lianxi;

import java.util.Scanner;

public class Solution62 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.nextLine().trim();

        String b = in.nextLine().trim();

        get(a,b);
    }

    public static void get(String in,String post){

        int len1 = in.length();

        if(len1==0){
            return;
        }

        char a  = post.charAt(post.length()-1);

        System.out.print(a);

        int index = 0;

        for(int i=0;i<len1;i++){
            if(in.charAt(i)==a){
                index = i;
            }
        }
        String in1 = in.substring(0,index);

        String in2 = in.substring(index+1);

        String post1 = post.substring(0,index);

        String post2 = post.substring(index,post.length()-1);

        get(in1,post1);
        get(in2,post2);

    }
}
