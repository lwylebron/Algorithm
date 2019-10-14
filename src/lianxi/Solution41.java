package lianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//携程
public class Solution41 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {

          List<Integer> list = new ArrayList<>();

          while(head!=null){
              list.add(head.val);
              head = head.next;
          }

          int[] res = new int[list.size()];

          int j=0;

          for(int i=0;i<list.size();i++){
            if(list.get(i)<=m){
                res[j] = list.get(i);
                j++;
            }
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)>m){
                res[j] = list.get(i);
                j++;
            }
        }



          ListNode node  =new ListNode(0);
          ListNode head1 = node;

          for(int i=0;i<res.length;i++){
              ListNode node1 = new ListNode(res[i]);
              node.next = node1;
              node = node.next;
          }

          return head1.next;


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
