package shop.mysql;
import shop.bean.Book;
//import shop.manage.ManageInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMysql {
	/**
	 * 图书浏览
	 * */
	public List<Book> selectBook() {
        List<Book> list = new ArrayList<>();
        Connection con=null;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String condition = "select * from book";
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setOrder_number(rs.getString("order_number"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setCategory(rs.getString("category"));
                book.setLogname(rs.getString("logname"));
                book.setBooknumber(rs.getInt("booknumber"));
                book.setPrice(rs.getInt("price"));
                book.setBookImg(rs.getString("bookImg"));
                list.add(book);
            }
            rs.close();
            psql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	
	/**
	 * 发布图书
	 * */
	public boolean addBook(Book book) {
        String condition= "insert into book(order_number,bookname,author,publisher,booknumber,price,category,logname,bookImg) "
                + "values(?,?,?,?,?,?,?,?,?)";
        Connection con=null;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            psql.setString(1,book.getOrder_number());              //设置参数1，创建id为3212的数据
            psql.setString(2,book.getBookname());      //设置参数2，name 为王刚
            psql.setString(3,book.getAuthor());
            psql.setString(4,book.getPublisher());       
            psql.setInt(5,book.getBooknumber());
            psql.setInt(6,book.getPrice());
            psql.setString(7,book.getCategory());
            psql.setString(8,book.getLogname());
            psql.setString(9, book.getBookImg());
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
	 * 数量
	 * */
	public boolean updateBooknumber(Book book) {
        String condition = "update book set booknumber=? where order_number = ?";
        Connection con=null;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);                        
            psql.setInt(1,book.getBooknumber());            
            psql.setString(2,book.getOrder_number());                          
            int count = psql.executeUpdate();
            psql.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	/**
	 * 更新图书信息
	 * */
	public boolean updateBook(Book book) {
        String condition = "update book set bookname=?, author=?, publisher=?, price=?, category=?, booknumber=?, bookImg=? where order_number = ? and logname=?";
        Connection con=null;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);            
            psql.setString(1,book.getBookname());      
            psql.setString(2,book.getAuthor());
            psql.setString(3,book.getPublisher());                   
            psql.setInt(4,book.getPrice());
            psql.setString(5,book.getCategory());
            psql.setInt(6,book.getBooknumber());
            psql.setString(7, book.getBookImg());
            psql.setString(8,book.getOrder_number());              
            psql.setString(9,book.getLogname());
            int count = psql.executeUpdate();
            psql.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
	
	/**
	 * 删除图书（当图书数量为零时）
	 * */
	public boolean deleteBook(String order_number) {
        String sql = "delete from book where order_number = ?";
        Connection con=null;// =ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, order_number);
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	/**
	 * 通过订阅号搜索图书
	 * */
	public Book getBook(String order_number) {//"+"'"+order_number+"'"
		String sql = "select * from book where order_number ="+"'"+ order_number+"'";        
		Connection con=null;// = DbUtil.getConnection();
		try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        Book book = null;
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");            
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setOrder_number(rs.getString("order_number"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setCategory(rs.getString("category"));
                book.setLogname(rs.getString("logname"));
                book.setBooknumber(rs.getInt("booknumber"));
                book.setPrice(rs.getInt("price"));
                book.setBookImg(rs.getString("bookImg"));
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        return book;
    }	
	
	/**
	 * 通过用户名搜索图书
	 * */
	public List<Book> getBookLogname(String order_number) {//"+"'"+order_number+"'"
		String sql = "select * from book where logname ="+"'"+ order_number+"'";        
		Connection con=null;// = DbUtil.getConnection();
		try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
		List<Book> list = new ArrayList<>();
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");            
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	Book book = new Book();
                book.setOrder_number(rs.getString("order_number"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setCategory(rs.getString("category"));
                book.setLogname(rs.getString("logname"));
                book.setBooknumber(rs.getInt("booknumber"));
                book.setPrice(rs.getInt("price"));
                book.setBookImg(rs.getString("bookImg"));
                list.add(book);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        return list;
    }


	
	
	/**
	 * 模糊搜索
	 * */
	public List<Book> searchBook(String key,String keyfind01,String keyfind02) {
        List<Book> list = new ArrayList<>();
        Connection con;// = ManageInfo.getConnection();
        try{Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){}
        String condition = "select * from book where "+keyfind01+" like '%" + key + "%'";
        if(keyfind02=="opt2") {condition = "select * from book where "+keyfind01+"='" + key + "'";}
        try {//"SELECT * FROM book WHERE order_number = "+"'"+order_number+"'";
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");
            PreparedStatement psql = con.prepareStatement(condition);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
            	Book book = new Book();
                book.setOrder_number(rs.getString("order_number"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setCategory(rs.getString("category"));
                book.setLogname(rs.getString("logname"));
                book.setBooknumber(rs.getInt("booknumber"));
                book.setPrice(rs.getInt("price"));
                book.setBookImg(rs.getString("bookImg"));
                list.add(book);
            }
            rs.close();
            psql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	

}
