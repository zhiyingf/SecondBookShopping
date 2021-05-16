package shop.servlet;
import shop.bean.Book;
import shop.mysql.BookMysql;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
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
		HttpSession session = req.getSession();
        BookMysql bookMysql = new BookMysql();
        List<Book> bookList = bookMysql.selectBook();
        session.setAttribute("bookList", bookList);//将bookList在index.jsp中利用EL表达式打印
        //req.setAttribute("bookList", bookList);
        int pageNos;//当前页数
        if (req.getParameter("pageNos") == null|| Integer.parseInt(req.getParameter("pageNos")) < 1) {
            pageNos = 1;
            } else {
            pageNos = Integer.parseInt(req.getParameter("pageNos"));
            }
        session.setAttribute("pageNos", pageNos);
     // req.setAttribute("pageNos", pageNos);
        int countPage=0;//总页数
        if(bookList.size()%3==0)
        {
            countPage = bookList.size()/3;
        }else {
            countPage = bookList.size()/3+1;
        }
        // 定义总页数并存到session中
        // 在实际开发中我们的总页数可以根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数
        session.setAttribute("countPage", countPage);
        //req.setAttribute("countPage", countPage);
        req.getRequestDispatcher("index.jsp").forward(req,resp);        
	}

}
