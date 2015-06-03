package queue;

public class ArrayQueue {
    private Object[] a;
    private int max;
    private int first, last;

    public ArrayQueue(int max) {
        this.max = max;
    }

    public ArrayQueue() {
        this(10);
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return first == 0 && last == max - 1 || first == last + 1;
    }

    private boolean grow() {
        int i, j;
        int max1 = max + max / 2;
        Object[] a1 = new Object[max1];

        if (a == null) return false;

        if (first < last) {
            for (i = first; i <= last; i++) {
                a1[i - first] = a[i];
            }
        } else {
            for (i = first; i <= max; i++) {
                a1[i - first] = a[i];
            }
            for (j = last; j <= last; j++) {
                a1[max - last] = a[j];
            }
        }
        a = a1;
        max = max1;
        int size;
        if (first <= last) {
            size = last - first + 1;
        } else {
            size = max - first + last + 1;
        }
        first = 0;
        last = size - 1;
        return true;
    }

    public void enqueue(Object x) {
        if (isFull() && !grow()) return;
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            a[++last] = 1;
        }
    }

    public Object front() throws Exception {
        if (isEmpty()) throw new Exception("The queue is empty.");
        return a[first];
    }

    public Object dequeue() throws Exception {
        if (isEmpty()) throw new Exception("The queue is empty.");
        Object x = a[first];
        if (first == last) {
            first = last = -1;
        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }
        return x;
    }
}
