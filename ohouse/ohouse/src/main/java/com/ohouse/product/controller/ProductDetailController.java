package com.ohouse.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.product.model.vo.Product;
import com.ohouse.product.service.ProductDetailService;
import com.ohouse.product.service.ProductDetailServiceImpl;

@WebServlet("/detail.pr")
public class ProductDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductDetailController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDetailService service = new ProductDetailServiceImpl();
        Product p = service.selectProduct(productId);
        if(p != null) {
        	request.setAttribute("product", p);
        	request.getRequestDispatcher("views/product/productPage.jsp").forward(request, response);
        } else {
        	request.getSession().setAttribute("alertMsg", "없는 상품입니다.");
        	response.sendRedirect(request.getContextPath());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
