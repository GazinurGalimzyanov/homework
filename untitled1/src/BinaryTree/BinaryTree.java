package BinaryTree;

/**
 * Created by User on 06.04.2017.
 */
public class BinaryTree<K extends Comparable,V> {
    TreeNode<K,V> root;
    public V put(K key, V value){
        TreeNode<K,V> node = new TreeNode<>(key,value);
        if (root==null){
            root=node;
            return null;
        }
        switch (root.compareTo(node)){
            case -1:
                if(root.getLeft()!=null)return put(root.getLeft(), node);
                root.setLeft(node);
                node.setFather(root);
                return null;
            case 0:
                V value1 = (V) root.getValue();
                root.setValue(value);
                return value1;
            case 1:
                if(root.getRight()!=null)return put(root.getRight(),node);
                root.setRight(node);
                node.setFather(root);
                return null;
        }return null;

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
                return value;
            case 1:
                if(root1.getRight()!=null)return put(root1.getRight(),node);
                root1.setRight(node);
                node.setFather(root1);
                return null;
        }return null;

    }
    public boolean containsKey(K key){
        switch (key.compareTo(root.getKey())){
            case -1:
                if(root.getLeft()!=null)return containsKey(key,root.getLeft());
                return false;
            case 0:
                return true;
            case 1:
                if(root.getRight()!=null)return containsKey(key,root.getRight());
                return false;
        }
        return false;
    }
    public boolean containsKey(K key,TreeNode node){
        switch (key.compareTo(node.getKey())){
            case -1:
                if(node.getLeft()!=null)return containsKey(key, node.getLeft());
                return false;
            case 0:
                return true;
            case 1:
                if(node.getRight()!=null)return containsKey(key, node.getRight());
                return false;
        }
        return false;
    }
    public boolean erase(K k){

        switch (k.compareTo(root.getKey())){
            case -1:
                if(root.getLeft()!=null)return erase(k, root.getLeft());
                return false;
            case 0:
                root=null;
                return true;
            case 1:
                if(root.getRight()!=null)return erase(k, root.getRight());
                return false;
        }
        return false;
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

}
