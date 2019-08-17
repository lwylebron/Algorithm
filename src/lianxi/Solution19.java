package lianxi;

import java.util.Scanner;

/**
 * 根据二叉树的前序遍历结果，判断是否为平衡二叉树,如1，2，3，null,null,4,5 返回true
 */
public class Solution19 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        String[] s1 = s.split(",");

        int res = height(s1,0);

        if(res==-1){
            System.out.print(false);
        }else{
            System.out.print(true);
        }
    }

    static int height(String[] s,int a){

       if(a>=s.length||s[a].equals("null")){
           return 0;
       }

       int left = height(s,2*a+1);
       int right = height(s,2*a+2);

       if(left==-1||right==-1){
           return -1;
       }

       if(Math.abs(left-right)>1){
           return -1;
       }

       return Math.max(left,right)+1;

    }
}
