package ClassicAlgorithm;

import java.util.HashMap;
import java.util.Map;

//前序遍历何中序遍历得到二叉树
public class ConstructTreeFromPandO {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0||inorder.length==0){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

    }

    public static TreeNode help(int[] preorder,int a,int b,int[] inorder,int c,int d,Map<Integer,Integer> map){

        if(a>b||c>d){
            return null;
        }

        TreeNode root = new TreeNode(preorder[a]);

        int i = map.get(preorder[a]);

        TreeNode left = help(preorder,a+1,a+i-c,inorder,c,i-1,map);
        TreeNode right = help(preorder,a+i-c+1,b,inorder,i+1,d,map);

        root.left = left;
        root.right = right;

        return root;
    }

}
