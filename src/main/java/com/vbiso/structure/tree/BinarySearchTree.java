package com.vbiso.structure.tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 12:05 AM 2019/3/5
 * @Modified By:
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {


  private TreeNode<AnyType> root;


  public BinarySearchTree(Collection<AnyType> collection){
    this.root = new TreeNode<>(collection);
  }


  private static class TreeNode<AnyType extends Comparable<? super AnyType>> {

    private TreeNode<AnyType> root;

    public TreeNode() {
      this.root = null;
    }


    public TreeNode(Collection<AnyType> collection) {

      for (AnyType anyType : collection) {
        insert(anyType);
      }
    }

    public void makeEmpty() {
      this.root = null;
    }

    public boolean isEmpty() {
      return this.root == null;
    }

    public boolean contains(AnyType element) {
      return contains(element, root);
    }

    private boolean contains(AnyType element, TreeNode<AnyType> root) {
      if (Objects.isNull(root)) {
        return false;
      }
      int compareResult = element.compareTo(root.element);
      if (compareResult < 0) {
        return contains(element, left);
      } else if (compareResult > 0) {
        return contains(element, right);
      } else {
        return true;
      }
    }

    @SuppressWarnings("all")
    public AnyType findMin() {
      if (isEmpty()) {
        throw new RuntimeException();
      }
      return findMin(root).element;
    }

    private TreeNode<AnyType> findMin(TreeNode<AnyType> root) {
      if (Objects.isNull(root)) {
        return null;
      } else if (root.left == null) {
        return root;
      }
      return findMax(root.left);
    }

    @SuppressWarnings("all")
    public AnyType findMax() {
      if (isEmpty()) {
        throw new RuntimeException();
      }
      return findMax(root).element;
    }

    private TreeNode<AnyType> findMax(TreeNode<AnyType> root) {

      if (Objects.isNull(root)) {
        return null;
      } else {
        while (Objects.nonNull(root.right)) {
          root = root.right;
        }
      }
      return root;
    }

    public void insert(AnyType element) {
      this.root = insert(element, root);
    }

    private TreeNode<AnyType> insert(AnyType element, TreeNode<AnyType> root) {
      if (Objects.isNull(root)) {
        return new TreeNode<>(element);
      }
      int compareResult = element.compareTo(root.element);
      if (compareResult < 0) {
        root.left = insert(element, root.left);
      } else if (compareResult > 0) {
        root.right = insert(element, root.right);
      }
      return root;
    }

    private void remove(AnyType element) {
      if (isEmpty()) {
        throw new RuntimeException();
      }
      this.root = remove(element, root);
    }

    private TreeNode<AnyType> remove(AnyType element, TreeNode<AnyType> root) {
      if (Objects.isNull(root)) {
        return root;
      }

      int compareResult = element.compareTo(root.element);
      if (compareResult < 0) {
        root.left = remove(element, root.left);
      } else if (compareResult > 0) {
        root.right = remove(element, root.right);
      } else if (Objects.nonNull(root.left) && Objects.nonNull(root.right)) {
        root.element = Objects.requireNonNull(findMin(root.right)).element;
        root.right = remove(root.element, root.right);
      } else {
        root = (Objects.nonNull(root.left)) ? root.left : root.right;
      }
      return root;
    }

    public void printTree() {
      if (isEmpty()) {
        System.out.println("empty tree");
      } else {
        printTree(root);
      }

    }

    private void printTree(TreeNode<AnyType> root) {
      if (Objects.nonNull(root)) {
        printTree(root.left);
        System.out.println(root.element);
        printTree(root.right);
      }
    }

    TreeNode(AnyType element) {
      this(element, null, null);
    }

    TreeNode(AnyType element, TreeNode<AnyType> left,
        TreeNode<AnyType> right) {
      this.element = element;
      this.left = left;
      this.right = right;
    }

    //值
    AnyType element;
    //左儿子
    TreeNode<AnyType> left;
    //右儿子
    TreeNode<AnyType> right;
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(Arrays.asList(3,4,3,1,2,4,6,5,6,73,3234,343));

    binarySearchTree.root.printTree();
    binarySearchTree.root.remove(5);
  }

}

