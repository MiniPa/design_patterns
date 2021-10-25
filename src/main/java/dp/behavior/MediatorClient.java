package dp.behavior;

/**
 * Description: 中介模式 Mediator
 * 引入一个能够管理对象间消息分布的对象,简化系统中对象间的通信
 * 1.去除对象间影响,简化对象间协议
 * 2.控制集中化,单个组件更加简单,容易处理
 * 3.不在包含处理组件间通信的逻辑,组件变得更加通用
 *
 * 适用性:
 * 对象集合需要以一个定义规范但复杂的方式通信
 * 想要在不使用子类的情况下,自定义分布在几个对象之间的行为
 *
 * TODO 不知道好处在哪里,哪里可以使用到这种模式.
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class MediatorClient {
  public static void main(String[] args) {
    AbstractColleague colleagueA = new ColleagueA();
    AbstractColleague colleagueB = new ColleagueB();
    AbstractMediator mediator = new Mediator(colleagueA, colleagueB);
    System.out.println("======设置A影响B=========");
    colleagueA.setNum(100, mediator);
    System.out.println(colleagueA.getNum() + "" +colleagueB.getNum());
    colleagueB.setNum(500,mediator);
    System.out.println(colleagueA.getNum() + "" +colleagueB.getNum());
  }
}

abstract class AbstractColleague {
  int num;
  int getNum() {
    return num;
  }
  void setNum(int num) {
    this.num = num;
  }
  public abstract void setNum(int num, AbstractMediator am);
}

class ColleagueA extends AbstractColleague {
  @Override
  public void setNum(int num, AbstractMediator am) {
    this.num = num;
    am.AaffectB();
  }
}

class ColleagueB extends AbstractColleague {
  public void setNum(int num, AbstractMediator am) {
    this.num = num;
    am.BaffectA();
  }
}

abstract class AbstractMediator {
  protected AbstractColleague A;
  protected AbstractColleague B;
  public AbstractMediator(AbstractColleague a, AbstractColleague b) {
    A = a;
    B = b;
  }
  public abstract void AaffectB();
  public abstract void BaffectA();
}

class Mediator extends AbstractMediator {
  public Mediator(AbstractColleague a, AbstractColleague b) {
    super(a, b);
  }
  @Override
  public void AaffectB() {
    int num = A.getNum();
    B.setNum(num*100);
  }
  @Override
  public void BaffectA() {
    int num = B.getNum();
    A.setNum(num/100);
  }
}





