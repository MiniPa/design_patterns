package dp.behavior;

/**
 * Description: 命令模式 Command
 * 在对象中封装了请求,则可以保存命令。将该命令传递给方法以及像任何其他对象一样返回命令。
 *
 * 1.分离调用操作的对象和知道如何完成该操作的对象
 * 2.容易扩展添加新命令
 *
 * 适用性:
 * 1.想要通过要执行的动作来参数化对象
 * 2.要在不同的时间制定、排序以及执行请求
 * 3.必须支持Undo,日志记录或事务
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class CommandClient {
  public static void main(String[] args) {
    Reciver reciver = new Reciver();
    ConcreteCommand command = new ConcreteCommand(reciver);
    command.execute();

    Invoker invoker = new Invoker(command);
    invoker.action();
  }
}

/**
 * 调用者
 */
class Invoker {
  private Command command;
  public Invoker(Command command) {
    this.command = command;
  }
  public void action() {
    this.command.execute();
  }
}

/**
 * 命令/操作
 */
abstract class Command {
  public abstract void execute();
}
class ConcreteCommand extends Command {
  private Reciver reciver;
  public ConcreteCommand(Reciver reciver) {
    this.reciver = reciver;
  }
  public void execute() {
    this.reciver.doSomething();
  }
}

/**
 * 执行者
 */
class Reciver {
  public void doSomething() {
    System.out.println("reciever 接到命令 执行逻辑处理");
  }
}