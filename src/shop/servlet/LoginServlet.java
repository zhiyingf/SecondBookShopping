package shop.servlet;
import shop.bean.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.mysql.UserMysql;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String logname=req.getParameter("logname");
		String password=req.getParameter("password");
		UserMysql userMysql=new UserMysql();
		User user=userMysql.login(logname, password);
		if(user==null) {
			//session.setAttribute("message", "账号或密码错误，请重新输入");
			req.setAttribute("message", "账号或密码错误，请重新输入" );
            //resp.sendRedirect("userLogin.jsp");
            req.getRequestDispatcher("userLogin.jsp").forward(req, resp);
		}
		else {
			session.setAttribute("currentUser", user);  
            resp.sendRedirect("BookListServlet");
		}
	}

}
