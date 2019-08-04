package ClassicAlgorithm;

public class GCD_LCM {

    /**
     *   最大公约数和最小公倍数问题
     *  题目链接:  http://acm.hdu.edu.cn/showproblem.php?pid=1019
     */

    //非递归最大共约数
    static int gcdIter(int a,int b){
        int r;
        while(a!=0){
            r=b%a;
            b=a;
            a=r;
        }
        return b;
    }

    static int gcd(int a,int b){
        return b==0?a:gcd(a,b%a);
    }

    //最小共倍数
    static int lcm(int a,int b){
        return a*b/(gcd(a,b));
    }

    //n个数的最小大共约数
    static int ngcd(int[] arr,int n){
        if(n==1){
            return arr[0];
        }

        return gcd(arr[n-1],ngcd(arr,n-1));
    }

    //n个数的最大公约数
    static int nlcm(int[] arr,int n){
        if(n==1){
            return arr[0];
        }

        return lcm(arr[n-1],nlcm(arr,n-1));
    }


    public static void main(String[] args) {

    }
}
