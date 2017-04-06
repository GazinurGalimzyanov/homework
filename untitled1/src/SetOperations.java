import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by User on 23.03.2017.
 */
public class SetOperations {
    public Collection fusion(Collection a,Collection b){
        TreeSet s=new TreeSet();
        Iterator i=a.iterator();
        while (i.hasNext())s.add(i.next());
        Iterator i1=b.iterator();
        while (i1.hasNext())s.add(i1.next());
        return s;
    }
    public Collection intersection(Collection a,Collection b){
        TreeSet s=new TreeSet();
        TreeSet s1=new TreeSet();
        Iterator i=a.iterator();
        while (i.hasNext()){
            if(!s.add(i.next())){
                s1.add(i.next());
            }
        }
        Iterator i1=b.iterator();
        while (i1.hasNext()){
            if(!s.add(i1.next())){
                s1.add(i1.next());
            }
        }
        return s1;
    }
    public Collection difference(Collection a,Collection b){
        Collection s=intersection(a,b);
        TreeSet s1=new TreeSet();
        Iterator i=a.iterator();
        while (i.hasNext()){
            if(s.add(i.next())){
                s1.add(i.next());
            }
        }
        Iterator i1=b.iterator();
        while (i1.hasNext()){
            if(s.add(i1.next())){
                s1.add(i1.next());
            }
        }
        return s1;
    }

}
