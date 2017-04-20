package behavior;

/**
 * Description: 状态模式 Status
 * <p>
 * 定义对象间1~n依赖关系,对象状态改变,其他依赖于它的对象都进行更新
 * 状态: 常用一个到多个Enum常量表示,用于解决有大量分支条件的状态
 *
 * 下面的案例并没有很好的展示状态模式的作用
 * <p>
 * Created by Chengjs on 2017/4/20 @version 1.0.
 */
public class StatusClient {
  public static void main(String[] args) {
    StatusContext context = new StatusContext();
    context.setWeather(new Sunshine());
    System.out.println(context.weatherMessage());
    System.out.println("======================");
    context.setWeather(new Rain());
    System.out.println(context.weatherMessage());
  }
}

class StatusContext {
  private Weather weather;

  public Weather getWeather() {
    return weather;
  }

  public void setWeather(Weather weather) {
    this.weather = weather;
  }

  public String weatherMessage() {
    return weather.getWeather();
  }
}

interface Weather {
  String getWeather();
}

class Rain implements Weather {

  public String getWeather() {
    return "下雨";
  }
}

class Sunshine implements Weather {

  public String getWeather() {
    return "阳光";
  }
}


