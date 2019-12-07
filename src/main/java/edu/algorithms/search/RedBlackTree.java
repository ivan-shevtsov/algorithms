package edu.algorithms.search;

import java.util.Objects;
import java.util.StringJoiner;

public class RedBlackTree <T extends Comparable, V> {

    private Node<T,V> rootNode;

    public void put(T key, V value) {
        System.out.println(key);
        Objects.requireNonNull(key);
        rootNode = putNewNode(rootNode, key, value);
        rootNode.colour = Node.BLACK;
    }

    private Node<T, V> putNewNode(Node<T,V> node, T key, V value) {
        if (node == null) {
            return newNodeForParent(node, key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = putNewNode(node.left, key, value);
            node.left.parent = node;
        } else if (cmp > 0) {
            node.right = putNewNode(node.right, key, value);
            node.right.parent = node;
        }
        return passUpRedLink(node);
    }

    private Node<T,V> passUpRedLink(Node<T,V> node) {
        Node<T, V> n = node;
        if (isRed(n.right) && !isRed(n.left)) {
            n = rotateLeft(n);
        }
        if (isRed(n.left) && isRed(n.left.left)) {
            n = rotateRight(n);
        }
        if (isRed(n.left) && isRed(n.right)) {
            flipColors(n);
        }
        return n;
    }

    private Node<T,V> rotateRight(Node<T,V> h) {
        Node<T, V> x = h.left;
        h.left = x.right;
        x.right = h;
        x.parent = h.parent;
        h.parent = x;
//        replaceChild(x.parent, h, x);
        h.colour = Node.RED;
        x.colour = h.colour;
        return x;
    }

    private Node<T,V> rotateLeft(Node<T,V> node) {
        Node<T, V> x = node.right;
        node.right = x.left;
        x.left = node;
        x.parent = node.parent;
        node.parent = x;
//        replaceChild(x.parent, node, x);
        x.colour = node.colour;
        node.colour = Node.RED;
        return x;
    }

    private void replaceChild(Node parent, Node<T,V> node, Node<T,V> x) {
        if (parent != null && parent.left == node) {
            parent.left = x;
        } else if (parent != null && parent.right == node) {
            parent.right = x;
        }
    }

    private Node<T, V> flipColors(Node<T, V> node) {
        node.left.colour = Node.BLACK;
        node.right.colour = Node.BLACK;
        node.colour = Node.RED;
        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed();
    }

    private Node<T, V> newNodeForParent(Node<T,V> node, T key, V value) {
        Node<T, V> child = new Node<>();
        child.key = key;
        child.value = value;
        child.parent = node;
        child.colour = Node.RED;
        return child;
    }

    private Node<T,V> findNode(T key, Node<T,V> rootNode) {
        return null;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        return join(rootNode, stringJoiner).toString();
    }

    private StringJoiner join(Node<T,V> node, StringJoiner stringJoiner) {
        if (node == null) {
            return stringJoiner;
        }
        if (node.left != null) {
            join(node.left, stringJoiner);
        }
        stringJoiner.add(node.key.toString());
        if (node.right != null) {
            join(node.right, stringJoiner);
        }
        return stringJoiner;
    }

    static class Node<T, V> {
        public static final boolean RED = false;
        public static final boolean BLACK = true;

        private Node parent;
        private boolean colour = RED;
        private Node left;
        private Node right;

        T key;
        V value;

        public boolean isRed() {
            return colour == RED;
        }
    }
}
