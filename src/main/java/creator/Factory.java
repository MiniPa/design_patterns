package creator;

/**
 * Description: 工厂模式
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
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

