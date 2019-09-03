package lianxi;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//拼多多第三题
public class Solution35 {

    static double res = 0;
    static int num = 1;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        

        Arrays.sort(a);

        //一共多少种情况

        for(int i=0;i<n;i++){
            num = num*a[i];
        }

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        help(lists,a,list,0);

        System.out.println(lists.size());

        for(List list1:lists){
            for(int i=0;i<list1.size();i++){
                System.out.print(list1.get(i));
            }
            System.out.println();
        }


    }



    public static void help(List<List<Integer>> lists ,int[] a,List<Integer> list,int n){

        if(n>=a.length){
            lists.add(new ArrayList<>(list));
            return;
        }else{
            for(int i=1;i<=a[n];i++){
                list.add(i);
                help(lists,a,list,n+1);
                list.remove(list.size()-1);
            }
        }





    }

}
