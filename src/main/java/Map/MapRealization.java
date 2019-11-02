package Map;

public class MapRealization {
    Object key;
    Object value;
    private int M = 16;
    private int size = 0;
    private Object[] st = new Object[M];

    private class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.next = next;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Object key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Object get(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    public void delete(Object key) {
        int i = hash(key);
        Node x = (Node) st[i];

        while (x != null) {
            if (key.equals(x.key)) {
                x.value = null;
            }
            x = x.next;
        }
        size--;
    }


    public boolean contains(Object key) {
        return get(key) != null;
    }

    public void put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]);
        size++;
    }


}


