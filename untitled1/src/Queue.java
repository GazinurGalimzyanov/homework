/**
 * Created by User on 27.02.2017.
 */
public class Queue {
    Dequeue data;
    public void push(Object val){
        data.pushTop(val);
    }
    public Object pop(){
        return data.popBottom();
    }

    public Queue() {
        this.data = new Dequeue();
    }

    public Object look(){
        return data.lookBottom();
    }
    public long getSize(){
        return data.getSize();
    }
}
