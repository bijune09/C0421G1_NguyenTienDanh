package Calculator;

public class Calculator {
    public static double calculate(double firstNumber, double secondNumber, String operator) {
        double result;
        switch (operator) {
            case "addition":
                result= firstNumber + secondNumber;
                break;
            case "subtraction":
                result= firstNumber - secondNumber;
                break;
            case "multiple":
                result= firstNumber * secondNumber;
                break;
            case "div":
                if (secondNumber != 0) {
                    result= firstNumber / secondNumber;
                }
                else {
                    throw new RuntimeException("Can't div by zero");
                }
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
//        if (operator.equals("addition")){
//            return result = firstNumber + secondNumber;
//        } else if (operator.equals("subtraction")){
//            return result = firstNumber - secondNumber;
//        } else if (operator.equals("multiple")){
//            return result = firstNumber * secondNumber;
//        } else {
//            if (secondNumber==0){
//                throw new ArithmeticException();
//            }
//            return firstNumber/secondNumber;
//        }
        return result;
    }
}
