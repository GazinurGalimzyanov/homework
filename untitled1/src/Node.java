

/**
 * Created by User on 27.02.2017.
 */
public class Node<T> {
    private Node<T> next;
    private Node<T> prev;
    private T val;

    public Node(T val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getNext() {

        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public T    getVal() {
        return val;
    }
}
