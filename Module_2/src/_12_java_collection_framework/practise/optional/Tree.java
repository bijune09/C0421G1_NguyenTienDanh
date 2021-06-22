package _12_java_collection_framework.practise.optional;

public interface Tree<E> {
    public boolean insert(E element);

    public void inorder();

    public int getSize();
}
