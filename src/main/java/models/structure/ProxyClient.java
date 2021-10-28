package models.structure;

/**
 * Description: 代理模式 Proxy
 * 1.扩展 spring中的AOP等技术都是采用的动态代理,非常常见
 *
 * 为其他对象提供代理,以控制对这个对象的访问
 *
 * 1.RemoteProxy:为对象在不同的地址空间提供局部代表      --权限
 * 2.VirtualProxy:根据需要创建开销非长大的对象          --资源
 * 3.ProtectionProxy:控制原始对象的访问                --安全
 * 4.SmarkReference:取代简单指针,访问对象时执行附加操作  --控制
 *
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class ProxyClient {
  public static void main(String[] args) {
    Object obj = new ProxyObject();
    obj.action();
    Object obj2 = new ObjectImpl();
    obj2.action();
  }
}

interface Object {
  void action();
}

class ObjectImpl implements Object {

  public void action() {
    System.out.println("这是被代理类");
  }
}

class ProxyObject implements Object {
  Object obj;

  public ProxyObject() {
    System.out.println("这是代理类");
    obj = new ObjectImpl();
  }

  public void action() {
    System.out.println("代理开始");
    obj.action();
    System.out.println("代理结束");
  }
}





