package deques;

public class LinkedDeque<T> extends AbstractDeque<T> {
    private int size;
    // IMPORTANT: Do not rename these fields or change their visibility.
    // We access these during grading to test your code.
    Node<T> front;
    Node<T> back;
    // Feel free to add any additional fields you may need, though.

    public LinkedDeque() {
        size = 0;
        front = new Node<T>(null, null, null);
        back = new Node<T>(null, front, null);
        front.next = back;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item, null, front.next);
        if (size == 0) {
            back.prev = newNode;
            front.next = newNode;
        } else {
            front.next = newNode;
            front.next.next.prev = newNode;
        }
        newNode.prev = front;
        size += 1;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item, back.prev, null);
        //nt tracker = 0;
        if (size == 0) {
            back.prev = newNode;
            front.next = newNode;
            newNode.prev = front;
            newNode.next = back; //////////
        } else {
            back.prev = newNode;
            newNode.next = back;
            newNode.prev.next = newNode;
        }
        size += 1;
    }

    public T removeFirst() {

        T removeOutput = null;
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            removeOutput = front.next.value;
            front.next = back;
            back.prev = front;
        }
        else {
            removeOutput = front.next.value;
            front.next.next.prev = front;
            front.next = front.next.next;
            // back.prev = back.prev.prev;
        }
        size -= 1;
        return removeOutput;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public T removeLast() {

        T removeOutput = null;
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            removeOutput = back.prev.value;
            front.next = front.next.next;
            back.prev = back.prev.prev;
        }
        else {
            removeOutput = back.prev.value;
            back.prev.prev.next = back;
            back.prev = back.prev.prev;
        }
        size -= 1;
        return removeOutput;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }



    public T get(int index) {
        //throw new UnsupportedOperationException("Not implemented yet.");
        if ((index >= size) || (index < 0)) {
            return front.value;
        }
        int mid = size / 2;
        int track = 0;
        Node<T> what = null;
        if (index > mid) {
            what = back.prev;
            while (track != size - index - 1) {
                what = what.prev;
                track++;
            }
        } else {
            what = front.next;
            while (track != index) {
                what = what.next;
                track++;
            }
        }
        return what.value;
    }

    public int size() {
        return size;
    }
}
