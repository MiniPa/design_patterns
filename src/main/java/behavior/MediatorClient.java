package behavior;

/**
 * Description: 中介模式 Mediator
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





