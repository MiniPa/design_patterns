package models.behavior;

/**
 * Description: 备忘录/日志 Memento ---- 单状态备份
 *
 * 缺陷: 多状态,多备份消耗资源严重, 需要提供回滚操作的需求类型
 * 自己思考 ---- 多状态备份
 *
 * 1.保持封装的完整性
 * 2.简化回到初始状态所需的操作
 *
 * 适用性:
 * 1.必需保存对象的快照,这样可以回复快照
 * 2.使用接口来获得状态可能会公开对象的实现细节,从而破坏对象的封装性
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class MementoClient {
  public static void main(String[] args) {
    Originator originator = new Originator();
    originator.setState("状态1");
    System.out.println("初始状态" + originator.getState());
    Caretaker caretaker = new Caretaker();
    caretaker.setMemento(originator.createMemento());

    originator.setState("状态2");
    System.out.println("中间状态" + originator.getState());

    originator.restoreMemento(caretaker.getMemento());
    System.out.println("恢复后状态" + originator.getState());

  }
}

/**
 * 发起人: 记录当前系统内部状态,定义属于备份的范围,负责创建和恢复状态
 */
class Originator {
  private String state = "";

  public Memento  createMemento() {
    return new Memento(this.state);
  }

  public void restoreMemento(Memento memento) {
    this.setState(memento.getState());
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}

/**
 * 负责存储和提供发起人内部的状态
 */
class Memento {
  private String state = "";

  public Memento(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}

/**
 * 备忘录管理员角色
 */
class Caretaker {
  private Memento memento;

  public Memento getMemento() {
    return memento;
  }

  public void setMemento(Memento memento) {
    this.memento = memento;
  }
}







