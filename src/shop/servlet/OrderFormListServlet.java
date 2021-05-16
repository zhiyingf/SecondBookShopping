package shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shop.bean.User;
import shop.bean.OrderForm;
import shop.mysql.OrderFormMysql;

/**
 * Servlet implementation class OrderFormListServlet
 */
@WebServlet("/OrderFormListServlet")
public class OrderFormListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderFormListServlet() {
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
        OrderFormMysql bookMysql = new OrderFormMysql();
        User user=new User();
        user=(User)session.getAttribute("currentUser"); 
        if(user==null) {req.getRequestDispatcher("orderformList.jsp").forward(req,resp);return;}
        List<OrderForm> bookList = bookMysql.selectBook(user.getLogname());
        session.setAttribute("orderformBookList", bookList);//将bookList在index.jsp中利用EL表达式打印
        //req.setAttribute("orderformBookList", bookList);
        int pageNos;
        if (req.getParameter("orderformPageNos") == null|| Integer.parseInt(req.getParameter("orderformPageNos")) < 1) {
            pageNos = 1;
            } else {
            pageNos = Integer.parseInt(req.getParameter("orderformPageNos"));
            }
        session.setAttribute("orderformPageNos", pageNos);  
        //req.setAttribute("orderformPageNos", pageNos); 
        int countPage=0;
        if(bookList.size()%3==0)
        {
            countPage = bookList.size()/3;
        }else {
            countPage = bookList.size()/3+1;
        }
        // 定义总页数并存到session中
        // 在实际开发中我们的总页数可以根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数
        session.setAttribute("orderformCountPage", countPage);
        //req.setAttribute("orderformCountPage", countPage);
        req.getRequestDispatcher("orderformList.jsp").forward(req,resp);        
	}

}
