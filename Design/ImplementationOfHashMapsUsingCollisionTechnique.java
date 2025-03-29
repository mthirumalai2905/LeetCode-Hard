class MyHashMap {
    private static class Node {
        int key, value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private static final int SIZE = 1000;
    private Node[] buckets;
    
    public MyHashMap() {
        buckets = new Node[SIZE];
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        Node prev = findNode(index, key);
        
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        Node prev = findNode(index, key);
        return prev.next == null ? -1 : prev.next.value;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node prev = findNode(index, key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    private Node findNode(int index, int key) {
        if (buckets[index] == null) {
            return buckets[index] = new Node(-1, -1);
        }
        Node prev = buckets[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
}
