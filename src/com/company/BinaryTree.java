package com.company;

public abstract class BinaryTree<E> {
    private TreeNode<E> root;
    public abstract boolean add(E parent, E child);
    public abstract TreeNode<E> levelOrderSearch(E item);
    public abstract TreeNode<E> postOrderSearch(E item);

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }
}
