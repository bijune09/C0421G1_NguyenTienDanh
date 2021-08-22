package vn.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Calculator {
    public double calculate(double firstNumber, double secondNumber, String operator){
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
        return result;
    }
}
