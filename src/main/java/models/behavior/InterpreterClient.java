package models.behavior;

import java.util.Stack;

/**
 * Description: 解释器 Interpreter
 * 1.此种模式缺陷比较多: 容易引起类膨胀,递归性能也不是很好
 * 2.解释定义其语法表示的语言,还提供了用表示来解释语言中语句的解释器
 *
 * 容易修改并扩展语法
 * 更容易实现语法
 *
 * 实用性:
 * 语言的语法比较简单
 * 效率不是主要问题
 *
 *
 * Created by Chengjs on 2017/4/17 @version 1.0.
 */
public class InterpreterClient {
  public static void main(String[] args) {
    String expression = "";
    char[] chars = expression.toCharArray();
    InterpreterContext parserContext = new InterpreterContext();
    Stack<Expression> stack = new Stack<Expression>();
    for (int i = 0; i < chars.length; i++) {
      // 进行语法判断,递归调用
    }
    Expression exp = stack.pop();
    exp.interpreter(parserContext);
  }
}

class InterpreterContext { }

abstract class Expression { /*抽象解释器*/
  public abstract Object interpreter(InterpreterContext ctx); /*解释操作*/
}

class TerminalExpression extends Expression {
  @Override
  public Object interpreter(InterpreterContext ctx) {
    return null;
  }
}

class NonTerminalExpression extends Expression {
  public NonTerminalExpression() { }
  @Override
  public Object interpreter(InterpreterContext ctx) {
    return null;
  }
}
