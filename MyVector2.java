import java.util.*;

public class MyVector2 extends MyVector implements Iterator{
    int cursor = 0;
    int lastRat = -1;

    public MyVector2(int capacity){
        super(capacity);
    }

    public MyVector2(){
        this(10);
    }

    public String toString(){
        String tmp = "";
        Iterator it = iterator();

        for(int i=0; it.hasNext(); i++){
            if(i!=0) tmp+=", ";
            tmp += it.next();
        }
        return "["+ tmp + "]";
    }

    public Iterator iterator(){
        cursor = 0;
        lastRat = -1;
        return this;
    }

    public boolean hasNext(){
        return cursor != size();
    }

    public Object next(){
        Object next = get(cursor);
        lastRat = cursor++;
        return next;
    }

    public void remove(){
        if(lastRat == -1){
            throw new IllegalStateException();
        } else {
            remove(lastRat);
            cursor--;
            lastRat = -1;
        }
    }
}
