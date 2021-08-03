package servlet;

import Calculator.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstNumber = Double.parseDouble(request.getParameter("first"));
        String operator = request.getParameter("operator");
        double secondNumber = Double.parseDouble(request.getParameter("second"));
        String result = "";

        try{
            result = String.valueOf(Calculator.calculate(firstNumber,secondNumber,operator));
        }catch (Exception ex){
            result = ex.getMessage();
        }

        request.setAttribute("result",result);
        request.setAttribute("firstNumber",firstNumber);
        request.setAttribute("secondNumber",secondNumber);

        request.getRequestDispatcher("output.jsp").forward(request,response);
    }
}
