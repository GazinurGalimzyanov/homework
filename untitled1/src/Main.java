

/**
 * Created by User on 27.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        int[] a=new int[1000];
        int n=5;
        SpecQueue s=new SpecQueue();
        s.push(a[0]);
        s.push(a[1]);
        s.push(a[2]);
        s.push(a[3]);
        s.push(a[4]);
        int min=s.min();
        for (int i=5;i<1000-n;i++){
            s.push(a[i]);
            s.pop();
            min=Math.min(min,s.min());
        }
        System.out.print(min);
    }
}
