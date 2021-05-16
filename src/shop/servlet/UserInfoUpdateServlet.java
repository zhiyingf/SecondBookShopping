package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.bean.User;
import shop.mysql.UserMysql;

/**
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateServlet() {
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
		
        String realname = req.getParameter("realname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        
        currentUser.setRealname(realname);
        currentUser.setPassword(password);
        currentUser.setAddress(address);
        currentUser.setEmail(email);
        currentUser.setPhone(phone);
        
        UserMysql usermysql = new UserMysql();
        boolean flag = usermysql.updateUser(currentUser);
        
        if (flag == true){
            req.setAttribute("message","修改成功");
            session.setAttribute("currentUser", currentUser);
            //req.getRequestDispatcher("LogoutServlet").forward(req,resp);
            req.getRequestDispatcher("userInfoUpdate.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("message","修改失败");
            req.getRequestDispatcher("userInfoUpdate.jsp").forward(req,resp);
        }
	}

}
