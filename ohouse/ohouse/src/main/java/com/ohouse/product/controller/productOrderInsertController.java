package com.ohouse.product.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.members.model.vo.Members;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Order;
import com.ohouse.product.model.vo.OrderProduct;
import com.ohouse.product.model.vo.Product;
import com.ohouse.product.service.ProductOrderService;
import com.ohouse.product.service.ProductOrderServiceImp;

/**
 * Servlet implementation class productOrderDetailController
 */
@WebServlet("/insert.or")
public class productOrderInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productOrderInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("연결");
		ProductOrderService pServ = new ProductOrderServiceImp();
		
		String name = request.getParameter("recipientName");
		String phone = request.getParameter("recipientPhone");
		String address = request.getParameter("recipientMainAddress") + " " + request.getParameter("recipientSubAddress");
		String requirement = request.getParameter("requirement");
		String paymentMethod = request.getParameter("paymentMethod");
		int pNo = Integer.parseInt(request.getParameter("productId"));
		int oNo = Integer.parseInt(request.getParameter("optNameNo"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice").substring(0, request.getParameter("totalPrice").lastIndexOf(".")));
		int deliveryDate = Integer.parseInt(request.getParameter("deliveryDate"));
		
		int membersNo = ((Members)request.getSession().getAttribute("loginUser")).getMembersNo();
		
		Order order = new Order();
		
		order.setMembersNo(membersNo);
		order.setRecipientName(name);
		order.setRecipientPhone(phone);
		order.setRecipientAddress(address);
		order.setRequirement(requirement);
		order.setTotalPrice(totalPrice);
		// 현재 날짜를 가져옵니다.
		LocalDate currentDate = LocalDate.now();
		// 현재 날짜에 배송 소요 일 수를 더해서 도착 예상일을 계산합니다.
		LocalDate arrivalDate = currentDate.plusDays(deliveryDate);
		// java.sql.Date로 변환합니다.
		Date sqlArrivalDate = Date.valueOf(arrivalDate);
		// 도착 예상일을 설정합니다.
		order.setArrivalDate(sqlArrivalDate);
		
		int result1 = pServ.insertOrder(order);
		
		
		if (result1 > 0) {
			int ordid = order.getOrdersId();
			OrderProduct ordpd = new OrderProduct();
			
			ordpd.setProductId(pNo);
			ordpd.setOrderOptions(oNo);
			ordpd.setAmount(amount);
			ordpd.setOrderId(ordid);
			
			int result2 = pServ.insertOrderProduct(ordpd);
			
			if(result2 >0) {
				request.getSession().setAttribute("alertMsg", "주문 성공");
				Product p = pServ.selectProductDetail(pNo);
				OptionsName o = pServ.selectOptNameDetail(oNo);
				Order orderSelect = pServ.selectOrder(ordid);
				OrderProduct ordpdSelect = pServ.selectOrderProduct(ordpd);
				request.setAttribute("p", p);
				request.setAttribute("o", o);
				request.setAttribute("order", orderSelect);
				request.setAttribute("ordpd", ordpdSelect);
				request.setAttribute("paymentMethod", paymentMethod);
				request.getRequestDispatcher("views/product/productOrderDetailPage.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("alertMsg", "주문 옵션 오류");
				response.sendRedirect(request.getContextPath());
			}
		
		} else {
			request.getSession().setAttribute("alertMsg", "주문 상품 오류");
			response.sendRedirect(request.getContextPath());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
