package lianxi;

import java.util.*;

public class Solution51 {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        String s0 = "";

        help(s, s0);

        List<String> list =new ArrayList<>();



        for (String res : set) {
            list.add(res);
        }

        Collections.sort(list);

        for(String res:list){
            System.out.println(res);
        }


    }


    public static void help(String s, String s1) {

        if (s.length() == 0) {
            set.add(s1);
            return;
        }

        if (s.length() == 1) {
            s1 = s1 + get(Integer.parseInt(s));
            set.add(s1);
            return;
        }

        String str1 = s.substring(0, 1);
        String str2 = s.substring(0, 2);

        int a = Integer.parseInt(str1);



        if (a <= 26) {
            help(s.substring(1), s1 + get(a));
        }

        int b = Integer.parseInt(str2);

        if (b <= 26) {
            help(s.substring(2), s1 + get(b));
        }

    }
    public static String get(int n) {
        if (n == 1) {
            return "A";
        }
        if (n == 2) {
            return "B";
        }
        if (n == 3) {
            return "C";
        }

        if (n == 4) {
            return "D";
        }
        if (n == 5) {
            return "E";
        }
        if (n == 6) {
            return "F";
        }
        if (n == 7) {
            return "G";
        }
        if (n == 8) {
            return "H";
        }
        if (n == 9) {
            return "I";
        }
        if (n == 10) {
            return "J";
        }
        if (n == 11) {
            return "K";
        }
        if (n == 12) {
            return "L";
        }
        if (n == 13) {
            return "M";
        }
        if (n == 14) {
            return "N";
        }
        if (n == 15) {
            return "O";
        }
        if (n == 16) {
            return "P";
        }
        if (n == 17) {
            return "Q";
        }
        if (n == 18) {
            return "R";
        }
        if (n == 19) {
            return "S";
        }
        if (n == 20) {
            return "T";
        }
        if (n == 21) {
            return "U";
        }
        if (n == 22) {
            return "V";
        }
        if (n == 23) {
            return "W";
        }
        if (n == 24) {
            return "X";
        }
        if (n == 25) {
            return "Y";
        }
        if (n == 26) {
            return "Z";
        }
        return null;
    }

}




