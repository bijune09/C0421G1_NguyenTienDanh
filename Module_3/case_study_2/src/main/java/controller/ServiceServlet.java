package controller;

import model.bean.service.Service;
import model.service.service.IServiceService;
import model.service.service.ServiceServiceImpl;
import model.service.service.tag.IRentTypeService;
import model.service.service.tag.IServiceTypeService;
import model.service.service.tag.RentTypeServiceImpl;
import model.service.service.tag.ServiceTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    private IServiceService serviceService = new ServiceServiceImpl();
    private IServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();
    private IRentTypeService rentTypeService = new RentTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                showServiceList(request,response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("service",this.serviceService.findById(id));
        request.setAttribute("rentType",this.rentTypeService.selectAll());
        request.setAttribute("serviceType",this.serviceTypeService.selectAll());
        request.getRequestDispatcher("service/edit_service.jsp").forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("rentType",this.rentTypeService.selectAll());
        request.setAttribute("serviceType",this.serviceTypeService.selectAll());
        request.getRequestDispatcher("service/create_service.jsp").forward(request,response);
    }

    private void showServiceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = this.serviceService.selectAll();
        request.setAttribute("serviceList",serviceList);
        request.getRequestDispatcher("service/display_service.jsp").forward(request,response);
    }
}
