package behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 迭代器 Iterator
 * 为集合中的有序访问提供一致性的方法,并且该集合独立于基础集合,并与之分离
 *
 * 支持集合的不同遍历,简化集合的接口
 * 适用性:
 * 在不开放集合对象内部表示的前提下,访问集合对象内容
 * 支持集合对象的多重遍历
 * 为遍历集合中不同结构提供一个统一的接口
 *
 * 1.此例是在集合基础上封装一个新对象Aggregate,并令其拥有迭代器的功能。
 * 2.疑问：直接调用其内部list,进行遍历处理不也能够达到同样的效果? 为啥要折腾搞这么一套。
 * 3.可能解答：这样封装有助于处理多线程,如果要将此类型的处理改为线程安全的,这种模式是需要使用的 TODO 证明给我看
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class IteratorClient {
  public static void main(String[] args) {
    Aggregate aggregate = new ConcreteAggregate();
    aggregate.add("小明");
    aggregate.add("小红");
    aggregate.add("小兰");
    Iterator iterator = aggregate.iterator();
    while (iterator.hasNext()) {
      String str = (String) iterator.next();
      System.out.println(str);
    }
  }
}

interface Iterator {
  public Object next();
  public boolean hasNext();
}

class ConcreteIterator implements Iterator {
  private List list = new ArrayList();
  private int cursor = 0;
  public ConcreteIterator(List list) {
    this.list = list;
  }
  public Object next() {
    Object obj = null;
    if (this.hasNext()) {
      obj = this.list.get(cursor++);
    }
    return obj;
  }
  public boolean hasNext() {
    if (cursor == list.size()) {
      return false;
    }
    return true;
  }
}

interface Aggregate {
  public void add(Object obj);
  public void remove(Object obj);
  public Iterator iterator();
}

class ConcreteAggregate implements Aggregate {
  private List list = new ArrayList();
  public void add(Object obj) {
    list.add(obj);
  }
  public void remove(Object obj) {
    list.remove(obj);
  }
  public Iterator iterator() {
    return new ConcreteIterator(list);
  }
}







