import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 素数筛选
 */
public class PrimeSieve {

    static List<Integer> prime(boolean[] isPrime,int max){
        List<Integer> prime = new ArrayList<>();

        Arrays.fill(isPrime,true);

        isPrime[0]=isPrime[1]=false;  //0和1不是素数；

        for(int i=2;i<=max;i++){
            if(isPrime[i]){
                prime.add(i);
                for(int j=i*2;j<=max;j=j+i){
                    isPrime[j]=false;
                }
            }
        }

        return prime;
    }

    //判断是否是回文数字
    static boolean isParlindrome(int num){
        int oldNum = num;
        int newNum  = 0;

        while(num>0){
            newNum = newNum*10+num/10;
            num = num/10;
        }

        return oldNum==newNum;
    }


}
