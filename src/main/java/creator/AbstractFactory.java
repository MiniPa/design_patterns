package creator;

/**
 * AbstractFactory: 抽象工厂,一个工厂创建不同的产品,但具体工厂和具体的产品还是耦合的
 *  感觉和Factory并没有什么实质区别,新增不同类型的产品还是需要修改Factory类
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-03-08
 **/
public class AbstractFactory {
  public static void main(String[] args) {
    Factory1 factory = new Factory1();
    factory.createProduct1().show();
    factory.createProduct2().show();
  }
}

interface IProduct1 {
  public void show();
}
interface IProduct2 {
  public  void show();
}
class Product1 implements IProduct1 {
  public void show() {
    System.out.println("this is Product1");
  }
}
class Product2 implements IProduct2 {
  public void show() {
    System.out.println("this is Product2");
  }
}

interface IFactory1 {
  public IProduct1 createProduct1();
  public IProduct2 createProduct2();
}
class Factory1 implements IFactory1 {
  public IProduct1 createProduct1() {
    return new Product1();
  }
  public IProduct2 createProduct2() {
    return new Product2();
  }
}
