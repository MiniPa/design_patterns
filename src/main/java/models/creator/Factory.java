package models.creator;

/**
 * Factory: 工厂模式(最常用) 一个具体的工厂与固定的产品耦合
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-04-08
 **/
public class Factory implements IFactory {
  public IProduct createProduct() {
    return new Product();
  }
}

interface IFactory {
  IProduct createProduct();
}

interface IProduct {
  void productMethod();
}

class Product implements IProduct {
  public void productMethod() {
    System.out.println("产品");
  }
}

class Client {
  public static void main(String[] args) {
    IFactory factory = new Factory();
    IProduct product = factory.createProduct();
    product.productMethod();
  }
}

