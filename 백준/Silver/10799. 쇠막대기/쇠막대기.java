
import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    String input = br.readLine();
    char[] brackets = input.toCharArray();
    int leftC = 0;
    int res = 0;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < brackets.length; i++) {
      if (i < brackets.length-1 && brackets[i] == '(' && brackets[i+1] == ')') {
        res += leftC;
        i++;
        continue;
      }
      if (brackets[i] == '(') {
        stack.push('(');
        leftC++;
      } else if (!stack.isEmpty() && stack.peek() == '('){
        leftC--;
        res++;
      }
    }
    bw.write(String.valueOf(res));
    bw.flush();
    br.close();
    bw.close();
  }
}
