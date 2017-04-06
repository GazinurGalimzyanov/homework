package BinaryTree;

/**
 * Created by User on 06.04.2017.
 */
public class TreeNode<K extends Comparable,V> implements Comparable{
    K key;
    V value;
    TreeNode father;

    public void setFather(TreeNode father) {
        this.father = father;
    }

    public TreeNode getFather() {

        return father;
    }

    TreeNode left;
    TreeNode right;

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public K getKey() {

        return key;
    }

    public V getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode(K key, V value) {

        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof TreeNode))
        return -1;
        TreeNode node= (TreeNode) o;
        return this.key.compareTo(node.key);
    }
}
