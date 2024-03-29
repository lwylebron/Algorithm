package ClassicAlgorithm;

public class connectRegionOfArray {
    /**
     * 给定一个矩阵，寻找连通域个数：前后左右相同为连通
     * ex：
     * 0 1 0 1
     * 0 1 1 1
     * 0 0 1 0
     * 0 1 0 0
     * 输出2
     */

    public static int getCount(int[][] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    result++;
                    erase(A, i, j);
                }
            }
        }
        return result;
    }

    public static void erase(int[][] A, int i, int j) {
        A[i][j] = 0;
        while (i - 1 >= 0 && A[i - 1][j] == 1) {
            erase(A, i - 1, j);
        }
        while (i + 1 < A.length && A[i + 1][j] == 1) {
            erase(A, i + 1, j);
        }
        while (j - 1 >= 0 && A[i][j - 1] == 1) {
            erase(A, i, j - 1);
        }
        while (j + 1 < A[0].length && A[i][j + 1] == 1) {
            erase(A, i, j + 1);
        }

    }
}
