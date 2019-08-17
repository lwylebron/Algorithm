package ClassicAlgorithm;

import java.util.Stack;

/**
 * 给定一个数组，数组元素大小代表矩形高度，每个元素处的矩形宽度为1，求此分布图中最大矩形面积
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;

        Stack<Integer> stack = new Stack<>();

        int max = 0;

        for(int i=0;i<=len;i++){

            int h  = i == len?0:heights[i];

            if(stack.isEmpty() || h>=heights[stack.peek()]){

                stack.push(i);

            }else{

                int res  = stack.pop();

                max = Math.max(max,heights[res]*(stack.isEmpty()?i:i-1-stack.peek()));
                i--;
            }

        }

        return max;
    }
}
