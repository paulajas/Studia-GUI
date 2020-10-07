package GUI9NEW;

import java.util.Iterator;

public
class StudentIterator<T>
        implements Iterator<T> {

    Element<T> head;

    public StudentIterator(Element<T> head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public T next() {
        T tmp = head.data;
        head = head.next;
        return tmp;
    }
}

