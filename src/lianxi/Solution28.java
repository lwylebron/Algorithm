package lianxi;

import java.util.Scanner;

public class Solution28 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int n = s.length();

        String sp1 = in.nextLine();

        int n1 = sp1.length();

        String sp2 = in.nextLine();

        int n2 = sp2.length();

        s = s.replaceAll(sp1," ");
        s = s.replaceAll(sp2,"->");

        System.out.print(s);
    }
}
