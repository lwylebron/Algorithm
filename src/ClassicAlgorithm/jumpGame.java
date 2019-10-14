package ClassicAlgorithm;


public class jumpGame {
    /**
     * 跳跃数组步长，返回最小步数
     */
    public static int jump(int[] A){
        if(A==null||A.length==0){
            return 0;
        }

        int step=0;
        int lastCover=0;
        int maxCover=0;

        for(int i=0;i<=maxCover&&i<A.length;i++){
            if(i>lastCover){
                step++;
                lastCover = maxCover;
            }

            if(i+A[i]>maxCover){
                maxCover = i+A[i];
            }
        }

        if(maxCover<A.length-1){
            return 0;
        }

        return step;
    }


    /**
     *判断是否可以跳过去
     */
    public  static boolean jump2(int[] A){

        int len = A.length;

        if(len<=1){
            return true;
        }

        int max = A[0];

        if(max==0){
            return  false;
        }

        for(int i=1;i<len;i++){

            if(max<i){
                return false;
            }

            if(A[i]+i>max){
                max = A[i]+i;
            }


        }

        return max>=A.length;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(jump(a));
    }

}
