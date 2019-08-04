package lianxi;

import java.util.*;

class Solution {

    public static List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        help(s,0,new ArrayList<String>(),res);

        return res;


    }

    public static void help(String s,int i,List<String> list,List<List<String>> res){

        if(i==s.length()){

            res.add(new ArrayList<String>(list));

        }else{

            for(int m=i;m<s.length();m++){

                if(isPalindrome(s,i,m)){

                    list.add(s.substring(i,m+1));

                    help(s,m+1,list,res);

                    list.remove(list.size()-1);
                }
            }

        }

    }

    public  static boolean isPalindrome(String s,int i,int j){

        while(i<j){

            if (s.charAt(i++)!=s.charAt(j--)){

                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String str = "absddw";

        List<List<String>> list = partition(str);

        String str1 = str.substring(0, 2);
        String str2 = str.substring(2);

        System.out.println(str1+":"+str2);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        Set<List<Integer>> set = new HashSet<>();
        set.add(list1);
        set.add(list2);

        set.add(list1);
        System.out.println(set.size());

    }
}