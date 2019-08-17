package lianxi;

import java.util.Scanner;

public class Solution18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int count = 1;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length()&&s.charAt(i+1)==s.charAt(i)){
                count++;
            }else{
                if(i==s.length()-1){
                    System.out.print(s.charAt(i)+"_"+count);
                }else{
                    System.out.print(s.charAt(i)+"_"+count+"_");
                }

                count=1;
            }
        }
    }
}
