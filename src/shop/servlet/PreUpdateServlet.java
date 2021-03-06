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
        req.setAttribute("search", "ζηδΉ¦ε");
        int pageNos;
        if (req.getParameter("mypageNos") == null|| Integer.parseInt(req.getParameter("mypageNos")) < 1) {
            pageNos = 1;
        } else {
            pageNos = Integer.parseInt(req.getParameter("mypageNos"));
        }
        session.setAttribute("mypageNos", pageNos);
        // ε?δΉζ»ι‘΅ζ°εΉΆε­ε°sessionδΈ­
        int countPage;
        if(bookList.size()<3)
        {
            countPage=1;
        }else {
            countPage = bookList.size()/3;
        }
        // ε¨ε?ιεΌεδΈ­ζδ»¬ηζ»ι‘΅ζ°ε―δ»₯ζ Ήζ?sqlθ―­ε₯εΎε°ζ₯θ―’ε°ηζ»ζ‘ζ°οΌηΆεη¨ζ»ζ‘ζ°ι€ζ―ι‘΅ηζ‘ζ°εΎε°ζ»ι‘΅ζ°
        session.setAttribute("mycountPage", countPage);
        int my=Integer.parseInt(req.getParameter("my"));
        session.setAttribute("my", my);
        req.getRequestDispatcher("publishBook.jsp").forward(req, resp);
	}

}
