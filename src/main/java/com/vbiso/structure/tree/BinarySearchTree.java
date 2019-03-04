package com.vbiso.structure.tree;

import java.util.Objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 12:05 AM 2019/3/5
 * @Modified By:
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {


  private static class TreeNode<AnyType extends Comparable<? super AnyType>> {

    private TreeNode<AnyType> root;

    public TreeNode() {
      this.root = null;
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
      if(Objects.isNull(root)){
        return null;
      }else if(root.left ==null){
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

      if(Objects.isNull(root)){
        return null;
      } else {
        while (Objects.nonNull(root.right)){
          root = root.right;
        }
      }
      return root;
    }

    public void insert(AnyType element) {
      this.root = insert(element, root);
    }

    private TreeNode<AnyType> insert(AnyType element, TreeNode<AnyType> root) {
      if(Objects.isNull(root)){
        return new TreeNode<>(element);
      }
      int compareResult= element.compareTo(root.element);
      if(compareResult < 0){
        root.left = insert(element,root.left);
      }else if (compareResult > 0){
        root.right = insert(element,root.right);
      }
      return root;
    }

    public void remove(AnyType element) {
      if (isEmpty()) {
        throw new RuntimeException();
      }
      this.root = remove(element, root);
    }

    private TreeNode<AnyType> remove(AnyType element, TreeNode<AnyType> root) {
      return null;
    }

    public void printTree() {

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

}

