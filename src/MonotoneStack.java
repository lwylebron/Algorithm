import java.util.Stack;

public class MonotoneStack {
    /**
     *单调栈，快速寻找一个数组中每一个元素　左右两边离它arr[i]最近的比它大/小的数
     */

    public static void main(String[] args) {
        int[] arr = {3,4,5,2,1,7};

        int n = arr.length;

        //找出左边第一个比arr[i]大的
        int[] LL  = new int[n];
        Stack<Integer> stack = new Stack();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&(arr[i]>arr[stack.peek()])){
                int temp = stack.pop();
                if(stack.isEmpty()){   //左边没有比arr[i]大的数
                    LL[temp] = -1;
                }else{
                    LL[temp]  =stack.peek();
                }
            }

            stack.push(i);  //入栈的下标
        }

        //如果栈不为空，处理剩下的
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(stack.isEmpty()){
                LL[temp]=-1;
            }else{
                LL[temp] = stack.peek();
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(LL[i]+" "); //打印的是下表位置
        }

        System.out.println();

        stack  = new Stack();

        int[] RR = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[i]>arr[stack.peek()]){
                int temp = stack.pop();
                if(stack.isEmpty()){
                    RR[temp] = -1;
                }else{
                    RR[temp] = stack.peek();
                }
            }

            stack.push(i);

        }

        while(!stack.isEmpty()){

            int temp = stack.pop();

            if(stack.isEmpty()){
                RR[temp] = -1;
            }else{
                RR[temp] = stack.peek();
            }
        }

            for(int i=0;i<n;i++){
                System.out.print(RR[i]+" ");
            }

        }

    }




