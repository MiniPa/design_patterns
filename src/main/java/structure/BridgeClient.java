package structure;

/**
 * Description: 桥接模式 Bridge
 *
 * 抽象部分和实现部分进行分离,可以独立变化
 * 1.
 *
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class BridgeClient {
  public static void main(String[] args) {
    Person man = new Man();
    Person lady = new Lady();
    Clothing jacket = new Jacket();
    Clothing trouser = new Trousers();
    trouser.personDressCloth(lady);
    jacket.personDressCloth(man);
  }
}

class Clothing {
  private Clothing clothing;

  /**
   * 穿衣服方法放在Clothing中,从而实现在Person的Clothing参数中放入适合的衣服
   * @param person
   */
  public void personDressCloth(Person person) {
    person.setClothing();
  }

  public Clothing getClothing() {
    return clothing;
  }

  public void setClothing(Clothing clothing) {
    this.clothing = clothing;
  }
}

class ClothingFactory {
  private static Clothing clothing;

  public static Clothing getClothing() {
    return clothing;
  }

  public void setClothing(Clothing clothing) {
    this.clothing = clothing;
  }

}

abstract class Person {
  private Clothing clothing;
  private String type;

  public abstract void dress();

  public Clothing getClothing() {
    return clothing;
  }

  /**
   * 此处使用工厂方法来提供Clothing对象,避免产生人对衣服的强依赖关系
   */
  public void setClothing() {
    this.clothing = ClothingFactory.getClothing();
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}

class Man extends Person {
  public Man() {
    setType("男人");
  }

  public void dress() {
    Clothing clothing = getClothing();
    clothing.personDressCloth(this);
  }
}

class Lady extends Person {
  public Lady() {
    setType("女人");
  }

  public void dress() {
    Clothing clothing = getClothing();
    clothing.personDressCloth(this);
  }
}

class Jacket extends Clothing {
  @Override
  public void personDressCloth(Person person) {
    System.out.println(person.getType() + " 穿马甲");
  }
}
class Trousers extends Clothing {
  @Override
  public void personDressCloth(Person person) {
    System.out.println(person.getType() + " 穿裤子");
  }
}

