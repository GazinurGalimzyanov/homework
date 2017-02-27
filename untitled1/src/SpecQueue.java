/**
 * Created by User on 27.02.2017.
 */
public class SpecQueue {
    SpecStack a;
    SpecStack b;
    boolean s;

    public SpecQueue() {
        a=new SpecStack();
        b=new SpecStack();
    }
    public void push(int val){
        a.push(val);
        s=true;
    }
    public int pop(){
    while (a.getSize()>0){
        b.push(a.pop());}
        s=false;
        return b.pop();
    }
    public int look(){
        while (a.getSize()>0){
            b.push(a.pop());}
        return b.look();
    }
    public int min(){
        if (s){
            return a.min();
        }
        return b.min();
    }
}
