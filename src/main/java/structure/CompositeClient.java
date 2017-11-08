package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 组合模式 Composite
 *
 * 允许创建树形结构来改变复杂性,同时允许结构中每一元素操作同一接口。
 * 使得整体和部分对用户是用来说具有一致性(即允许客户使用单个对象或多个同一对象组合)
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







