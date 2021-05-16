package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import shop.bean.*;
import shop.mysql.*;
/**
 * Servlet implementation class AddOrderFormServlet
 */
@WebServlet("/AddOrderFormServlet")
public class AddOrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		req.setCharacterEncoding("utf-8");
		//String order_number=req.getParameter("order_number1");
		String booknumber=req.getParameter("booknumber1");
		//String kind=req.getParameter("kind");
		//BookMysql bookmysql = new BookMysql();
		//Book book=bookmysql.getBook(order_number); 
		HttpSession session = req.getSession();
		Book book=(Book)session.getAttribute("book");
		int kind=(int)session.getAttribute("kind");
		if(kind==1) {
			OrderForm orderform=new OrderForm();
	        User user=new User();
	        //HttpSession session = req.getSession();
	        user= (User)session.getAttribute("currentUser");     
	        orderform.setLogname(user.getLogname());
	        orderform.setAddress(user.getAddress());
	        orderform.setBookImg(book.getBookImg());
	        orderform.setBookname(book.getBookname());
	        orderform.setBooknumber(Integer.valueOf(booknumber));
	        orderform.setOrder_number(book.getOrder_number());
	        orderform.setPhone(user.getPhone());
	        orderform.setPrice(book.getPrice());
	        orderform.setRealname(book.getAuthor());
	        
	        OrderFormMysql orderformmysql=new OrderFormMysql();        
	        if(orderformmysql.checkOrderform(user.getLogname(), book.getOrder_number())!=null) {
	        	req.setAttribute("message", "该书已添加到购物车<br/>如需修改请进入购物车界面进行修改"); 	        	
	        }else {
	        	req.setAttribute("message", "成功加入购物车");
	        	System.out.println("orderform未插入");
	            orderformmysql.addItem(orderform);
	            System.out.println("orderform插入成功");	                       
	        }       
	        req.getRequestDispatcher("prebuy.jsp").forward(req, resp);
			return;
		}               
		else {
			BookMysql bookmysql = new BookMysql();
			if(bookmysql.updateBooknumber(book)) {
				req.setAttribute("message", "成功加入购买");				
			}
			else {
				req.setAttribute("message", "购买失败");				
			}
			req.getRequestDispatcher("prebuy.jsp").forward(req, resp);
		}
        return;
	}
}
