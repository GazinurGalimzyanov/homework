import java.util.Arrays;

/**
 * Created by User on 01.03.2017.
 */
public class Graph {
    int[][] edges;
    int capasity = 10;
    int lenght;

    public Graph() {
        edges = new int[capasity][capasity];
        lenght = 0;
    }

    public void add(int[] links) {
        edges[lenght] = links;
        for (int i : links) {
            int[] a = Arrays.copyOf(edges[i], edges[i].length + 1);
            a[edges[i].length] = lenght;
            edges[i] = a;
        }
        lenght++;
    }

    public Stack DFS() {
        Stack s = new Stack();
        boolean[] mark = new boolean[lenght];
        Arrays.fill(mark, false);
        int[] trace = new int[lenght];
        for (int i : edges[0]) {
            DFS(edges[0][i], 0, mark, trace);
        }
        for (int v = lenght - 1; v != 0; v = trace[v]) {
            s.push(v);
        }
        return s;
    }

    void DFS(int v, int from, boolean[] mark, int[] trace) {
        if (mark[v]) {
            return;
        }
        mark[v] = true;
        trace[v] = from;
        if (v == lenght - 1) {
            return;
        }
        for (int i : edges[v]) {
            DFS(edges[v][i], v, mark, trace);
        }
    }
}
