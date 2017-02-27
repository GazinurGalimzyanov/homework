import java.util.Arrays;

/**
 * Created by User on 27.02.2017.
 */
public class Heap {
    int[] data;
    int size;
    int capacity;

    public Heap() {
        capacity=10;
        size=0;
        data=new int[capacity];
    }
    public void pushTop(int i){
        int p=(i-1)/2;
        if (i==0)return;
        if(data[i]>data[p]){
            swap(i,p);
            pushTop(p);
        }
    }
    public  void swap(int a,int b){

        int k=data[a];
        data[a]=data[b];
        data[b]=k;
    }
    public void add(int val){
        if(size==capacity-1){
            expand();
        }
        data[size]=val;
        pushTop(size);
        size++;
    }
    public void expand(){
        capacity*=2;
        int[] b= Arrays.copyOf(data,capacity);
        data=b;
    }
    public void pushBottom(int i){
        int i1=i*2+1;
        int i2=i*2+2;
        if(i==size||(i1>size-1&&i2>size-1))return;
        if (data[i]==Math.min(Math.max(data[i1],data[i2]),data[i])){
            if(data[i1]>data[i2]){
                swap(i,i1);
                pushBottom(i1);
            }else {
                swap(i,i2);
                pushBottom(i2);
            }
        }
    }
    public int pop(){
        int a=data[0];
        size--;
        data[0]=data[size];
        pushBottom(0);
        return a;
    }
}
