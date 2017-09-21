package creator;

/**
 * Builder: 建造者,根据参数来构建不同的产品
 *  1.新增B不同参数产品时候,修改Director类即可(可配置)
 *  2.新增产品A,继承产品接口,创建A的Director类来进行处理
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-04-08
 **/
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
    builder.setPart("奥迪", "A8");
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
