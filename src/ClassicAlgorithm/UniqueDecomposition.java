package ClassicAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UniqueDecomposition {
    /**
     * 唯一分解定理
     * 任何一个大于1的自然数 N，如果N不为质数，那么N可以唯一分解成有限个质数的乘积
     */

    //筛选出0-n之间的素数
    static List<Integer> sieve(int n){
        List<Integer> prime = new ArrayList<>();

        boolean[] isPrime = new boolean[n+1];

        Arrays.fill(isPrime,true);

        isPrime[0]=isPrime[1]=false;  //0和1不是素数；

        for(int i=2;i<=n;i++){
            if(isPrime[i]) {
                prime.add(i);
                for (int j = i * 2; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        return prime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        List<Integer> prime = sieve(n);

        List<Integer> res  = new ArrayList<>();

        for(int i=0;i<prime.size();i++){
            int a = prime.get(i);
            while(n%a==0){
                res.add(a);
                n=n/a;
            }
        }

        for(int i=0;i<prime.size();i++){
            System.out.print(prime.get(i)+" ");
        }

        System.out.println();

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    /**
     * 约数枚举
     * 把一个数的约数全部列举出来
     */

    static List<Integer> yueshuNumEnum(int n){
        List<Integer> res = new ArrayList<>();

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                res.add(i);
                if(i!=n/i){
                    res.add(n/i);
                }
            }
        }
        return res;
    }


}
