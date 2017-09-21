package behavior;

/**
 * Description: 策略模式 Strategy
 *
 * 1.和命令模式非常像,将具体操作封装在策略中,由上下文具体决定执行何种策略,感觉和命令模式一般无二
 * 2.都是对行为和动作的封装,感觉和函数一样,勾引不了我使用的兴趣 -- 不就是封装么?
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class StrategyClient {
  public static void main(String[] args) {
    Context context;
    System.out.println("执行策略1================>>");
    context = new Context(new ConcreteStrategy1());
    context.execute();
    System.out.println("执行策略2================>>");
    context = new Context(new ConcreteStrategy2());
    context.execute();
  }
}
interface IStrategy {
  public void doSomething();
}
class ConcreteStrategy1 implements IStrategy {
  public void doSomething() {
    System.out.println("具体策略1");
  }
}
class ConcreteStrategy2 implements IStrategy {
  public void doSomething() {
    System.out.println("具体策略2");
  }
}
class Context {
  private IStrategy strategy;
  public Context(IStrategy strategy) {
    this.strategy = strategy;
  }
  public void execute() {
    strategy.doSomething();
  }
}












