package lianxi;

import java.util.Scanner;

public class Solution72 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        String res = help(n);

        int len = res.length();

        char aim = 0;

        for(int i=len-1;i>=0;i--){
            if(res.charAt(i)!='0'){
                aim = res.charAt(i);
                break;
            }
        }

        System.out.println(aim);


    }

    static String help(int n) {
        int[] res = new int[100000000];
        int digit = 1;
        res[0] = 1;
        for (int i = 2; i <= n; i++) {
            int carry = 0;
            for (int j = 0; j < digit; j++) {
                int temp = res[j] * i + carry; //每一位的运算结果
                res[j] = temp % 10;   //将最低位保留在原位置
                carry = temp / 10;   //计算进位, 等下这个进位会累加到j+1
            }
            while (carry != 0) {
                res[digit] = carry % 10;
                carry /= 10;
                digit++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digit - 1; i >= 0; i--) sb.append( (char)(res[i] + '0'));
        return sb.toString();
    }
}
