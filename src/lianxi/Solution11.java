package lianxi;


/**
 * 源程序面试，求一个整数的平方根，保证其精度在0.01以下。
 */
public class Solution11 {

    public static void main(String[] args) {
        System.out.println(getA(8));
    }

    public static float getA(int a){

        float i=0;

        float j = a;

        while(i<j){

            float mid = i+(j-i)/2;

            if(((0<mid*mid-a)&&mid*mid-a<0.01)||((0<a-mid*mid)&&a-mid*mid<0.01)){
                return mid;
            }

            if(mid*mid>a){
                j=mid;
            }else{
                i=mid;
            }
        }
        return 0;
    }
}


