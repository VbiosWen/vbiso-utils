package com.vbiso.structure.linked;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 3:31 PM 2019/4/18
 * @Modified By:
 */
public class LinkedNode {

  private String value;

  private LinkedNode linkedNode;

  public LinkedNode(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public LinkedNode getLinkedNode() {
    return linkedNode;
  }

  public void setLinkedNode(LinkedNode linkedNode) {
    this.linkedNode = linkedNode;
  }

  public static void main(String[] args) {
    LinkedNode linkedNode = new LinkedNode("1");
    linkedNode.setLinkedNode(new LinkedNode("2"));
    linkedNode.getLinkedNode().setLinkedNode(new LinkedNode("3"));

    print(linkedNode);

    LinkedNode pre = null;

    LinkedNode now = linkedNode;

    while (now != null) {
      LinkedNode next = linkedNode.linkedNode;
      now.linkedNode = pre;
      pre = now;
      now = next;

    }

    print(pre);

    print(linkedNode);

  }

  private static void print(LinkedNode linkedNode) {
    System.out.println(linkedNode.getValue());
    if (linkedNode.getLinkedNode() != null) {
      print(linkedNode.getLinkedNode());
    }
  }
}
