package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.bean.Book;
import shop.mysql.BookMysql;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		req.getRequestDispatcher("addbook.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		req.setCharacterEncoding("utf-8");
		
		String order_number = req.getParameter("order_number");
        String bookname = req.getParameter("bookname");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String category = req.getParameter("category");
        String logname = req.getParameter("logname");
        String bookImg= req.getParameter("bookImg");
        String price = req.getParameter("price");
        String booknumber=req.getParameter("booknumber");
        
        Book book = new Book();        
        
        book.setOrder_number(order_number);
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategory(category);
        book.setLogname(logname);
        book.setBooknumber(Integer.valueOf(booknumber));
        book.setPrice(Integer.valueOf(price));
        book.setBookImg(bookImg);
        
        BookMysql bookmysql = new BookMysql();
        if(bookmysql.getBook(order_number)==null) {
        	bookmysql.addBook(book);
        	req.setAttribute("message", "发布成功");
            req.getRequestDispatcher("addbook.jsp").forward(req, resp);
        }
        else {
        	req.setAttribute("message", "发布失败，该订阅号已被使用，请更换新的订阅号发布图书");            
            req.getRequestDispatcher("addbook.jsp").forward(req, resp);
        }
	}

}
