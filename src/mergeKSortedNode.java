import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *合并K个有序链表
 */

public class mergeKSortedNode {

    public static Node mergeSortedNode(Node[] lists){
        if(lists==null||lists.length==0){
            return null;
        }

        if(lists.length==1){
            return lists[0];
        }

        //创建一个容量为链表个数的优先队列，从小到大排序
        PriorityQueue<Node> minHeap = new PriorityQueue<>(lists.length, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val-o2.val;
            }
        });

        //首先将每个链表的头部放入优先队列中
        for(Node head:lists){
            minHeap.offer(head);
        }

        Node res = new Node(-1);
        Node tail = res;
        Node cur = null;

        while(!minHeap.isEmpty()){
            cur = minHeap.poll();
            tail.next = cur;
            tail = tail.next;
            if(cur.next!=null){
                minHeap.offer(cur.next);
            }
        }


        return res.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        Node[] lists = new Node[2];
        lists[0] =node1;
        lists[1] = node2;

        Node res = mergeSortedNode(lists);

        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
