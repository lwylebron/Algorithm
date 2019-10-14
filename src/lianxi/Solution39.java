package lianxi;

import java.util.Scanner;

//迷宫有障碍物，且可以创越边界，求最短路径

/**
 * 4
 * ..S.
 * #..#
 * ..E#
 * #为障碍，S为起点，E为终点
 * */
public class Solution39 {


    //上下左右四个方向移动
    static int[][] temp = {{0,1},{1,0},{0,-1},{-1,0}};

    //最短步数
    static int minStep = 99999;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        in.nextLine();

        char[][] a = new char[n][n];

        int[][] book = new int[n][n];

        int x0=0;
        int y0=0;

        for(int i=0;i<n;i++){
            String s =in.nextLine();

            for(int j=0;j<n;j++){
                a[i][j] = s.charAt(j);
                if(a[i][j]=='S'){
                    x0=i;
                    y0=j;
                }
            }
        }

        book[x0][y0] = 1;

        defs(x0,y0,0,a,book,n);

        System.out.println(minStep);
    }

    public  static void defs(int x,int y, int step,char[][] a,int[][] book,int n){
        //边界条件
        if(a[x][y]=='E'){
            minStep = Math.min(minStep,step);
            return;
        }

        //循环四个方向
        for(int i=0;i<4;i++){
            //x方向偏移量
            int tx = temp[i][0];
            //y方向偏移量
            int ty = temp[i][1];

            int nx = (x+tx)%n;
            if(x+tx<0){
                nx = n-1;
            }
            int ny = (y+ty)%n;
            if(y+ty<0){
                ny = n-1;
            }

            //如果该位置没有障碍物并且也没有走过
            if((a[nx][ny]=='.'||a[nx][ny]=='E')&&book[nx][ny]==0){
                //标记为走过
                book[nx][ny]=1;
                //下一个几点搜索
                defs(nx,ny,step+1,a,book,n);
                //取消标记回到上一层
                book[nx][ny]=0;
            }
        }
    }

}
