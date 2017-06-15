package Cache;

/**
 * Created by User on 25.04.2017.
 */
public class CacheItem<V> implements Comparable<CacheItem> {
    private V value;
    private long quantity;
    private long lastuse;
    private long frequency;

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {

        return value;
    }

    public CacheItem(V value) {
        this.value = value;
        lastuse = System.currentTimeMillis();
        quantity = 0;
        frequency = 0;
    }

    private void use() {
        long l = System.currentTimeMillis();
        frequency = (frequency * quantity + l - lastuse) / ++quantity;
        lastuse = l;
    }

    @Override
    public int compareTo(CacheItem o) {
        if (o.lastuse>lastuse){
            return -1;
        }
        else if(o.lastuse<lastuse){
            return 1;
        }else if(o.frequency>frequency){
            return 1;
        }else if(o.frequency>frequency){
            return -1;
        }
            return 0;
    }
}
