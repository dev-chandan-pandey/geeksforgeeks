/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
          List<Integer> values = new ArrayList<>();

        // Push values of all nodes into a list
        while (root != null) {
            // Push the head node of the sub-linked-list
            values.add(root.data);

            // Push all the nodes of the sub-linked-list
            Node temp = root.bottom;
            while (temp != null) {
                values.add(temp.data);
                temp = temp.bottom;
            }

            // Move to the next head node
            root = root.next;
        }

        // Sort the node values in ascending order
        Collections.sort(values);

        // Construct the new flattened linked list
        Node tail = null;
        Node head = null;
        for (int value : values) {
            Node newNode = new Node(value);

            // If this is the first node of the linked list,
            // make the node as head
            if (head == null)
                head = newNode;
            else
                tail.bottom = newNode;
            tail = newNode;
        }

        return head;
    }
}