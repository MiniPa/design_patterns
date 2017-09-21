package structure;

/**
 * AdapterClient: 适配器 Adapter
 * 改变类的接口以适应不同接口兼容性问题
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-04-08
 **/
public class AdapterClient {
  public static void main(String[] args) {
    Target target = new Adapter(new Adaptee());
    target.adapteeMethod();
    target.adapterMethod();
  }
}

/**
 * 对Adaptee的接口进行适配
 */
class Adapter implements Target {
  private Adaptee adaptee;

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  public void adapteeMethod() {
    adaptee.adapteeMethod();
  }

  public void adapterMethod() {
    System.out.println("Adapter Method()");
  }
}

/**
 * 希望协同工作的目标接口
 */
interface Target {
  void adapteeMethod();
  void adapterMethod();
}

/**
 * 目前存在的需要适配的原接口/类
 */
class Adaptee {
  public void adapteeMethod() {
    System.out.println("Adaptee Method()");
  }
}
