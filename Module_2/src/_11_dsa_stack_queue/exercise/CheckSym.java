package _11_dsa_stack_queue.exercise;

import java.util.Stack;

public class CheckSym {

    public static boolean check(String[] string) {
        Stack<String> stack = new Stack<>();
        for (String sym : string) {
            if (sym.equals("(")) {
                stack.push(sym);
            } else if (sym.equals(")")) {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] string = "s * (s – a) * s – b) * (s – c)  ".split("");
        System.out.println(check(string));
    }
}
