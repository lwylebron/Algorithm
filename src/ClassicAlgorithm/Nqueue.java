package ClassicAlgorithm;

public class Nqueue {

    /**
     * 将N个皇后放到N x N 的棋盘上，使她们之间不能互相攻击
     */
    public static void Nqueue(int n){

        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.'; //将棋盘全部置为‘.’;
            }
        }

        defs(board,0);

    }

    static void defs(char[][] board,int cols){       //按列从左至右递归

        if(cols==board.length){             //满足边界条件打印棋盘
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int i=0;i<board.length;i++){   //按行遍历
            if(isVidate(board,i,cols)){
                board[i][cols]='Q';
                defs(board,cols+1);  //递归，向右推进
                board[i][cols]='.';
            }
        }


    }

    static boolean isVidate(char[][] board,int x,int y){

        for(int i=0;i<board.length;i++){

            for(int j=0;j<y;j++){

                if(board[i][j]=='Q'&&(i==x||i+j==x+y||y+i==x+j)){    //后面一定要加括号
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Nqueue(4);
    }

}
