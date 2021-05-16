package shop.manage;
import java.sql.Connection;
import java.sql.DriverManager;

public class ManageInfo {
    private static Connection con=null;
    public static Connection getConnection() {
        if (con==null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopbook","root","zhiyingf");                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
    /**
     * 测试数据库是否连通
     *
     * @param args
     
    public static void main(String[] args) {
        System.err.println(getConnection());
    }
}*/
