package behavior;

import java.util.Vector;

/**
 * Description: 观察者 Observer
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



