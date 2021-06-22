package _12_java_collection_framework.practise.optional;

public class TreeNode<E> {
    protected  E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
    }
}
