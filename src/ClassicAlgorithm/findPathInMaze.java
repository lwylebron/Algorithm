package ClassicAlgorithm;

import java.util.Scanner;

/**
 * 使用深度优先搜索解决迷宫问题
 * 如5*5的迷宫
 * 00101
 * 00001
 * 00100
 * 01001
 * 00001
 * 0代表可行，1代表障碍，问从初始位置（0，0）到（3，2）最少需要走多少步
 */
public class findPathInMaze {
    //人质所在迷宫位置
    static int fx,fy;
    //迷宫为5*5
    static int n = 5;
    //上下左右四个方向移动
    static int[][] temp = {{0,1},{1,0},{0,-1},{-1,0}};
    //迷宫数组
    static int[][] squera = new int[n][n];

    //标记数组，走过就标记为1
    static int[][] book = new int[n][n];

    //最短步数
    static int minStep = 99999;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("请输入迷宫数组5*5：");

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                squera[i][j] = in.nextInt();
            }
        }

        System.out.println("请输入人质所在位置：");

        fx = in.nextInt();
        fy = in.nextInt();

        book[0][0] = 1;

        defs(0,0,0);

        System.out.println(minStep);
    }

    public  static void defs(int x,int y, int step){
        //边界条件，到达人质所在位置
        if(x==fx&&y==fy){
            minStep = Math.min(minStep,step);
            return;
        }

        //循环四个方向
        for(int i=0;i<4;i++){
            //x方向偏移量
            int tx = temp[i][0];
            //y方向偏移量
            int ty = temp[i][1];

            if(x+tx>=n||x+tx<0){
                continue;
            }

            if(y+ty>=n||y+ty<0){
                continue;
            }

            //如果该位置没有障碍物并且也没有走过
            if(squera[x+tx][y+ty]==0&&book[x+tx][y+ty]==0){
                //标记为走过
                book[x+tx][y+ty]=1;
                //下一个几点搜索
                defs(x+tx,y+ty,step+1);
                //取消标记回到上一层
                book[x+tx][y+ty]=0;
            }
        }
    }



}
