package dp.structure;

/**
 * Description: 桥接模式 Bridge
 *
 * 抽象部分和实现部分进行分离,可以独立变化
 * 使用"对象组合关系"解耦了抽象和实现之间固有的绑定关系,使之各自可以沿着各自的维度来变化
 *
 * 适用性：
 * 系统要在构件的抽象化角色和具体化角色间增加更多的灵活性.避免两层次间建立静态联系.
 * 实现角色改变对客户端是完全透明的(即实现化角色任何改变不应当影响客户端)
 * 构件有多于一个的抽象化角色和实现化角色,系统需要他们进行动态耦合
 *
 * 案例：精辟案例,比我这个案例要更深入一分
 * http://www.cnblogs.com/houleixx/archive/2008/02/23/1078877.html
 * 1.由于系统自身逻辑,具有2个或多个维度的变化,在不引入额外复杂度同时,沿着多个方向进行变化,此时使用Bridge
 * 2.不同的汽车泡在不同路上(不同人穿不同衣服)
 * 3.不同的人开不同的车跑在不同的路上(不同季节不同人穿不同衣服)
 *
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

  /**
   * 工厂方法来提供Clothing对象,避免产生人对衣服的强依赖关系
   */
  public void setClothing() {
    this.clothing = ClothingFactory.getClothing();
  }

  public Clothing getClothing() { return clothing; }

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

