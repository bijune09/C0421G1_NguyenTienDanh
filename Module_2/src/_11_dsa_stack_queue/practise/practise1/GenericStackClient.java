package _11_dsa_stack_queue.practise.practise1;

public class GenericStackClient {
    private static void stackOfStrings(){
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("five");
        stack.push("six");
        stack.push("seven");
        stack.push("three");
        stack.push("two");
        stack.push("one");
        System.out.println("1.1 Size of stack after push operations: "+stack.size());
        System.out.println("1.2 Pop elements from stack: ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("1.3. Size of stack after pop operations: "+stack.size()+"\n");
    }
    private static void stackOfIntegers(){
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("2.1 Size of stack after push operations: "+stack.size());
        System.out.println("2.2 Pop elements from stack: ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("2.3. Size of stack after pop operations: "+stack.size()+"\n");
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("2. Stack of string");
        stackOfStrings();
    }
}
