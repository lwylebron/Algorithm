public class tanxin {

    /**
     * 给定一个整形数组arr，代表数值不同的纸牌排成一条线，玩家A和玩家B依次拿走每张纸牌，
     * 规定玩家A先拿，但每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都是绝顶聪明。
     * 请返回最后获胜者的分数。
     */

    public static int win1(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        return Math.max(first(arr,0,arr.length-1),seconde(arr,0,arr.length-1));
    }
    //在数组arr的i到j上先拿
    public static int first(int[] arr,int i,int j){
        //如果只有一个元素，先拿就别无选择
        if (i==j){
            return arr[i];
        }
        return Math.max(arr[i]+seconde(arr,i+1,j),arr[j]+seconde(arr,i,j-1));
    }

    //在数组arr的i到j上后拿
    public static int seconde(int[] arr,int i,int j){
        //如果只剩一个元素，后那肯定什么都拿不到了
        if (i == j) {
            return 0;
        }
        return Math.min(first(arr,i+1,j),first(arr,i,j-1));
    }


    /**
     * 一排有N个位置，一个机器人在最开始停留在P位置上，
     * 如果P==0，下一分钟机器人一定向右移动到1位置，如果P=N-1，下一分钟机器人一定向左移动到N-2位置。
     * 如果P在0到N-1之间，下一分钟机器人一定会向左或向右移动，求K分钟时候，机器人到达T位置有多少种走法。
     *
     * 递归：在K分钟是T位置上只能从K-1分钟的T-1位置和K-1分钟的T+1位置上来，
     * 那么K分钟T位置上走法也就是他们二者之和了。然后在设置相应的边界就可以了。
     */

    public static int f1(int N,int P,int K,int T){
        if (N < 2 || P < 0 || K < 1 || T < 0 || P >= N || T >= N) {
            return 0;
        }
        if (K == 1) {
            return T==P?1:0;
        }
        if (T == 0) {
            return  f1(N,P,K-1,1);

        }
        if (T == N - 1) {
            return f1(N,P,K-1,T-1);
        }
        return f1(N,P,K-1,T-1)+f1(N,P,K-1,T+1);
    }

}


