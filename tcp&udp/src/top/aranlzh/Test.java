package top.aranlzh;

public class Test {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        System.out.println(node1.toString());

        System.out.println(new Test().reverse(node1).toString());

    }

}
