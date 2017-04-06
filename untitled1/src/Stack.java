/**
 * Created by User on 27.02.2017.
 */
public class Stack<T> {
    Dequeue<T> data;

    public Stack() {
        data=new Dequeue<T>();
    }

    public void push(T val){
        data.pushTop(val);
    }
    public T pop(){
        return data.popTop();
    }
    public T look(){
        return data.lookTop();
    }
    public long getSize(){
        return data.getSize();
    }
}
