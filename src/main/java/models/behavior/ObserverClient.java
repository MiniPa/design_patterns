package models.behavior;

import java.util.Vector;

/**
 * Description: 观察者 Observer
 * 可用在多响应的场景中,方便安排不同观察者
 * 为组件向相关接收方提供广播消息提供了灵活的方法,定义了对象一到多的依赖关系
 *
 * 1.抽象了主体和Observer之间的耦合关系
 * 2.支持广播方式的通信
 *
 * 适用性:
 * 对一个对象的修改涉及对其他对象的修改,而不知道有多少对象需要进行相应的修改。
 * 对象应该能够在不用假设对象标识的前提下通知其他对象
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class ObserverClient {
  public static void main(String[] args) {
    SubJect sub = new ConcreteSubject();
    Observer ob1 = new ConcreteObserver1();
    Observer ob2 = new ConcreteObserver2();
    sub.attach(ob1);
    sub.attach(ob2);
    sub.doSomething();
  }
}

/*被观察者 Subject*/
abstract class SubJect {
  /*观察者引用*/
  private Vector<Observer> obs = new Vector<Observer>();
  public void attach(Observer obs) {
    this.obs.add(obs);
  }
  public void detach(Observer obs) {
    this.obs.remove(obs);
  }
  public void notifyObserver() {
    for (Observer ob : obs) {
      ob.update();
    }
  }
  public abstract void doSomething();
}
class ConcreteSubject extends SubJect {
  public void doSomething() {
    System.out.println("被观察者事件触发");
    this.notifyObserver();
  }
}

/*观察者 Observer*/
abstract class Observer {
  public abstract void update();
}
class ConcreteObserver1 extends Observer {
  public void update() {
    System.out.println("observer1 接到消息,做出对策");
  }
}
class ConcreteObserver2 extends Observer {
  public void update() {
    System.out.println("observer2 接到消息,做出对策");
  }
}



