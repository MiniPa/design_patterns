package creator;

/**
 * Description: Builder 建造者
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
abstract class Builder {
  public abstract void setPart(String arg1, String arg2);
  public abstract ProductB getProduct();
}
class ConcreteBuilder extends Builder {
  private ProductB productB = new ProductB();
  public void setPart(String arg1, String arg2) {
    productB.setName(arg1);
    productB.setType(arg2);
  }
  public ProductB getProduct() {
    return productB;
  }
}

class Director {
  public Builder builder;

  public ProductB getAProduct() {
    builder = new ConcreteBuilder();
    builder.setPart("宝马", "A6");
    return builder.getProduct();
  }
  public ProductB getBProduct() {
    builder = new ConcreteBuilder();
    builder.setPart("奥迪","A8");
    return builder.getProduct();
  }

  public static void main(String[] args) {
    Director director = new Director();
    ProductB productB = director.getBProduct();
    ProductB productA = director.getAProduct();
    productA.show();
    productB.show();
  }
}

class ProductB {
  private String name;
  private String type;
  public void show() {
    System.out.println("名称" + name);
    System.out.println("型号" + type);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
