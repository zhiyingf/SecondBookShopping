package shop.mysql;
//import shop.manage.ManageInfo;
import shop.bean.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.DriverManager;



public class UserMysql {
	/**
	 * 注册
	 * */
	public boolean register(String logname,String realname, String password, String email,String phone, String address) {
        Connection con ;//= ManageInfo.getConnection();       
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String condition = "insert into bookuser (logname,realname,password,email,phone,address) "+ "values(?,?,?,?,?,?)";
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
        	PreparedStatement psql = con.prepareStatement(condition);
            psql.setString(1, logname);              //设置参数1，创建id为3212的数据
            psql.setString(2, realname);      //设置参数2，name 为王刚
            psql.setString(3, password);
            psql.setString(4, email);
            psql.setString(5, phone);
            psql.setString(6, address);            
            int count = psql.executeUpdate();
            psql.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
	/**
	 * 登录
	 */
	public User login(String logname, String password) {
        Connection con=null;// = ManageInfo.getConnection();
        String condition = "select * from bookuser where logname = ? and password = ?";
        User user = null;
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {        	
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement pst = con.prepareStatement(condition);
            pst.setString(1, logname);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setLogname(rs.getString("logname"));
                user.setRealname(rs.getString("realname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
	
	
	/**
	 * 检查是否重logname
	 * */
	public User checkUserName(String userName) {
        Connection con=null;//= ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String sql = "select * from bookuser where logname = ?";
        User user = null;
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setLogname(rs.getString("logname"));
                user.setRealname(rs.getString("realname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

	
	/**
	 * 获取用户个人信息
	 * */
	public User getUser(int logname) {
        Connection con=null;// = DbUtil.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String condition = "select * from bookuser where logname = " + logname;
        User user = null;
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");            
            PreparedStatement psql = con.prepareStatement(condition);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setLogname(rs.getString("logname"));
                user.setRealname(rs.getString("realname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
            rs.close();
            psql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
	
	
	/**
	 * 修改用户个人信息
	 * */
	public boolean updateUser(User user) {
        Connection con ;//= ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String condition = "UPDATE bookuser set password=? , realname = ? , email = ? , phone=? , address=? where logname = ?";
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            psql.setString(1, user.getPassword());
            psql.setString(2, user.getRealname());
            psql.setString(3, user.getEmail());
            psql.setString(4, user.getPhone());
            psql.setString(5, user.getAddress());
            psql.setString(6, user.getLogname());
                        
            int count = psql.executeUpdate();
            psql.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
}
