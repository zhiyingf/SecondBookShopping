package shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.bean.Book;
import shop.bean.User;
import shop.mysql.BookMysql;

/**
 * Servlet implementation class PreUpdateServlet
 */
@WebServlet("/PreUpdateServlet")
public class PreUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateServlet() {
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
        User currentUser = (User) session.getAttribute("currentUser");
        String logname=currentUser.getLogname();        
        BookMysql bookMysql = new BookMysql();
        List<Book> bookList = bookMysql.getBookLogname(logname);      
        req.setAttribute("mybookList", bookList);
        req.setAttribute("search", "我的书单");
        int pageNos;
        if (req.getParameter("mypageNos") == null|| Integer.parseInt(req.getParameter("mypageNos")) < 1) {
            pageNos = 1;
        } else {
            pageNos = Integer.parseInt(req.getParameter("mypageNos"));
        }
        session.setAttribute("mypageNos", pageNos);
        // 定义总页数并存到session中
        int countPage;
        if(bookList.size()<3)
        {
            countPage=1;
        }else {
            countPage = bookList.size()/3;
        }
        // 在实际开发中我们的总页数可以根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数
        session.setAttribute("mycountPage", countPage);
        int my=Integer.parseInt(req.getParameter("my"));
        session.setAttribute("my", my);
        req.getRequestDispatcher("publishBook.jsp").forward(req, resp);
	}

}
