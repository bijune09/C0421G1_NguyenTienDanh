package _15_exception_handle.exercise;

public class IllegalTriangleException extends Exception{
    String errorMess;

    public IllegalTriangleException(String errorMess) {
        this.errorMess = errorMess;
    }

    @Override
    public String toString() {
        return "IllegalTriangleException{" +
                "errorMess='" + errorMess + '\'' +
                '}';
    }

    public String getErrorMess() {
        return errorMess;
    }

}
