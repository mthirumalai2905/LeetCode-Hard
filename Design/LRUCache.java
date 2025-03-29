import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final DoublyLinkedList cache;

    LRUCache(int cap) {
        this.capacity = cap;
        this.map = new HashMap<>();
        this.cache = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        cache.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            cache.moveToHead(node);
        } else {
            if (cache.size >= capacity) {
                Node tail = cache.removeTail();
                map.remove(tail.key);
            }
            Node newNode = new Node(key, value);
            cache.addToHead(newNode);
            map.put(key, newNode);
        }
    }

    private class DoublyLinkedList {
        private final Node head, tail;
        private int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        Node removeTail() {
            if (size == 0) return null;
            Node tailNode = tail.prev;
            remove(tailNode);
            return tailNode;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
