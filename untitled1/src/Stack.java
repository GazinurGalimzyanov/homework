/**
 * Created by User on 27.02.2017.
 */
public class Stack {
    Dequeue data;

    public Stack() {
        data=new Dequeue();
    }

    public void push(Object val){
        data.pushTop(val);
    }
    public Object pop(){
        return data.popTop();
    }
    public Object look(){
        return data.lookTop();
    }
    public long getSize(){
        return data.getSize();
    }
}
