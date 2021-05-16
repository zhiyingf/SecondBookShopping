package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.bean.Book;
import shop.mysql.BookMysql;

/**
 * Servlet implementation class Prebuy
 */
@WebServlet("/Prebuy")
public class Prebuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prebuy() {
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
		int kind=Integer.parseInt(req.getParameter("kind"));
		BookMysql bookmysql = new BookMysql();
        Book book=bookmysql.getBook(order_number);
        //req.setAttribute("book", book);
        session.setAttribute("book", book);
        //req.setAttribute("kind",kind );
        session.setAttribute("kind", kind);
        req.getRequestDispatcher("prebuy.jsp").forward(req, resp);
	}

}
