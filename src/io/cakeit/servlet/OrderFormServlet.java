package io.cakeit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import io.cakeit.config.AlipayConfig;
import io.cakeit.entity.Item;
import io.cakeit.util.Cart;
import io.cakeit.util.DB;

@WebServlet("/OrderForm")
public class OrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrderFormServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		ArrayList<Item> items = cart.getItem();
		for (Item item : items) {
			float count=item.getCount();
			new DB().updateItemAmount(item, count);
		}
		
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("WEB-INF/pages/orderForm.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		AlipayClient alipayClient =  new  DefaultAlipayClient( AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);  //获得初始化的AlipayClient 
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//付款金额，必填
		String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
		//订单名称，必填
		String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
		//商品描述，可空
		String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
	    String form= "" ;
	    try  {
	        form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单 
	    }  catch  (AlipayApiException e) {
	        e.printStackTrace();
	    }
	    //httpResponse.setContentType( "text/html;charset="  + CHARSET);
	    //httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面 
	    //httpResponse.getWriter().flush();
	    //httpResponse.getWriter().close();
	
		//请求
		//String result = alipayClient.pageExecute(alipayRequest).getBody();
		
		response.getWriter().write(form);
		response.getWriter().flush();
		response.getWriter().close();
		//输出
		//out.println(result);

		//doGet(request, response);
	}

}
