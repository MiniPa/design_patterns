package structure;

/**
 * Description: 装饰模式 Decoractor
 *
 * 动态给一个对象添加额外职责,模式上比生成子类更加灵活
 *
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class DecoractorClient {
  public static void main(String[] args) {
    DMan man = new DMan();
    ManDecoratorA manDecoratorA = new ManDecoratorA();
    ManDecoratorB manDecoratorB = new ManDecoratorB();

    manDecoratorA.setPerson(man);
    manDecoratorB.setPerson(manDecoratorA);
    manDecoratorB.eat();
  }
}

interface DPerson {
  void eat();
}

class DMan implements DPerson {
  public void eat() {
    System.out.println("男人在吃饭");
  }
}

abstract class Decorator implements DPerson {
  protected DPerson person;

  public void eat() {
    person.eat();
  }

  public DPerson getPerson() {
    return person;
  }

  public void setPerson(DPerson person) {
    this.person = person;
  }
}

class ManDecoratorA extends Decorator {
  @Override
  public void eat() {/*这里看出 装饰是通过子类重写父类方法 来实现增加额外功能的*/
    super.eat();
    reEat();
    System.out.println("ManDecoratorA类装饰");
  }

  private void reEat() {
    System.out.println("再吃一顿饭");
  }
}

class ManDecoratorB extends Decorator {
  @Override
  public void eat() {
    super.eat();
    System.out.println("===================");
    System.out.println("ManDecoratorB类装饰");
  }
}







