package ClassicAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class QuickPow {
    /**
     * 乘法快速幂
     * (a*b) mod c == ( (a mod c) * (b mod c) ) mod c
     */

    //递归计算（a^n）%mod
    static long powMod(long a,long n,long mod){
        if(n==0){
            return 1;
        }

        long half = powMod(a,n>>1,mod);

        long res = half*half%mod;

        if((n&1)!=0){                //n为奇数时，开始算的实际是powMod(a,n-1,mod),故再做一次计算
            res = res*a%mod;
        }

        return res;


    }

    //非递归
    static long powMod2(long a,long n,long mod){
        long res =1;
        while(n>0){
            if((n&1)!=0){
                res = res*a%mod;
            }
            a = a*a%mod;
            n>>=1;
        }

        return res;
    }

    /**
     * 快速乘法
     * @param
     */

    static long quickMul(long a,long b){
        long ans = 0;

        while(b>0){   //当b不为0时
            if((b&1)!=0){
                ans=ans+a;
            }
            b>>=1;
            a<<=1;

        }
        return ans;
    }

    //快速幂

    static long quickpow(long a,long b){
        if(a==0){
            return 0;
        }
        if(b==0){
            return 1;
        }
        long ans = 1;

        while(b>0){
            if((b&1)!=0){
              ans = ans*a;
            }
            b>>=1;
            a=a*a;
        }

        return ans;
    }

    public static void main(String[] args) {



        int a = 4;
        int b = a&1;  //判断最低位是否为1

        System.out.println(b);

        Stack<List<Integer>> stack = new Stack<>();

        List<Integer> list = new LinkedList<>();

        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(2);
        ((LinkedList<Integer>) list).addFirst(3);

        System.out.println(list.get(0));

        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);

        List<Integer> list2 = list1;  //直接赋值,改变list2将改变list1.

        list2.add(3);

        System.out.println(list1.get(2));
    }
}
