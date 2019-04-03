package com.vbiso.structure.tree;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:29 PM 2019/4/3
 * @Modified By:
 */
public class AvlTree<T extends Comparable<? super T>> {

  AvlNode<T> element;


  public AvlTree(T element) {
    this.element = new AvlNode<>(element);
  }

  public void insert(T element) {
    this.element= this.element.insert(element, this.element);
  }


  public int height() {
    return element.height(element);
  }

  public void print(){
    print(element);
  }

  private void print(AvlNode<T> element) {
    if(element !=null){
      System.out.println(element.element);
      print(element.leftChild);
      print(element.rightChild);
    }

  }


  static class AvlNode<T extends Comparable<? super T>> {

    T element;

    AvlNode<T> leftChild;

    AvlNode<T> rightChild;

    int height;

    private static final int ALLOW_IMBALANCE = 1;

    AvlNode(T element) {
      this(element, null, null);
    }

    AvlNode(T element, AvlNode<T> leftChild,
        AvlNode<T> rightChild) {
      this.element = element;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
      height = 0;
    }

    AvlNode<T> insert(T element, AvlNode<T> parentNode) {

      if (parentNode == null) {
        return new AvlNode<>(element);
      }

      int compareResult = parentNode.element.compareTo(element);

      if (compareResult > 0) {
        parentNode.leftChild = insert(element, parentNode.leftChild);
      } else if (compareResult < 0) {
        parentNode.rightChild = insert(element, parentNode.rightChild);
      }
      return balance(parentNode);
    }

    private AvlNode<T> balance(AvlNode<T> parentNode) {

      if (parentNode == null) {
        return parentNode;
      }

      if (height(parentNode.leftChild) - height(parentNode.rightChild) > ALLOW_IMBALANCE) {
        if (height(parentNode.leftChild.leftChild) >= height(parentNode.leftChild.rightChild)) {
          parentNode = rotateWithLeftChild(parentNode);
        } else {
          parentNode = doubleWithLeftChild(parentNode);
        }
      } else if (height(parentNode.rightChild) - height(parentNode.leftChild) > ALLOW_IMBALANCE) {
        if (height(parentNode.rightChild.rightChild) >= height(parentNode.rightChild.leftChild)) {
          parentNode = rotateWithRightChild(parentNode);
        } else {
          parentNode = doubleWithRightChild(parentNode);
        }
      }
      parentNode.height = Math.max(height(parentNode.leftChild), height(parentNode.rightChild)) + 1;
      return parentNode;
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
      k3.rightChild = rotateWithLeftChild(k3.rightChild);
      return rotateWithRightChild(k3);
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {

      k3.leftChild = rotateWithRightChild(k3.leftChild);

      return rotateWithLeftChild(k3);
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {

      AvlNode<T> k2 = k1.rightChild;
      k1.rightChild = k2.leftChild;
      k2.leftChild = k1;


      k1.height = Math.max(height(k1.leftChild), height(k1.rightChild)) + 1;
      k2.height = Math.max(height(k2.leftChild), height(k2.rightChild)) + 1;

      return k2;
    }

    private AvlNode<T> remove(T x1, AvlNode<T> parentNode) {
      int compareResult = parentNode.element.compareTo(x1);

      if (compareResult < 0) {
        remove(x1, parentNode.leftChild);
      } else if (compareResult > 0) {
        remove(x1, parentNode.rightChild);
      } else if (parentNode.leftChild != null && parentNode.rightChild != null) {
        parentNode.element = findMin(parentNode.rightChild).element;
        parentNode.rightChild = remove(parentNode.element, parentNode.rightChild);
      } else {
        parentNode = (parentNode.leftChild != null) ? parentNode.leftChild : parentNode.rightChild;
      }
      return balance(parentNode);
    }

    private AvlNode<T> findMin(AvlNode<T> parentNode) {
      if (parentNode.leftChild == null) {
        return parentNode;
      }
      return findMin(parentNode.leftChild);
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
      AvlNode<T> k1 = k2.leftChild;
      k2.leftChild = k1.rightChild;
      k1.rightChild = k2;

      k2.height = Math.max(height(k2.leftChild), height(k2.rightChild) + 1);

      k1.height = Math.max(height(k1.leftChild), height(k1.rightChild) + 1);

      return k1;
    }

    int height(AvlNode<T> node) {
      return node == null ? -1 : node.height;
    }
  }

  public static void main(String[] args) {
    AvlTree<Integer> avlTree = new AvlTree<>(1);

    avlTree.insert(2);
    avlTree.insert(3);
    avlTree.insert(4);
    avlTree.insert(5);
    avlTree.insert(6);

    avlTree.print();
  }

}
