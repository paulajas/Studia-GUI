package GUI9NEW;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public
class MyList<T>
        implements Iterable<T>{

    Element<T> head;

    public void add(T data){
        Element<T> tmp = new Element<T>();
        tmp.data = data;
        tmp.next = head;
        head = tmp;
    }

    public void show(){
        Element tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StudentIterator<T>(head);
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
