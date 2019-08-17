package ClassicAlgorithm;


import java.util.*;

/**
 * 用户1和用户2之间的距离不超过d则认为他们之间相互关联，
 * 并且关联具有传递性，用户1与用户2关联，用户2与用户3关联,则它们相互关联
 * 输入：第一行设定欧式距离d，第二行给出用户数N，之后的N行表示第0个用户到N-1个用户的地理位置横纵坐标
 * 输出：输出n行，每行为一个用户群
 */
public class AssociatedUser {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int d = in.nextInt();

        int N = in.nextInt();

        int[][] pos = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                pos[i][j] = in.nextInt();
            }
        }


    }


    public static boolean underD(int x1,int y1,int x2,int y2){

        if(((x2-x1)^2+(y2-y1)^2)>4){
            return false;
        }

        return true;
    }
}
