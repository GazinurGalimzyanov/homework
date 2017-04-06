/**
 * Created by User on 27.02.2017.
 */
public class SpecQueue {
    SpecStack a;
    SpecStack b;

    public SpecQueue() {
        a=new SpecStack();
        b=new SpecStack();
    }
    public void push(int val){
        a.push(val);
    }
    public int pop(){
        if(b.getSize()==0){
    while (a.getSize()>0){
        b.push(a.pop());}}
        return b.pop();
    }
    public int look(){
        if(b.getSize()==0){
        while (a.getSize()>0){
            b.push(a.pop());}}
        return b.look();
    }
    public int min(){
        return Math.min(a.min(),b.min());
    }
}
