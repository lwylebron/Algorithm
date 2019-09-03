package lianxi;


import java.util.Scanner;

public class Solution27 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int n = s.length();

        String sp1 = in.nextLine();

        int n1 = sp1.length();

        String sp2 = in.nextLine();

        int n2 = sp2.length();

        StringBuffer sb = new StringBuffer();

        sb.append(s.charAt(0));

        for(int i=1;i<s.length();i++){

            int j=i;
            int count=0;
            while(count<n1&&j<s.length()&&s.charAt(j)==sp1.charAt(count)){
                j++;
                count++;
            }

            if(count==n1){

                sb.append(" ");
                i=i+n1;

            }else{
                sb.append(s.charAt(i));
            }
        }


        StringBuffer sb1 = new StringBuffer();

        sb1.append(sb.charAt(0));

        for(int i=1;i<sb.length();i++){

            int j=i;
            int count=0;
            while(count<n2&&j<sb.length()&&sb.charAt(j)==sp2.charAt(count)){
                j++;
                count++;
            }

            if(count==n2){
                sb1.append("->");
                i=i+n2;
            }else{
                sb1.append(sb.charAt(i));
            }
        }


        System.out.print(sb1.toString());
    }
}
