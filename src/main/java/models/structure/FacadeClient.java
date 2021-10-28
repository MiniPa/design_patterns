package models.structure;

/**
 * Description: 外观模式 Facade
 *
 * 为子系统中一组接口提供一致的界面facede高层接口,增加系统易用性
 *
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class FacadeClient {
  public static void main(String[] args) {
    ServiceA sa = new ServiceAImpl();
    ServiceB sb = new ServiceBImpl();
    sa.methodA();
    sb.mehtodB();
    System.out.println("================");
    Facade facede = new Facade();
    facede.methodA();
    facede.methodB();
  }
}

/**
 * 定义一个高级的接口/类
 */
class Facade {
  ServiceA sa;
  ServiceB sb;
  ServiceC sc;

  public Facade() {
    this.sa = new ServiceAImpl();
    this.sb = new ServiceBImpl();
    this.sc = new ServiceCImpl();
  }

  public void methodA() {
    sa.methodA();
    sb.mehtodB();
  }
  public void methodB() {
    sb.mehtodB();
    sc.methodC();
  }
  public void methodC() {
    sc.methodC();
    sa.methodA();
  }
}

interface ServiceA {
  public void methodA();
}

interface ServiceB {
  public void mehtodB();
}

interface ServiceC {
  public void methodC();
}

class ServiceAImpl implements ServiceA {

  public void methodA() {
    System.out.println("这是服务A");
  }
}

class ServiceBImpl implements ServiceB {

  public void mehtodB() {
    System.out.println("这里是服务B");
  }
}

class ServiceCImpl implements ServiceC {

  public void methodC() {
    System.out.println("这里是服务C");
  }
}



