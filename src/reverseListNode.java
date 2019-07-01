public class reverseListNode {

  public static Node reverse(Node head){
      if(head==null||head.next==null){
          return head;
      }

      Node temp = head.next;
      Node newHead = reverse(head.next);
      temp.next = head;
      head.next = null;
      return newHead;
  }

    /**
     * 翻转位置m-n之间的节点
     */
    public static Node reverseMN(Node head,int m,int n){
        if(head==null||n-m<=0){
            return head;
        }

        Node cur = head;
        Node end = cur;
        Node start = cur;
        Node next  =null;
        Node prev = null;

        int i=1;

        for(;i<m;i++){
            start = cur;
            cur = cur.next;
            end = cur;
        }

        for(i=0;i<=n-m;i++){
            next = cur.next;
            cur.next=prev;
            prev = cur;
            cur = next;
        }

        start.next = prev;
        end.next = cur;

        if(m==1){
            return prev;
        }
        return head;
    }


    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        Node head4 = new Node(4);
        Node head5 = new Node(5);

        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;

       Node node =  reverse(head1);

        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }

    }

}
