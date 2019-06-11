package com.vbiso.leetcode;

import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:04 PM 2019/4/20
 * @Modified By:
 */
public class LineNodeSum {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    void insert(int val, ListNode root) {
      ListNode listNode = new ListNode(val);
      if (root.next == null) {
        root.next = listNode;
      }
      ListNode next = root;
      while (next != null) {
        next = next.next;
      }
    }
  }

  @Test
  public void testLinkNodeSum() {

    ListNode listNode = new ListNode(2);
    listNode.next = new ListNode(4);
    listNode.next.next = new ListNode(3);
    ListNode listNode1 = new ListNode(5);
    listNode1.next = new ListNode(6);
    listNode1.next.next = new ListNode(4);
    addTwoNumbers(listNode, listNode1);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode listNode = new ListNode(0);
    ListNode curr = listNode;
    ListNode p1 = l1;
    ListNode p2 = l2;
    int carray = 0;
    while (p1 != null || p2 != null) {
      int x = (p1 != null) ? p1.val : 0;
      int y = (p2 != null) ? p2.val : 0;
      int sum = carray + x + y;
      carray = sum / 10;
      if (p1 != null) {
        p1 = p1.next;
      }
      if (p2 != null) {
        p2 = p2.next;
      }
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
    }
    if (carray > 0) {
      curr.next = new ListNode(carray);
    }
    return listNode.next;
  }

}
