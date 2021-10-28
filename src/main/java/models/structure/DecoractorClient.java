package models.structure;

/**
 * Description: 装饰模式 Decoractor
 *
 * 动态给一个对象添加额外职责(即动态添加/删除功能,但不能修改对象外观和功能),模式上比生成子类更加灵活
 * 用一种对客户端来说是透明的方法来修改对象的功能
 *
 * 装饰A + 人 => 装饰A者
 * 装饰B + 装饰A者 => 装饰B者
 * 装饰B者.eat() => 装饰A者.eat() => 在不同装饰者中将会执行不同装饰者执行的不同装饰任务
 * 所有装饰者都是人, 穿一层衣服的人,穿多层衣服的人,装饰了多少,没层装饰都会起作用的
 *
 * 1.比静态继承具有更大灵活性
 * 2.避免特征装载类处于层次级别过高级别
 * 3.改进对象扩展性
 * 4.简化编码,新写的修饰类都单独针对一个功能,无需将所有的行为编码到一个对象中
 *
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class DecoractorClient {
  public static void main(String[] args) {
    DMan man = new DMan();
    ManDecoratorA manDecoratorA = new ManDecoratorA();
    ManDecoratorB manDecoratorB = new ManDecoratorB();
    ManDrinkDecorator dd = new ManDrinkDecorator();

    manDecoratorA.setPerson(man);
    manDecoratorB.setPerson(manDecoratorA);
    dd.setPerson(manDecoratorB);
    dd.eat();
  }
}

interface DPerson {
  void eat();
}

class DMan implements DPerson {
  public void eat() {
    System.out.println("最初要干的事情: 男人在吃饭");
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
    System.out.println("===================");
    System.out.println("ManDecoratorA类装饰");
    reEat();
  }

  private void reEat() {
    System.out.println("装饰A 再吃一顿面条");
  }
}

class ManDecoratorB extends Decorator {
  @Override
  public void eat() {
    super.eat();
    System.out.println("===================");
    System.out.println("ManDecoratorB类装饰");
    reEat();
  }

  private void reEat() {
    System.out.println("装饰B 再喝一碗汤");
  }
}

class ManDrinkDecorator extends Decorator {
  @Override
  public void eat() {
    super.eat();
    System.out.println("===================");
    System.out.println("ManDrinkDecorator类装饰");
    reEat();
  }

  private void reEat() {
    System.out.println("装饰Drink 喝瓶汽水");
  }
}







