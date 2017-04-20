package structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 享元模式 FlyWeight
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class FlyWeightClient {
  public static void main(String[] args) {
  FlyWeight f1 = FlyWeightFactory.getFlyWeight("a");
    f1.action(1);
  FlyWeight f2 = FlyWeightFactory.getFlyWeight("a");
    System.out.println(f1 == f2);
  FlyWeight f3 = FlyWeightFactory.getFlyWeight("b");
    f3.action(2);
    System.out.println(f1 == f3);
  FlyWeight f4 = FlyWeightFactory.getFlyWeight("c");
    f4.action(3);
  FlyWeight f5 = FlyWeightFactory.getFlyWeight("d");
    f5.action(4);
    System.out.println(FlyWeightFactory.getSize());
  }
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








