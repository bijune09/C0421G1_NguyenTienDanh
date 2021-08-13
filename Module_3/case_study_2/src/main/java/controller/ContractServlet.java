package controller;

import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.repository.contract.AttachServiceImpl;
import model.repository.contract.DetailContractRepoImpl;
import model.repository.contract.IAttachServiceRepo;
import model.repository.contract.IDetailContractRepo;
import model.service.contract.ContractServiceImpl;
import model.service.contract.IContractService;
import model.service.customer.CustomerServiceImpl;
import model.service.customer.ICustomerService;
import model.service.customer_using_contract.CustomerUsingServiceImpl;
import model.service.customer_using_contract.ICustomerUsingService;
import model.service.employee.EmployeeServiceImpl;
import model.service.employee.IEmployeeService;
import model.service.service.IServiceService;
import model.service.service.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new ContractServiceImpl();
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private IServiceService serviceService = new ServiceServiceImpl();
    private ICustomerService customerService = new CustomerServiceImpl();
    private IAttachServiceRepo attachServiceRepo = new AttachServiceImpl();
    private IDetailContractRepo detailContractRepo = new DetailContractRepoImpl();
    private ICustomerUsingService customerUsingService = new CustomerUsingServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createContract(request,response);
                break;
            case "createContract":
                createDetail(request,response);
                break;
        }
    }

    private void createDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int attachId = Integer.parseInt(request.getParameter("attachId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contractId,attachId,quantity);

        this.detailContractRepo.createContractDetail(contractDetail);
        showContract(request,response);
    }


    private void createContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idService = Integer.parseInt(request.getParameter("idService"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        double totalMoney = Double.parseDouble(request.getParameter("total"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));

        Contract contract = new Contract(idEmployee,idCustomer,idService,start,end,totalMoney,deposit);
        this.contractService.createContract(contract);
        showContract(request,response);
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
            case "createContract":
                showCreateDetailForm(request,response);
                break;
            default:
                showContract(request,response);
                break;
        }

    }

    private void showCreateDetailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contractList",this.contractService.selectAll());
        request.setAttribute("attachServiceList",this.attachServiceRepo.selectAll());
        request.getRequestDispatcher("contract/create_contract_detail.jsp").forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("employeeList",this.employeeService.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("customerList",this.customerService.selectAll());
        request.setAttribute("serviceList",this.serviceService.selectAll());
        request.getRequestDispatcher("contract/create_contract.jsp").forward(request,response);
    }


    private void showContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerUsingList",this.customerUsingService.selectAll());
        request.getRequestDispatcher("contract/display_contract.jsp").forward(request,response);
    }
}
