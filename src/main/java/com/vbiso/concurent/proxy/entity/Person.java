package com.vbiso.concurent.proxy.entity;

import java.util.List;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:32 PM 2019/4/12
 * @Modified By:
 */
public class Person {


  private List<GrandFather> grandFathers;

  private List<Parent> parents;

  private List<Child> children;

  public List<GrandFather> getGrandFathers() {
    return grandFathers;
  }

  public void setGrandFathers(List<GrandFather> grandFathers) {
    this.grandFathers = grandFathers;
  }

  public List<Parent> getParents() {
    return parents;
  }

  public void setParents(List<Parent> parents) {
    this.parents = parents;
  }

  public List<Child> getChildren() {
    return children;
  }

  public void setChildren(List<Child> children) {
    this.children = children;
  }
}
