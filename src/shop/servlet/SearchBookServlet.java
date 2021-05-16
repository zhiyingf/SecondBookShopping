package shop.servlet;

import shop.bean.Book;
//import shop.bean.User;
import shop.mysql.BookMysql;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//req.getRequestDispatcher("/search.jsp").forward(req,resp);
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        //User currentUser = (User) session.getAttribute("currentUser");
        String keyfind01=req.getParameter("keyfind01");
        String keyfind02=req.getParameter("keyfind02");
        String key = req.getParameter("key");
        BookMysql bookMysql = new BookMysql();
        List<Book> bookList = bookMysql.searchBook(key,keyfind01,keyfind02);      
        req.setAttribute("bookList", bookList);
        req.setAttribute("search", "搜索结果");
        int pageNos;
        if (req.getParameter("pageNos") == null|| Integer.parseInt(req.getParameter("pageNos")) < 1) {
            pageNos = 1;
        } else {
            pageNos = Integer.parseInt(req.getParameter("pageNos"));
        }
        session.setAttribute("pageNos", pageNos);
        // 定义总页数并存到session中
        int countPage;
        if(bookList.size()<3)
        {
            countPage=1;
        }else {
            countPage = bookList.size()/3;
        }
        // 在实际开发中我们的总页数可以根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数
        session.setAttribute("countPage", countPage);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
	}

}
