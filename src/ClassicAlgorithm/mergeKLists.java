package ClassicAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *合并k个有序的链表
 */
public class mergeKLists {
    public Node mergeKLists(Node[] lists) {

        if(lists==null||lists.length == 0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(lists.length,  //两个参数，一个是队列的长度，一个是比较器，队列从小到大；
                new Comparator<Node>(){
                    @Override
                    public int compare(Node n1, Node n2) {
                        return n1.val - n2.val;
                    }
                });




        for(Node head:lists){  //将每个链表的头节点入队列；
            if(head!=null){
                minHeap.offer(head);
            }
        }

        Node dummyHead = new Node(-1);
        Node tail = dummyHead,cur=null;

        while(minHeap.size()>0){
            cur = minHeap.poll();
            tail.next=cur;
            tail=tail.next;
            if(cur.next!=null){
                minHeap.offer(cur.next);
            }
        }

        return dummyHead.next;

    }
}
