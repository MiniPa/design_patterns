package models.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 享元模式 FlyWeight, "租借工厂"--创建并借出对象
 * 通过共享对象减少系统中低等级的详细的对象数目
 *
 * 1.此例中相同参数从工厂中拿出来的对象是相同的,节约了资源. 同时也会产生问题
 *
 * 适用性:
 * 1.应用程序使用大量的对象
 * 2.对象数量巨大导致很高的存储开销
 * 3.程序不依赖于对象的身份
 *
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class FlyWeightClient {
  public static void main(String[] args) {
    FlyWeight f1 = FlyWeightFactory.getFlyWeight("a");
    f1.action(1);
    FlyWeight f2 = FlyWeightFactory.getFlyWeight("a");
    System.out.println(f1 == f2); //true
    FlyWeight f3 = FlyWeightFactory.getFlyWeight("b");
    f3.action(2);
    System.out.println(f1 == f3); //false
    FlyWeight f4 = FlyWeightFactory.getFlyWeight("c");
    f4.action(3);
    FlyWeight f5 = FlyWeightFactory.getFlyWeight("d");
    f5.action(4);
    System.out.println(FlyWeightFactory.getSize());
  }
  /*
    参数值:1
    true
    参数值:2
    false
    参数值:3
    参数值:4
    4
   *  */

}

interface FlyWeight {
  void action(int arg);
}

class FlyWeightImpl implements FlyWeight {

  public void action(int arg) {
    System.out.println("参数值:" + arg);
  }
}

class FlyWeightFactory {
  private static Map flyWeights = new HashMap();

  public FlyWeightFactory(String arg) {
    flyWeights.put(arg, new FlyWeightImpl());
  }

  public static FlyWeight getFlyWeight(String key) {
    if (flyWeights.get(key) == null) {
      flyWeights.put(key, new FlyWeightImpl());
    }
    return (FlyWeight) flyWeights.get(key);
  }

  public static int getSize() {
    return flyWeights.size();
  }
}








