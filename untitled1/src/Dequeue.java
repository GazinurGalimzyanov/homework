/**
 * Created by User on 27.02.2017.
 */
public class Dequeue<T> {
    Node<T> tail;
    Node<T> head;
    long size;

    public Dequeue() {
        tail=null;
        head=null;
        size=0;
    }
    public void pushTop(T val){
        Node<T> n=new Node(val);
        if(size==0){
            tail=n;
            head=n;
        }else if(size==1){
            head=n;
            n.setPrev(tail);
            tail.setNext(head);
        }
        else {
            n.setPrev(head);
            head.setNext(n);
            head=n;
        }
        size++;
    }
    public void pushBottom(T val){
        Node<T> n=new Node(val);
        if(size==0){
            tail=n;
            head=n;
        }else if(size==1){
            tail=n;
            n.setPrev(head);
            head.setNext(tail);
        }
        else {
            n.setPrev(tail);
            tail.setNext(n);
            tail=n;
        }
        size++;
    }
    public T popTop(){
        T val=head.getVal();
        head=head.getPrev();
        head.setNext(null);
        size--;
        return val;
    }
    public T popBottom(){
        T val=tail.getVal();
        tail=tail.getNext();
        tail.setPrev(null);
        size--;
        return val;
    }
    public T lookTop(){
        return head.getVal();
    }

    public long getSize() {
        return size;
    }

    public T lookBottom(){
        return tail.getVal();

    }
}
