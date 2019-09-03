package lianxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//拼多多寻梦第一题
public class Solution34 {

    public static void main(String[] args) {

        Scanner in= new Scanner(System.in);

        String str  = in.nextLine();

        List<Integer> list = new ArrayList<>();

        int start = 0;

        int n=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==','){
                String s1 = str.substring(start,i);
                list.add(Integer.parseInt(s1));
                start = i+1;
            }
            if(str.charAt(i)==';'){
                list.add(Integer.parseInt(str.substring(start,i)));
                n = Integer.parseInt(str.substring(i+1));
                break;
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            if((list.get(i))%2==0){
                list1.add(list.get(i));
            }else{
                list2.add(list.get(i));
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);


        if(list1.size()>=n){
            for(int i=0;i<n;i++){
                if(i==n-1){
                    System.out.print(list1.get(list1.size()-i-1));
                }else{
                    System.out.print(list1.get(list1.size()-i-1)+",");
                }
            }
        }else{
            for(int i=0;i<list1.size();i++){
                System.out.print(list1.get(list1.size()-i-1)+",");
            }
            int count = n-list1.size();
            for(int i=0;i<count;i++){
                if(i==count-1){
                    System.out.print(list2.get(list2.size()-i-1));
                }else{
                    System.out.print(list2.get(list2.size()-i-1)+",");
                }
            }
        }

    }
}
