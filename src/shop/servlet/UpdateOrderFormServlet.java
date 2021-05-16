package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.bean.Book;
//import shop.bean.Book;
import shop.bean.OrderForm;
import shop.mysql.BookMysql;
import shop.mysql.OrderFormMysql;

/**
 * Servlet implementation class UpdateOrderFormServlet
 */
@WebServlet("/UpdateOrderFormServlet")
public class UpdateOrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		req.setCharacterEncoding("utf-8");		
		HttpSession session = req.getSession();
		OrderForm orderform=(OrderForm)session.getAttribute("book");
		int kind=(int)session.getAttribute("kind");
		int booknumber=Integer.valueOf(req.getParameter("booknumber1"));
		orderform.setBooknumber(booknumber);		
		OrderFormMysql orderformmysql=new OrderFormMysql();
		if(kind==1) {	
			BookMysql bookmysql = new BookMysql();
			Book book=bookmysql.getBook(orderform.getOrder_number());
			if(booknumber>book.getBooknumber()) {
				req.setAttribute("message", "购买失败，该书最大数量为"+book.getBooknumber());
			}else {
				if(bookmysql.updateBooknumber(book)&&orderformmysql.deleteOrderform(orderform.getOrder_number(), orderform.getLogname())) {
					req.setAttribute("message", "成功购买");					
				}
				else {
					req.setAttribute("message", "购买失败");					
				}
			}
			req.getRequestDispatcher("modifyPrebuy.jsp").forward(req, resp);
			return;
			
		}else {
			if(orderformmysql.deleteOrderform(orderform.getOrder_number(), orderform.getLogname())) {
				req.setAttribute("message", "成功删除");		
			}else {
				req.setAttribute("message", "删除失败");		
			}
			req.getRequestDispatcher("modifyPrebuy.jsp").forward(req, resp);
		}
		return;
	}		
}
