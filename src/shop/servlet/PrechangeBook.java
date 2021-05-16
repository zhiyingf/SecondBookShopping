package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.bean.Book;
//import shop.bean.OrderForm;
import shop.mysql.BookMysql;
//import shop.mysql.OrderFormMysql;

/**
 * Servlet implementation class PrechangeBook
 */
@WebServlet("/PrechangeBook")
public class PrechangeBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrechangeBook() {
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
		String order_number=req.getParameter("order_number");		
		int kind=Integer.parseInt(req.getParameter("mykind"));
		session.setAttribute("mykind", kind);
		BookMysql bookmysql=new BookMysql();
		Book book=new Book();
		book=bookmysql.getBook(order_number);
		session.setAttribute("mybook", book);
		System.out.println(book.getAuthor());
		if(kind==2) {
			req.getRequestDispatcher("PreChangebook.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("changebook.jsp").forward(req, resp);
		}
	}

}
