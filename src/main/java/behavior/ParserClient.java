package behavior;

import java.util.Stack;

/**
 * Description: 解释器 Parser
 * 此种模式缺陷比较多: 容易引起类膨胀,递归性能也不是很好
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class ParserClient {
  public static void main(String[] args) {
    String expression = "";
    char[] chars = expression.toCharArray();
    ParserContext parserContext = new ParserContext();
    Stack<Expression> stack = new Stack<Expression>();
    for (int i = 0; i < chars.length; i++) {
      // 进行语法判断,递归调用
    }
    Expression exp = stack.pop();
    exp.interpreter(parserContext);
  }
}

class ParserContext { }

abstract class Expression { /*抽象解释器*/
  public abstract Object interpreter(ParserContext ctx); /*解释操作*/
}

class TerminalExpression extends Expression {
  @Override
  public Object interpreter(ParserContext ctx) {
    return null;
  }
}

class NonTerminalExpression extends Expression {
  public NonTerminalExpression() { }
  @Override
  public Object interpreter(ParserContext ctx) {
    return null;
  }
}
