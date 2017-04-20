package behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 迭代器 Iterator
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







