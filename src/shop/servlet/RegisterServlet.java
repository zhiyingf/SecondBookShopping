package shop.servlet;
import shop.bean.User;
import shop.mysql.UserMysql;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//req.getRequestDispatcher("/register.jsp").forward(req, resp);
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		req.setCharacterEncoding("utf-8");
        String logname = req.getParameter("logname");
        String realname = req.getParameter("realname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        UserMysql userMysql = new UserMysql();
        User check = userMysql.checkUserName(logname);
        if (check != null) {
            req.setAttribute("message", "注册失败，该用户名已经被使用，请更换用户名");
            req.getRequestDispatcher("userRegister.jsp").forward(req, resp);
        } else {
            userMysql.register(logname,realname,password,email,phone,address);  //注册用户
            req.setAttribute("message", "注册成功，请登录");
            req.getRequestDispatcher("userLogin.jsp").forward(req, resp); 
            //System.out.println("<BR>经过3秒后，将自动跳转到登陆界面，进行登录");
      	    //resp.setHeader("Refresh", "3;URL=userLogin.jsp");
        }
	}

}
