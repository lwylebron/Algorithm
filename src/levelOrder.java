import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    /**
     * 按层打印树
     * 使用双端队列
     */
    public static void  levelOrder(TreeNode root){

        if(root==null){
            System.out.print("");
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root); //offer添加元素并且返回true,在尾部添加;
        int cur=0;//保存上一层节点的数量

        while(!queue.isEmpty()){
            cur = queue.size();
            for(int i=0;i<cur;i++){
                TreeNode peek = queue.poll();
                System.out.print(peek.val+" ");  //poll移除并返回头部，peek返回头部
                if(peek.left!=null){
                    queue.offer(peek.left);
                }
                if(peek.right!=null){
                    queue.offer(peek.right);
                }

            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node4.left=node8;
        node4.right=node9;

        levelOrder(node1);

    }
}
