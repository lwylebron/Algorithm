package lianxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution86 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        List<Integer> list=  new ArrayList<>();

        String[] a = s.trim().split(",");

        for(int i=0;i<a.length;i++){
            list.add(Integer.parseInt(a[i]));
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1)-list.get(0));

    }
}
