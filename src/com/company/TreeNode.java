package com.company;

public class TreeNode <E>{

    private E data;
    private TreeNode firstchild;
    private TreeNode nextsibling;

    /**
     *
     * @param data
     */
    public TreeNode(E data) {
        this.data = data;
        this.firstchild = null;
        this.nextsibling = null;
    }

    public E getData() {
        return data;

    }
    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getNextsibling() {
        return nextsibling;
    }

    public void setNextsibling(TreeNode<E> nextsibling) {
        this.nextsibling = nextsibling;
    }

    public TreeNode<E> getFirstchild() {
        return firstchild;
    }

    public void setFirstchild(TreeNode<E> firstchild) {
        this.firstchild = firstchild;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
