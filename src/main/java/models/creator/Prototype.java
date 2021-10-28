package models.creator;

import java.util.ArrayList;

/**
 * Description: 原型模式 需要 deep clone()
 *  适用于大的对象,特殊情况下使用。
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class Prototype implements Cloneable {
  private ArrayList list = new ArrayList();

  protected Object clone() {
    Prototype prototype = null;
    try {
      prototype = (Prototype) super.clone();
      prototype.list = (ArrayList) this.list.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return prototype;
  }
}

