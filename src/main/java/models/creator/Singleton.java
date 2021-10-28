package models.creator;

/**
 * Description: 单例模式 lazyModel
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class Singleton {
  private static Singleton singleton;
  private Singleton() {};
  public static synchronized Singleton getInstance() {
    /*问题: 可能会有多个线程同时进入此处?????*/
    if (singleton == null) {
      singleton = new Singleton();
    }
    return singleton;
  }
}

/**
 * Description: 单例模式 hungryModel
 */
class HungrySingleton {
  private static HungrySingleton singleton = new HungrySingleton();
  public static HungrySingleton getInstance() {
    return singleton;
  }
}

/**
 * Description: 单例模式 凯哥式样
 * ==> 建议使用,但是还存在bug，不记得是哪篇blog中提到的了
 */
class KaigeSingleton {
  private static KaigeSingleton kaigeSingleton;
  public static KaigeSingleton getSingeleton() {
    if (kaigeSingleton == null) {
      synchronized (KaigeSingleton.class) {
        if (kaigeSingleton == null) {
          kaigeSingleton = new KaigeSingleton();
        }
      }
    }
    return kaigeSingleton;
  }
}


















