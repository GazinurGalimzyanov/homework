package Cache;

import BinaryTree.BinaryTree;
import BinaryTree.TreeNode;

/**
 * Created by User on 25.04.2017.
 */
public class SplayTree<K extends Comparable, V> {
    BinaryTree<K, V> data;

    public void splay(TreeNode n) {
        data.root = n;
    }

    public V put(K key, V value) {
        TreeNode<K, V> node = new TreeNode<>(key, value);
        if (data.root == null) {
            data.root = node;
            return null;
        }
        V v=null;
        switch (data.root.compareTo(node)) {
            case -1:
                if (data.root.getLeft() != null) {
                    v = data.put(data.root.getLeft(), node);
                } else {
                    v = null;
                    data.root.setLeft(node);
                    node.setFather(data.root);
                }
                splay(node);
                break;
            case 0:
                V value1 = (V) data.root.getValue();
                data.root.setValue(value);
                return value1;
            case 1:
                if (data.root.getRight() != null) {
                    v = data.put(data.root.getRight(), node);
                } else {
                    v = null;
                    data.root.setRight(node);
                    node.setFather(data.root);
                }
                splay(node);
                break;
        }
        return v;
    }public boolean containsKey(K key){
        boolean ans=false;
        switch (key.compareTo(data.root.getKey())){
            case -1:
                if(data.root.getLeft()!=null)ans= data.containsKey(key, data.root.getLeft());
                break;
            case 0:
                return true;
            case 1:
                if(data.root.getRight()!=null)ans= data.containsKey(key, data.root.getRight());
                break;
        }
        return ans;
    }
}
