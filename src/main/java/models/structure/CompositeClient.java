package models.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 组合模式 Composite
 *
 * 允许创建树形结构来改变复杂性,同时允许结构中每一元素操作同一接口。
 * 使得整体和部分对用户是用来说具有一致性(即允许客户使用单个对象或多个同一对象组合)
 *
 * 1.定义了主要由对象和复合对象组成的类层次结构
 * 2.添加新的组件类型更简单
 * 3.提供结构的灵活性和可管理的接口
 *
 * 适用性:
 * 1.想要表示对象的整个或者部分的层次结构
 * 2.想客户端忽略单个对象和复合对象的差异
 * 3.结构可以具有任何级别的复杂性,并且可以是动态的
 *
 *
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class CompositeClient {
  public static void main(String[] args) {
    Employer pm = new Programer("项目经理");
    Employer pa = new ProjectAssistant("项目助理");
    Employer p1 = new Programer("程序员1");
    Employer p2 = new Programer("程序员2");
    pm.add(pa);
    pm.add(p2);
    List<Employer> employers = pm.getEmployers();
    for (Employer employer : employers) {
      /*打印项目经理的直属下级*/
      System.out.println(employer.getName());
    }
  }
}

abstract class Employer {/*组合中对象申明的接口*/
  private String name;
  public List<Employer> employers;

  public abstract void add(Employer employer);
  public abstract void delete(Employer employer);

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Employer> getEmployers() {
    return employers;
  }

  public void setEmployers(List<Employer> employers) {
    this.employers = employers;
  }
}

class Programer extends Employer { /*Leaf对象*/
  public Programer(String name) {
    setName(name);
    employers = new ArrayList<>(); /*表示程序员没有下属了*/
  }

  public void add(Employer employer) {
    employers.add(employer);
  }

  public void delete(Employer employer) {
    employers.remove(employer);
  }
}

class ProjectAssistant extends Employer {
  public ProjectAssistant(String name) {
    setName(name);
    employers = null;
  }

  public void add(Employer employer) {
    employers.add(employer);
  }

  public void delete(Employer employer) {
    employers.remove(employer);
  }
}

class ProjectManager extends Employer {
  public ProjectManager(String name) {
    setName(name);
    employers = new ArrayList<Employer>();
  }

  public void add(Employer employer) {
    employers.remove(employer);
  }

  public void delete(Employer employer) {
    employers.remove(employer);
  }
}







