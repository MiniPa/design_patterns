package principle;

/**
 * Description 依赖倒置
 * Created by Chengjs on 2017/4/16.
 */
public class DependencyInversion {
  public static void main(String[] args) {
    Client.startUp();
  }
}
interface IReader { String getContent(); }

class NewsPaper implements IReader {
  public String  getContent() {
    return "this is a newsPaper";
  }
}

class Book implements IReader {
  public String getContent() {
    return "this is a Book";
  }
}

class Mother {
  public void narrate(IReader reader) {
    System.out.printf(reader.getContent());
  }
}

class Client {
  public static Mother mother = new Mother();
  public static void startUp() {
    mother.narrate(new Book());
    mother.narrate(new NewsPaper());
  };
}








