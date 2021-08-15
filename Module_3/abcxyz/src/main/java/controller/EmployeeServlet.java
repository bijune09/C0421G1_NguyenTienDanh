package controller;

import model.bean.Employee;
import model.repository.ITagRepo;
import model.repository.implement.DivisionRepoImpl;
import model.repository.implement.EducationRepoImpl;
import model.repository.implement.PositionRepoImpl;
import model.service.IEmployeeService;
import model.service.implement.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private DivisionRepoImpl divisionRepo = new DivisionRepoImpl();
    private EducationRepoImpl educationRepo = new EducationRepoImpl();
    private PositionRepoImpl positionRepo = new PositionRepoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String character = request.getParameter("search");
        request.setAttribute("employeeList",this.employeeService.findByChar(character));
        request.getRequestDispatcher("employee/display_employee.jsp").forward(request,response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.employeeService.deleteEmployee(id);
        showEmployeeList(request,response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationId = Integer.parseInt(request.getParameter("educationId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));

        Employee employee = new Employee(name,birthday,idCard,salary,phone,email,address,positionId,educationId,divisionId);
        Map<String,String> message = this.employeeService.editEmployee(employee);
        if (message== null){
            showEmployeeList(request,response);
        } else {
            request.setAttribute("msgName",message.get("name"));
            request.setAttribute("msgIdCard",message.get("idCard"));
            request.setAttribute("msgPhone",message.get("phone"));
            request.setAttribute("divisionList",this.divisionRepo.selectAll());
            request.setAttribute("educationList",this.educationRepo.selectAll());
            request.setAttribute("positionList",this.positionRepo.selectAll());
            request.setAttribute("employee",employee);
            request.getRequestDispatcher("employee/edit_employee.jsp").forward(request,response);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationId = Integer.parseInt(request.getParameter("educationId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));

        Employee employee = new Employee(name,birthday,idCard,salary,phone,email,address,positionId,educationId,divisionId);
        Map<String,String> message = this.employeeService.createEmployee(employee);
        if (message== null){
            showEmployeeList(request,response);
        } else {
            request.setAttribute("msgName",message.get("name"));
            request.setAttribute("msgIdCard",message.get("idCard"));
            request.setAttribute("msgPhone",message.get("phone"));
            request.setAttribute("divisionList",this.divisionRepo.selectAll());
            request.setAttribute("educationList",this.educationRepo.selectAll());
            request.setAttribute("positionList",this.positionRepo.selectAll());
            request.setAttribute("employee",employee);
            request.getRequestDispatcher("employee/create_employee.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                showEmployeeList(request,response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("employee",this.employeeService.findById(id));
        request.setAttribute("divisionList",this.divisionRepo.selectAll());
        request.setAttribute("educationList",this.educationRepo.selectAll());
        request.setAttribute("positionList",this.positionRepo.selectAll());
        request.getRequestDispatcher("employee/edit_employee.jsp").forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("divisionList",this.divisionRepo.selectAll());
        request.setAttribute("educationList",this.educationRepo.selectAll());
        request.setAttribute("positionList",this.positionRepo.selectAll());
        request.getRequestDispatcher("employee/create_employee.jsp").forward(request,response);
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeeList",this.employeeService.selectAll());
        request.getRequestDispatcher("employee/display_employee.jsp").forward(request,response);
    }
}
