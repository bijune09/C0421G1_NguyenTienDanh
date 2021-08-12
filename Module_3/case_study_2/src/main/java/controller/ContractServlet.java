package controller;

import model.bean.contract.Contract;
import model.service.contract.ContractServiceImpl;
import model.service.contract.IContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new ContractServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createContract(request,response);
                break;
            case "edit":
                editContract(request,response);
                break;
            case "delete":
                deleteContract(request,response);
                break;
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        this.contractService.deleteContract(idContract);
        response.sendRedirect("/contracts");
    }

    private void editContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idService = Integer.parseInt(request.getParameter("idService"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        double totalMoney = Double.parseDouble(request.getParameter("total"));

        Contract contract = new Contract(idContract,idEmployee,idCustomer,idService,start,end,totalMoney);
        this.contractService.editContract(contract);
        request.setAttribute("contract",contract);
        request.getRequestDispatcher("contract/edit_contract.jsp").forward(request,response);
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idService = Integer.parseInt(request.getParameter("idService"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        double totalMoney = Double.parseDouble(request.getParameter("total"));

        Contract contract = new Contract(idEmployee,idCustomer,idService,start,end,totalMoney);
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
            case "edit":
                showEditForm(request,response);
                break;
            default:
                showContract(request,response);
                break;
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("contract/create_contract.jsp").forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = this.contractService.findById(id);
        request.setAttribute("contract",contract);
        request.getRequestDispatcher("contract/edit_contract.jsp").forward(request,response);
    }

    private void showContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = this.contractService.selectAll();
        request.setAttribute("contractList",contractList);
        request.getRequestDispatcher("contract/display_contract.jsp").forward(request,response);
    }
}
