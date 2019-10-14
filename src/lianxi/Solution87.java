package lianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution87 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(isAnagramOfPalindrome2(in.nextLine()));
    }

    public  static int isAnagramOfPalindrome2(String S) {
        int n = S.length();
        List<Character> v = new ArrayList<>(26);
        for(int i = 0; i < n; i++) {
            Character c = S.charAt(i);
            if(v.contains(c)) {//已经包含就移除，意思是出现次数为偶数的就不统计
                v.remove(c);
            } else {
                v.add(c);
            }
        }
        if(n % 2 == 0 && v.size() == 0) {//S的长度的偶数，那么各个字母的出现次数必须都是偶数
            return 1;
        } else if(n % 2 != 0 && v.size() == 1) {//S的长度是奇数，那么可以有一个字母的出现次数是奇数
            return 1;
        } else {
            return 0;
        }
    }

}
