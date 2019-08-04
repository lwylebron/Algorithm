package lianxi;

import java.util.Stack;

public class Solution8 {
    public static void main(String[] args) {

        String s = "aabbcc(bb)cc3a";  //用栈的时候，考虑好什么时候判断，本题中遇到‘（’和数字的时候判断，其他入栈。
        System.out.println(help(s));

    }

    public static String help(String str) {

        if (str == null || str.length() == 0) {
            return null;
        }

        Stack<Character> stack = new Stack<>();

        StringBuffer sb = new StringBuffer();

        String num = "";

        int i = 1;

        stack.push(str.charAt(0));

        while (i < str.length()) {

            if ((str.charAt(i)) >= '0' && (str.charAt(i)) <= '9') {
                while (i < str.length() && (str.charAt(i)) >= '0' && (str.charAt(i)) <= '9') {
                    num = num + str.charAt(i);
                    i++;
                }

                int w = 0;
                if (num.charAt(0) != '0') {
                    w = Integer.parseInt(num);
                }

                if (!stack.isEmpty() && stack.peek() != ')') {
                    char c = stack.pop();
                    for (int m = 0; m < w; m++) {
                        sb.append(c);
                    }
                }
                StringBuffer sb1 = new StringBuffer();
                if (!stack.isEmpty() && stack.peek() == ')') {
                    stack.pop();
                    while (!stack.isEmpty()) {
                        sb1.append(stack.pop());
                    }
                    sb1.reverse();
                    for (int m = 0; m < w; m++) {
                        sb.append(sb1.toString());
                    }
                }
                num = "";

            } else if (str.charAt(i) == '(') {
                StringBuffer sb1 = new StringBuffer();
                while (!stack.isEmpty()) {
                    sb1.append(stack.pop());
                }
                sb.append(sb1.reverse().toString());
                i++;
            } else {
                stack.push(str.charAt(i));
                i++;
            }

        }

        StringBuffer sb1 = new StringBuffer();

        while (!stack.isEmpty()) {
            sb1.append(stack.pop());
        }

        return sb.toString() + sb1.reverse().toString();
    }

}
