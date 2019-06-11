package com.vbiso.concurent.proxy.entity;

import java.util.Collections;
import net.sf.cglib.beans.BeanCopier;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:35 PM 2019/4/12
 * @Modified By:
 */
public class Haha1 {

  private Person person;


  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public static void main(String[] args){

    BeanCopier copier = BeanCopier.create(Haha1.class,Haha2.class,true);
    Haha1 source = new Haha1();
    Person person = new Person();
    Child child = new Child();
    child.setCode("1");
    child.setType("hah");
    person.setChildren(Collections.singletonList(child));
    Parent parent = new Parent();
    parent.setName("father");
    parent.setSex("haha");
    person.setParents(Collections.singletonList(parent));

    GrandFather grandFather = new GrandFather();
    grandFather.setDesc("test");
    grandFather.setType("haha");

    person.setGrandFathers(Collections.singletonList(grandFather));

    source.setPerson(person);

    Haha2 haha2 = new Haha2();
    copier.copy(source, haha2, (value, target, context) -> {
      if(target.equals(Integer.TYPE)){

        return new Integer(((Number)value).intValue() + 1);
      }
      return value;
    });

    System.out.println(haha2);
    System.out.println(haha2.getPerson());
    System.out.println(haha2.getPerson().getChildren());
  }
}
