package lianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//携程
public class Solution42 {

    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String resolve(String expr) {

        if(expr==null||expr.length()==0){
            return "";
        }
        //记录括号的个数
        int count = 0;

        StringBuffer sb = new StringBuffer();

        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack1  = new Stack<>();

        for(int i=0;i<expr.length();i++){

            char c = expr.charAt(i);

            if(c=='('){
                count++;
                stack1.push(i);
            }else if(c==')'){
                count--;
                int j = stack1.pop();
                List<Character> list =  new ArrayList<>();
                for(int m=i-1;m>j;m--){
                    list.add(stack.pop());
                }


                if(count==0){
                   for(int p=0;p<list.size();p++){
                       sb.append(list.get(p));
                   }
                }else{
                    for(int n=0;n<list.size();n++){
                        stack.push(list.get(n));
                    }
                }
            }else{
                if(count==0){
                    sb.append(c);
                }else{
                    stack.push(c);
                }
            }

        }

        if(count!=0){
            return "";
        }

        return sb.toString();


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
