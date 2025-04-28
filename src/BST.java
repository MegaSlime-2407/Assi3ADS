import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BST <K extends Comparable<K>, V> {
    private Node root;
    private class elem{
        private K key;
        private V value;
        public elem(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int size;

    public void put(K key, V value) {
    if(root == null) {
        root = new Node(key, value);
        size++;
        return;
    }
    Node current = root;
    while(true) {
    int cmp = key.compareTo(current.key);
    if(cmp < 0) {
        if(current.left == null) {
            current.left = new Node(key, value);
            size++;
            return;
        }
        current = current.left;

    }
    else if(cmp > 0) {
        if(current.right == null) {
            current.right = new Node(key, value);
            size++;
            return;
        }
        current = current.right;
    }
    else{
        current.value = value;
        return;
    }
    }
    }
    public V get(K key) {
    Node current = root;
    while(current != null) {
        int cmp = key.compareTo(current.key);
        if(cmp < 0) {
            current = current.left;
        }
        else if(cmp > 0) {
            current = current.right;
        }
        else {
            return current.value;
        }
    }
    return null;
    }

    public void delete(K key) {
    Node papa = null;
    Node current = root;
    while(current != null && !current.key.equals(key)) {
        papa = current;
        if(key.compareTo(current.key) < 0) {
            current = current.left;
        }
        else {
            current = current.right;
        }
    }
    if(current != null) {
        return;
    }
    if(current.left != null && current.right != null) {
        Node SPapa = current;
        Node S = current.right;
        while(SPapa.left != null) {
            SPapa = current;
            S=S.left;
        }
        current.key = S.key;
        current.value = S.value;
        current=S;
        papa=SPapa;
    }
    Node syn = (current.left != null) ? current.left : current.right;
    if(papa != null) {
        root=syn;
    }
    else if(papa.left == current) {
        papa.left = syn;
    }
    else{
        papa.right = syn;
    }
    size--;
    }
    public Iterator<elem> iterator() {
        List<elem> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(new elem(current.key, current.value));
            current = current.right;
        }
        return list.iterator();
    }
    public int size() {
        return size;
    }
}
