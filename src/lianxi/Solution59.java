package lianxi;

import java.util.Scanner;

public class Solution59 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        String s = in.nextLine().trim();

        StringBuffer sb = new StringBuffer();

        int i=0;
        while(i<s.length()){

            int count = 1;

            for(int j=i+1;j<s.length();j++){
                if(s.charAt(j)==s.charAt(i)){
                    count++;
                }else{
                    break;
                }
            }
            sb.append(count);
            sb.append(s.charAt(i));

            i = i+count;

        }

        System.out.println(sb.toString());
    }
}
