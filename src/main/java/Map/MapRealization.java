package Map;

public class MapRealization {

    private int capacity = 16;
    private int treshold = 16;
    private int size = 0;
    private float loadFactor = 0.75f;
    private float multiplier = 1.5f;
    private Object[] st = new Object[capacity];

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
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public Object get(Object key) {

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

    public void remove(Object key) {
        int i = hash(key);
        Node x = (Node) st[i];
        
        if ((size <= loadFactor * capacity) && (size / multiplier > treshold)) {
            int newcapacity = (int) Math.round(capacity / multiplier);
            Object[] st1 = new Object[newcapacity];
            System.arraycopy(st, 0, st1, 0, capacity);
            st = st1;
            capacity = newcapacity;

        }

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

        int i = hash(key);
        Node x = (Node) st[i];
        
         if (size >= loadFactor * capacity) {
            int newcapacity = Math.round(capacity * multiplier);
            Object[] st1 = new Object[newcapacity];
            System.arraycopy(st, 0, st1, 0, capacity);
            st = st1;
            capacity = newcapacity;
        }
        
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


