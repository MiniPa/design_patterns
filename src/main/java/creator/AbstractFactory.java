package creator;

/**
 * Description: 抽象工厂
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class AbstractFactory {
  public static void main(String[] args) {
    Factory1 factory = new Factory1();
    factory.createProduct1().show();
    factory.createProduct2().show();
  }
}

interface IProduct1 {
  void show();
}
interface IProduct2 {
  void show();
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
  IProduct1 createProduct1();
  IProduct2 createProduct2();
}
class Factory1 implements IFactory1 {
  public IProduct1 createProduct1() {
    return new Product1();
  }
  public IProduct2 createProduct2() {
    return new Product2();
  }
}
