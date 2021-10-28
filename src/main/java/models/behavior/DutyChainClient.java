package models.behavior;

/**
 * Description: 责任链 Chian of Responsibility
 *
 * 1.臆想的替代方案：不同等级的请求,在实际操作中用if判断然后分别调用不同的handler来处理
 *   不也非常方便么.
 * 2.在责任链条环节非常多,数量和顺序经常变动. 以及链条传递条件复杂情况下,普通的if判断形式将会导致代码非常复杂,
 *   不容易变动,此时使用责任链还是比较适合的。
 * 3.注意：普通的业务逻辑使用简单条件判断即可,责任链在判断逻辑,和流程处理上边进行了易于扩展的处理
 *
 * 增加向对象指定责任的灵活性
 * 在一个类中产生的事件可以被发送到组成中的其他类处理器上,类的集合可作为一个整体
 *
 * 适用性:
 * 多个对象可以处理一个请求,而其处理器确是未知的
 * 在不指定确切的请求接收对象情况下,向几个对象中的一个发送请求
 * 动态的指定能够处理请求的对象集
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class DutyChainClient {
  public static void main(String[] args) {
    Handler h1 = new ConcreteHandler1();
    Handler h2 = new ConcreteHandler2();
    Handler h3 = new ConcreteHandler3();
    /*设置处理器等级链接*/
    h1.setNextHandler(h2);
    h2.setNextHandler(h3);
    Response response = h1.hanleRequest(new Request(new Level(3)));
  }
}

class Level {
  private int level = 0;
  public Level(int level) {
    this.level = level;
  }
  public boolean above(Level level) {
    if (this.level >= level.level) {
      return true;
    }
    return false;
  }
}

class Request {
  Level level;
  public Request(Level level) {
    this.level = level;
  }
  public Level getLevel() {
    return level;
  }
}
class Response { }
abstract class Handler {
  private Handler nextHandler;
  public final Response hanleRequest(Request request) {
    Response response = null;
    if (this.getHandlerLevel().above(request.getLevel())) {
      response = this.response(request);
    } else {
      if (this.nextHandler != null) {
        this.nextHandler.hanleRequest(request);
      } else {
        System.out.println("没有合适的处理器一");
      }
    }
    return response;
  }
  public void setNextHandler(Handler handler) {
    this.nextHandler = handler;
  }
  protected abstract Level getHandlerLevel();
  public abstract Response response(Request request);
}
class ConcreteHandler2 extends Handler{
  protected Level getHandlerLevel() {
    return new Level(2);
  }
  public Response response(Request request) {
    System.out.println("请求由处理器2处理");
    return null;
  }
}
class ConcreteHandler1 extends Handler{
  protected Level getHandlerLevel() {
    return new Level(1);
  }
  public Response response(Request request) {
    System.out.println("请求由处理器1处理");
    return null;
  }
}
class ConcreteHandler3 extends Handler{
  protected Level getHandlerLevel() {
    return new Level(3);
  }
  public Response response(Request request) {
    System.out.println("请求由处理器3处理");
    return null;
  }
}













