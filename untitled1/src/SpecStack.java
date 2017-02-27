/**
 * Created by User on 27.02.2017.
 */
public class SpecStack {
    Stack data;

    public SpecStack() {
        data=new Stack();
    }
    public void push(int val){
        data.push(new Pair(val,Math.min(val,min())));
    }
    public int pop(){
        int a;
        Pair b= (Pair) data.pop();
        a=b.getA();
        return a;
    }
    public int look(){
        int a;
        Pair b= (Pair) data.look();
        a=b.getA();
        return a;
    }
    public int min(){
        int a;
        Pair b= (Pair) data.look();
        a=b.getB();
        return a;
    }
    public long getSize(){
        return data.getSize();
    }
}
