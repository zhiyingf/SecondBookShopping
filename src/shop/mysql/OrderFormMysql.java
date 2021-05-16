package shop.mysql;

import shop.bean.OrderForm;
//import shop.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderFormMysql {
	/**
	 * 该用户订单浏览（通过用户名搜索订单表）
	 * */
	public List<OrderForm> selectBook(String logname) {
        List<OrderForm> list = new ArrayList<>();
        Connection con=null;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String condition = "select * from orderform where logname = "+"'"+logname+"'";
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                OrderForm orderform = new OrderForm();
                orderform.setLogname(rs.getString("logname")); 
                orderform.setOrder_number(rs.getString("order_number"));                
                orderform.setBookname(rs.getString("bookname"));   
                orderform.setRealname(rs.getString("realname"));                
                orderform.setPhone(rs.getString("phone"));    
                orderform.setAddress(rs.getString("address"));
                orderform.setBooknumber(rs.getInt("booknumber"));
                orderform.setPrice(rs.getInt("price"));
                orderform.setBookImg(rs.getString("bookImg"));
                list.add(orderform);
            }
            rs.close();
            psql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	/**
	 * 添加订单
	 * */
	public boolean addItem(OrderForm orderform) {
        String condition= "insert into orderform(logname,bookname,realname,order_number,phone,address,booknumber,price,bookImg) "
                + "values(?,?,?,?,?,?,?,?,?)";
        Connection con=null;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            psql.setString(1,orderform.getLogname());              //设置参数1，创建id为3212的数据
            psql.setString(2,orderform.getBookname());      //设置参数2，name 为王刚
            psql.setString(3,orderform.getRealname());
            psql.setString(4,orderform.getOrder_number());       
            psql.setString(5,orderform.getPhone());
            psql.setString(6,orderform.getAddress());
            psql.setInt(7,orderform.getBooknumber());
            psql.setInt(8,orderform.getPrice());
            psql.setString(9, orderform.getBookImg());
            psql.executeUpdate();    
            int count = psql.executeUpdate();
            psql.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
	/**
	 * 修改订单(该用户的该书的订单数量)
	 * */
	public boolean updateOrderForm(OrderForm orderform) {
        String condition = "update orderform set booknumber=? where order_number = ? and logname=?";
        Connection con=null;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);            
            psql.setInt(1,orderform.getBooknumber());      
            psql.setString(2,orderform.getOrder_number());              //设置参数1，创建id为3212的数据
            psql.setString(3,orderform.getLogname());
            int count = psql.executeUpdate();
            psql.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	/**
	 * 检查是否重订单
	 * */
	public OrderForm checkOrderform(String logname,String order_number) {
        Connection con=null;// = ManageInfo.getConnection();
        OrderForm orderform =null;
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String condition = "select * from orderform where logname = ? and order_number=?";
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            psql.setString(1, logname);
            psql.setString(2, order_number);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {     
            	orderform = new OrderForm();
                orderform.setLogname(rs.getString("logname")); 
                orderform.setOrder_number(rs.getString("order_number"));                
                orderform.setBookname(rs.getString("bookname"));   
                orderform.setRealname(rs.getString("realname"));                
                orderform.setPhone(rs.getString("phone"));    
                orderform.setAddress(rs.getString("address"));
                orderform.setBooknumber(rs.getInt("booknumber"));
                orderform.setPrice(rs.getInt("price"));
                orderform.setBookImg(rs.getString("bookImg"));
            }
            rs.close();
            psql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderform;
    }
	
	/**
	 * 删除订单
	 * */
	public boolean deleteOrderform(String order_number,String logname) {
        String condition = "delete from orderform where order_number = ? and logname= ?";
        Connection con=null;// =ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            psql.setString(1, order_number);
            psql.setString(2,logname);
            int count = psql.executeUpdate();
            psql.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
