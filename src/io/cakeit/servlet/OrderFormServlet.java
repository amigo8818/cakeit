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
		AlipayClient alipayClient =  new  DefaultAlipayClient( AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);  //��ó�ʼ����AlipayClient 
		//�����������
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		//�̻������ţ��̻���վ����ϵͳ��Ψһ�����ţ�����
		String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//���������
		String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
		//�������ƣ�����
		String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
		//��Ʒ�������ɿ�
		String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
	    String form= "" ;
	    try  {
	        form = alipayClient.pageExecute(alipayRequest).getBody();  //����SDK���ɱ� 
	    }  catch  (AlipayApiException e) {
	        e.printStackTrace();
	    }
	    //httpResponse.setContentType( "text/html;charset="  + CHARSET);
	    //httpResponse.getWriter().write(form); //ֱ�ӽ������ı�html�����ҳ�� 
	    //httpResponse.getWriter().flush();
	    //httpResponse.getWriter().close();
	
		//����
		//String result = alipayClient.pageExecute(alipayRequest).getBody();
		
		response.getWriter().write(form);
		response.getWriter().flush();
		response.getWriter().close();
		//���
		//out.println(result);

		//doGet(request, response);
	}

}
