package behavior;

/**
 * Description: 命令模式 CommandModel
 * 不明所以,没有找到合适的案例来说明
 * 理解： 将命令和命令接收者进行解耦合,各自规范他们的元,在各种命令编程的模型中,还是有用处的。
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

class Invoker {
  private Command command;
  public Invoker(Command command) {
    this.command = command;
  }
  public void action() {
    this.command.execute();
  }
}
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
class Reciver {
  public void doSomething() {
    System.out.println("reciever 接到命令 执行逻辑处理");
  }
}