package controller;

import model.bean.Product;
import model.repository.ICategoryRepository;
import model.service.ICategoryService;
import model.service.IProductService;
import model.service.impl.CategoryServiceImpl;
import model.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();
    private ICategoryService categoryService = new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createObj(request, response);
                break;
            case "edit":
                editObj(request, response);
                break;
            case "delete":
                deleteObj(request, response);
                break;
            case "search":
                searchObj(request,response);
                break;
        }
    }

    private void searchObj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("productList",this.productService.findByName(name));
        request.getRequestDispatcher("product/display.jsp").forward(request,response);
    }

    private void deleteObj(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.productService.removeProduct(id);
        response.sendRedirect("/products");
    }

    private void editObj(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(id,name,price,quantity,color,categoryId);

        this.productService.editProduct(product);
        response.sendRedirect("/products");
    }

    private void createObj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(name,price,quantity,color,categoryId);

        this.productService.createProduct(product);
        request.setAttribute("msg","Success");
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
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
                displayList(request, response);
                break;
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList",this.productService.selectAll());
        request.getRequestDispatcher("product/display.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("categoryList",this.categoryService.selectAll());
        request.setAttribute("product",this.productService.findById(id));
        request.getRequestDispatcher("product/edit.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList",this.categoryService.selectAll());
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }
}
