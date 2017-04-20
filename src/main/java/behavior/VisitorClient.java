package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description: 访问者 Visitor
 *
 * 封装易变操作到visitor中去
 * abstract visitor define which elements can be visited -- difficult to add new elements
 * visitor attach more actions to element
 * abstract element announce which visitor available
 * visitor.visit(this)
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class VisitorClient {
  public static void main(String[] args) {
    List<Element> list = ObjectStructure.getList();
    for (Element element : list) {
      element.accept(new Visitor());
    }
  }
}

interface IVisitor {
  /*visitor 中定义那些对象可以被访问*/
  public void visit(ConcreteElement1 el1);
  public void visit(ConcreteElement2 el2);
}
class Visitor implements IVisitor {
  public void visit(ConcreteElement1 el1) {
    el1.doSomething();
    System.out.println("visitor of el1 doSomething");
    /*访问者让被访问的元素干活, && 元素中封装在访问者中的操作 -------------- 关键点*/
  }
  public void visit(ConcreteElement2 el2) {
    el2.doSomething();
    System.out.println("visitor of el2 doSomething");
  }
}

abstract class Element {
  public abstract void accept(IVisitor visitor);
  /*本身业务逻辑*/
  public abstract void doSomething();
}
class ConcreteElement1 extends Element {
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
  public void doSomething() {
    System.out.println("这是元素1");
  }
}
class ConcreteElement2 extends Element {
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
  public void doSomething() {
    System.out.println("这是元素2");
  }
}

/**
 * 结构对象 包含元素的容器
 */
class ObjectStructure {
  public static List<Element> getList() {
    List<Element> list = new ArrayList<Element>();
    Random random = new Random();
    for (int i = 0; i < 5; i++) {
      int a = random.nextInt(100);
      if (a > 50) {
        list.add(new ConcreteElement1());
      } else {
        list.add(new ConcreteElement2());
      }
    }
    return list;
  }
}





