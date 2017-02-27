

/**
 * Created by User on 27.02.2017.
 */
public class Node {
    private Node next;
    private Node prev;
    private Object val;

    public Node(Object val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public Node getNext() {

        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public Object getVal() {
        return val;
    }
}
