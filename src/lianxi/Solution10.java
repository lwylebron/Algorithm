package lianxi;

public class Solution10 {

    public static void main(String[] args) {

    }

    /**
     * 面值1，5，10.。。组成n元的方法个数
     *
     * 采用深度优先搜索
     *
     * 将所有面值的钱放到一个数组中，从小到大排序。
     *
     * @param num1
     * @param num2
     * @return
     */
    private static String process(String num1, String num2){

        int[] a  = new int[6];

        String[] b  = num1.split(" ");

        int count  =0;
        for(int i=0;i<6;i++){
            a[i] = Integer.parseInt(b[i]);
            count = count+a[i];
        }

        int c = Integer.parseInt(num2);

        return String.valueOf(-1);


    }


}
