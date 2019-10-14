package ClassicAlgorithm;


/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class candyDistribute {

    public int getCandy(int[] a){

        int res = 0;

        int len = a.length;

        int[] candy = new int[len];

        for(int i=0;i<len;i++){
            candy[i] = 1;
        }

        for(int i=0;i<len-1;i++){
            if(a[i+1]>a[i]){
                candy[i+1] = candy[i]+1;
            }
        }

        for(int i=len-1;i>0;i--){
            if(a[i-1]>a[i]&&candy[i-1]<=candy[i]){
                candy[i-1] = candy[i]+1;
            }
        }

        for(int i=0;i<len;i++){
            res = res+candy[i];
        }

        return res;
    }
}
