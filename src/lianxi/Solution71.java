package lianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution71 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<a.length;i++){
            a[i] = in.nextInt();
        }

        int s = in.nextInt();


        List<Integer> list = new ArrayList<>();

        //第一个基站的位置
        list.add(s+a[0]);

        for(int i=1;i<n;i++){
            int d = list.get(list.size()-1);
            if(a[i]<=d){
                continue;
            }else{
                list.add(a[i]+s);
            }

        }
        System.out.println(list.size());
    }

}
