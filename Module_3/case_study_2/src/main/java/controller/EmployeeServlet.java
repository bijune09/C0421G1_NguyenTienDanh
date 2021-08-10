package controller;

import model.bean.employee.Employee;
import model.service.employee.EmployeeServiceImpl;
import model.service.employee.IEmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editEmployee(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.employeeService.deleteEmployee(id);
        response.sendRedirect("/employees");
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("positionId"));
        int education = Integer.parseInt(request.getParameter("educationId"));
        int division = Integer.parseInt(request.getParameter("divisionId"));
//        String username = request.getParameter("username");

        Employee newEmployee = new Employee(id,name,position,education,division,birthday,idCard,salary,phone,email,
                address);

        this.employeeService.editEmployee(newEmployee);
        request.setAttribute("employee",newEmployee);
        request.getRequestDispatcher("employee/edit_employee.jsp").forward(request,response);

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("nameEmployee");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("positionId"));
        int education = Integer.parseInt(request.getParameter("educationId"));
        int division = Integer.parseInt(request.getParameter("divisionId"));

        Employee employee = new Employee(name, position, education, division, birthday, idCard,
                salary, phone, email, address);

        this.employeeService.createEmployee(employee);
        showEmployeeList(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                try {
                    showEmployeeList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existEmployee = this.employeeService.findById(id);
        request.setAttribute("employee",existEmployee);
        request.getRequestDispatcher("employee/edit_employee.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> employeeList;
        employeeList = this.employeeService.selectAll();
        request.setAttribute("employeeList",employeeList);
        request.getRequestDispatcher("employee/display_employee.jsp").forward(request, response);
    }
}
