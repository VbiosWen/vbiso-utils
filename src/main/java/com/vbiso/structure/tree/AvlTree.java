package com.vbiso.structure.tree;

import java.util.Objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 12:09 AM 2019/3/9
 * @Modified By:
 */
public class AvlTree<AnyType extends Comparable<? super AnyType>> {

  static final int ALLOWED_IMBALANCE = 1;


  public static class AvlNode<AnyType extends Comparable<? super AnyType>> {

    public AvlNode(AnyType element) {
      this.element = element;
    }


    AnyType element;

    AvlNode<AnyType> left;

    AvlNode<AnyType> right;

    int height;
  }

  private int height(AvlNode<AnyType> t) {
    return Objects.isNull(t) ? -1 : t.height;
  }

  public AvlNode<AnyType> insert(AnyType element, AvlNode<AnyType> t) {
    if (Objects.isNull(t)) {
      return new AvlNode<>(element);
    }
    int compareResult = element.compareTo(t.element);
    if (compareResult < 0) {
      //如果比当前节点小，插入左节点
      return insert(element, t.left);
    } else if (compareResult > 0) {
      //如果比当前节点大，插入右节点
      return insert(element, t.right);
    } else {
      //noting to do
    }
    return balance(t);
  }

  private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
    if (Objects.isNull(t)) {
      return t;
    }
    if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
      if (height(t.left.left) >= height(t.left.right)) {
        t = rotateWithLeftChild(t);
      } else {
        t = doubleWithLeftChild(t);
      }
    } else {
      if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
        if (height(t.right.right) >= height(t.left.right)) {
          t = rotateWithRightChild(t);
        } else {
          t = doubleWithRightChild(t);
        }
      }
    }
    assert t != null;
    t.height = Math.max(height(t.left), height(t.right)) + 1;
    return t;
  }

  private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
    k3.right = rotateWithLeftChild(k3.right);
    return rotateWithRightChild(k3);
  }

  private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {
    AvlNode<AnyType> k1 = k2.right;
    k2.right = k1.left;
    k1.left = k2;
    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
    k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
    return k1;
  }

  private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
    k3.left = rotateWithRightChild(k3.left);
    return rotateWithLeftChild(k3);
  }

  //左节点深度-右节点深度>1 并且左节点的左节点的深度>=右节点的深度 右旋转 k1 上移，k2成为K1的右节点，并且k1的右节点变成k2的左节点
  private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
    AvlNode<AnyType> k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;
    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
    k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
    return k1;
  }

}
