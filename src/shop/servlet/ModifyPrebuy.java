package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import shop.bean.Book;
import shop.bean.OrderForm;
//import shop.mysql.BookMysql;
import shop.mysql.OrderFormMysql;

/**
 * Servlet implementation class ModifyPrebuy
 */
@WebServlet("/ModifyPrebuy")
public class ModifyPrebuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPrebuy() {
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
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String order_number=req.getParameter("order_number");
		String logname=req.getParameter("logname");
		int kind=Integer.parseInt(req.getParameter("kind"));
		OrderFormMysql orderformmysql=new OrderFormMysql();
		OrderForm orderform=new OrderForm();
		orderform=orderformmysql.checkOrderform(logname, order_number);
		session.setAttribute("book", orderform);
		session.setAttribute("kind", kind);
		req.getRequestDispatcher("modifyPrebuy.jsp").forward(req, resp);
	}
	

}
