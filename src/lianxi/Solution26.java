package lianxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution26 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int n = 0;

        List<Character> list = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if((a>='A'&&a<='Z')||(a>='a'&&a<='z')){
                list.add(a);
            }
        }

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();

        int count=0;

        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if((a>='A'&&a<='Z')||(a>='a'&&a<='z')){
               sb.append(list.get(count++));
            }else{
                sb.append(a);
            }
        }

        System.out.print(sb.toString());

    }
}
