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
 * Servlet implementation class UpdateBookListServlet
 */
@WebServlet("/UpdateBookListServlet")
public class UpdateBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookListServlet() {
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
		Book book1=(Book)session.getAttribute("mybook");
		int mykind=(int)session.getAttribute("mykind");		
		BookMysql bookmysql = new BookMysql();
        
		if(mykind==1) {
			//更新图书
			String order_number = book1.getOrder_number();
	        String bookname = req.getParameter("bookname");
	        String author = req.getParameter("author");
	        String publisher = req.getParameter("publisher");
	        String category = req.getParameter("category");
	        String logname = book1.getLogname();
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
	        
	        if(bookmysql.updateBook(book)) {	        	
	        	req.setAttribute("message", "更新成功");	            
	        }
	        else {
	        	req.setAttribute("message", "更新失败");            	            
	        }
	        req.getRequestDispatcher("addbook.jsp").forward(req, resp);
	        return;
		}
		else {
			//删除
			if(bookmysql.deleteBook(book1.getOrder_number())) {	        	
	        	req.setAttribute("message", "删除成功");	            
	        }
	        else {
	        	req.setAttribute("message", "删除失败");            	            
	        }
			req.getRequestDispatcher("PreChangebook.jsp").forward(req, resp);
			return;
		}
	}

}
