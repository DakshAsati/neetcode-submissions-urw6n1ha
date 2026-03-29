class MyHashMap {

    private static class Node {
        int key, value;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node[] map;
    private final int SIZE = 10000;

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        Node head = map[idx];

        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        map[idx] = newNode;
    }

    public int get(int key) {
        int idx = hash(key);
        for (Node curr = map[idx]; curr != null; curr = curr.next) {
            if (curr.key == key)
                return curr.value;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        Node curr = map[idx], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) map[idx] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
