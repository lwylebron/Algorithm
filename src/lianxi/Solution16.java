package lianxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution16 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        String str = in.nextLine();

        int n = str.length();

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                list.add(str.charAt(i)-'0');
            }
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}
