package SplayTree;

/**
 * Created by User on 16.04.2017.
 */
public class SplayTree<K extends Comparable, V> {
    TreeNode<K, V> root;

    public SplayTree() {
    }

    public V put(K key, V value){
        TreeNode<K,V> node = new TreeNode<>(key,value);
        if (root==null){
            root=node;
            return null;
        }
        return put(root,node);
    }
    public V put(TreeNode root1,TreeNode node){
        switch (root1.compareTo(node)){
            case -1:
                if(root1.getLeft()!=null)return put(root1.getLeft(),node);
                root1.setLeft(node);
                node.setFather(root1);
                return null;
            case 0:
                V value = (V) root1.getValue();
                root1.setValue(node.getValue());
                splay(root1);
                return value;
            case 1:
                if(root1.getRight()!=null)return put(root1.getRight(),node);
                root1.setRight(node);
                node.setFather(root1);
                return null;
        }return null;

    }
    public boolean containsKey(K key){
        return containsKey(key,root);
    }
    public boolean containsKey(K key,TreeNode node){
        switch (key.compareTo(node.getKey())){
            case -1:
                if(node.getLeft()!=null)return containsKey(key, node.getLeft());
                return false;
            case 0:
                splay(node);
                return true;
            case 1:
                if(node.getRight()!=null)return containsKey(key, node.getRight());
                return false;
        }
        return false;
    }
    public boolean erase(K k){

        return erase(k,root);
    }
    public boolean erase(K k,TreeNode node){

        switch (k.compareTo(node.getKey())){
            case -1:
                if(node.getLeft()!=null)return erase(k, node.getLeft());
                return false;
            case 0:
                TreeNode left=node.getLeft();
                TreeNode right=node.getRight();
                TreeNode father=node.getFather();
                if(father.getRight()==node){
                    father.setRight(right);
                    right.setFather(father);
                    while (right.getLeft()!=null){
                        right=right.getLeft();
                    }
                    left.setFather(right);
                    right.setLeft(left);
                    splay(father);
                }
                else {
                    father.setLeft(left);
                    left.setFather(father);
                    while (left.getRight()!=null){
                        left=left.getRight();
                    }
                    right.setFather(left);
                    left.setLeft(right);
                }
                return true;
            case 1:
                if(node.getRight()!=null)return erase(k, node.getRight());
                return false;
        }
        return false;
    }
    void splay(final TreeNode node) {
        while (node != root) {
            if (node.getFather() == root) {

                if (node == node.getFather().getLeft())
                    rightRotate(node);
                else if (node == node.getFather().getRight()) {
                    leftRotate(node);

                }
            } else {
                if (node == node.getFather().getLeft() &&
                        node.getFather() == node.getFather().getFather().getLeft()) {

                    rightRotate(node.getFather().getFather());
                    rightRotate(node.getFather());

                } else if (node == node.getFather().getRight() &&
                        node.getFather() == node.getFather().getFather().getRight()) {

                    leftRotate(node.getFather().getFather());
                    leftRotate(node.getFather());
                }
                else if (node == node.getFather().getRight() &&
                        node.getFather() ==node.getFather().getFather().getLeft()) {

                    leftRotate(node.getFather());
                    rightRotate(node.getFather().getFather());

                } else if (node==node.getFather().getLeft() &&
                        node.getFather() == node.getFather().getFather().getRight()) {

                    rightRotate(node.getFather());
                    leftRotate(node.getFather().getFather());

                }
            }
        }
    }

    void rightRotate(TreeNode node) {
        TreeNode left = node.getLeft();

        node.setLeft(left.getRight());
        if (left.getRight() != null)
            left.getRight().setFather(node);

        transplant(node, left);

        left.setRight(node);
        left.getRight().setFather(left);
    }


    void leftRotate(TreeNode node) {
        TreeNode right = node.getRight();

        node.setLeft(right.getLeft());
        if (right.getLeft() != null)
            right.getLeft().setFather(node);

        transplant(node, right);

        right.setLeft(node);
        right.getLeft().setFather(right);
    }

    void transplant(TreeNode node, TreeNode left) {
        if (node.getFather() == null)
            root = left;
        else if (node == node.getFather().getLeft())
            node.getFather().setLeft(left);
        else if (node == node.getFather().getRight())
            node.getFather().setRight(left);

        if (left != null)
            left.setFather(node.getFather());
    }
}
