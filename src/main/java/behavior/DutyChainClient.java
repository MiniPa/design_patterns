package behavior;

/**
 * Description: 责任链 DutyChain
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
    Response response = h1.hanleRequest(new Request(new Level(2)));
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













