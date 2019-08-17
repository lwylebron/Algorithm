package lianxi;

import java.util.Scanner;

public class Solution17 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();

        String[] str = str1.substring(1,str1.length()-1).split(",");

        int[] a = new int[str.length];

        for(int i=0;i<str.length;i++){
            a[i] = Integer.parseInt(str[i]);
        }

        System.out.print(findIndex(a,0,a.length-1,19));
    }

    public static int findIndex(int[] a,int start,int end,int aim){

        if(start>end){
            return -1;
        }

        int mid = start+(end-start)/2;

        if(a[mid]==aim){
            return mid;
        }

        if(findIndex(a,mid+1,end,aim)>=0){
            return findIndex(a,mid+1,end,aim);
        }
        if(findIndex(a,start,mid-1,aim)>=0){
            return findIndex(a,start,mid-1,aim);
        }

        return -1;

    }
}
